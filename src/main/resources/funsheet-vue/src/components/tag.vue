<template>
    <div>
        <h4>{{ name }}</h4>
    </div>
</template>

<script>
  export default {
    props: {
      name: {
        type: String,
        required: true
      }
    }
  };
</script>
