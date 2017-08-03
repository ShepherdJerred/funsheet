<template>
    <div>
        <section class="hero is-primary">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        Create tag
                    </h1>
                </div>
            </div>
        </section>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
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
