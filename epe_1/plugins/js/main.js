$(document).ready(function () {
    $.ajax({
        method: "POST",
        url: "components/Headers.html",
        data: "",
        cache: false,
        success: function (data) { $("#header").html(data); }
    });

    $.ajax({
        method: "POST",
        url: "components/Footers.html",
        data: "",
        cache: false,
        success: function (data) { $("#footer").html(data); }
    });

    $.ajax({
        method: "POST",
        url: "components/SideNav.html",
        data: "",
        cache: false,
        success: function (data) { $("#navbar").html(data); }
    });
    console.log('El DOM ha sido completamente cargado');
});

function loagPage(page) {
    $.ajax({
        method: "POST",
        url: "page/" + page + ".html",
        data: "",
        cache: false,
        success: function (data) { $("#main").html(data); }
    });
}

function login() {
    $('#formRegister').modal('show');
}