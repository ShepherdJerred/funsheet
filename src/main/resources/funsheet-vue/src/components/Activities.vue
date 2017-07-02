<template>
    <h1>Activites</h1>
    <template v-for="activity in activities">
        <activity :name="activity.name"
                  :type="activity.type"
                  :rating="activity.rating">
        </activity>
    </template>
</template>

<script>
  import activity from './Activity.vue';

  export default {
    components: {
      activity
    },
    computed: {
      activities: function () {
        return this.$store.state.activities;
      }
    }
  };
</script>

<style>

</style>
