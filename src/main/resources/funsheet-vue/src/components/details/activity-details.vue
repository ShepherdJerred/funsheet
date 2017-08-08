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
                            <template v-if="activity.type">
                                <a class="card-footer-item">
                                    <router-link :to="{ name: 'Type Details', params: { 'uuid': activity.type.uuid } }">
                                        {{ activity.type.name }}
                                    </router-link>
                                </a>
                            </template>
                        </footer>
                    </div>

                    <div class="card controls">
                        <footer class="card-footer">
                            <a class="card-footer-item">
                                <router-link :to="{ name: 'Edit Activity', params: { 'uuid': activity.uuid } }">
                                    Edit
                                </router-link>
                            </a>
                            <a class="card-footer-item">
                                <router-link :to="{ name: 'Delete Activity', params: { 'uuid': activity.uuid } }">
                                    Delete
                                </router-link>
                            </a>
                        </footer>
                    </div>
                </div>
                <template v-if="activity.location">
                    <div class="column">
                        <place-view :location="activity.location"></place-view>
                    </div>
                </template>
            </div>
        </div>
    </div>
</template>

<script>
  import PlaceView from '../place-map.vue';

  export default {
    name: 'Activity-Details',
    components: {
      PlaceView
    },
    props: {
      uuid: {
        Type: String,
        required: true
      }
    },
    computed: {
      activity: function () {
        return this.activities[this.uuid];
      },
      activities: function () {
        return this.$store.state.Activities.activities;
      }
    }
  };
</script>

<style lang="scss" scoped>
    .controls {
        margin-top: 20px;
    }
</style>
