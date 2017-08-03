<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        {{ location.name }}
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
            <place-view :location="location"></place-view>
            <div class="card">
                <div class="card-content">
                    <h3 class="title">Everything to do in {{ location.name }}</h3>
                    <ul>
                        <template v-for="activity in activitiesAtLocation">
                            <activity :activity="activity"></activity><br>
                        </template>
                    </ul>
                </div>
            </div>
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
