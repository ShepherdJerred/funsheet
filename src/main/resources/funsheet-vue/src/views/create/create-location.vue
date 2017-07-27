<template>
    <div>
        <section class="hero is-primary">
            <div class="hero-body">
                <div class="container">
                    <h1 class="title">
                        Create location
                    </h1>
                </div>
            </div>
        </section>
        <div class="container">
            <create-location></create-location>
        </div>
    </div>
</template>

<script>
  import CreateLocation from '../../components/location/create-location.vue';

  export default {
    components: {
      CreateLocation
    }
  };
</script>
