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
            <form v-on:submit.prevent="onSubmit">
                <div class="field">
                    <label class="label">
                        Name
                        <span>
                    <input class="input" v-model="name" required>
                </span>
                    </label>
                </div>
                <span>
                    <button class="button is-danger" type="button" v-on:click="$router.go(-1)">Cancel</button>
                <button class="button is-success">Create</button>
            </span>
            </form>
        </div>
    </div>
</template>

<script>
  export default {
    name: 'Create-Tag',
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
          this.$router.push({name: 'Tag Details', params: {'uuid': response.body.uuid}});
        }, response => {
          console.log(response.body);
        });
      }
    }
  };
</script>
