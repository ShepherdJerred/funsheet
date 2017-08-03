<template>
    <div>
        <table class="table is-fullwidth">
            <thead>
            <tr>
                <th>Name</th>
                <th>Place ID</th>
            </tr>
            </thead>
            <tbody>
            <template v-for="location in locations">
                <tr>
                    <td>
                        <router-link :to="'/location/' + location.uuid">{{ location.name }}</router-link>
                    </td>
                    <td>
                        {{ location.placeId }}
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
      locations: {
        type: Array,
        required: true
      }
    }
  };
</script>

<style lang="scss" scoped>

</style>
