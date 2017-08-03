<template>
    <div>
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
</template>

<script>
  export default {
    props: {
      tags: {
        type: Array,
        required: true
      }
    }
  };
</script>

<style lang="scss" scoped>

</style>
