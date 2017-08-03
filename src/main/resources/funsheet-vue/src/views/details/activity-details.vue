<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-two-thirds-desktop is-offset-2">
                    <h1 class="title">
                        {{ activity.name }}
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-two-thirds-desktop is-offset-2">
            <div class="columns">
                <div class="column">
                    <div class="card">
                        <div class="card-content">
                            <div class="content">
                                {{ activity.description }}
                            </div>
                        </div>
                        <footer class="card-footer">
                            <div class="card-footer-item">
                                <template v-if="activity.cost === 0">
                                    Free
                                </template>
                                <template v-else>
                                    <template v-for="i in activity.cost">$</template>
                                </template>
                            </div>
                            <div class="card-footer-item">
                                <template v-for="i in activity.rating">
                                    <i class="fa fa-star"></i>
                                </template>
                            </div>
                            <a class="card-footer-item">
                                <template v-if="activity.type">
                                    <router-link :to="'/type/' + activity.type.uuid">{{ activity.type.name }}
                                    </router-link>
                                </template>
                            </a>
                        </footer>
                    </div>

                    <div class="card controls">
                        <footer class="card-footer">
                            <a class="card-footer-item">
                                <template v-if="activity.type">
                                    <router-link :to="'/activity/edit/' + activity.uuid">
                                        Edit
                                    </router-link>
                                </template>
                            </a>
                            <a class="card-footer-item">
                                <template v-if="activity.type">
                                    <router-link :to="'/activity/delete/' + activity.uuid">
                                        Delete
                                    </router-link>
                                </template>
                            </a>
                        </footer>
                    </div>
                </div>
                <div class="column">
                    <template v-if="activity.location">
                        <place-view :location="activity.location"></place-view>
                    </template>
                </div>
            </div>
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

<style lang="scss" scoped>
    .columns {
        margin-top: 10px;
    }

    .controls {
        margin-top: 20px;
    }
</style>
