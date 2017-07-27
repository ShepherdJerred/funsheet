<template>
    <div>
        <section class="hero is-primary">
            <div class="hero-body">
                <div class="container">
                    <h1 class="title">
                        Let's find something to do
                    </h1>
                    <search-bar :searchOptions="searchOptions" v-on:search="updateResults"></search-bar>
                </div>
            </div>
        </section>
        <div>
            <div class="container">
                <search-results :searchResults="searchResults"></search-results>
            </div>
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
      updateResults: function (results) {
        this.searchResults = results;
        console.log(results);
      }
    }
  };
</script>

<style lang="scss" scoped>
    @import '../scss/global';
</style>
