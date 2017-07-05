<template>
    <div>
        <h2>Create Activity</h2>
        <form v-on:submit.prevent="onSubmit">
            <input type="text" v-model="name" required>
            <input type="number" v-model="rating" required>
            <select v-model="type">
                <option v-for="type in allTypes" v-bind:value="type.uuid">
                    {{ type.name }}
                </option>
            </select>
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
        type: null
      };
    },
    computed: {
      allTypes: function () {
        return this.$store.state.types;
      }
    },
    methods: {
      onSubmit: function () {
        this.$http.post('/api/activities', {
          'name': this.name,
          'rating': this.rating,
          'typeUuid': this.type
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
    }
  };
</script>
