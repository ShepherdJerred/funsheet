<template>
    <div>
        <div class="activitySearch">
            <div class="searchBar">
                <i class="fa fa-fw fa-search searchIcon"></i>
                <input v-model="query"
                       @input="search"
                       type="search"
                       placeholder="Search"
                       class="searchInput">
            </div>
            <template v-if="activities.length > 0">
                <template v-for="activity in activities">
                    <activity :name="activity.name"
                              :type="activity.type.name"
                              :rating="activity.rating"
                              :location="activity.location.name">
                    </activity>
                </template>
            </template>
            <template v-else-if="query.length > 0">
                <h1 class="resultText">No results</h1>
            </template>
            <template v-else>
                <h1 class="resultText">Search for an activity..</h1>
            </template>
        </div>
    </div>
</template>

<script>
  import ActivityTable from '../components/activity-table.vue';
  import Activity from '../components/activity.vue';

  import Fuse from 'fuse.js';

  export default {
    components: {
      ActivityTable,
      Activity
    },
    props: {
      searchOptions: {
        type: Object,
        required: true
      }
    },
    data: function () {
      return {
        query: '',
        results: ''
      };
    },
    computed: {
      topResults: function () {
        return this.results.slice(0, 10);
      },
      activities: function () {
        return this.$store.state.activities;
      }
    },
    methods: {
      search: function () {
        this.results = this.fuse.search(this.query);
      }
    },
    created: function () {
      this.fuse = new Fuse(this.activities, this.searchOptions);
      this.$store.dispatch('getActivities');
    }
  };
</script>

<style lang="scss" scoped>
    @import '../scss/variables';
    .activitySearch {
    }

    .searchBar {
        display: flex;
        align-items: center;
        margin-bottom: 20px;
    }

    .searchIcon {
        color: $color;
        font-size: 2vw;
        margin-right: 20px;
    }

    .searchInput {
        margin-top: 10px;
        width: 100%;
        background: $background;
        color: $color;
        border: none;
        font-family: 'Mukta Vaani', sans-serif;
        font-size: 2vw;
        font-weight: 700;
        padding: 0;

        &::placeholder {
            color: $color;
        }

        &:focus {
            outline: none;
        }
    }

    .resultText {
        color: $color;
        font-family: 'Mukta Vaani', sans-serif;
        font-weight: 100;
    }
</style>
