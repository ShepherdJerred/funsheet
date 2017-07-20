<template>
    <div>
        <form v-on:submit.prevent="onSubmit" class="pure-form pure-form-stacked">
            <label>
                Name
                <span>
                    <input class="input" type="text" v-model="name" required>
                </span>
            </label>
            <template v-if="allTags.length > 0">
                <label>
                    Tags
                    <span>
                    <select v-model="tags" multiple>
                        <option v-for="tag in allTags" v-bind:value="tag.uuid">
                            {{ tag.name }}
                        </option>
                    </select>
                </span>
                </label>
            </template>
            <span>
                <button class="pure-button pure-button-primary">Submit</button>
            </span>
        </form>
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
      }
    }
  };
</script>
