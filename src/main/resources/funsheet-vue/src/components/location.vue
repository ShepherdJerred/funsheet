<template>
    <div>
        <h4>{{ name }}</h4>
        <h5>{{ placeId }}</h5>
    </div>
</template>

<script>
  export default {
    props: {
      name: {
        type: String,
        required: true
      },
      placeId: {
        type: String,
        required: true
      }
    }
  };
</script>
