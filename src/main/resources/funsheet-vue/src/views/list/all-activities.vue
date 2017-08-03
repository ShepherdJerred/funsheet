<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-half-desktop is-offset-one-quarter-desktop">
                    <h1 class="title">
                        All Activities
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-half-desktop is-offset-one-quarter-desktop">
            <activity-table :activities="activities">
            </activity-table>
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
