<template>
    <div>
        <div class="card">
            <div class="card-content">
                <iframe class="map"
                        frameborder="0"
                        allowfullscreen
                        :src="src">
                </iframe>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
      props: {
        placeId: {
          type: String,
          required: true
        }
      },
      computed: {
        src: function () {
          return 'https://www.google.com/maps/embed/v1/place?key=AIzaSyDzHtAQxI5QVj-1aohH0f8VtmMfTFQxyFQ' +
            '&q=place_id:' + this.placeId;
        }
      }
    };
</script>

<style lang="scss" scoped>
    .map {
        width: 100%;
        height: 450px;
        border: 0;
    }
</style>
