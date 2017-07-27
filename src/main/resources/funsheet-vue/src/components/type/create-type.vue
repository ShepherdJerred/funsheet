<template>
    <div>
        <form v-on:submit.prevent="onSubmit">
            <div class="field">
                <label class="label">
                    Name
                    <span>
                    <input class="input" type="text" v-model="name" required>
                </span>
                </label>
            </div>
            <template v-if="allTags.length > 0">
                <label class="label">
                    Tags
                    <span class="select is-multiple">
                    <select v-model="tags" multiple>
                        <option v-for="tag in allTags" v-bind:value="tag.uuid">
                            {{ tag.name }}
                        </option>
                    </select>
                </span>
                </label>
            </template>
            <span>
                <button class="button">Submit</button>
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
