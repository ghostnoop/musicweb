<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>

<@base.main>
    <div class="col content-col">


        <section class="content">
            <div class="container-fluid content-container">
                <h2 class="headline">What's New</h2>
                <div class="row content-row">

                    <!-- должно приходить с бд-->

                    <#list songs as song>
                        <div class="col-12 col-sm-6 col-md-3 col-lg-2 item">
                            <article class="item-song">
                                <div class="item-image">
                                    <div class="item-hover">
                                        <div class="item-hover-center">
                                            <i class="far fa-play-circle" onclick="playTrack(${song.getId()})"></i>
                                        </div>
                                    </div>
                                    <a href="/detail/song?id=${song.getId()}" class="image-ref">
                                        <img class="img" src="/img/get?name=${song.getCover_img()}"
                                             alt>
                                    </a>
                                </div>
                                <div class="item-desc">
                                    <div class="item-name"><a
                                                href="/detail/song?id=${song.getId()}">${song.getTitle()}</a>
                                        <div class="item-author">
                                            by
                                            <a href="/detail/artist?id=${song.getArtist_id().getId()}">${song.getArtist_id().getName()}</a>
                                        </div>
                                    </div>
                                </div>
                            </article>
                        </div>
                    </#list>

                    <!-- -->


                </div>
                <#--        user is login-->
                <#if !user??>
                    <div class="container login-container">
                        <div class="row widjet-btn justify-content-center">
                            <div class="col-8 login-btn">
                                <a href="/login">
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
                </#if>


                <h2 class="headline">New Albums</h2>
                <div class="row content-row">
                    <#--            new albums-->
                    <#list albums as album>
                        <div class="col-12 col-sm-6 col-md-3 col-lg-2 item">
                            <article class="item-song">
                                <div class="item-image">
                                    <div class="item-hover">
                                        <a href="#">
                                            <div class="item-hover-center">
                                                <i class="far fa-play-circle" onclick="playAlbum(${album.getId()})"></i>
                                            </div>
                                        </a>
                                    </div>
                                    <a href="#" class="image-ref">
                                        <img src="/img/get?name=${album.getCover_img()}"
                                             alt>
                                    </a>
                                </div>
                                <div class="item-desc">
                                    <div class="item-name"><a href="/detail/album?id=${album.getId()}">${album.getTitle()}</a>
                                        <div class="item-author">
                                            by
                                            <a href="/detail/artist?id=${album.getArtist_id().getId()}">${album.getArtist_id().getName()}</a>
                                        </div>
                                    </div>
                                </div>
                            </article>
                        </div>
                    </#list>

                </div>
            </div>
        </section>
    </div>
</@base.main>
