<template>
    <div>
        <form v-on:submit.prevent="onSubmit" class="pure-form pure-form-stacked">
            <div class="field">
                <label class="label">
                    Name
                    <span>
                    <input class="input" type="text" v-model="name" required>
                </span>
                </label>
            </div>
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
    }
  };
</script>
