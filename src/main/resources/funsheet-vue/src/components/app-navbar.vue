<template>
    <div class="navbar">
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <div class="navbar__items">
                <nav class="navbarBrand">
                    <a href="" class="navbarLink">Funsheet</a>
                </nav>
                <nav class="navbarLinks">
                    <router-link to="/" class="navbarLink">Home</router-link>
                    <router-link to="/activity/create" class="navbarLink">Create Activity</router-link>
                    <router-link to="/location/create" class="navbarLink">Create Location</router-link>
                    <router-link to="/tag/create" class="navbarLink">Create Tag</router-link>
                    <router-link to="/type/create" class="navbarLink">Create Type</router-link>
                </nav>
            </div>
        </div>
    </div>
</template>

<script>

</script>

<style lang="scss" scoped>
    $background: #7367F0;

    .navbar {
        color: #fff;
        background: $background;
        margin-bottom: 10px;
    }

    .navbar__items {
        display: flex;
        justify-content: space-between;
    }

    .navbarBrand__link {
        color: #fff;
        padding: 15px 10px;
        display: block;
        text-decoration: none;
    }

    .navbarLinks {
    }

    .navbarLink {
        color: #fff;
        padding: 15px 10px;
        display: inline-block;
        text-decoration: none;

        &:hover {
            background: darken($background, 5%);
        }
    }
</style>
