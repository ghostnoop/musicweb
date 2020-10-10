<%@ page import="models.entities.Song" %>
<%@ page import="java.util.List" %>
<jsp:include page="header.jsp"/>

<div class="col content-col">
    <section class="content">
        <div class="container-fluid content-container">
            <h2 class="headline">What's New</h2>
            <div class="row content-row">

                <!-- должно приходить с бд-->
                <%
                    List<Song> songs = (List) request.getAttribute("songs");
                    if (songs != null)
                        for (Song song : songs) {
                %>

                <div class="col-12 col-sm-6 col-md-3 col-lg-2 item">
                    <article class="item-song">
                        <div class="item-image">
                            <div class="item-hover">
                                <a href="#">
                                    <i class="far fa-play-circle"></i>
                                </a>
                            </div>
                            <a href="#" class="image-ref">
                                <img src="<%=song.getCover_img()%>"
                                     alt>
                            </a>
                        </div>
                        <div class="item-desc">
                            <div class="item-name"><a href="#">Tempered Song</a>
                                <div class="item-author">
                                    by
                                    <a href="#">Miaow</a>
                                </div>
                            </div>
                        </div>
                    </article>
                </div>
                <%}%>



                <!-- -->
            </div>
            <div class="container login-container">
                <div class="row widjet-btn justify-content-center">
                    <div class="col-8 login-btn">
                        <a href="login_page.html">
                                        <span>
                                            <i class="fas fa-user-plus" aria-hidden="true"></i>
                                            Login or Create account
                                        </span>
                            <br>
                            <span class="aside-login">
                                            Get free musics when you logged in, and give your comments to them.
                                        </span>
                        </a>
                    </div>
                </div>
            </div>
            <h2 class="headline">New Albums</h2>
            <div class="row content-row">
                <div class="col-12 col-sm-6 col-md-3 col-lg-2 item">
                    <article class="item-song">
                        <div class="item-image">
                            <div class="item-hover">
                                <a href="#">
                                    <i class="far fa-play-circle"></i>
                                </a>
                            </div>
                            <a href="#" class="image-ref">
                                <img src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/m19-150x150.jpg"
                                     alt>
                            </a>
                        </div>
                        <div class="item-desc">
                            <div class="item-name"><a href="#">Tempered Song</a>
                                <div class="item-author">
                                    by
                                    <a href="#">Miaow</a>
                                </div>
                            </div>
                        </div>
                    </article>
                </div>
                <div class="col-12 col-sm-6 col-md-3 col-lg-2 item">
                    <article class="item-song">
                        <div class="item-image">
                            <div class="item-hover">
                                <a href="#">
                                    <i class="far fa-play-circle"></i>
                                </a>
                            </div>
                            <a href="#">
                                <img src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/m15-150x150.jpg"
                                     alt>
                            </a>
                        </div>
                        <div class="item-desc">
                            <div class="item-name"><a href="#">Bubble</a>
                                <div class="item-author">
                                    by
                                    <a href="#">Miaow</a>
                                </div>
                            </div>
                        </div>
                    </article>
                </div>
                <div class="col-12 col-sm-6 col-md-3 col-lg-2 item">
                    <article class="item-song">
                        <div class="item-image">
                            <div class="item-hover">
                                <a href="#">
                                    <i class="far fa-play-circle"></i>
                                </a>
                            </div>
                            <a href="#">
                                <img src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/b17-150x150.jpg"
                                     alt>
                            </a>
                        </div>
                        <div class="item-desc">
                            <div class="item-name"><a href="#">Lismore</a>
                                <div class="item-author">
                                    by
                                    <a href="#">Joe Holmes</a>
                                </div>
                            </div>
                        </div>
                    </article>
                </div>
                <div class="col-12 col-sm-6 col-md-3 col-lg-2 item">
                    <article class="item-song">
                        <div class="item-image">
                            <div class="item-hover">
                                <a href="#">
                                    <i class="far fa-play-circle"></i>
                                </a>
                            </div>
                            <a href="#">
                                <img src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/b5-150x150.jpg"
                                     alt>
                            </a>
                        </div>
                        <div class="item-desc">
                            <div class="item-name"><a href="#">Beside Me</a>
                                <div class="item-author">
                                    by
                                    <a href="#">Miaow</a>
                                </div>
                            </div>
                        </div>
                    </article>
                </div>
                <div class="col-12 col-sm-6 col-md-3 col-lg-2 item">
                    <article class="item-song">
                        <div class="item-image">
                            <div class="item-hover">
                                <a href="#">
                                    <i class="far fa-play-circle"></i>
                                </a>
                            </div>
                            <a href="#">
                                <img src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/m17-150x150.jpg"
                                     alt>
                            </a>
                        </div>
                        <div class="item-desc">
                            <div class="item-name">
                                <a href="#">Lentement</a>
                                <div class="item-author">
                                    by
                                    <a href="#">James Garsia</a>
                                </div>
                            </div>
                        </div>
                    </article>
                </div>
                <div class="col-12 col-sm-6 col-md-3 col-lg-2 item">
                    <article class="item-song">
                        <div class="item-image">
                            <div class="item-hover">
                                <a href="#">
                                    <i class="far fa-play-circle"></i>
                                </a>
                            </div>
                            <a href="#">
                                <img src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/b16-150x150.jpg"
                                     alt>
                            </a>
                        </div>
                        <div class="item-desc">
                            <div class="item-name"><a href="#">The Separation</a>
                                <div class="item-author">
                                    by
                                    <a href="#">Bossr</a>
                                </div>
                            </div>
                        </div>
                    </article>
                </div>
            </div>
        </div>
    </section>
</div>
<section class="aside-info">
    <aside>
        <div class="col-auto aside-col-info">
            <h4>Top artists</h4>

            <!-- должно приходить с бд-->
            <div class="list-group">
                <div class="list-group-item">
                    <div class="avatar-container"><a href=""><img
                            src="http://flatfull.com/wp/musik/wp-content/themes/musiks/assets/images/default_300_300.jpg"
                            alt=""></a></div>
                    <div class="name-container"><a href="">Miaow</a></div>
                </div>

                <div class="list-group-item">
                    <div class="avatar-container"><a href=""><img
                            src="http://flatfull.com/wp/musik/wp-content/themes/musiks/assets/images/default_300_300.jpg"
                            alt=""></a></div>
                    <div class="name-container"><a href="">The Stark Palace</a></div>
                </div>
                <div class="list-group-item">
                    <div class="avatar-container"><a href=""><img
                            src="http://flatfull.com/wp/musik/wp-content/themes/musiks/assets/images/default_300_300.jpg"
                            alt=""></a></div>
                    <div class="name-container"><a href="">Bossr</a></div>
                </div>
                <div class="list-group-item">
                    <div class="avatar-container"><a href=""><img
                            src="http://flatfull.com/wp/musik/wp-content/themes/musiks/assets/images/default_300_300.jpg"
                            alt=""></a></div>
                    <div class="name-container"><a href="">Crystal Guerrero</a></div>
                </div>
                <div class="list-group-item">
                    <div class="avatar-container"><a href=""><img
                            src="http://flatfull.com/wp/musik/wp-content/themes/musiks/assets/images/default_300_300.jpg"
                            alt=""></a></div>
                    <div class="name-container"><a href="">James Garcia</a></div>
                </div>
                <div class="list-group-item">
                    <div class="avatar-container"><a href=""><img
                            src="http://flatfull.com/wp/musik/wp-content/themes/musiks/assets/images/default_300_300.jpg"
                            alt=""></a></div>
                    <div class="name-container"><a href="">Jean Schneider</a></div>
                </div>
                <div class="list-group-item">
                    <div class="avatar-container"><a href=""><img
                            src="http://flatfull.com/wp/musik/wp-content/themes/musiks/assets/images/default_300_300.jpg"
                            alt=""></a></div>
                    <div class="name-container"><a href="">Jeremy Scott</a></div>
                </div>
                <div class="list-group-item">
                    <div class="avatar-container"><a href=""><img
                            src="http://flatfull.com/wp/musik/wp-content/themes/musiks/assets/images/default_300_300.jpg"
                            alt=""></a></div>
                    <div class="name-container"><a href="">Jesse Russell</a></div>
                </div>
                <div class="list-group-item">
                    <div class="avatar-container"><a href=""><img
                            src="http://flatfull.com/wp/musik/wp-content/themes/musiks/assets/images/default_300_300.jpg"
                            alt=""></a></div>
                    <div class="name-container"><a href="">Joe Holmes</a></div>
                </div>
                <div class="list-group-item">
                    <div class="avatar-container"><a href=""><img
                            src="http://flatfull.com/wp/musik/wp-content/themes/musiks/assets/images/default_300_300.jpg"
                            alt=""></a></div>
                    <div class="name-container"><a href="">Joe Holmes</a></div>
                </div>
                <div class="list-group-item">
                    <div class="avatar-container"><a href=""><img
                            src="http://flatfull.com/wp/musik/wp-content/themes/musiks/assets/images/default_300_300.jpg"
                            alt=""></a></div>
                    <div class="name-container"><a href="">Joe Holmes</a></div>
                </div>
            </div>
            <!-- -->
        </div>
    </aside>
</section>
</div>
</div>
</section>

<section>
    <footer class="footer  footer-player">
        <div class="footer-container container-fluid">
            <div class="col-auto login unside" id="unside_login">
                <a href="login_page.html">
                    <i class="fas fa-user-plus"></i>
                    <span>Login</span>
                </a>
            </div>
            <div class="col-auto login side" id="side_login">
                <a href="login_page.html" id="login-ref">
                    <i class="fas fa-user-plus"></i>
                </a>
            </div>
            <div class="col player"></div>
        </div>
    </footer>
</section>
<jsp:include page="footer.jsp"/>
