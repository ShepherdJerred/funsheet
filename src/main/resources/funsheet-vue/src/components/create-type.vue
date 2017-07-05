<template>
    <div>
        <h2>Create Type</h2>
        <form v-on:submit.prevent="onSubmit">
            <label>
                Name
                <input type="text" v-model="name" required>
            </label>
            <label>
                Tags
                <select v-model="tags" multiple>
                    <option v-for="tag in allTags" v-bind:value="tag.uuid">
                        {{ tag.name }}
                    </option>
                </select>
            </label>
            <button>Submit</button>
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
    },
    created: function () {
      this.$store.dispatch('getTags');
    }
  };
</script>
