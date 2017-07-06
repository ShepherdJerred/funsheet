<template>
    <div>
        <h3>Activites</h3>
        <create-activity></create-activity>
        <template v-for="activity in activities">
            <activity :name="activity.name"
                      :type="activity.type"
                      :rating="activity.rating"
                      :location="activity.location">
            </activity>
        </template>
    </div>
</template>

<script>
  import createActivity from './create-activity.vue';
  import activity from './activity.vue';

  export default {
    components: {
      createActivity,
      activity
    },
    computed: {
      activities: function () {
        return this.$store.state.activities;
      }
    },
    created: function () {
      this.$store.dispatch('getActivities');
    }
  };
</script>
