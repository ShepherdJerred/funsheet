<template>
    <div id="app">
        <navbar></navbar>
        <router-view></router-view>
    </div>
</template>

<script>
  import Navbar from './components/ui-navbar.vue';

  export default {
    name: 'App',
    components: {
      Navbar
    },
    created: function () {
      this.$store.dispatch('getActivities');
      this.$store.dispatch('getLocations');
      this.$store.dispatch('getTypes');
      this.$store.dispatch('getTags');
    }
  };
</script>

<style lang="scss">
    @import 'scss/global';

    #app {
        background: $neutral-light;
        min-height: 100vh;
    }
</style>
