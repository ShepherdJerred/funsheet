<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        Edit {{ location.name }}
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
                <button class="button is-primary">Edit</button>
            </span>
            </form>
        </div>
    </div>
</template>

<script>
  export default {
    name: 'Edit-Location',
    props: {
      uuid: {
        Type: String,
        required: true
      }
    },
    data: function () {
      return {
        name: '',
        placeId: ''
      };
    },
    computed: {
      location: function () {
        return this.locations[this.uuid];
      },
      locations: function () {
        return this.$store.state.Locations.locations;
      }
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
      this.name = this.location.name;
      this.placeId = this.location.placeId;
    }
  };
</script>
