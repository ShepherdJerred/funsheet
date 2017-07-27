<template>
    <div>
        <section class="hero is-primary">
            <div class="hero-body">
                <div class="container">
                    <h1 class="title">
                        Create tag
                    </h1>
                </div>
            </div>
        </section>
        <div class="container">
            <create-tag></create-tag>
        </div>
    </div>
</template>

<script>
  import CreateTag from '../../components/tag/create-tag.vue';

  export default {
    components: {
      CreateTag
    }
  };
</script>
