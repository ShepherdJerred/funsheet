<template>
    <div>
        <h3 class="title is-3">Tags</h3>
        <create-tag></create-tag>
        <template v-for="tag in tags">
            <tag :name="tag.name">
            </tag>
        </template>
    </div>
</template>

<script>
  import createTag from './create-tag.vue';
  import tag from './tag.vue';

  export default {
    components: {
      createTag,
      tag
    },
    computed: {
      tags: function () {
        return this.$store.state.tags;
      }
    },
    created: function () {
      this.$store.dispatch('getTags');
    }
  };
</script>
