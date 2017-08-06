<template>
    <div>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
            <login></login>
        </div>
    </div>
</template>

<script>
  import Login from './user-login.vue';

  export default {
    components: {
      Login
    }
  };
</script>
