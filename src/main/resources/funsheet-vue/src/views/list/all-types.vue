<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-half-desktop is-offset-one-quarter-desktop">
                    <h1 class="title">
                        All Types
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-half-desktop is-offset-one-quarter-desktop">
            <type-table :types="types">
            </type-table>
        </div>
    </div>
</template>

<script>
  import TypeTable from '../../components/type/type-table.vue';

  export default {
    components: {
      TypeTable
    },
    computed: {
      types: function () {
        return this.$store.state.types;
      }
    }
  };
</script>
