<template>
    <div>
        <h1>Activites</h1>
        <a href="/">Add activity</a>
        <template v-for="activity in activities">
            <activity :name="activity.name"
                      :type="activity.type"
                      :rating="activity.rating">
            </activity>
        </template>
    </div>
</template>

<script>
  import activity from './activity.vue';

  export default {
    components: {
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

<style>

</style>
