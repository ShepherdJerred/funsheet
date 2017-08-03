<template>
    <div>
        <h4>
            <router-link :to="'/activity/' + activity.uuid">{{ activity.name }}</router-link>
            <small>Rating: {{ activity.rating }}</small>
        </h4>
        <p>
            Cost: {{ activity.cost }}
            Description: {{ activity.description }}
            <template v-if="activity.type">
                Type:
                <router-link :to="'/type/' + activity.type.uuid">{{ activity.type.name }}</router-link>
            </template>
            <template v-if="activity.location">
                Location:
                <router-link :to="'/location/' + activity.location.uuid">{{ activity.location.name }}</router-link>
            </template>
        </p>
    </div>
</template>

<script>
  import PlaceView from '../place-map.vue';

  export default {
    components: {
      PlaceView
    },
    props: {
      activity: {
        type: Object,
        required: true
      }
    }
  };
</script>
