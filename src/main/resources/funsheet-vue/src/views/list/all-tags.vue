<template>
    <div>
        <div class="hero">
            <div class="hero-body">
                <div class="column is-half-desktop is-offset-one-quarter-desktop">
                    <h1 class="title">
                        All Tags
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-half-desktop is-offset-one-quarter-desktop">
            <tag-table :tags="tags">
            </tag-table>
        </div>
    </div>
</template>

<script>
  import TagTable from '../../components/tag/tag-table.vue';

  export default {
    components: {
      TagTable
    },
    computed: {
      tags: function () {
        return this.$store.state.tags;
      }
    }
  };
</script>
