<template>
    <div>
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <app-search :searchOptions="searchOptions"></app-search>
        </div>
    </div>
</template>

<script>
  import AppSearch from './activity-search.vue';

  import LocationList from '../components/location-list.vue';
  import TagList from '../components/tag-list.vue';
  import TypeList from '../components/type-list.vue';
  import ActivityList from '../components/activity-list.vue';

  export default {
    components: {
      AppSearch,
      LocationList,
      TagList,
      TypeList,
      ActivityList
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
            'name'
          ]
        }
      };
    }
  };
</script>
