// Function to validate book removal
const confirmDeletion = (event) => {
    if (!confirm('Are you sure you want to remove this book?')) {
        event.preventDefault();
    }
};

// Apply listeners using arrow functions
const setupEventListeners = () => {
    // Select all delete buttons
    const deleteButtons = document.querySelectorAll('.book-card__btn--delete');
    deleteButtons.forEach(btn => btn.addEventListener('click', confirmDeletion));

    // Handle broken cover URLs
    const covers = document.querySelectorAll('img');
    covers.forEach(img => {
        img.addEventListener('error', () => {
            img.src = 'https://images.unsplash.com/photo-1543002588-bfa74002ed7e?q=80&w=2730&auto=format&fit=crop';
        });
    });
};

document.addEventListener('DOMContentLoaded', () => setupEventListeners());