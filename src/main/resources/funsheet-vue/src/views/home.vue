<template>
    <div>
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <app-search :searchOptions="searchOptions"></app-search>
            <activity-table></activity-table>
        </div>
    </div>
</template>

<script>
  import AppSearch from '../components/activity-search.vue';
  import ActivityTable from '../components/activity-table.vue';

  export default {
    components: {
      AppSearch,
      ActivityTable
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
            'location.name',
            'type.name',
            'tags'
          ]
        }
      };
    }
  };
</script>
