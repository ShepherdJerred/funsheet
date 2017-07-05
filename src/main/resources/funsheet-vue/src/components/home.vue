<template>
    <div>
        <location-list></location-list>
        <hr>
        <tag-list></tag-list>
        <hr>
        <type-list></type-list>
        <hr>
        <activity-list></activity-list>
    </div>
</template>

<script>
  import LocationList from '../components/location-list.vue';
  import TagList from '../components/tag-list.vue';
  import TypeList from '../components/type-list.vue';
  import ActivityList from '../components/activity-list.vue';

  export default {
    components: {
      LocationList,
      TagList,
      TypeList,
      ActivityList
    }
  };
</script>
