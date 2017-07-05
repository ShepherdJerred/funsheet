<template>
    <div>
        <nav class="navbar">
            <div class="navbar-brand">
                <a class="navbar-item" href="/">
                    Funsheet
                </a>

                <div class="navbar-burger burger">
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
            </div>

            <div class="navbar-end">
                <a class="navbar-item">
                    Home
                </a>
            </div>
        </nav>
        <section class="section">
            <div class="container">
                <div class="columns">
                    <div class="column">
                        <location-list></location-list>
                    </div>
                    <div class="column">
                        <tag-list></tag-list>
                    </div>
                    <div class="column">
                        <type-list></type-list>
                    </div>
                    <div class="column">
                        <activity-list></activity-list>
                    </div>
                </div>
            </div>
        </section>
    </div>
</template>

<script>
  import LocationList from '../components/location-list.vue';
  import TagList from '../components/tag-list.vue';
  import TypeList from '../components/type-list.vue';
  import ActivityList from '../components/activity-list.vue';

  export default {
    components: {
      LocationList,
      TagList,
      TypeList,
      ActivityList
    }
  };
</script>
