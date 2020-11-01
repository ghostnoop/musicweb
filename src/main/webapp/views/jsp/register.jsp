<jsp:include page="header.jsp" />

<div class="col content-col">
    <div class="container-fluid login-container2">
        <section class="login-section">
            <article>
                <h1>Register</h1>
                <% Boolean error = (Boolean) request.getAttribute("error"); %>
                <% if (error!=null && error){ %>
                <div class="error-block"> <!-- .error-active -->
                    <!-- Сообщение об ошибке-->
                    <span class="error-text">
                                <strong>Error:</strong>
                                some error text
                                </span>
                </div>
                <%}%>
                <form action="${pageContext.request.contextPath}/register" class="login-form" method="post">
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
                            <input id="user-checkbox-artist" name="isArtist" type="checkbox" value="yes" class="required in-user-checkbox-artist">
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

<jsp:include page="footer.jsp" />
