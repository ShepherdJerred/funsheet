<template>
    <div>
        <section class="hero is-primary">
            <div class="hero-body">
                <div class="container">
                    <h1 class="title">
                        Create type
                    </h1>
                </div>
            </div>
        </section>
        <div class="container">
            <create-type></create-type>
        </div>
    </div>
</template>

<script>
  import CreateType from '../../components/type/create-type.vue';

  export default {
    components: {
      CreateType
    }
  };
</script>
