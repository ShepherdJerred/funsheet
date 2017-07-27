<template>
    <div>
        <div class="container">
            <tag :tag="tag"></tag>
            <h3>All types tagged {{ tag.name }}</h3>
            <ul>
                <template v-for="type in typesWithTag">
                    <type :type="type"></type>
                </template>
            </ul>
        </div>
    </div>
</template>

<script>
  import Tag from '../../components/tag/tag.vue';
  import Type from '../../components/type/type.vue';

  export default {
    components: {
      Tag,
      Type
    },
    computed: {
      typesWithTag: function () {
        return this.types.filter(type => {
          return type.tags.find(tag => tag.uuid === this.$route.params.uuid);
        });
      },
      types: function () {
        return this.$store.state.types;
      },
      tag: function () {
        return this.tags.find(tag => tag.uuid === this.$route.params.uuid);
      },
      tags: function () {
        return this.$store.state.tags;
      }
    }
  };
</script>
