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
                    Rating
                    <span>
                    <input class="input" type="number" v-model="rating" required>
                </span>
                </label>
            </div>
            <div class="field">
                <label class="label">
                    Cost
                    <span>
                    <input class="input" type="number" v-model="cost" required>
                </span>
                </label>
            </div>
            <div class="field">
                <label class="label">
                    Description
                    <span>
                    <input class="input" type="text" v-model="description" required>
                </span>
                </label>
            </div>
            <template v-if="allTypes.length > 0">
                <label class="label">
                    Type
                    <span class="select">
                    <select v-model="type">
                        <option v-for="type in allTypes" v-bind:value="type.uuid">
                            {{ type.name }}
                        </option>
                    </select>
                </span>
                </label>
            </template>
            <template v-if="allLocations.length > 0">
                <label class="label">
                    Location
                    <span>
                    <select v-model="location">
                        <option v-for="location in allLocations" v-bind:value="location.uuid">
                            {{ location.name }}
                        </option>
                    </select>
                </span>
                </label>
            </template>
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
        name: '',
        rating: 0,
        cost: 0,
        description: '',
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
          'cost': this.cost,
          'description': this.description,
          'location': this.location
        }).then(response => {
          console.log(response.body);
          this.$store.dispatch('getActivities');
        }, response => {
          console.log(response.body);
        });
      }
    }
  };
</script>
