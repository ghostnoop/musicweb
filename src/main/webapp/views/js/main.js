$(function () {
    $("#side_logo").hide();
    $("#side_login").hide();
    $("#side_menu").hide();
    let win = $(window);
    win.resize(function () {
        if (win.width() < 850) {
            $(".aside-info").hide();
        }
        if (win.width() >= 850) {
            $(".aside-info").show();
        }
    });

    $("#side_button").click(function () {
        let unside_login = $("#unside_login");
        let unside_logo = $("#unside_logo");
        let unside_menu = $("#unside_menu");
        let side_logo = $("#side_logo");
        let side_login = $("#side_login");
        let side_menu = $("#side_menu");
        if (side_logo.is(":visible")) {
            unside_logo.show();
            unside_menu.show();
            unside_login.show();
            side_logo.hide();
            side_login.hide();
            side_menu.hide();

        } else {
            unside_logo.hide();
            unside_login.hide();
            unside_menu.hide();
            side_logo.show();
            side_login.show();
            side_menu.show();
        }
    })
});