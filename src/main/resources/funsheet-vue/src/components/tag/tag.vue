<template>
    <div>
        <h4>{{ tag.name }}</h4>
    </div>
</template>

<script>
  export default {
    props: {
      tag: {
        type: Object,
        required: true
      }
    }
  };
</script>
