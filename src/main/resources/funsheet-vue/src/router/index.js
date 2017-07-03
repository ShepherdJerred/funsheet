import Vue from 'vue';
import Router from 'vue-router';
import ActivityList from '../components/activity-list.vue';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Activities',
      component: ActivityList
    }
  ]
});
