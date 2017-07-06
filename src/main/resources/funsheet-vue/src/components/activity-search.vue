<template>
    <div>
        <input v-model="query" @input="search" type="search" placeholder="Search for an activity">
        <template v-for="result in topResults">
            <activity :name="result.name"
                      :type="result.type"
                      :rating="result.rating"
                      :location="result.location">
            </activity>
        </template>
    </div>
</template>

<script>
  import Activity from '../components/activity.vue';

  import Fuse from 'fuse.js';

  export default {
    components: {
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

<style>

</style>
