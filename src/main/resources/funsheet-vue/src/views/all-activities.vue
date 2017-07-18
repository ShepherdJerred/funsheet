<template>
    <div>
        <activity-table :activities="activities">
        </activity-table>
    </div>
</template>

<script>
    import ActivityTable from '../components/activity-table.vue';

    export default {
      components: {
        ActivityTable
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
