<template>
    <div>
        <h1>Login</h1>
        <form method="post"
              action="/login/callback"
              class="pure-form pure-form-stacked">
            <label>
                Username
                <input type="text"
                       name="username"
                       required>
            </label>
            <label>
                Password
                <input type="password"
                       name="password"
                       required>
            </label>
            <button class="pure-button pure-button-primary">Login</button>
        </form>
    </div>
</template>
