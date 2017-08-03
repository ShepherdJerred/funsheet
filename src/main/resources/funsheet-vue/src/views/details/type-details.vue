<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        {{ type.name }}
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
            <div class="card">
                <div class="card-content">
                    <h3 class="title">All activities of type {{ type.name }}</h3>
                    <ul>
                        <template v-for="activity in activitiesWithType">
                            <activity :activity="activity"></activity><br>
                        </template>
                    </ul>
                </div>
            </div>
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
