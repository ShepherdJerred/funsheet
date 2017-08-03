<template>
    <div>
        <div class="hero">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        Create location
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
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
