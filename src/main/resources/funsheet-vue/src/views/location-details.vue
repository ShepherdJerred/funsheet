<template>
    <div>
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <location :name="location.name"
                      :coordinate="location.coordinate">
            </location>
            <h3>Everything to do in {{ location.name }}</h3>
            <ul>
                <template v-for="activity in activitiesAtLocation">
                    <activity :uuid="activity.uuid"
                              :name="activity.name"
                              :type="activity.type"
                              :rating="activity.rating"
                              :location="activity.location">
                    </activity>
                </template>
            </ul>
        </div>
    </div>
</template>

<script>
  import Location from '../components/location.vue';
  import Activity from '../components/activity.vue';

  export default {
    components: {
      Location,
      Activity
    },
    computed: {
      activitiesAtLocation: function () {
        return this.activities.filter(e => e.location.uuid === this.$route.params.uuid);
      },
      activities: function () {
        return this.$store.state.activities;
      },
      location: function () {
        return this.locations.find(e => e.uuid === this.$route.params.uuid);
      },
      locations: function () {
        return this.$store.state.locations;
      }
    }
  };
</script>
