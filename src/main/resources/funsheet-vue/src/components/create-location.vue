<template>
    <div>
        <h2>Create Location</h2>
        <form v-on:submit.prevent="onSubmit">
            <label>
                Name
                <input type="text" v-model="name" required>
            </label>
            <label>
                Latitude
                <input type="number" v-model="latitude" required>
            </label>
            <label>
                Longitude
                <input type="number" v-model="longitude" required>
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
        latitude: 0,
        longitude: 0
      };
    },
    methods: {
      onSubmit: function () {
        this.$http.post('/api/locations', {
          'name': this.name,
          'latitude': this.latitude,
          'longitude': this.longitude
        }).then(response => {
          console.log(response.body);
          this.$store.dispatch('getLocations');
        }, response => {
          console.log(response.body);
        });
      }
    },
    created: function () {
      this.$store.dispatch('getLocations');
    }
  };
</script>
