<template>
    <div>
        <h2>Create Tag</h2>
        <form v-on:submit.prevent="onSubmit">
            <input type="text" v-model="name" required>
            <button>Submit</button>
        </form>
    </div>
</template>

<script>
  export default {
    data: function () {
      return {
        name: ''
      };
    },
    methods: {
      onSubmit: function () {
        this.$http.post('/api/tags', {
          'name': this.name
        }).then(response => {
          console.log(response.body);
          this.$store.dispatch('getTags');
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
