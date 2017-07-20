<template>
    <div>
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <activity-table :activities="activities">
            </activity-table>
        </div>
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
      }
    };
</script>
