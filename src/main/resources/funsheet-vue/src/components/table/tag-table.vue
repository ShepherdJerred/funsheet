<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-half-desktop is-offset-one-quarter-desktop">
                    <h1 class="title">
                        All Tags
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-half-desktop is-offset-one-quarter-desktop">
            <table class="table is-fullwidth">
                <thead>
                <tr>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                <template v-for="tag in tags">
                    <tr>
                        <td>
                            <router-link :to="'/tag/' + tag.uuid">{{ tag.name }}</router-link>
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
      tags: function () {
        return this.$store.state.tags;
      }
    }
  };
</script>

<style lang="scss" scoped>

</style>
