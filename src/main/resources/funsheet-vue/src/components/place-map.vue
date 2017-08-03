<template>
    <div>
        <div class="card">
            <div class="card-image">
                <iframe class="map"
                        frameborder="0"
                        allowfullscreen
                        :src="src">
                </iframe>
            </div>
            <div class="card-content">
                <div class="content">
                    <router-link :to="'/location/' + location.uuid"><h1 class="title">{{ location.name }}</h1></router-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
      props: {
        location: {
          type: Object,
          required: true
        }
      },
      computed: {
        src: function () {
          return 'https://www.google.com/maps/embed/v1/place?key=AIzaSyDzHtAQxI5QVj-1aohH0f8VtmMfTFQxyFQ' +
            '&q=place_id:' + this.location.placeId;
        }
      }
    };
</script>

<style lang="scss" scoped>
    .map {
        width: 100%;
        height: 350px;
        border: 0;
    }
</style>
