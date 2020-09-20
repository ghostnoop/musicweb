# Documentation for the 'Music Player' web application
An app for listening to music, making playlists, and uploading your own tracks.
## Technology stack
- ### Frontend 
  - HTML / JS / CSS
  - Bootstrap v.4.5.2
  - JQuery v.3.5.1
  
- ### Backend
  - Java Servlets v.4.0.1 
  - Freemarker template engine v.2.3.30
  - JDBS MySQL v.8.0.21
 
## Сoncepts and patterns
- ### Concept of development
  - MVC
- ### Design pattern
  - Repository
- ### Database design technology
  - ORM
  
 ## The functionality of the site
 - Authorization, registration, remember me.
 - Сonfigurable user Profile, view playlists in your profile.
 - View information, the ability to enter information (upload musics, leaving comments).
 - Division of functionality between registered and unregistered users. 
    - An unregistered user can't leave comments or upload their own music, creating playlists.
    - For anonymous users, you can still listen to music.
 - The comments under the tracks, playlists.
 - Search by track name, artist name, filter by genre, novelty, length, and popularity.
 
 ## The task of developing applications
 - Using sessions in authorization.
 - Using cookies to remember me.
 - Using include and inheritance in templates.
 - At least 3 forms with different widgets-text, textarea, select, check, file-field.
 - Password hashing.
 - Full implementation of the MVC concept.
 - Validation of data (on the client and server) entered by the user.
 - Using ajax requests for search/verification.
 - Workability of all pages.
 - User-friendly interface for working with tracks.
 - Fast operation and loading of the site
