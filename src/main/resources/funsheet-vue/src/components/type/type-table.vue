<template>
    <div>
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
</template>

<script>
  export default {
    props: {
      types: {
        type: Array,
        required: true
      }
    }
  };
</script>

<style lang="scss" scoped>

</style>
