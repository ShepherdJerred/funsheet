<template>
    <div>
        <div class="hero">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        {{ tag.name }}
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
            <div class="card">
                <div class="card-content">
                    <h3 class="title">All types tagged {{ tag.name }}</h3>
                    <ul>
                        <template v-for="type in typesWithTag">
                            <type :type="type"></type><br>
                        </template>
                    </ul>
                </div>
            </div>
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
