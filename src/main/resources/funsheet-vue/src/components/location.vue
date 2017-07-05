<template>
    <div>
        <h2>{{ name }}</h2>
        <ul>
            <li>Latitude: {{ coordinate.latitude }}</li>
            <li>Longitude: {{ coordinate.longitude }}</li>
        </ul>
    </div>
</template>

<script>
  export default {
    props: {
      name: {
        type: String,
        required: true
      },
      coordinate: {
        type: Object,
        required: true
      }
    }
  };
</script>
