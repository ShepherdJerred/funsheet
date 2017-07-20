<template>
    <div>
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <create-location></create-location>
        </div>
    </div>
</template>

<script>
  import CreateLocation from '../components/create-location.vue';

  export default {
    components: {
      CreateLocation
    }
  };
</script>
