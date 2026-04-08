// Function to handle image loading errors (fallbacks)
const handleImageError = () => {
    const images = document.querySelectorAll('.book-card__img');

    images.forEach(img => {
        img.addEventListener('error', () => {
            // Placeholder image if URL is broken
            img.src = 'https://via.placeholder.com/400x600/1e293b/94a3b8?text=No+Cover+Found';
        });
    });
};

// Simple log for session feedback
const initApp = () => {
    console.log('BookEcho Catalog Initialized');
    handleImageError();
};

// DOM Content Loaded Listener
document.addEventListener('DOMContentLoaded', () => initApp());