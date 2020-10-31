<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>

<@base.main css=["register_page","login_page"]>
<div class="col content-col">

    <div class="container-fluid login-container2">
        <section class="login-section">
            <article>
                <h1>Register</h1>
                <#if error??>
                    <div class="error-active">
                        <span class="error-text">
                                <strong>Error:</strong>
                                ${error}
                                </span>
                    </div>
                </#if>

                <form action="/register" class="login-form" method="post">
                    <fieldset>
                        <legend>Register New Account</legend>
                        <p class="login-username">
                            <label for="user-login">Username</label>
                            <input id="user-login" name="user-login" type="text"
                                   class="required in-user-login">
                        </p>
                        <p class="login-username">
                            <label for="user-login">lastname</label>
                            <input id="user-lastname" name="user-lastname" type="text"
                                   class="required in-user-login">
                        </p>

                        <p class="login-email">
                            <label for="user-email">Email</label>
                            <input id="user-email" name="user-email" type="email"
                                   class="required in-user-email">
                        </p>
                        <p class="login-password">
                            <label for="user-password">Password</label>
                            <input id="user-password" name="user-password" type="password"
                                   class="required in-user-password">
                        </p>
                        <p class="login-checkbox-artist">
                            <label for="user-checkbox-artist">Are you artist ?</label>
                            <input id="user-checkbox-artist" name="isArtist" type="checkbox" value="yes"
                                   class="required in-user-checkbox-artist">
                        </p>
                        <p class="login-submit">
                            <input id="user_submit" type="submit" class="in-user-submit" value="Register">
                        </p>
                    </fieldset>
                </form>
            </article>
        </section>
    </div>
</div>
</@base.main>
