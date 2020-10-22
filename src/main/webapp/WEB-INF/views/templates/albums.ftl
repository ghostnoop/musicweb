<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>

<@base.main>
<div class="col content-col">
    <section class="content">
        <div class="container-fluid content-container">
            <h2 class="headline">Albums</h2>
            <div class="row content-row">

                <!-- должно приходить с бд-->

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


                <!-- -->

            </div>
        </div>
    </section>
</div>
</@base.main>
