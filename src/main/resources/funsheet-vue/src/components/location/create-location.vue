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
            <div class="field">
                <label class="label">
                    Place ID
                    <span>
                    <input class="input" type="text" v-model="placeId" required>
                </span>
                </label>
            </div>
            <span>
                <button class="button is-primary">Submit</button>
            </span>
        </form>
    </div>
</template>

<script>
  export default {
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
