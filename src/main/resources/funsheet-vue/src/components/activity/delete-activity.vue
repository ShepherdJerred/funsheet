<template>
    <div>
        <form v-on:submit.prevent="onSubmit" class="pure-form pure-form-stacked">
            <h1 class="title">Are you sure you want to delete {{ activity.name }}?</h1>
            <span>
                <button class="button is-danger" type="button" v-on:click="this.$router.go(-1)">Cancel</button>
                <button class="button is-success">Confirm</button>
            </span>
        </form>
    </div>
</template>

<script>
  export default {
    data: function () {
      return {
        name: ''
      };
    },
    props: {
      activity: {
        type: Object,
        required: true
      }
    },
    methods: {
      onSubmit: function () {
        this.$http.delete('/api/activities/' + this.activity.uuid).then(response => {
          this.$store.dispatch('getActivities');
          this.$router.push('/');
        }, response => {
          console.log(response.body);
        });
      }
    }
  };
</script>
