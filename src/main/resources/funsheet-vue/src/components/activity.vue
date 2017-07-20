<template>
    <div>
        <h4><router-link :to="'/activity/' + uuid">{{ name }}</router-link>
            <small>Rating: {{ rating }}</small>
        </h4>
        <p>
            <template v-if="type">
                Type: <router-link :to="'/type/' + type.uuid">{{ type.name }}</router-link>
            </template>
            <template v-if="location">
                Location: <router-link :to="'/location/' + location.uuid">{{ location.name }}</router-link>
            </template>
        </p>
    </div>
</template>

<script>
  export default {
    props: {
      uuid: {
        type: String,
        required: true
      },
      name: {
        type: String,
        required: true
      },
      type: {
        type: Object,
        required: true
      },
      rating: {
        type: Number,
        required: true
      },
      location: {
        type: Object,
        required: true
      }
    }
  };
</script>
