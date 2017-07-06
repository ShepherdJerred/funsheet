<template>
    <div>
        <h3>Activites</h3>


        <table class="pure-table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Rating</th>
                <th>Location</th>
            </tr>
            </thead>
            <tbody>
            <template v-for="activity in activities">
                <tr>
                    <td>{{ activity.name }}</td>
                    <td><template v-if="activity.type">{{ activity.type.name }}</template></td>
                    <td>{{ activity.rating }}</td>
                    <td><template v-if="activity.location">{{ activity.location.name }}</template></td>
                </tr>
            </template>
            </tbody>
        </table>
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
