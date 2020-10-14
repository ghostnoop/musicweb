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
                    </div>
                    <div class="music-buttons">
                        <a href="" class="play">
                            <i class="far fa-play-circle" aria-hidden="true"></i>
                        </a>
                        <button class="favorite-button" id="favorite">
                            Favorite
                            <i class="far fa-star" id="favorite-star"></i>
                            <!-- favorite
                            <i class="fas fa-star"></i>
                            -->
                            </i>
                        </button>
                        <span class="playing_count">
                                        <i class="fa fa-caret-right"></i>
                                        1246
                                    </span>
                    </div>

                </div>
            </div>
        </div>
        <div class="comment_area">
            <h3 class="artist-music-header">Leave a comment</h3>
            <form action="" method="post">
                <p class="comment-notes">
                    Your email address will not be published.
                    Required fields are marked
                    <span class="required">*</span>
                </p>
                <div class="form-group">
                    <label for="comment">Comment:</label>
                    <span class="required">*</span>
                    <textarea name="comment" id="comment" cols="45" rows="8"></textarea>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="author">Your Name:</label>
                        <span class="required">*</span>
                        <input class="form-control" id="author" name="author" type="text">
                    </div>
                    <div class="col-sm-6">
                        <label for="email">Your Email:</label>
                        <span class="required">*</span>
                        <input class="form-control" id="email" name="email" type="text">
                    </div>
                </div>
                <input name="submit" class="btn comment-submit" type="submit" value="Post Comment">
            </form>
        </div>
        <div class="comments">
            <h3 class="artist-music-header">Comments</h3>
            <div class="list-group music-group">
                <div class="list-group-item music-group-item comment">
                    <div class="item-name">
                        <a href="#"><strong>Tempered Song</strong></a>
                        <div class="item-author">
                            by Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sequitur disserendi ratio cognitioque naturae; Summae mihi videtur inscitiae. Utram tandem linguam nescio? Audeo dicere, inquit. Duo Reges: constructio interrete. Istam voluptatem, inquit, Epicurus ignorat? Tum Torquatus: Prorsus, inquit, assentior;
                            Huius ego nunc auctoritatem sequens idem faciam. Haec quo modo conveniant, non sane intellego. Praeclare hoc quidem. Quorum sine causa fieri nihil putandum est. Illud non continuo, ut aeque incontentae.
                        </div>
                        <span class="comment-date">21.09.2020</span>
                    </div>
                </div>
                <div class="list-group-item music-group-item comment">
                    <div class="item-name">
                        <a href="#"><strong>Tempered Song</strong></a>
                        <div class="item-author">
                            by Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sequitur disserendi ratio cognitioque naturae; Summae mihi videtur inscitiae. Utram tandem linguam nescio? Audeo dicere, inquit. Duo Reges: constructio interrete. Istam voluptatem, inquit, Epicurus ignorat? Tum Torquatus: Prorsus, inquit, assentior;
                            Huius ego nunc auctoritatem sequens idem faciam. Haec quo modo conveniant, non sane intellego. Praeclare hoc quidem. Quorum sine causa fieri nihil putandum est. Illud non continuo, ut aeque incontentae.
                        </div>
                        <span class="comment-date">21.09.2020</span>
                    </div>
                </div>
                <div class="list-group-item music-group-item comment">
                    <div class="item-name">
                        <a href="#"><strong>Tempered Song</strong></a>
                        <div class="item-author">
                            by Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sequitur disserendi ratio cognitioque naturae; Summae mihi videtur inscitiae. Utram tandem linguam nescio? Audeo dicere, inquit. Duo Reges: constructio interrete. Istam voluptatem, inquit, Epicurus ignorat? Tum Torquatus: Prorsus, inquit, assentior;
                            Huius ego nunc auctoritatem sequens idem faciam. Haec quo modo conveniant, non sane intellego. Praeclare hoc quidem. Quorum sine causa fieri nihil putandum est. Illud non continuo, ut aeque incontentae.
                        </div>
                        <span class="comment-date">21.09.2020</span>
                    </div>
                </div>
                <div class="list-group-item music-group-item comment">
                    <div class="item-name">
                        <a href="#"><strong>Tempered Song</strong></a>
                        <div class="item-author">
                            by Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sequitur disserendi ratio cognitioque naturae; Summae mihi videtur inscitiae. Utram tandem linguam nescio? Audeo dicere, inquit. Duo Reges: constructio interrete. Istam voluptatem, inquit, Epicurus ignorat? Tum Torquatus: Prorsus, inquit, assentior;
                            Huius ego nunc auctoritatem sequens idem faciam. Haec quo modo conveniant, non sane intellego. Praeclare hoc quidem. Quorum sine causa fieri nihil putandum est. Illud non continuo, ut aeque incontentae.
                        </div>
                        <span class="comment-date">21.09.2020</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

    <section class="aside-info">
        <aside>
            <h4>Top 5 artist</h4>
            <div class="col-auto aside-col-info">

                <!-- должно приходить с бд-->
                <div class="list-group">
                    <div class="list-group-item">
                        <div class="avatar-container"><a href=""><img
                                        src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/b17-150x150.jpg"
                                        alt=""></a></div>
                        <div class="name-container"><a href="">Miaow</a></div>
                    </div>
                    <div class="list-group-item">
                        <div class="avatar-container"><a href=""><img
                                        src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/m19-150x150.jpg"
                                        alt=""></a></div>
                        <div class="name-container"><a href="">The Stark Palace</a></div>
                    </div>
                    <div class="list-group-item">
                        <div class="avatar-container"><a href=""><img
                                        src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/b16-150x150.jpg"
                                        alt=""></a></div>
                        <div class="name-container"><a href="">Bossr</a></div>
                    </div>
                    <div class="list-group-item">
                        <div class="avatar-container"><a href=""><img
                                        src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/m17-150x150.jpg"
                                        alt=""></a></div>
                        <div class="name-container"><a href="">Crystal Guerrero</a></div>
                    </div>
                    <div class="list-group-item">
                        <div class="avatar-container"><a href=""><img
                                        src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/b19-150x150.jpg"
                                        alt=""></a></div>
                        <div class="name-container"><a href="">James Garcia</a></div>
                    </div>
                </div>
                <!-- -->
            </div>
        </aside>
    </section>

</@base.main>
