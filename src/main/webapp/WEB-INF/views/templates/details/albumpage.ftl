<#ftl encoding="UTF-8"/>
<#import "../layouts/base.ftl" as base>

<@base.main css=["artist_page","music_page"] js=["favorite"]>

    <div class="col content-col ">
        <div class="main-panel">
            <div class="artist-inf">
                <div class="row">
                    <div class="col-sm-4 artist-image">
                        <img src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/m13.jpg" alt="">
                    </div>
                    <div class="col-sm-8 artist-desc">
                        <!-- Название Альбома -->
                        <h1>Top Board</h1>
                        <div class="meta">
                            <span>Artist: <a href="">Bossr</a></span>
                            <span>Publish: 2013</span>
                            <span>In: <a href="">Rock</a>, <a href="">Jazz</a></span>
                        </div>
                        <div class="music-buttons">
                            <a href="" class="play">
                                <i class="far fa-play-circle" aria-hidden="true"></i>
                            </a>
                            <!-- должна идти по контексту-->
                            <!-- far - если не любимчик, fas - если любимчик -->
                            <button class="favorite-button" id="favorite">
                                Favorite
                                <i id="favorite-star" class="far fa-star"></i>
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
                <div class="music-text">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sequitur disserendi ratio
                        cognitioque naturae; <b>Summae mihi videtur inscitiae.</b> <i>Utram tandem linguam
                            nescio?</i> Audeo dicere, inquit. Duo Reges: constructio interrete. Istam
                        voluptatem, inquit, Epicurus ignorat? <i>Tum Torquatus: Prorsus, inquit, assentior;</i>
                    </p>
                    <p>Huius ego nunc auctoritatem sequens idem faciam. Haec quo modo conveniant, non sane
                        intellego. <i>Praeclare hoc quidem.</i> Quorum sine causa fieri nihil putandum est.
                        Illud non continuo, ut aeque incontentae.</p>
                    <p>Nulla erit controversia. Magna laus. Nos commodius agimus.</p>
                    <p>Haec igitur Epicuri non probo, inquam.
                        <mark>Urgent tamen et nihil remittunt.</mark>
                        Sin aliud quid voles, postea. A mene tu? Nihilo magis.
                    </p>
                    <p>Istic sum, inquit. Qualem igitur hominem natura inchoavit?</p>
                </div>
            </div>
            <!-- Музыка артиста -->
            <h3 class="artist-music-header">Music</h3>
            <div class="list-group music-group">
                <div class="list-group-item music-group-item">
                    <div class="music-img">
                        <div class="overlay">
                            <div class="item-overlay">
                                <a href="">
                                    <i class="far fa-play-circle" aria-hidden="true"></i>
                                </a>
                            </div>
                        </div>
                        <a href="">
                            <img src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/b5-150x150.jpg"
                                 alt="">
                        </a>
                    </div>
                    <div class="item-name">
                        <a href="#"><strong>Hidden</strong></a>
                        <div class="item-author">
                            by
                            <a href="#">Bossr</a>
                        </div>
                    </div>
                </div>
                <div class="list-group-item music-group-item">
                    <div class="music-img">
                        <div class="overlay">
                            <div class="item-overlay">
                                <a href="">
                                    <i class="far fa-play-circle" aria-hidden="true"></i>
                                </a>
                            </div>
                        </div>
                        <a href="">
                            <img src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/b5-150x150.jpg"
                                 alt="">
                        </a>
                    </div>
                    <div class="item-name">
                        <a href="#"><strong>Hidden</strong></a>
                        <div class="item-author">
                            by
                            <a href="#">Bossr</a>
                        </div>
                    </div>
                </div>
                <div class="list-group-item music-group-item">
                    <div class="music-img">
                        <div class="overlay">
                            <div class="item-overlay">
                                <a href="">
                                    <i class="far fa-play-circle" aria-hidden="true"></i>
                                </a>
                            </div>
                        </div>
                        <a href="">
                            <img src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/b5-150x150.jpg"
                                 alt="">
                        </a>
                    </div>
                    <div class="item-name">
                        <a href="#"><strong>Hidden</strong></a>
                        <div class="item-author">
                            by
                            <a href="#">Bossr</a>
                        </div>
                    </div>
                </div>
                <div class="list-group-item music-group-item">
                    <div class="music-img">
                        <div class="overlay">
                            <div class="item-overlay">
                                <a href="">
                                    <i class="far fa-play-circle" aria-hidden="true"></i>
                                </a>
                            </div>
                        </div>
                        <a href="">
                            <img src="http://flatfull.com/wp/musik/wp-content/uploads/2015/07/b5-150x150.jpg"
                                 alt="">
                        </a>
                    </div>
                    <div class="item-name">
                        <a href="#"><strong>Hidden</strong></a>
                        <div class="item-author">
                            by
                            <a href="#">Bossr</a>
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
    <#include "../layouts/sideartists.ftl">




</@base.main>
