$(function () {
    var elms = ['track', 'timer', 'duration', 'playBtn', 'playlist-list', 'pauseBtn', 'prevBtn', 'nextBtn', 'playlistBtn', 'volumeBtn', 'playlist', 'volume', 'barEmpty', 'barFull'];
    elms.forEach(function (elm) {
        window[elm] = document.getElementById(elm);
    });

    /**
     * Player class containing the state of our playlist and where we are in it.
     * Includes all methods for playing, skipping, updating the display, etc.
     * @param {Array} playlist Array of objects with playlist song details ({title, file, howl}).
     */
    var Player = function (playlist) {
        this.playlist = playlist;
        this.index = 0;

        // Display the title of the first track.
        track.innerHTML = '1. ' + playlist[0].title;

        playlist.forEach(function(song) {
            var div = document.createElement('li');
            div.innerHTML = '<div class="playlist-item">\n' +
                '                                    <a href=""><i class="far fa-play-circle interface-activity" aria-hidden="true"></i></a>\n' +
                '                                    <a class="playlist-item-remove" >×</a>\n' +
                '                                    <a class="jp-playlist-item jp-playlist-current" tabindex="0"></a>\n' +
                '                                    <a href="http://flatfull.com/wp/musik/music/lentement/" class="playlist-item-title">' + song.title + '</a>\n' +
                '                                    <span class="playlist-item-autor">by ' + song.author + '</span>\n' +
                '                                </div>';
            div.onclick = function() {
                player.skipTo(playlist.indexOf(song));
            };
            document.getElementById('playlist-list').appendChild(div);
        });
    };
    Player.prototype = {
        /**
         * Play a song in the playlist.
         * @param  {Number} index Index of the song in the playlist (leave empty to play the first or current).
         */
        play: function (index) {
            var self = this;
            var sound;

            index = typeof index === 'number' ? index : self.index;
            var data = self.playlist[index];

            // If we already loaded this track, use the current one.
            // Otherwise, setup and load a new Howl.
            if (data.howl) {
                sound = data.howl;
            } else {
                sound = data.howl = new Howl({
                    src: ['../audio/' + data.file],
                    html5: true, // Force to HTML5 so that the audio can stream in (best for large files).
                    onplay: function () {
                        // Display the duration.
                        duration.innerHTML = self.formatTime(Math.round(sound.duration()));

                        // Start upating the progress of the track.
                        requestAnimationFrame(self.step.bind(self));
                        pauseBtn.style.display = 'table-cell';
                    },
                    onend: function () {
                        self.skip('next');
                    },
                });
            }

            // Begin playing the sound.
            sound.play();

            // Update the track display.
            track.innerHTML = (index + 1) + '. ' + data.title;

            // Show the pause button.
            if (sound.state() === 'loaded') {
                playBtn.style.display = 'none';
                pauseBtn.style.display = 'table-cell';
            } else {
                playBtn.style.display = 'none';
                pauseBtn.style.display = 'none';
            }

            // Keep track of the index we are currently playing.
            self.index = index;
        },

        /**
         * Pause the currently playing track.
         */
        pause: function () {
            var self = this;

            // Get the Howl we want to manipulate.
            var sound = self.playlist[self.index].howl;

            // Puase the sound.
            sound.pause();

            // Show the play button.
            playBtn.style.display = 'table-cell';
            pauseBtn.style.display = 'none';
        },

        /**
         * Skip to the next or previous track.
         * @param  {String} direction 'next' or 'prev'.
         */
        skip: function (direction) {
            var self = this;

            // Get the next track based on the direction of the track.
            var index = 0;
            if (direction === 'prev') {
                index = self.index - 1;
                if (index < 0) {
                    index = self.playlist.length - 1;
                }
            } else {
                index = self.index + 1;
                if (index >= self.playlist.length) {
                    index = 0;
                }
            }

            self.skipTo(index);
        },

        /**
         * Skip to a specific track based on its playlist index.
         * @param  {Number} index Index in the playlist.
         */
        skipTo: function (index) {
            var self = this;

            // Stop the current track.
            if (self.playlist[self.index].howl) {
                self.playlist[self.index].howl.stop();
            }

            // Play the new track.
            self.play(index);
        },

        /**
         * Set the volume and update the volume slider display.
         * @param  {Number} val Volume between 0 and 1.
         */
        volume: function (val) {
            Howler.volume(val);

            // Update the display on the slider.
            var barWidth = (val * 100) / 100;
            barFull.style.width = (barWidth * 100) + '%';
        },

        /**
         * Seek to a new position in the currently playing track.
         * @param  {Number} per Percentage through the song to skip.
         */
        seek: function (per) {
            var self = this;

            // Get the Howl we want to manipulate.
            var sound = self.playlist[self.index].howl;

            // Convert the percent into a seek position.
            if (sound.playing()) {
                sound.seek(sound.duration() * per);
            }
        },

        /**
         * The step called within requestAnimationFrame to update the playback position.
         */
        step: function () {
            var self = this;

            // Get the Howl we want to manipulate.
            var sound = self.playlist[self.index].howl;

            // Determine our current seek position.
            var seek = sound.seek() || 0;
            timer.innerHTML = self.formatTime(Math.round(seek));
            // If the sound is still playing, continue stepping.
            if (sound.playing()) {
                requestAnimationFrame(self.step.bind(self));
            }
        },

        /**
         * Format the time from seconds to M:SS.
         * @param  {Number} secs Seconds to format.
         * @return {String}      Formatted time.
         */
        formatTime: function (secs) {
            var minutes = Math.floor(secs / 60) || 0;
            var seconds = (secs - minutes * 60) || 0;

            return minutes + ':' + (seconds < 10 ? '0' : '') + seconds;
        }
    };

// Setup our new audio player class and pass it the playlist.
    var player = new Player([
        {
            title: 'komety 1',
            author: 'polnalyubvi',
            file: 'komety.mp3',
            howl: null
        },
    ]);

    var isPlaying = false;

    playBtn.addEventListener('click', function () {
        player.play();
    });
    volumeBtn.addEventListener('click', function () {
        if (Howler.volume() === 0) {
            player.volume(1);
        } else {
            player.volume(0);
        }
    });
    pauseBtn.addEventListener('click', function () {
        isPlaying = false;
        player.pause();
    });
    prevBtn.addEventListener('click', function () {
        player.skip('prev');
    });
    nextBtn.addEventListener('click', function () {
        player.skip('next');
    });
    playlistBtn.addEventListener('click', function () {
        $('#playlist').toggleClass('hide');
    });
    playlist.addEventListener('click', function () {
        player.togglePlaylist();
    });
    barEmpty.addEventListener('click', function (event) {
        var per = (event.layerX - barEmpty.offsetLeft) / barEmpty.offsetWidth;
        player.volume(per);
    });
})