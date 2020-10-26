function check() {
    var a = $("#genre").prop('selectedIndex').toString();
    document.getElementById("genre_selected").value = a.toString();

}

$("#file_upload").change(function () {
    $('#avatar_form').submit();
});
