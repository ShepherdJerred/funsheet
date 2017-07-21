<template>
    <div>
        <h4>{{ type.name }}</h4>
        <h5>Tags</h5>
        <ul>
            <template v-for="tag in type.tags">
                <li><router-link :to="'/tag/' + tag.uuid">{{ tag.name }}</router-link></li>
            </template>
        </ul>
    </div>
</template>

<script>
  export default {
    props: {
      type: {
        type: Object,
        required: true
      }
    }
  };
</script>
