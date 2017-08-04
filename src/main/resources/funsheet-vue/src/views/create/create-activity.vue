<template>
    <div>
        <div class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        Create activity
                    </h1>
                </div>
            </div>
        </div>
        <div class="columns">
            <div class="column is-one-third-desktop is-offset-one-third-desktop">
                <create-activity></create-activity>
            </div>
        </div>
    </div>
</template>

<script>
  import CreateActivity from '../../components/activity/create-activity.vue';

  export default {
    components: {
      CreateActivity
    }
  };
</script>

<style lang="scss" scoped>
    
</style>
