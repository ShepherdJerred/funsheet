<template>
    <div>
        <template v-if="tag">
            <div class="hero is-primary">
                <div class="hero-body">
                    <div class="column is-two-thirds-desktop is-offset-2-desktop">
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
                                        <li>
                                            <router-link :to="{ name: 'Type Details', params: { 'uuid': type.uuid } }">
                                                {{ type.name }}
                                            </router-link>
                                        </li>
                                    </template>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="column">
                        <div class="card">
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
        </template>
        <template v-else>
            <div class="hero is-danger">
                <div class="hero-body">
                    <div class="container">
                        <h1 class="title">
                            Tag not found
                        </h1>
                    </div>
                </div>
            </div>
        </template>
    </div>
</template>

<script>
  import Helper from '../../helpers';

  export default {
    name: 'Tag-Details',
    props: {
      uuid: {
        Type: String,
        required: true
      }
    },
    computed: {
      typesWithTag: function () {
        return Helper.objectToArray(this.types).filter(type => {
          return Helper.objectToArray(type.tags).find(tag => tag.uuid === this.uuid);
        });
      },
      types: function () {
        return this.$store.state.Types.types;
      },
      tag: function () {
        return this.tags[this.uuid];
      },
      tags: function () {
        return this.$store.state.Tags.tags;
      }
    }
  };
</script>

<style lang="scss" scoped>

</style>
