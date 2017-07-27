<template>
    <div>
        <section class="hero is-primary">
            <div class="hero-body">
                <div class="container">
                    <h1 class="title">
                        Create activity
                    </h1>
                </div>
            </div>
        </section>
        <div class="container">
            <create-activity></create-activity>
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
