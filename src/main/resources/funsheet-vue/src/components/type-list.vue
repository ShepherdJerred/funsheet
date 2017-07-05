<template>
    <div>
        <h1>Types</h1>
        <create-type></create-type>
        <template v-for="type in types">
            <type :name="type.name"
                  :tags="type.tags">
            </type>
        </template>
    </div>
</template>

<script>
  import createType from './create-type.vue';
  import type from './type.vue';

  export default {
    components: {
      createType,
      type
    },
    computed: {
      types: function () {
        return this.$store.state.types;
      }
    },
    created: function () {
      this.$store.dispatch('getTypes');
    }
  };
</script>
