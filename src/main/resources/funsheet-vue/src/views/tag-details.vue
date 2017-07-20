<template>
    <div>
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <tag :name="tag.name">
            </tag>
        </div>
        <h3>All activities with a type tagged {{ tag.name }}</h3>
        <ul>
            <template v-for="activity in activitiesWithTag">
                <activity :uuid="activity.uuid"
                          :name="activity.name"
                          :type="activity.type"
                          :rating="activity.rating"
                          :location="activity.location">
                </activity>
            </template>
        </ul>
    </div>
</template>

<script>
  import Tag from '../components/tag.vue';
  import Activity from '../components/activity.vue';

  export default {
    components: {
      Tag,
      Activity
    },
    computed: {
      activitiesWithTag: function () {
        return []; // TODO
      },
      activities: function () {
        return this.$store.state.activities;
      },
      tag: function () {
        return this.tags.find(e => e.uuid === this.$route.params.uuid);
      },
      tags: function () {
        return this.$store.state.tags;
      }
    }
  };
</script>
