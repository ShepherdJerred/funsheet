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
                        <input class="input" type="number" v-model="rating" required min="1" max="5">
                    </span>
                </label>
                <p class="help">Rating between 1-5</p>
            </div>
            <div class="field">
                <label class="label">
                    Cost
                    <span>
                        <input class="input" type="number" v-model="cost" required min="0" max="5">
                    </span>
                </label>
                <p class="help">Cost between 0-5</p>
            </div>
            <div class="field">
                <label class="label">
                    Description
                    <span>
                        <textarea class="textarea" v-model="description" required></textarea>
                </span>
                </label>
            </div>
            <template v-if="allTypes.length > 0">
                <div class="field">
                    <label class="label">
                        Type
                        <div class="control">
                            <div class="select">
                                <select v-model="type">
                                    <option v-for="type in allTypes" v-bind:value="type.uuid">
                                        {{ type.name }}
                                    </option>
                                </select>
                            </div>
                        </div>
                    </label>
                </div>
            </template>
            <template v-else>
                <p>No types exist</p>
            </template>
            <template v-if="allLocations.length > 0">
                <div class="field">
                    <label class="label">
                        Location
                        <div class="control">
                            <div class="select">
                                <select v-model="location">
                                    <option v-for="location in allLocations" v-bind:value="location.uuid">
                                        {{ location.name }}
                                    </option>
                                </select>
                            </div>
                        </div>
                    </label>
                </div>
            </template>
            <template v-else>
                <p>No locations exist</p>
            </template>
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
        rating: 1,
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
        this.resetForm();
      },
      resetForm: function () {
        this.name = '';
        this.rating = 1;
        this.cost = 0;
        this.description = '';
        this.type = null;
        this.location = null;
      }
    }
  };
</script>
