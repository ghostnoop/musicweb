<#ftl encoding="UTF-8"/>
<#import "../layouts/base.ftl" as base>

<@base.main css=["music_page","artist_page"] js=['favorite']>
<div class="col content-col">

    <div class="main-panel">
        <div class="artist-inf">
            <div class="row">
                <div class="col-sm-4 artist-image">
                    <img src="${song.getCover_img()}" alt="">
                </div>
                <div class="col-sm-8 artist-desc">
                    <!-- Название трека -->
                    <h1>${song.getTitle()}</h1>
                    <div class="meta">
                        <span>Artist: <a href="/detail/artist?id=${song.getArtist_id().getId()}">${song.getArtist_id().getName()}</a></span>
                        <span>In: <a href="detail/genre?id=${song.getGenre_id().getId()}">${song.getGenre_id().getName()}</a></span>

                    </div>
                    <div class="music-buttons">
                        <a href="" class="play">
                            <i class="far fa-play-circle" aria-hidden="true"></i>
                        </a>
                        <#if user??>

                        <button class="favorite-button" id="favorite">
                            Favorite
                            <i class="far fa-star ${(liked)?then("fas", "")}" id="favorite-star"></i>
                            </i>
                            <input type="hidden" id="like-btn" value="${song.getId()}">
                        </button>
                        </#if>

                        <span class="playing_count">
                                        <i class="fa fa-caret-right"></i>
                                        ${likes}
                                    </span>
                    </div>

                </div>
            </div>
        </div>

        <#if user??>
        <div class="comment_area">

            <h3 class="artist-music-header">Leave a comment</h3>
            <form action="/commentsave" method="post">
                <input hidden name="song_id" value="${song.getId()}">
                <div class="form-group">
                    <label for="comment">Comment:</label>
                    <span class="required">*</span>
                    <textarea name="user_text" id="comment" cols="45" rows="8"></textarea>
                </div>

                <input name="submit" class="btn comment-submit" type="submit" value="Post Comment">
            </form>
        </div>
        </#if>

        <div class="comments">
            <h3 class="artist-music-header">Comments</h3>
            <div class="list-group music-group">

                <#list comments as comment>

                <div class="list-group-item music-group-item comment">
                    <div class="item-name">
                        <a href="#"><strong>${comment.getUser_id().getName()}</strong></a>
                        <div class="item-author">
                        ${comment.getUser_text()}
                        </div>
                        <span class="comment-date">${comment.getCreated_at()}</span>
                    </div>
                </div>
                </#list>

            </div>
        </div>
    </div>

</div>
    <#include "../layouts/sideartists.ftl">


</@base.main>
