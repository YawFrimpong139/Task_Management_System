package com.example.demo1.dao;


import com.example.demo1.model.Task;
import java.sql.*;
import java.util.*;

public class TaskDAO {
    private final String URL = "jdbc:mysql://localhost:3306/tasks?" +
            "useSSL=false&" +
            "allowPublicKeyRetrieval=true&" +
            "serverTimezone=UTC";

    private final String USER = "root";
    private final String PASSWORD = "zealow139";

    private static final String INSERT_TASK_SQL = "INSERT INTO task (title, description, due_date, status) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_TASKS = "SELECT * FROM task";
    private static final String SELECT_TASK_BY_ID = "SELECT * FROM task WHERE id = ?";
    private static final String DELETE_TASK_SQL = "DELETE FROM task WHERE id = ?";

    // Register the driver when the class is loaded
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load MySQL JDBC driver", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addTask(Task task) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_TASK_SQL, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setDate(3, new java.sql.Date(task.getDueDate().getTime()));
            stmt.setString(4, task.getStatus());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating task failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    task.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating task failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding task", e);
        }
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_TASKS)) {

            while (rs.next()) {
                Task task = new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDate("due_date"),
                        rs.getString("status")
                );
                tasks.add(task);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving tasks", e);
        }
        return tasks;
    }

    public void updateTask(Task task) {
        String sql = "UPDATE task SET title=?, description=?, due_date=?, status=? WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setDate(3, new java.sql.Date(task.getDueDate().getTime()));
            stmt.setString(4, task.getStatus());
            stmt.setInt(5, task.getId());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Updating task failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error updating task", e);
        }
    }

    public Optional<Task> getTaskById(int id) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_TASK_BY_ID)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Task(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getDate("due_date"),
                            rs.getString("status")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving task with id: " + id, e);
        }
        return Optional.empty();
    }

    public boolean deleteTask(int id) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_TASK_SQL)) {

            stmt.setInt(1, id);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting task with id: " + id, e);
        }
    }
}
