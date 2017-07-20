<template>
    <div>
        <table class="pure-table activityTable">
            <thead>
            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Rating</th>
                <th>Location</th>
            </tr>
            </thead>
            <tbody>
            <template v-for="activity in activities">
                <tr>
                    <td>
                        <router-link :to="'/activity/' + activity.uuid">{{ activity.name }}</router-link>
                    </td>
                    <td>
                        <template v-if="activity.type">
                            <router-link :to="'/type/' + activity.type.uuid">{{ activity.type.name }}</router-link>
                        </template>
                    </td>
                    <td>{{ activity.rating }}</td>
                    <td>
                        <template v-if="activity.location">
                            <router-link :to="'/location/' + activity.location.uuid">{{ activity.location.name }}
                            </router-link>
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
      activities: {
        type: Array,
        required: true
      }
    }
  };
</script>

<style lang="scss" scoped>
    .activityTable {
        width: 100%;
    }
</style>
