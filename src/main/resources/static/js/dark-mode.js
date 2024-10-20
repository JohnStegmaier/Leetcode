const toggleButton = document.getElementById('toggle-btn');
const body = document.body;
const container = document.querySelector('.container');
const navbar = document.querySelector('.navbar');

body.classList.add('no-transition');
container.classList.add('no-transition');
navbar.classList.add('no-transition');
toggleButton.classList.add('no-transition');

// Check for previously set dark mode in localStorage
const darkModeEnabled = localStorage.getItem('darkMode') === 'enabled';
if (darkModeEnabled) {
    body.classList.add('dark-mode');
    toggleButton.classList.add('dark-mode');
    navbar.classList.add('dark-mode');
    container.classList.add('dark-mode');
}

// Remove no-transition class after a short delay
setTimeout(() => {
    body.classList.remove('no-transition');
    toggleButton.classList.remove('no-transition');
    navbar.classList.remove('no-transition');
    container.classList.remove('no-transition');
}, 1000);

toggleButton.addEventListener('click', () => {
    body.classList.toggle('dark-mode');
    toggleButton.classList.toggle('dark-mode');
    navbar.classList.toggle('dark-mode');
    container.classList.toggle('dark-mode');

    // Store user preference in localStorage
    if (body.classList.contains('dark-mode')) {
        localStorage.setItem('darkMode', 'enabled');
    } else {
        localStorage.setItem('darkMode', 'disabled');
    }
});