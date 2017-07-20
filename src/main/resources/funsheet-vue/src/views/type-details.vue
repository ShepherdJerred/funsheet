<template>
    <div>
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <type :name="type.name"
                  :tags="type.tags">
            </type>
            <h3>All activities of type {{ type.name }}</h3>
            <ul>
                <template v-for="activity in activitiesWithType">
                    <activity :uuid="activity.uuid"
                              :name="activity.name"
                              :type="activity.type"
                              :rating="activity.rating"
                              :location="activity.location">
                    </activity>
                </template>
            </ul>
        </div>
    </div>
</template>

<script>
  import Type from '../components/type.vue';
  import Activity from '../components/activity.vue';

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
