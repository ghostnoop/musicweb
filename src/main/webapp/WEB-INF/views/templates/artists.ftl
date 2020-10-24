<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>

<@base.main css=["artists_page"]>
    <div class="col content-col">
        <section class="content">
            <div class="container-fluid content-container">
                <h2 class="headline">Artists</h2>
                <div class="row content-row">
                    <#list artists as artist>

                        <div class="col-12 col-sm-3 col-lg-2 item">
                            <article class="item-song">
                                <div class="item-image">
                                    <a href="#" class="image-ref">
                                        <img class="img-fluid" src="/img/get?name=${artist.getAvatar_img()}"
                                             alt>
                                    </a>
                                </div>
                                <div class="item-desc">
                                    <div class="item-name"><a
                                                href="/detail/artist?id=${artist.getId()}">${artist.getName()}</a></div>
                                </div>
                            </article>
                        </div>
                    </#list>
                </div>
            </div>
        </section>
    </div>
</@base.main>
