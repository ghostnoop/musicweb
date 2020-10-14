<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>

<@base.main css=["search_page"] js=['search']>
    <div class="col content-col">
        <h1 class="search_header">Search results for: <strong id="search_query">Miaow</strong></h1>

        <!-- Если не нашлось результатов-->
        <div class="nothing_found">
            <h1 class="search_header">Nothing Found</h1>
        </div>
        <!-- Если не нашлось результатов-->

        <!-- результат поиска -->
        <div class="search-results">


        </div>

        <div class="search-result">
            <article>
                <div class="search-result-image"><img src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/m5-150x150.jpg" alt=""></div>
                <div class="search-result-text">
                    <h2 class="search-result-text-name search_header"><a href="#">Miaow 2005</a></h2>
                    <div class="search-result-text-desc">
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Hoc etsi multimodis reprehendi potest, tamen accipio, quod dant. Sin te auctoritas commovebat, nobisne omnibus et Platoni ipsi nescio quem illum anteponebas? Egone non intellego, quid sit don Graece, Latine voluptas?...
                    </div>
                </div>
                <div class="result-link"><a href="#">Read More...</a></div>
            </article>
        </div>


    </div>
</@base.main>
