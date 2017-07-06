<template>
    <div>
        <input v-model="query" type="text" placeholder="Search for an activity">
        <template v-for="result in topResults">
            {{ result.name }}
        </template>
    </div>
</template>

<script>
  import Fuse from 'fuse.js';

  export default {
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
