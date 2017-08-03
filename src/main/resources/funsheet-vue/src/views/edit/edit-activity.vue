<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        Edit {{ activity.name }}
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
            <edit-activity :activity="activity"></edit-activity>
        </div>
    </div>
</template>

<script>
  import EditActivity from '../../components/activity/edit-activity.vue';

  export default {
    components: {
      EditActivity
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
