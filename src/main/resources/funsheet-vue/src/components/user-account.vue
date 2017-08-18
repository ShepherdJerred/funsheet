<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-two-thirds-desktop is-offset-2-desktop">
                    <h1 class="title">
                        {{ username }}
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-two-thirds-desktop is-offset-2-desktop">
            <button class="button" v-on:click="onClick()">Log out</button>
        </div>
    </div>
</template>

<script>
  import jwt from 'jwt-decode';

  export default {
    name: 'User-Account',
    computed: {
      username: function () {
        return jwt(localStorage.getItem('jwt')).username;
      }
    },
    methods: {
      onClick: function () {
        localStorage.removeItem('jwt');
        // TODO Find a better way to do this
        // Reload the page to update the navbar
        location.reload();
        this.$router.push({name: 'Home'});
      }
    }
  };
</script>
