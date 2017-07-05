<template>
    <div>
        <h2>Create Activity</h2>
        <form v-on:submit.prevent="onSubmit">
            <label>
                Name
                <input type="text" v-model="name" required>
            </label>
            <label>
                Rating
                <input type="number" v-model="rating" required>
            </label>
            <label>
                Type
                <select v-model="type">
                    <option v-for="type in allTypes" v-bind:value="type.uuid">
                        {{ type.name }}
                    </option>
                </select>
            </label>
            <label>
                Location
                <select v-model="location">
                    <option v-for="location in allLocations" v-bind:value="location.uuid">
                        {{ location.name }}
                    </option>
                </select>
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
        rating: 0,
        type: null,
        location: null
      };
    },
    computed: {
      allTypes: function () {
        return this.$store.state.types;
      },
      allLocations: function () {
        return this.$store.state.locations;
      }
    },
    methods: {
      onSubmit: function () {
        this.$http.post('/api/activities', {
          'name': this.name,
          'rating': this.rating,
          'type': this.type,
          'location': this.location
        }).then(response => {
          console.log(response.body);
          this.$store.dispatch('getActivities');
        }, response => {
          console.log(response.body);
        });
      }
    },
    created: function () {
      this.$store.dispatch('getTypes');
      this.$store.dispatch('getLocations');
    }
  };
</script>
