<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        Edit {{ tag.name }}
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
            <edit-tag :tag="tag"></edit-tag>
        </div>
    </div>
</template>

<script>
  import EditTag from '../../components/tag/edit-tag.vue';

  export default {
    components: {
      EditTag
    },
    computed: {
      tag: function () {
        return this.tags.find(tag => tag.uuid === this.$route.params.uuid);
      },
      tags: function () {
        return this.$store.state.tags;
      }
    }
  };
</script>
