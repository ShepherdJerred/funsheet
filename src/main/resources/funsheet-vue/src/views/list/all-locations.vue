<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-half-desktop is-offset-one-quarter-desktop">
                    <h1 class="title">
                        All Locations
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-half-desktop is-offset-one-quarter-desktop">
            <location-table :locations="locations">
            </location-table>
        </div>
    </div>
</template>

<script>
  import LocationTable from '../../components/location/location-table.vue';

  export default {
    components: {
      LocationTable
    },
    computed: {
      locations: function () {
        return this.$store.state.locations;
      }
    }
  };
</script>
