<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        Create location
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
                <div class="field">
                    <label class="label">
                        Place ID
                        <span>
                    <input class="input" v-model="placeId" required>
                </span>
                    </label>
                    <p class="help">
                        <a href="https://google-developers.appspot.com/maps/documentation/javascript/examples/full/places-placeid-finder"
                           target="_blank">
                            Place ID finder</a>
                    </p>
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
    name: 'Create-Location',
    data: function () {
      return {
        name: '',
        placeId: ''
      };
    },
    methods: {
      onSubmit: function () {
        this.$http.post('/api/locations', {
          'name': this.name,
          'placeId': this.placeId
        }).then(response => {
          console.log(response.body);
          this.$store.dispatch('getLocations');
        }, response => {
          console.log(response.body);
        });
        this.resetForm();
      },
      resetForm: function () {
        this.name = '';
        this.placeId = '';
      }
    }
  };
</script>
