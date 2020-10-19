$(document).ready(function () {
    $("#favorite").click(function () {
        $("#favorite-star").toggleClass("fas");
        $.ajax({
            url: '/like',
            type: "POST",
            data: {
                'song_id': $("#like-btn").val()
            },
            dataType: 'json',
            success: function (data) {
                console.log(data);
            }
        });
    })
});
