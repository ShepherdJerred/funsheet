<template>
    <div>
        <h3>Locations</h3>
        <template v-for="location in locations">
            <location :name="location.name"
                      :coordinate="location.coordinate">
            </location>
        </template>
    </div>
</template>

<script>
  import createLocation from './create-location.vue';
  import location from './location.vue';

  export default {
    components: {
      createLocation,
      location
    },
    computed: {
      locations: function () {
        return this.$store.state.locations;
      }
    },
    created: function () {
      this.$store.dispatch('getLocations');
    }
  };
</script>
