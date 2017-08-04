<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        Edit {{ location.name }}
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
            <edit-location :location="location"></edit-location>
        </div>
    </div>
</template>

<script>
  import EditLocation from '../../components/location/edit-location.vue';

  export default {
    components: {
      EditLocation
    },
    computed: {
      location: function () {
        return this.locations.find(location => location.uuid === this.$route.params.uuid);
      },
      locations: function () {
        return this.$store.state.locations;
      }
    }
  };
</script>
