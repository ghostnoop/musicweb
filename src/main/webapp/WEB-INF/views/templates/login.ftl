<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>

<@base.main css=["login_page"]>
<div class="col content-col">

    <div class="container-fluid login-container2">
        <section class="login-section">
            <article>
                <h1>Login</h1>
                <#if error??>
                    <div class="error-active">
                        <span class="error-text">
                                <strong>Error:</strong>
                                ${error}
                                </span>
                    </div>
                </#if>
                <form action="/login" class="login-form" method="post">
                    <fieldset>
                        <legend>Log into Your Account</legend>
                        <p class="login-username">
                            <label for="user-login">Email</label>
                            <input id="user-login" name="user-login" type="email" class="required in-user-login">
                        </p>
                        <p class="login-password">
                            <label for="user-password">Password</label>
                            <input id="user-password" name="user-password" type="password" class="required in-user-password">
                        </p>
                        <p class="login-remember">
                            <label>
                                <input type="checkbox" name="rememberme" id="rememberme" value="forever">
                                Remember Me
                            </label>
                        </p>
                        <p class="login-artist">
                            <label>
                                <input type="checkbox" name="is-artist" id="isartist" value="forever">
                                Artist ?
                            </label>
                        </p>
                        <p class="login-submit">
                            <input id="user_submit" type="submit" class="in-user-submit" value="Log In">
                        </p>
                        <!-- lost your password ?
                            <p class="login-lost-password"></p>
                        -->
                        <a href="/register" class="text-info">Register New Account</a>
                    </fieldset>
                </form>
            </article>
        </section>
    </div>
</div>
</@base.main>
