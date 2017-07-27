<template>
    <div>
        <h1 class="title">Register</h1>
        <form method="post"
              action="/register">
            <div class="field">
                <label class="label">
                    Username
                    <span class="control">
                        <input type="text"
                               name="username"
                               class="input"
                               required>
                    </span>
                </label>
            </div>
            <div class="field">
                <label class="label">
                    Password
                    <span class="control">
                        <input type="password"
                               name="password"
                               class="input"
                               required>
                    </span>
                </label>
            </div>
            <div class="field">
                <label class="label">
                    Confirm Password
                    <span class="control">
                        <input type="password"
                               class="input"
                               required>
                    </span>
                </label>
            </div>
            <button class="button">Login</button>
        </form>
    </div>
</template>
