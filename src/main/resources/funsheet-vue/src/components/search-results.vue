<template>
    <div>
        <template v-if="searchResults.length > 0">
            <template v-for="result in searchResults">
                <div class="card result">
                    <header class="card-header">
                        <router-link class="card-header-title" :to="'activity/' + result.uuid">
                            {{ result.name }}
                        </router-link>
                    </header>
                    <div class="card-content">
                        <div class="content">
                            {{ result.description }}
                        </div>
                    </div>
                    <footer class="card-footer">
                        <span class="card-footer-item">
                            <template v-for="i in result.rating">$</template>
                        </span>
                        <span class="card-footer-item">
                            <template v-for="i in result.rating">
                                <i class="fa fa-star"></i>
                            </template>
                        </span>
                        <router-link :to="'/location/' + result.location.uuid" class="card-footer-item">
                            {{ result.location.name }}
                        </router-link>
                    </footer>
                </div>
            </template>
        </template>
        <template v-else>
            <template v-if="activities.length < 0">
                <p>Add an activity first</p>
            </template>
            <template v-else-if="query.length == 0">
                <p>Search for an activity</p>
            </template>
            <template v-else>
                <p>
                    No results
                </p>
            </template>
        </template>
    </div>
</template>

<script>
  import Activity from './activity/activity.vue';

  export default {
    components: {
      Activity
    },
    props: {
      searchResults: {
        type: Array,
        required: true
      },
      query: {
        type: String,
        required: true
      }
    },
    computed: {
      activities () {
        return this.$store.state.activities;
      }
    }
  };
</script>

<style lang="scss" scoped>
    .result {
        margin-top: 10px;
    }
</style>
