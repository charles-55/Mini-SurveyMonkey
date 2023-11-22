$(document).ready(function() {
    $('#dark-mode-toggle').on('change', function() {
        const htmlElement = document.documentElement;

        if ($(this).prop('checked')) {
            htmlElement.setAttribute("data-bs-theme", "dark");
        } else {
            htmlElement.setAttribute("data-bs-theme", "light");
        }
    });
});