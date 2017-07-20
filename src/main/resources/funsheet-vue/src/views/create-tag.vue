<template>
    <div>
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <create-tag></create-tag>
        </div>
    </div>
</template>

<script>
  import CreateTag from '../components/create-tag.vue';

  export default {
    components: {
      CreateTag
    }
  };
</script>
