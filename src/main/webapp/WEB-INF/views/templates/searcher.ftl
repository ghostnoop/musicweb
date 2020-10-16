<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>

<@base.main css=["search_page"] js=['search']>
    <div class="col content-col">
        <h1 class="search_header">Search results for: <strong id="search_query">${(searchField??)?then(searchField, "")}</strong></h1>

        <!-- Если не нашлось результатов-->

        <!-- Если не нашлось результатов-->

        <div class="search-results">


        <!-- результат поиска -->


            <#if songs??>
<#list songs as song>

        <div class="search-result">
            <article>
                <div class="search-result-image"><img src="${song.getCover_img()}" alt=""></div>
                <div class="search-result-text">
                    <h2 class="search-result-text-name search_header"><a href="/detail/song?id=${song.getId()}">${song.getTitle()}</a></h2>
                    <a href="/detail/artist?id=${song.getArtist_id().getId()}">
                    <div class="search-result-text-desc">
                        artist: ${song.getArtist_id().getName()}
                    </div>
                    </a>
                </div>
            </article>
        </div>
</#list>

                <#else >
                    <div class="nothing_found">
                        <h1 class="search_header">Nothing Found</h1>
                    </div>
            </#if>



        </div>


    </div>
</@base.main>
