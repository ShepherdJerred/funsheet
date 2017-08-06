<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        {{ location.name }}
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-two-thirds-desktop is-offset-2">
            <div class="columns">
                <div class="column">
                    <div class="card">
                        <div class="card-content">
                            <h3 class="title">Everything to do in {{ location.name }}</h3>
                            <ul>
                                <template v-for="activity in activitiesAtLocation">
                                    <li>{{ activity.name }}</li>
                                </template>
                            </ul>
                        </div>
                    </div>

                    <div class="card controls">
                        <footer class="card-footer">
                            <a class="card-footer-item">
                                <router-link :to="{ name: 'Edit Location', params: { 'uuid': location.uuid } }">
                                    Edit
                                </router-link>
                            </a>
                            <a class="card-footer-item">
                                <router-link :to="{ name: 'Delete Location', params: { 'uuid': location.uuid } }">
                                    Delete
                                </router-link>
                            </a>
                        </footer>
                    </div>
                </div>
                <div class="column">
                    <place-view :location="location"></place-view>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
  import PlaceView from '../place-map.vue';

  export default {
    components: {
      PlaceView
    },
    computed: {
      activitiesAtLocation: function () {
        return this.activities.filter(activity => activity.location.uuid === this.$route.params.uuid);
      },
      activities: function () {
        return this.$store.state.activities;
      },
      location: function () {
        return this.locations.find(location => location.uuid === this.$route.params.uuid);
      },
      locations: function () {
        return this.$store.state.locations;
      }
    }
  };
</script>

<style lang="scss" scoped>
    .controls {
        margin-top: 20px;
    }
</style>
