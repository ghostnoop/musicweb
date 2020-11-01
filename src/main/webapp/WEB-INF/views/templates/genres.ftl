<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>

<@base.main css=["genres_page"]>
    <div class="col-auto genres-list-col">
        <ul class="genres-list">
            <!-- active-genres-item активный жанр -->
            <li class="genres-list-item active-genres-item"><a href="/genres"><span
                            class="genres-list-item-count"></span>All</a></li>
            <#list genres as genre>
                <li class="genres-list-item"><a href="/genres?id=${genre.getId()}"><span
                                class="genres-list-item-count"></span>${genre.getName()}</a></li>
            </#list>
        </ul>
    </div>
    <div class="col content-col">
        <section class="content">
            <div class="container-fluid content-container">
                <h2 class="headline">${name}</h2> <!-- название жанра -->
                <div class="row content-row">

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
                                        <img src="/img/get?name=${song.getCover_img()}"
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


                </div>
            </div>
        </section>
    </div>
</@base.main>
