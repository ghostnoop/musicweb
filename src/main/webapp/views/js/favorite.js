$(document).ready(function () {
    $("#favorite").click(function () {
        $("#favorite-star").toggleClass("fas");
        var isLike=$("#favorite-star").hasClass("fas");

        console.log($("#counter").text());
        var counter=parseInt($("#counter").text());
        console.log(counter);
        if (isLike){
            $("#counter").text(counter+1);
        }
        else {
            $("#counter").text(counter-1);
        }

        $.ajax({
            url: '/like',
            type: "POST",
            data: {
                'song_id': $("#like-btn").val(),
                'like': isLike
            },
            dataType: 'json'
        });

    })
});
