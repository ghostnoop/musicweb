<#ftl encoding="UTF-8"/>
<#import "../layouts/base.ftl" as base>

<@base.main css=["artist_page","music_page"] >

    <div class="col content-col ">
        <div class="main-panel">
            <div class="artist-inf">
                <div class="row">
                    <div class="col-sm-4 artist-image">
                        <img src="/img/get?name=${artist.getAvatar_img()}" alt="">
                    </div>
                    <div class="col-sm-8 artist-desc">
                        <h1>Artist</h1>
                        <p>${artist.getName()} ${artist.getLastname()}</p>
                        <p><b>Email</b></p>
                        <p>${artist.getEmail()}</p>
                        <p><b>Created profile</b></p>
                        <p>${artist.getCreated_at()}</p>

                    </div>
                </div>
            </div>
            <h3 class="artist-music-header">Music</h3>
            <div class="list-group music-group">

                <#list songs as song>

                    <div class="list-group-item music-group-item">
                        <div class="music-img">
                            <div class="overlay">
                                <div class="item-overlay">
                                    <a href="/detail/song?id=${song.getId()}">
                                        <i class="far fa-play-circle" aria-hidden="true"></i>
                                    </a>
                                </div>
                            </div>
                            <a href="">
                                <img src="/img/get?name=${song.getCover_img()}"
                                     alt="">
                            </a>
                        </div>
                        <div class="item-name">
                            <a href="detail/song?id=${song.getId()}"><strong>${song.getTitle()}</strong></a>
                            <div class="item-author">
                                by
                                <a href="#">${song.getArtist_id().getName()}</a>
                            </div>
                        </div>
                    </div>

                </#list>


            </div>

        </div>
    </div>

    <#include "../layouts/sideartists.ftl">
    <script>
        function check() {
            var a = $("#genre").prop('selectedIndex').toString();
            document.getElementById("genre_selected").value = a.toString();

        }
    </script>

</@base.main>
