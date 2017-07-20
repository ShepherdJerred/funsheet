<template>
    <div>
        <div class="pure-u-1-8"></div>
        <div class="pure-u-3-4">
            <create-activity></create-activity>
        </div>
    </div>
</template>

<script>
  import CreateActivity from '../components/create-activity.vue';

  export default {
    components: {
      CreateActivity
    }
  };
</script>
