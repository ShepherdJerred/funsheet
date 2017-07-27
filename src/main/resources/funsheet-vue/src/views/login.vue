<template>
    <div>
        <section class="hero is-primary">
            <div class="hero-body">
                <div class="container">
                    <h1 class="title">
                        Login
                    </h1>
                </div>
            </div>
        </section>
        <div class="container">
            <login></login>
        </div>
    </div>
</template>

<script>
  import Login from '../components/ui-login.vue';

  export default {
    components: {
      Login
    }
  };
</script>
