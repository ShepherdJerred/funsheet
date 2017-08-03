<template>
    <div>
        <div class="hero">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        {{ activity.name }}
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
            <p>
                Rating: {{ activity.rating }}<br>
                Cost: {{ activity.cost }}<br>
                Description: {{ activity.description }}<br>
            </p>
            <template v-if="activity.type">
                Type:
                <router-link :to="'/type/' + activity.type.uuid">{{ activity.type.name }}</router-link><br>
            </template>
            <template v-if="activity.location">
                Location:
                <router-link :to="'/location/' + activity.location.uuid">{{ activity.location.name }}</router-link>
                <place-view :placeId="activity.location.placeId"></place-view>
            </template>
        </div>
    </div>
</template>

<script>
  import Activity from '../../components/activity/activity.vue';
  import PlaceView from '../../components/place-map.vue';

  export default {
    components: {
      Activity,
      PlaceView
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
