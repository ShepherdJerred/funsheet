<template>
    <div>
        <h4>{{ name }}</h4>
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
