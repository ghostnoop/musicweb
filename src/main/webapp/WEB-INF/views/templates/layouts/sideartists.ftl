<#if topArtists??>
    <section class="aside-info">
        <aside>
            <h4>Top ${topArtists?size} artist</h4>
            <div class="col-auto aside-col-info">
                <div class="list-group">
                    <#list topArtists as artist>
                        <div class="list-group-item">
                            <div class="avatar-container"><a href="/detail/artist?id=${artist.getId()}"><img
                                            src="/img/get?name=${artist.getAvatar_img()}"
                                            alt=""></a></div>
                            <div class="name-container"><a href="">${artist.getName()}</a></div>
                        </div>
                    </#list>
                </div>
            </div>
        </aside>
    </section>
</#if>
