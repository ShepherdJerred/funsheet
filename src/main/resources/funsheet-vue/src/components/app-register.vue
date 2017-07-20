<template>
    <div>
        <h1>Register</h1>
        <form method="post"
              action="/register"
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
            <label>
                Confirm Password
                <input type="password"
                       required>
            </label>
            <button class="pure-button pure-button-primary">Register</button>
        </form>
    </div>
</template>
