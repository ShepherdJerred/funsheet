<template>
    <div>
        <activity :uuid="activity.uuid"
                  :name="activity.name"
                  :type="activity.type.name"
                  :rating="activity.rating"
                  :location="activity.location.name">
        </activity>
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
    },
    created: function () {
      this.$store.dispatch('getActivities');
    }
  };
</script>
