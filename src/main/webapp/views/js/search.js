function searchAjax(link){
    return $.ajax({
        url : link,
        type:'HEAD'
    });
}
//<div class="search-result">
//             <article>
//                 <div class="search-result-image"><img src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/m5-150x150.jpg" alt=""></div>
//                 <div class="search-result-text">
//                     <h2 class="search-result-text-name search_header"><a href="#">Miaow 2005</a></h2>
//                     <div class="search-result-text-desc">
//                         Lorem ipsum dolor sit amet, consectetur adipiscing elit. Hoc etsi multimodis reprehendi potest, tamen accipio, quod dant. Sin te auctoritas commovebat, nobisne omnibus et Platoni ipsi nescio quem illum anteponebas? Egone non intellego, quid sit don Graece, Latine voluptas?...
//                     </div>
//                 </div>
//                 <div class="result-link"><a href="#">Read More...</a></div>
//             </article>
//         </div>
function searcherAjax(link){
    $.ajax({
        url: link,
        type: "POST",
        data: {
            'searchField': $("#search_input").val()
        },
        dataType: 'json',
        success: function (data) {
            alert(data.size);
            var i =0;
            $( ".search-results" ).append( $(
                '<div class="search-result"> <article> ' +
                ' <div class="search-result-image"><img src="'+data[i]['cover_img']+'" alt=""></div>'+
                '<div class="search-result-text">'+
                '<h2 class="search-result-text-name search_header"><a href="/detail/song?id='+data[i]['id']+'">'+data[i]['title']+'</a></h2>'+
                '<div class="search-result-text-desc">'+
                'artist: '+data[i]['artist_id']['name']+
                '</div></div></article></div>'
            ) );

            alert(data[0]['id'])
        }

    });
}

$("#methodForm").submit(function(e){
    e.preventDefault();
    alert($("#search_input").val());

    var form = this;
    searcherAjax('/searcher').done(function() {
        // form.submit(); // submit bypassing the jQuery bound event
    }).fail(function () {
        alert("No index present!");
    });
});
