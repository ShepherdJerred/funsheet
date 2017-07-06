<template>
    <div>
        <h4>Create Location</h4>
            <form v-on:submit.prevent="onSubmit">
                <label>
                    Name
                    <span>
                    <input class="input" type="text" v-model="name" required>
                    </span>
                </label>
                <label>
                    Latitude
                    <span>
                    <input  class="input" type="number" v-model="latitude" required>
                    </span>
                </label>
                <label>
                    Longitude
                    <span>
                    <input  class="input" type="number" v-model="longitude" required>
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
