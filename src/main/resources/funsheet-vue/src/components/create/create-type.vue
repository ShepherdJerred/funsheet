<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        Create type
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
                <button class="button is-primary">Create</button>
            </span>
            </form>
        </div>
    </div>
</template>

<script>
  export default {
    data: function () {
      return {
        name: '',
        tags: []
      };
    },
    computed: {
      allTags: function () {
        return this.$store.state.tags;
      }
    },
    methods: {
      onSubmit: function () {
        this.$http.post('/api/types', {
          'name': this.name,
          'tags': this.tags
        }).then(response => {
          console.log(response.body);
          this.$store.dispatch('getTypes');
        }, response => {
          console.log(response.body);
        });
        this.resetForm();
      },
      resetForm: function () {
        this.name = '';
        this.tags = [];
      }
    }
  };
</script>
