<template>
    <div>
        <section class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        Create tag
                    </h1>
                </div>
            </div>
        </section>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
            <form v-on:submit.prevent="onSubmit" class="pure-form pure-form-stacked">
                <div class="field">
                    <label class="label">
                        Name
                        <span>
                    <input class="input" v-model="name" required>
                </span>
                    </label>
                </div>
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
        this.resetForm();
      },
      resetForm: function () {
        this.name = '';
      }
    }
  };
</script>
