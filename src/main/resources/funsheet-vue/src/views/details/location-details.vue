<template>
    <div>
        <div class="container">
            <location :location="location"></location>
            <place-view :placeId="location.placeId"></place-view>
            <h3>Everything to do in {{ location.name }}</h3>
            <ul>
                <template v-for="activity in activitiesAtLocation">
                    <activity :activity="activity"></activity>
                </template>
            </ul>
        </div>
    </div>
</template>

<script>
  import Location from '../../components/location/location.vue';
  import Activity from '../../components/activity/activity.vue';
  import PlaceView from '../../components/place-map.vue';

  export default {
    components: {
      Location,
      Activity,
      PlaceView
    },
    computed: {
      activitiesAtLocation: function () {
        return this.activities.filter(activity => activity.location.uuid === this.$route.params.uuid);
      },
      activities: function () {
        return this.$store.state.activities;
      },
      location: function () {
        return this.locations.find(location => location.uuid === this.$route.params.uuid);
      },
      locations: function () {
        return this.$store.state.locations;
      }
    }
  };
</script>
