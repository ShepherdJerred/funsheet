<template>
    <div>
        <form method="post"
              action="/login/callback">
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
            <button class="button">Login</button>
        </form>
    </div>
</template>
