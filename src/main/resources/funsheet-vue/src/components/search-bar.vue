<template>
    <div>
        <input v-model="query"
               @input="search"
               class="input"
               type="search"
               :placeholder="randomActivity.name">
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
        fuse: null,
        query: '',
        results: []
      };
    },
    computed: {
      activities: function () {
        return this.$store.state.activities;
      },
      randomActivity: function () {
        if (this.activities.length > 0) {
          return this.activities[Math.floor(Math.random() * this.activities.length)];
        } else {
          return 'Search for an activity';
        }
      }
    },
    methods: {
      search: function () {
        this.results = this.fuse.search(this.query);
        this.$emit('search', this.results);
        console.log(this.fuse);
        console.log(this.results);
      }
    },
    created: function () {
      this.fuse = new Fuse(this.$store.state.activities, this.searchOptions);
    }
  };
</script>

<style lang="scss" scoped>
    @import '../scss/global';
</style>
