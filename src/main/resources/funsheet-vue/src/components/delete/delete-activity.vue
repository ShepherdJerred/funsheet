<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        Delete {{ activity.name }}
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
            <div>
                <form v-on:submit.prevent="onSubmit" class="pure-form pure-form-stacked">
                    <h1 class="title">Are you sure you want to delete {{ activity.name }}?</h1>
                    <span>
                <button class="button is-danger" type="button" v-on:click="this.$router.go(-1)">Cancel</button>
                <button class="button is-success">Confirm</button>
            </span>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
  export default {
    data: function () {
      return {
        name: ''
      };
    },
    computed: {
      activity: function () {
        return this.activities.find(activity => activity.uuid === this.$route.params.uuid);
      },
      activities: function () {
        return this.$store.state.activities;
      }
    },
    methods: {
      onSubmit: function () {
        this.$http.delete('/api/activities/' + this.activity.uuid).then(response => {
          this.$store.dispatch('getActivities');
          this.$router.push({ name: 'Home' });
        }, response => {
          console.log(response.body);
        });
      }
    }
  };
</script>
