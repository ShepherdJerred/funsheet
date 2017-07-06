<template>
    <div>
        <h4>{{ name }}</h4>
        <h5>Tags</h5>
        <ul>
            <template v-for="tag in tags">
                <li>{{ tag.name }}</li>
            </template>
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
      tags: {
        type: Array,
        required: true
      }
    }
  };
</script>
