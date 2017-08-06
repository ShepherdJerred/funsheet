<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        {{ tag.name }}
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-two-thirds-desktop is-offset-2">
            <div class="columns">
                <div class="column">
                    <div class="card">
                        <div class="card-content">
                            <h3 class="title">All types tagged {{ tag.name }}</h3>
                            <ul>
                                <template v-for="type in typesWithTag">
                                    <li>{{ type.name }}</li>
                                </template>
                            </ul>
                        </div>
                    </div>

                    <div class="card controls">
                        <footer class="card-footer">
                            <a class="card-footer-item">
                                <router-link :to="{ name: 'Edit Tag', params: { 'uuid': tag.uuid } }">
                                    Edit
                                </router-link>
                            </a>
                            <a class="card-footer-item">
                                <router-link :to="{ name: 'Delete Tag', params: { 'uuid': tag.uuid } }">
                                    Delete
                                </router-link>
                            </a>
                        </footer>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
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

<style lang="scss" scoped>
    .controls {
        margin-top: 20px;
    }
</style>
