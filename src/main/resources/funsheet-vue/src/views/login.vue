<template>
    <div>
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <login></login>
            <register></register>
        </div>
    </div>
</template>

<script>
  import Login from '../components/app-login.vue';
  import Register from '../components/app-register.vue';

  export default {
    components: {
      Login,
      Register
    }
  };
</script>
