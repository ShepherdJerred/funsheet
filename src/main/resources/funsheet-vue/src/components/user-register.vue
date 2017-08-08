<template>
    <div>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
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
                <button class="button is-primary">Login</button>
            </form>
        </div>
    </div>
</template>

<script>
  export default {
    name: 'User-Register'
  };
</script>
