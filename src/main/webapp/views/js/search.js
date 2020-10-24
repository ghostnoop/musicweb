function searcherAjax(link) {
    $.ajax({
        url: link,
        type: "POST",
        data: {
            'searchField': $("#search_input").val(),
            'filter':$("#filt").val(),
            'ajax':true
        },
        dataType: 'json',
        success: function (data) {
            console.log(data.length);
            // alert(data.size);
            $('.nothing_found').remove();
            $('.search-result').remove();
            // alert(data.length);
            if (data.length === 0) {
                $(".search-results").append($(
                '<div class="nothing_found">' +
                '<h1 class="search_header">Nothing Found</h1>' +
                '</div>'
                ));
                return;
            }

            for (var i = 0; i < data.length; i++) {
                $(".search-results").append($(
                    '<div class="search-result"> <article> ' +
                    ' <div class="search-result-image"><img class="search-img" src="img/get?name=' + data[i]['cover_img'] + '" alt=""></div>' +
                    '<div class="search-result-text">' +
                    '<h2 class="search-result-text-name search_header"><a href="/detail/song?id=' + data[i]['id'] + '">' + data[i]['title'] + '</a></h2>' +
                    '<a href="/detail/artist?id='+ data[i]['artist_id']['id']+'">'+
                    '<div class="search-result-text-desc">' +
                    'artist: ' + data[i]['artist_id']['name'] +
                    '</div>v</div></article></div>'
                ));
            }

        }

    });
}


$("#methodForm").submit(function (e) {
    e.preventDefault();
    var stateObj = { id: "100" };
    window.history.pushState(stateObj,
        "Search music", "/searcher?search="+$("#search_input").val());
    $('#search_query').last().html( $("#search_input").val() );

    $('.nothing_found').remove();
    $('.search-result').remove();

    searcherAjax('/searcher');
});
