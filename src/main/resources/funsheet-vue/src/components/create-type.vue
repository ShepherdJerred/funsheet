<template>
    <div>
        <h4>Create Type</h4>
        <form v-on:submit.prevent="onSubmit">
            <label>
                Name
                <span>
                        <input class="input" type="text" v-model="name" required>
                    </span>
            </label>
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
            <span>
                    <button>Submit</button>
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
    },
    created: function () {
      this.$store.dispatch('getTags');
    }
  };
</script>
