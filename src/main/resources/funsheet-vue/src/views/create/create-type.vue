<template>
    <div>
        <div class="hero">
            <div class="hero-body">
                <div class="column is-one-third-desktop is-offset-one-third-desktop">
                    <h1 class="title">
                        Create type
                    </h1>
                </div>
            </div>
        </div>
        <div class="column is-one-third-desktop is-offset-one-third-desktop">
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
