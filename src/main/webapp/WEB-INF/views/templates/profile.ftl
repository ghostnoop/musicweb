<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>

<@base.main css=["artist_page","music_page"] js=["profile"]>

    <div class="col content-col ">
        <div class="main-panel">
            <div class="artist-inf">
                <div class="row">
                    <form method="post" id="avatar_form" action="/changeavatar" enctype="multipart/form-data">
                        <div class="col-sm-4 artist-image">
                            <img src="/img/get?name=${user.getAvatar_img()}" alt="">
                            <input type="file" name="avatar" class="file_upload" id="file_upload"
                                   accept=".png, .jpg, .jpeg"/>

                        </div>
                    </form>
                    <div class="col-sm-8 artist-desc">
                        <h1>${(isArtist??)?then("Artis", "User")}</h1>
                        <p>${user.getName()} ${user.getLastname()}</p>
                        <p><b>Email</b></p>
                        <p>${user.getEmail()}</p>
                        <p><b>Created profile</b></p>
                        <p>${user.getCreated_at()}</p>

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
                                    <i class="far fa-play-circle" onclick="playTrack(${song.getId()})"
                                       aria-hidden="true"></i>
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
                                <a href="#">${song.getArtist_id().getName()}</a>
                            </div>
                        </div>
                    </div>

                </#list>


            </div>
            <#if isArtist??>
                <h3 class="artist-music-header">Upload new track</h3>
                <div class="download_area">
                    <form action="/uploadsong" method="post" enctype="multipart/form-data">
                        <p class="comment-notes">
                            Required fields are marked
                            <span class="required">*</span>
                        </p>
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <label for="track_name">Track Name:</label>
                                <span class="required">*</span>
                                <input class="form-control" id="track_name" name="track_name" type="text">
                            </div>
                            <div class="col-sm-12">
                                <label for="track_img">Track image:</label>
                                <span class="required">*</span>
                                <input id="track_img" type="file" name="track_img" accept="image/*,image/jpeg">
                            </div>
                            <div class="col-sm-12">
                                <label for="track">Track</label>
                                <span class="required">*</span>
                                <input id="track" type="file" name="track" accept="audio/*">
                            </div>
                            <div class="col-sm-12">
                                <label for="genre">genre</label>
                                <span class="required">*</span>
                                <select class="form-control" id="genre" name="genre" onchange="check()">
                                    <#list genres as genre>
                                        <option>${genre.getName()}</option>
                                    </#list>
                                </select>
                            </div>
                            <input name="genre_selected" id="genre_selected" value="0" hidden>

                        </div>
                        <input name="submit" class="btn comment-submit" type="submit" value="Push Track">
                    </form>
                </div>
            </#if>

        </div>
    </div>

    <#include "layouts/sideartists.ftl">


</@base.main>
