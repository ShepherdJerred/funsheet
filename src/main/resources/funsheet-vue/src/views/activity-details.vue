<template>
    <div>
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <activity :activity="activity"></activity>
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
        return this.activities.find(activity => activity.uuid === this.$route.params.uuid);
      },
      activities: function () {
        return this.$store.state.activities;
      }
    }
  };
</script>
