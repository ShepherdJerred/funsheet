<template>
    <div>
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <app-search :searchOptions="searchOptions"></app-search>
        </div>
    </div>
</template>

<script>
  import AppSearch from '../components/app-search.vue';

  export default {
    components: {
      AppSearch
    },
    data: function () {
      return {
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
    }
  };
</script>

<style lang="scss" scoped>

</style>
