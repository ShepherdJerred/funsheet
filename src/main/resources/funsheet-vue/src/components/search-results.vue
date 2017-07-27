<template>
    <div>
        <template v-if="searchResults.length > 0">
            <template v-for="result in searchResults">
                <activity :activity="result"></activity>
            </template>
        </template>
        <template v-else>
            <p class="resultText">No results</p>
        </template>
    </div>
</template>

<script>
  import Activity from './activity/activity.vue';

  export default {
    components: {
      Activity
    },
    props: {
      searchResults: {
        type: Array,
        required: true
      }
    }
  };
</script>

<style lang="scss" scoped>

</style>
