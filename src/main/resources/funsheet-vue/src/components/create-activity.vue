<template>
    <div>
        <h4 class="subtitle is-4">Create Activity</h4>
        <div class="field">
            <form v-on:submit.prevent="onSubmit">
                <label class="label">
                    Name
                    <span class="control">
                        <input class="input" type="text" v-model="name" required>
                    </span>
                </label>
                <label class="label">
                    Rating
                    <span class="control">
                        <input class="input" type="number" v-model="rating" required>
                    </span>
                </label>
                <label class="label">
                    Type
                    <span class="control select">
                        <select v-model="type">
                            <option v-for="type in allTypes" v-bind:value="type.uuid">
                                {{ type.name }}
                            </option>
                        </select>
                    </span>
                </label>
                <label class="label">
                    Location
                    <span class="control select">
                        <select v-model="location">
                            <option v-for="location in allLocations" v-bind:value="location.uuid">
                                {{ location.name }}
                            </option>
                        </select>
                    </span>
                </label>
                <span class="control">
                    <button class="button is-primary">Submit</button>
                </span>
            </form>
        </div>
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
