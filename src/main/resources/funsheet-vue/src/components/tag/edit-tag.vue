<template>
    <div>
        <form v-on:submit.prevent="onSubmit" class="pure-form pure-form-stacked">
            <div class="field">
                <label class="label">
                    Name
                    <span>
                        <input class="input" v-model="name" required>
                    </span>
                </label>
            </div>
            <span>
                <button class="button is-primary">Edit</button>
            </span>
        </form>
    </div>
</template>

<script>
  export default {
    props: {
      tag: {
        type: Object,
        required: true
      }
    },
    data: function () {
      return {
        uuid: '',
        name: ''
      };
    },
    methods: {
      onSubmit: function () {
        this.$http.patch('/api/tags/' + this.uuid, {
          'uuid': this.uuid,
          'name': this.name
        }).then(response => {
          console.log(response.body);
          this.$store.dispatch('getTags');
        }, response => {
          console.log(response.body);
        });
      }
    },
    created: function () {
      this.uuid = this.tag.uuid;
      this.name = this.tag.name;
    }
  };
</script>
