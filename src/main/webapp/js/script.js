document.addEventListener('DOMContentLoaded', function() {
    // Add any client-side functionality here
    console.log('Task Manager application loaded');

    // Example: Confirm before deleting
    const deleteButtons = document.querySelectorAll('.btn-delete');
    deleteButtons.forEach(button => {
        button.addEventListener('click', function(e) {
            if (!confirm('Are you sure you want to delete this task?')) {
                e.preventDefault();
            }
        });
    });

    // Add date picker enhancements if needed
    const dateInputs = document.querySelectorAll('input[type="date"]');
    dateInputs.forEach(input => {
        // You could initialize a date picker library here
    });
});