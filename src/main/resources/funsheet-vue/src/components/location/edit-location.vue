<template>
    <div>
        <form v-on:submit.prevent="onSubmit" class="pure-form pure-form-stacked">
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
                        <input class="input" v-model="name" required>
                    </span>
                </label>
                <p class="help">
                    <a href="https://google-developers.appspot.com/maps/documentation/javascript/examples/full/places-placeid-finder" target="_blank">
                        Place ID finder</a>
                </p>
            </div>
            <span>
                <button class="button is-primary">Edit</button>
            </span>
        </form>
    </div>
</template>

<script>
  export default {
    props: {
      location: {
        type: Object,
        required: true
      }
    },
    data: function () {
      return {
        uuid: '',
        name: '',
        placeId: ''
      };
    },
    methods: {
      onSubmit: function () {
        this.$http.patch('/api/locations/' + this.uuid, {
          'uuid': this.uuid,
          'name': this.name,
          'placeId': this.placeId
        }).then(response => {
          console.log(response.body);
          this.$store.dispatch('getLocations');
        }, response => {
          console.log(response.body);
        });
      }
    },
    created: function () {
      this.uuid = this.location.uuid;
      this.name = this.location.name;
      this.placeId = this.location.placeId;
    }
  };
</script>
