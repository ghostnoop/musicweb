<#ftl encoding="UTF-8"/>

<#macro main css=[] js=[]>
    <html>
    <head>
        <title>${(title??)?then(title, "Music player")}</title>
        <link rel="stylesheet" href="../../../../views/static/V2/bootstrap.min.css">
        <link rel="stylesheet" href="../../../../views/css/home_page.css">
        <#--        <link rel="stylesheet" href="../../../../views/css/login_page.css">-->
        <#--        <link rel="stylesheet" href="../../../../views/css/register_page.css">-->
        <#list css as styles>
            <link rel="stylesheet" href="../../../../views/css/${styles}.css">

        </#list>
    </head>
    <body>

    <section>
        <header>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-auto logo unside" id="unside_logo">
                        <a href="/index" class="logo-ref">
                            <i class="fas fa-headphones-alt"></i>
                            <span>MusicPlayer</span>
                        </a>
                    </div>
                    <div class="col-auto logo side pt-3" id="side_logo">
                        <a href="/index" class="logo-ref">
                            <i class="fas fa-headphones-alt"></i>
                        </a>
                    </div>
                    <div class="col right_bar">
                        <a href="#" class="text-muted" id="side_button">
                            <i class="fa fa-bars"></i>
                        </a>
                        <form action="/searcher" id="methodForm" role="search" class="search">
                            <div class="input-group">
		                    <span class="input__btn">
		                        <button type="submit" id="search_btn" class="btn btn-sm bg-white btn-icon rounded">
                                    <i class="fa fa-search"></i>
                                </button>
		                    </span>
                                <input type="text" autocomplete="true" id="search_input" class="rounded input-search"
                                       name="search"
                                       placeholder="Search..."
                                >
                                <select class="form-control form-control-sm" name="filt" id="filt">
                                    <option selected>--</option>
                                    <option>Likes</option>
                                    <option>New</option>
                                </select>
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
                                <li class="menu-item">
                                    <a href="/index">
                                        <i class="fas fa-music music-icon-green" aria-hidden="true"></i>
                                        <span>Discover</span>
                                    </a>
                                </li>
                                <li class="menu-item"><a href="/genres">
                                        <i class="fas fa-align-left music-icon-blue" aria-hidden="true"></i>
                                        <span>Genres</span>
                                    </a></li>
                                <li class="menu-item"><a href="/albums">
                                        <i class="fas fa-compact-disc music-icon-green" aria-hidden="true"></i>
                                        <span>Albums</span>
                                    </a></li>
                                <li class="menu-item"><a href="/artists">
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
                                <li class="menu-item">
                                    <a href="/index">
                                        <i class="fas fa-music music-icon-green"></i>
                                    </a>
                                </li>
                                <li class="menu-item"><a href="/genres">
                                        <i class="fas fa-align-left music-icon-blue"></i>
                                    </a></li>
                                <li class="menu-item"><a href="/albums">
                                        <i class="fas fa-compact-disc music-icon-green"></i>
                                    </a></li>
                                <li class="menu-item"><a href="/artists">
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
                <#nested>


            </div>
        </div>
    </section>

    <#include "bottombar.ftl">


    <script src="../../../../views/js/fontawesome.js" crossorigin="anonymous"></script>
    <script src="../../../../views/js/jquery-3.5.1.min.js"></script>
    <#list js as jscript>
        <script src="../../../../views/js/${jscript}.js"></script>
    </#list>

    <script src="../../../../views/js/main.js"></script>
    <script src="../../../../views/js/howler.core.js"></script>
    <script src="../../../../views/js/player.js"></script>

    </body>
    </html>

</#macro>
