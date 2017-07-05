<template>
    <div>
        <h1>Create Activity</h1>
        <form v-on:submit.prevent="onSubmit">
            <input type="text" v-model="name" required>
            <input type="number" v-model="rating" required>
            <button>Submit</button>
        </form>
    </div>
</template>

<script>
  export default {
    data: function () {
      return {
        name: '',
        rating: 0
      };
    },
    methods: {
      onSubmit: function () {
        // POST /someUrl
        this.$http.post('/api/activities', {
          'name': this.name,
          'rating': this.rating,
          'typeUuid': null
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
