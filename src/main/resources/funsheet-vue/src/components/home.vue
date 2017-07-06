<template>
    <div>
        <div class="container">
            <div class="row">
                <div class="three columns">
                    <location-list></location-list>
                </div>
                <div class="three columns">
                    <tag-list></tag-list>
                </div>
                <div class="three columns">
                    <type-list></type-list>
                </div>
                <div class="three columns">
                    <activity-list></activity-list>
                </div>
            </div>
        </div>
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
