<template>
    <div>
        <nav class="navbar">
            <div class="navbar-brand">
                <a class="navbar-item" href="/">
                    Funsheet
                </a>
                <div class="navbar-burger burger" v-bind:class="{ 'is-active': isActive }" data-target="navbar"
                     v-on:click="toggleActive()">
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
            </div>

            <div id="navbar" class="navbar-menu" v-bind:class="{ 'is-active': isActive }">
                <div class="navbar-start">
                    <router-link class="navbar-item" to="/" active-class="is-active" v-on:click="toggleActive()">
                        Home
                    </router-link>
                    <div class="navbar-item has-dropdown is-hoverable">
                        <a class="navbar-link">
                            Create
                        </a>
                        <div class="navbar-dropdown">
                            <router-link class="navbar-item" to="/activity/create" active-class="is-active"
                                         v-on:click.native="toggleActive()">
                                Activity
                            </router-link>
                            <router-link class="navbar-item" to="/location/create" active-class="is-active"
                                         v-on:click.native="toggleActive()">
                                Location
                            </router-link>
                            <router-link class="navbar-item" to="/type/create" active-class="is-active"
                                         v-on:click.native="toggleActive()">
                                Type
                            </router-link>
                            <router-link class="navbar-item" to="/tag/create" active-class="is-active"
                                         v-on:click.native="toggleActive()">
                                Tag
                            </router-link>
                        </div>
                    </div>
                    <div class="navbar-item has-dropdown is-hoverable">
                        <a class="navbar-link">
                            View all
                        </a>
                        <div id="blogDropdown" class="navbar-dropdown">
                            <router-link class="navbar-item" to="/activity/all" active-class="is-active"
                                         v-on:click.native="toggleActive()">
                                Activities
                            </router-link>
                            <router-link class="navbar-item" to="/location/all" active-class="is-active"
                                         v-on:click.native="toggleActive()">
                                Locations
                            </router-link>
                            <router-link class="navbar-item" to="/type/all" active-class="is-active"
                                         v-on:click.native="toggleActive()">
                                Types
                            </router-link>
                            <router-link class="navbar-item" to="/tag/all" active-class="is-active"
                                         v-on:click.native="toggleActive()">
                                Tags
                            </router-link>
                        </div>
                    </div>
                </div>

                <!--<div class="navbar-end">-->
                <!--<div class="navbar-item">-->
                <!--<div class="field is-grouped">-->
                <!--<p class="control">-->
                <!--<router-link class="button"-->
                <!--to="/login"
                 v-on:click="toggleActive()">-->
                <!--<span class="icon">-->
                <!--<i class="fa fa-user"></i>-->
                <!--</span>-->
                <!--<span>Sign in</span>-->
                <!--</router-link>-->
                <!--</p>-->
                <!--</div>-->
                <!--</div>-->
                <!--</div>-->
            </div>
        </nav>
    </div>
</template>

<script>
  export default {
    data: function () {
      return {
        isActive: false
      };
    },
    methods: {
      toggleActive: function () {
        this.isActive = !this.isActive;
      }
    }
  };
</script>

<style lang="scss" scoped>
    @import '../scss/global';

    .navbar-brand {
        font-family: $font-brand;
    }
</style>
