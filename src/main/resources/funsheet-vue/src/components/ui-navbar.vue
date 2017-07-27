<template>
    <div>
        <nav class="navbar">
            <div class="container">
                <div class="navbar-brand">
                    <a class="navbar-item" href="/">
                        Funsheet
                    </a>
                    <div class="navbar-burger burger" data-target="navMenuExample">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                </div>

                <div id="navMenuExample" class="navbar-menu">
                    <div class="navbar-start">
                        <router-link class="navbar-item" to="/">
                            Home
                        </router-link>
                        <div class="navbar-item has-dropdown is-hoverable">
                            <a class="navbar-link is-active">
                                Create
                            </a>
                            <div class="navbar-dropdown">
                                <router-link class="navbar-item" to="/activity/create">
                                    Activity
                                </router-link>
                                <router-link class="navbar-item" to="/location/create">
                                    Location
                                </router-link>
                                <router-link class="navbar-item" to="/type/create">
                                    Type
                                </router-link>
                                <router-link class="navbar-item" to="/tag/create">
                                    Tag
                                </router-link>
                            </div>
                        </div>
                        <div class="navbar-item has-dropdown is-hoverable">
                            <a class="navbar-link">
                                View all
                            </a>
                            <div id="blogDropdown" class="navbar-dropdown">
                                <router-link class="navbar-item" to="/activity/all">
                                    Activity
                                </router-link>
                                <router-link class="navbar-item" to="/location/all">
                                    Location
                                </router-link>
                                <router-link class="navbar-item" to="/type/all">
                                    Type
                                </router-link>
                                <router-link class="navbar-item" to="/tag/all">
                                    Tag
                                </router-link>
                            </div>
                        </div>
                    </div>

                    <div class="navbar-end">
                        <div class="navbar-item">
                            <div class="field is-grouped">
                                <p class="control">
                                    <router-link class="button"
                                       to="/login">
                                    <span class="icon">
                                        <i class="fa fa-user"></i>
                                    </span>
                                        <span>Sign in</span>
                                    </router-link>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</template>

<style lang="scss" scoped>
    @import '../scss/global';

    .navbar-brand {
        font-family: $font-brand;
    }
</style>
