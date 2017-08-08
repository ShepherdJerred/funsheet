<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        Edit {{ type.name }}
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
            <form v-on:submit.prevent="onSubmit">
                <div class="field">
                    <label class="label">
                        Name
                        <span>
                        <input class="input" v-model="name" required>
                    </span>
                    </label>
                </div>
                <template v-if="allTags.length > 0">
                    <div class="field">
                        <label class="label">
                            Tags
                            <div class="control">
                            <span class="select is-multiple">
                                <select v-model="tags" multiple>
                                    <option v-for="tag in allTags" v-bind:value="tag.uuid">
                                        {{ tag.name }}
                                    </option>
                                </select>
                            </span>
                            </div>
                        </label>
                    </div>
                </template>
                <template v-else>
                    <p>No tags exist</p>
                </template>
                <span>
                <button class="button is-primary">Edit</button>
            </span>
            </form>
        </div>
    </div>
</template>

<script>
  import Helper from '../../helpers';

  export default {
    name: 'Edit-Type',
    props: {
      uuid: {
        type: String,
        required: true
      }
    },
    data: function () {
      return {
        name: '',
        tags: []
      };
    },
    computed: {
      allTags: function () {
        return Helper.objectToArray(this.$store.state.Tags.tags);
      },
      type: function () {
        return this.types[this.uuid];
      },
      types: function () {
        return this.$store.state.Types.types;
      }
    },
    methods: {
      onSubmit: function () {
        this.$http.patch('/api/types/' + this.uuid, {
          'uuid': this.uuid,
          'name': this.name,
          'tags': this.tags
        }).then(response => {
          console.log(response.body);
          this.$store.dispatch('getTypes');
        }, response => {
          console.log(response.body);
        });
      }
    },
    created: function () {
      this.name = this.type.name;
      this.tags = this.type.tags; // TODO this should be the tag uuid, not the tag object
    }
  };
</script>
