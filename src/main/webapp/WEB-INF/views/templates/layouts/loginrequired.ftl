<section>
    <footer class="footer  footer-player">
        <div class="footer-container container-fluid">
            <div class="row">
                <div class="col-auto login unside" id="unside_login">
                    <#if !user??>
                        <a href="/login">
                            <i class="fas fa-user-plus"></i>
                            <span>Login</span>
                        </a>
                    </#if>

                </div>
                <div class="col-auto login side pt-4" id="side_login">
                    <#if !user??>
                        <a href="/login" id="login-ref">
                            <i class="fas fa-user-plus"></i>
                        </a>
                    </#if>
                </div>
                <div class="col player">
                    <div class="player-interface">
                        <div class="row">
                            <div class="col-auto left-buttons">
                                <div class="back" id="prevBtn">
                                    <i class="fas fa-backward interface-btn"></i>
                                </div>
                                <div class="start" id="playBtn">
                                    <i class="far fa-play-circle interface-activity" aria-hidden="true"></i>
                                </div>
                                <div class="hide stop" id="pauseBtn">
                                    <i class="far fa-pause-circle interface-activity" aria-hidden="true"></i>
                                </div>
                                <div class="next" id="nextBtn">
                                    <i class="fas fa-forward interface-btn"></i>
                                </div>
                                <div class="playlist" id="playlistBtn">
                                    <i class="fas fa-list-ul"></i>
                                </div>
                            </div>
                            <div class="col progress-track-interface">
                                <div class="track-progress">
                                    <a id="track"></a>
                                    <div id="waveform"></div>
                                    <div id="bar"></div>
                                    <div id="progress"></div>
                                </div>
                            </div>
                            <div class="col-auto right-buttons">
                                <div class="track-current-time track-time" id="timer">00:00</div>
                                <div class="track-duration-time track-time" id="duration">00:00</div>
                                <div class="volume" id="volumeBtn">
                                    <i class="fas fa-volume-up"></i>
                                </div>
                                <div class="volume-bar" id="volume">
                                    <div class="volume-bar-scale" id="barEmpty">
                                        <div class="volume-bar-scale-status" id="barFull"></div>
                                    </div>
                                </div>
                                <div class="loop">
                                    <a href=""><i class="fas fa-circle-notch"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="playlist hide" id="playlist">
                        <ul id="playlist-list">
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</section>
