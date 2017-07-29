<template>
    <div>
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <activity-table :activities="activities">
                </activity-table>
            </div>
        </div>
    </div>
</template>

<script>
  import ActivityTable from '../../components/activity/activity-table.vue';

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
