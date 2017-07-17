<template>
    <div>
        <div class="activitySearch">
            <div class="searchBar">
                <i class="fa fa-fw fa-search searchIcon"></i>
                <input v-model="query"
                       @input="search"
                       type="search"
                       placeholder="Search for an activity"
                       class="searchInput">
            </div>
            <activity-table :activities="results"></activity-table>
        </div>
    </div>
</template>

<script>
  import ActivityTable from '../components/activity-table.vue';

  import Fuse from 'fuse.js';

  export default {
    components: {
      ActivityTable
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
    $background: #ECF0F1;
    $color: #2C3E50;
    $color-light: #95A5A6;

    .activitySearch {
    }

    .searchBar {
        display: flex;
        align-items: center;
        margin-bottom: 20px;
    }

    .searchIcon {
        color: $color-light;
        font-size: 2.5vw;
        margin-right: 20px;
    }

    .searchInput {
        margin-top: 5px;
        width: 100%;
        background: $background;
        color: $color   ;
        border: none;
        font-family: 'Mukta Vaani', sans-serif;
        font-size: 3.5vw;
        padding: 0;

        &::placeholder {
            color: $color-light;
        }

        &:focus {
            outline: none;
        }
    }
</style>
