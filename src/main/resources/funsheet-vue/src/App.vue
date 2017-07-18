<template>
    <div id="app">
        <div class="pure-g">
            <div class="pure-u-1">
                <app-navbar></app-navbar>
            </div>
        </div>
        <div class="pure-g">
            <div class="pure-u-1">
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>

<script>
  import AppNavbar from './components/app-navbar.vue';

  export default {
    components: {
      AppNavbar
    },
    name: 'app'
  };
</script>

<style lang="scss" scoped>
    @import 'scss/_variables.scss';
    #app {
        background: $background;
        min-height: 100vh;
    }
</style>
