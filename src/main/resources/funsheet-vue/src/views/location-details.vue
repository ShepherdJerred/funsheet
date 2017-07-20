<template>
    <div>
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <location :name="location.name"
                      :placeId="location.placeId">
            </location>

            <iframe
                    width="600"
                    height="450"
                    frameborder="0"
                    style="border: 0"
                    :src="'https://www.google.com/maps/embed/v1/place?key=AIzaSyDzHtAQxI5QVj-1aohH0f8VtmMfTFQxyFQ' +
                     '&q=place_id:' + location.placeId"
                    allowfullscreen>
            </iframe>
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
