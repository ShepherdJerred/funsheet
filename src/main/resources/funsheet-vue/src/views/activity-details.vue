<template>
    <div>
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <activity :uuid="activity.uuid"
                      :name="activity.name"
                      :type="activity.type"
                      :rating="activity.rating"
                      :location="activity.location">
            </activity>
        </div>
    </div>
</template>

<script>
  import Activity from '../components/activity.vue';

  export default {
    components: {
      Activity
    },
    computed: {
      activity: function () {
        return this.activities.find(e => e.uuid === this.$route.params.uuid);
      },
      activities: function () {
        return this.$store.state.activities;
      }
    }
  };
</script>
