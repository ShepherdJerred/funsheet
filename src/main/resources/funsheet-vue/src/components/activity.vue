<template>
    <div>
        <h4>{{ name }}
            <small>Rating: {{ rating }}</small>
        </h4>
        <p>
            <template v-if="type">
                Type: {{ type.name }}
            </template>
            <template v-if="location">
                Location: {{ location.name }}
            </template>
        </p>
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
      },
      location: {
        type: Object,
        required: true
      }
    }
  };
</script>
