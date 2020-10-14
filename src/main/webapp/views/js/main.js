$(function () {
    $("#side_logo").hide();
    $("#side_login").hide();
    $("#side_menu").hide();
    var win = $(window);
    win.resize(function () {
        if (win.width() < 850) {
            $(".aside-info").hide();
        }
        if (win.width() >= 850) {
            $(".aside-info").show();
        }
    });

    $("#side_button").click(function () {
        var unside_login = $("#unside_login");
        var unside_logo = $("#unside_logo");
        var unside_menu = $("#unside_menu");
        var side_logo = $("#side_logo");
        var side_login = $("#side_login");
        var side_menu = $("#side_menu");
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
