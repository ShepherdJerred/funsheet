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
            <table class="table is-fullwidth">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Tags</th>
                </tr>
                </thead>
                <tbody>
                <template v-for="type in types">
                    <tr>
                        <td>
                            <router-link :to="'/type/' + type.uuid">{{ type.name }}</router-link>
                        </td>
                        <td>
                            <template v-for="tag in type.tags">
                                {{ tag.name }},
                            </template>
                        </td>
                    </tr>
                </template>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
  export default {
    computed: {
      types: function () {
        return this.$store.state.types;
      }
    }
  };
</script>

<style lang="scss" scoped>

</style>
