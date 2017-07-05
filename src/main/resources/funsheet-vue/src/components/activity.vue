<template>
    <div>
        <h2>{{ name }}
            <small>Rating: {{ rating }}</small>
        </h2>
        <template v-if="type">
            <p>{{ type.name }}</p>
        </template>
    </div>
</template>

<script>
  export default {
    props: {
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
      }
    }
  };
</script>
