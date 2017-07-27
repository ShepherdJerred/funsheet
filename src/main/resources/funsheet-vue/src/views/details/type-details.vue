<template>
    <div>
        <div class="container">
            <type :type="type"></type>
            <h3>All activities of type {{ type.name }}</h3>
            <ul>
                <template v-for="activity in activitiesWithType">
                    <activity :activity="activity"></activity>
                </template>
            </ul>
        </div>
    </div>
</template>

<script>
  import Type from '../../components/type/type.vue';
  import Activity from '../../components/activity/activity.vue';

  export default {
    components: {
      Type,
      Activity
    },
    computed: {
      activitiesWithType: function () {
        return this.activities.filter(activity => activity.type.uuid === this.$route.params.uuid);
      },
      activities: function () {
        return this.$store.state.activities;
      },
      type: function () {
        return this.types.find(type => type.uuid === this.$route.params.uuid);
      },
      types: function () {
        return this.$store.state.types;
      }
    }
  };
</script>
