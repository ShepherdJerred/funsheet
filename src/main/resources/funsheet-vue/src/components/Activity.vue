<template>
    <div>
        {{ name }}
        {{ type }}
        {{ rating }}
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
        type: String,
        required: true
      },
      rating: {
        type: Number,
        required: true
      }
    }
  };
</script>
