<template>
    <div>
        <h4>{{ name }}</h4>
        <h5>Tags</h5>
        <ul>
            <template v-for="tag in tags">
                <li><router-link :to="'/tag/' + tag.uuid">{{ tag.name }}</router-link></li>
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
