/**
 * 
 */

// Lógica efeito de seleção no menu
document.addEventListener('DOMContentLoaded', function () {
    const links = document.querySelectorAll('.nav_link');

    function setActiveLink() {
        const activeLink = localStorage.getItem('activeLink');
        if (activeLink) {
            links.forEach(link => {
                link.classList.remove('active');
            });
            document.querySelector(`a[href="${activeLink}"]`).classList.add('active');
        }
    }

    links.forEach(link => {
        link.addEventListener('click', () => {
            links.forEach(link => {
                link.classList.remove('active');
            });

            link.classList.add('active');

            localStorage.setItem('activeLink', link.getAttribute('href'));
        });
    });

    setActiveLink();
});


// Lógica do modal de exclusão de produtos
$(document).ready(function() {
    $('#confirmationModal').hide();
    $('.delete-link').click(function(e) {
        e.preventDefault();
        var id = $(this).data('id');
        $('#confirmationModal').show();
        $('#confirmDelete').click(function() {
            window.location.href = './delete?id=' + id;
            $('#confirmationModal').hide();
        });
        $('#cancelDelete').click(function() {
            $('#confirmationModal').hide();
            window.location.href = 'consultarProduto.jsp';
        });
    });
    var confirmDeleteButton = document.getElementById("confirmDelete");
    var confirmationModal = document.getElementById("confirmationModal");
    confirmDeleteButton.addEventListener("click", function() {
        confirmationModal.style.display = "none";
    });
});

 