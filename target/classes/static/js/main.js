// �������� ��� �������� <a> ������ ���������
var navLinks = document.querySelectorAll('.navs-link');

// ���������� ��� ������ � ��������� ���������� ������� ��� �����
navLinks.forEach(function(navLink) {
    navLink.addEventListener('click', function(event) {
        // ������� ����� "active" � ���� ������
        navLinks.forEach(function(link) {
            link.classList.remove('active-link');
        });

        // ��������� ����� "active" � ��������� ������
        navLink.classList.add('active-link');
    });
});