<template>
    <div>
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <activity :activity="activity"></activity>
            </div>
        </div>
    </div>
</template>

<script>
  import Activity from '../../components/activity/activity.vue';

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
