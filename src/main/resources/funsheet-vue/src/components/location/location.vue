<template>
    <div>
        <h4>{{ location.name }}</h4>
    </div>
</template>

<script>
  export default {
    props: {
      location: {
        type: Object,
        required: true
      }
    }
  };
</script>
