<template>
    <div>
        <section class="hero is-primary">
            <div class="hero-body">
                <div class="container">
                    <h1 class="title">
                        All Activities
                    </h1>
                </div>
            </div>
        </section>
        <div class="container">
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
