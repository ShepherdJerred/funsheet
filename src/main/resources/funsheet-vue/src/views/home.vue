<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        Let's find something to do
                    </h1>
                    <search-bar :searchOptions="searchOptions" v-on:search="updateResults"></search-bar>
                </div>
            </div>
        </div>

        <div class="column is-one-third-desktop is-offset-one-third-desktop">
            <search-results :searchResults="searchResults" :query="query"></search-results>
        </div>
    </div>
</template>

<script>
  import SearchBar from '../components/search-bar.vue';
  import SearchResults from '../components/search-results.vue';

  export default {
    components: {
      SearchBar,
      SearchResults
    },
    data: function () {
      return {
        searchResults: [],
        query: '',
        searchOptions: {
          shouldSort: true,
          threshold: 0.6,
          location: 0,
          distance: 100,
          maxPatternLength: 32,
          minMatchCharLength: 1,
          keys: [
            'name',
            'type.name',
            'type.tags.name',
            'location.name'
          ]
        }
      };
    },
    methods: {
      updateResults: function (results, query) {
        this.searchResults = results;
        this.query = query;
      }
    }
  };
</script>

<style lang="scss" scoped>
    @import '../scss/global';
</style>
