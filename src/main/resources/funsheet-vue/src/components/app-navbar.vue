<template>
    <div class="navbar">
        <div class="pure-u-1-24"></div>
        <div class="pure-u-11-12">
            <div class="navbar__items">
                <nav class="navbarLinks">
                    <a href="" class="navbarLink navbarLink--brand">Funsheet</a>
                    <router-link to="/"
                                 class="navbarLink">Home</router-link>
                </nav>
                <nav class="navbarLinks">
                    <router-link to="/login"
                                 class="navbarLink">Login</router-link>
                    <router-link to="/register"
                                 class="navbarLink">Sign Up</router-link>
                </nav>
            </div>
        </div>
    </div>
</template>

<script>

</script>

<style lang="scss" scoped>
@import "../scss/variables";
    .navbar {
        color: $color;
        background: $background;
        margin-bottom: 10px;
        display: flex;
        text-transform: none;
    }

    .navbar__items {
        display: flex;
        justify-content: space-between;
    }

    .navbarLinks {
        display: flex;
        flex-direction: row;
        font-family: 'Cabin', sans-serif;
        font-size: 18px;
        align-items: center;
    }

    .navbarLink {
        color: $color;
        padding: 5px 15px;
        text-decoration: none;

        &:hover {
            background: darken($background, 5%);
        }
    }

.navbarLink--brand {
    display: flex;
    font-family: 'Lobster', cursive;
    font-size: 22px;
    align-items: center;
}
</style>
