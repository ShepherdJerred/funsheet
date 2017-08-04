<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        Edit {{ type.name }}
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
            <edit-type :type="type"></edit-type>
        </div>
    </div>
</template>

<script>
  import EditType from '../../components/type/edit-type.vue';

  export default {
    components: {
      EditType
    },
    computed: {
      type: function () {
        return this.types.find(type => type.uuid === this.$route.params.uuid);
      },
      types: function () {
        return this.$store.state.types;
      }
    }
  };
</script>
