// Получаем все элементы <a> внутри навигации
var navLinks = document.querySelectorAll('.navs-link');

// Перебираем все ссылки и добавляем обработчик события для клика
navLinks.forEach(function(navLink) {
    navLink.addEventListener('click', function(event) {
        // Удаляем класс "active" у всех ссылок
        navLinks.forEach(function(link) {
            link.classList.remove('active-link');
        });

        // Добавляем класс "active" к кликнутой ссылке
        navLink.classList.add('active-link');
    });
});