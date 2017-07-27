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
        query: '',
        results: []
      };
    },
    computed: {
      activities () {
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
        let fuse = new Fuse(this.$store.state.activities, this.searchOptions);
        this.results = fuse.search(this.query);
        this.$emit('search', this.results, this.query);
      }
    }
  };
</script>

<style lang="scss" scoped>
    @import '../scss/global';
</style>
