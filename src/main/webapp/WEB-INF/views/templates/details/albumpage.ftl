<#ftl encoding="UTF-8"/>
<#import "../layouts/base.ftl" as base>

<@base.main css=["artist_page","music_page"] js=["favorite"]>

    <div class="col content-col ">
        <div class="main-panel">
            <div class="artist-inf">
                <div class="row">
                    <div class="col-sm-4 artist-image">
                        <img src="/img/get?name=${album.getCover_img()}" alt="">
                    </div>
                    <div class="col-sm-8 artist-desc">
                        <!-- Название Альбома -->
                        <h1>${album.getTitle()}</h1>
                        <div class="meta">
                            <span>Artist: <a href="/detail/artist?id=${album.getArtist_id().getId()}">${album.getArtist_id().getName()}</a></span>
                        </div>
                        <div class="music-buttons">
                            <i class="far fa-play-circle play" onclick="playAlbum(${album.getId()})" aria-hidden="true"></i>

                        </div>
                    </div>
                </div>
                <div class="music-text">
                  ${album.getDescription()}
                </div>
            </div>
            <!-- Музыка артиста -->
            <h3 class="artist-music-header">Music</h3>

            <div class="list-group music-group">
                <#list songs as song>

                        <div class="list-group-item music-group-item">
                            <div class="music-img">
                                <div class="overlay">
                                    <div class="item-overlay">
                                            <i class="far fa-play-circle" onclick="playTrack(${song.getId()})" aria-hidden="true"></i>
                                    </div>
                                </div>
                                <a href="">
                                    <img src="/img/get?name=${song.getCover_img()}"
                                         alt="">
                                </a>
                            </div>
                            <div class="item-name">
                                <a href="/detail/song?id=${song.getId()}"><strong>${song.getTitle()}</strong></a>
                                <div class="item-author">
                                    by
                                    <a href="/detail/artist?id=${song.getArtist_id().getId()}">${song.getArtist_id().getName()}</a>
                                </div>
                            </div>
                        </div>


                </#list>
            </div>

        </div>
    </div>
    <#include "../layouts/sideartists.ftl">




</@base.main>
