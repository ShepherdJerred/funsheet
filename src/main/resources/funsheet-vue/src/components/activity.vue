<template>
    <div>
        <h2>{{ name }} <small>Rating: {{ rating }}</small></h2>
        <p>{{ type.name }}</p>
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
