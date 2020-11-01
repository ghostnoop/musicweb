<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <title>Register - Music</title>--%>
    <title>${title}</title>
    <style>
    <%@include file='/views/static/V2/bootstrap.min.css' %>
    <%@include file='/views/css/home_page.css' %>
    <%@include file='/views/css/login_page.css' %>
    <%@include file='/views/css/register_page.css' %>
    </style>

</head>
<body>

<section>
    <header>
        <div class="container-fluid">
            <div class="row">
                <div class="col-auto logo unside" id="unside_logo">
                    <a href="main_page.html" class="logo-ref">
                        <i class="fas fa-headphones-alt"></i>
                        <span>MusicPlayer</span>
                    </a>
                </div>
                <div class="col-auto logo side pt-3" id="side_logo">
                    <a href="main_page.html" class="logo-ref">
                        <i class="fas fa-headphones-alt"></i>
                    </a>
                </div>
                <div class="col right_bar">
                    <a href="#" class="text-muted" id="side_button">
                        <i class="fa fa-bars"></i>
                    </a>
                    <form action="" role="search" class="search">
                        <div class="input-group">
		            <span class="input__btn">
		              <button type="submit" class="btn btn-sm bg-white btn-icon rounded"><i
                              class="fa fa-search"></i></button>
		            </span>
                            <input type="text" autocomplete="off" class="rounded input-search" name="search"
                                   placeholder="Search...">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </header>
</section>
<section>
    <div class="container-fluid">
        <div class="row">
            <div class="col-auto menu unside" id="unside_menu">
                <aside>
                    <nav class="navigation">
                        <ul class="menu-list">
                            <li class="menu-item header-list">
                                <span>Discover music</span>
                            </li>
                            <li class="menu-item active">
                                <a href="main_page.html">
                                    <i class="fas fa-music music-icon-green" aria-hidden="true"></i>
                                    <span>Discover</span>
                                </a>
                            </li>
                            <li class="menu-item"><a href="genres_page.html">
                                <i class="fas fa-align-left music-icon-blue" aria-hidden="true"></i>
                                <span>Genres</span>
                            </a></li>
                            <li class="menu-item"><a href="albums_page.html">
                                <i class="fas fa-compact-disc music-icon-green" aria-hidden="true"></i>
                                <span>Albums</span>
                            </a></li>
                            <li class="menu-item"><a href="artists_page.html">
                                <i class="fas fa-user-friends music-icon-blue" aria-hidden="true"></i>
                                <span>Artists</span>
                            </a></li>
                            <li class="menu-item-border"></li>
                        </ul>
                    </nav>
                    <section>
                        <div class="empty-block"></div>
                    </section>
                </aside>
            </div>
            <div class="col-auto menu side" id="side_menu">
                <aside>
                    <nav class="navigation">
                        <ul class="menu-list">
                            <li class="menu-item active">
                                <a href="main_page.html">
                                    <i class="fas fa-music music-icon-green"></i>
                                </a>
                            </li>
                            <li class="menu-item"><a href="genres_page.html">
                                <i class="fas fa-align-left music-icon-blue"></i>
                            </a></li>
                            <li class="menu-item"><a href="albums_page.html">
                                <i class="fas fa-compact-disc music-icon-green"></i>
                            </a></li>
                            <li class="menu-item"><a href="artists_page.html">
                                <i class="fas fa-user-friends music-icon-blue"></i>
                            </a></li>
                            <li class="menu-item-border"></li>
                        </ul>
                    </nav>
                    <section>
                        <div class="empty-block"></div>
                    </section>
                </aside>
            </div>
