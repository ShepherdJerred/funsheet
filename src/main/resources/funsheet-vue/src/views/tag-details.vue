<template>
    <div>
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <tag :name="tag.name">
            </tag>
            <h3>All types tagged {{ tag.name }}</h3>
            <ul>
                <template v-for="type in typesWithTag">
                    <type :name="type.name"
                          :tags="type.tags">
                    </type>
                </template>
            </ul>
        </div>
    </div>
</template>

<script>
  import Tag from '../components/tag.vue';
  import Type from '../components/type.vue';

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
