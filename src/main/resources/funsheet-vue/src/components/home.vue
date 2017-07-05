<template>
    <div>
        <tag-list></tag-list>
        <type-list></type-list>
        <activity-list></activity-list>
    </div>
</template>

<script>
  import TagList from '../components/tag-list.vue';
  import TypeList from '../components/type-list.vue';
  import ActivityList from '../components/activity-list.vue';

  export default {
    components: {
      TagList,
      TypeList,
      ActivityList
    }
  };
</script>
