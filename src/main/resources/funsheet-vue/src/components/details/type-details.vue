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
        <div class="column is-two-thirds-desktop is-offset-2">
            <div class="columns">
                <div class="column">
                    <div class="card">
                        <div class="card-content">
                            <h3 class="title">All activities of type {{ type.name }}</h3>
                            <ul>
                                <template v-for="activity in activitiesWithType">
                                    <li>{{ activity.name }}</li>
                                </template>
                            </ul>
                        </div>
                    </div>

                    <div class="card controls">
                        <footer class="card-footer">
                            <a class="card-footer-item">
                                <router-link :to="'/type/edit/' + type.uuid">
                                    Edit
                                </router-link>
                            </a>
                            <a class="card-footer-item">
                                <router-link :to="'/type/delete/' + type.uuid">
                                    Delete
                                </router-link>
                            </a>
                        </footer>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
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

<style lang="scss" scoped>
    .controls {
        margin-top: 20px;
    }
</style>
