<template>
    <div>
        <h1>Activites</h1>
        <create-activity></create-activity>
        <template v-for="activity in activities">
            <activity :name="activity.name"
                      :type="activity.type"
                      :rating="activity.rating">
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
