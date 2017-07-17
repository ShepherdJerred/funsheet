import Vue from 'vue';
import Router from 'vue-router';

import Home from '../views/home.vue';
import CreateActivity from '../components/create-activity.vue';
import CreateLocation from '../components/create-location.vue';
import CreateTag from '../components/create-tag.vue';
import CreateType from '../components/create-type.vue';
import Login from '../views/login.vue';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/activity/create',
      name: 'Create Activity',
      component: CreateActivity
    },
    {
      path: '/location/create',
      name: 'Create Location',
      component: CreateLocation
    },
    {
      path: '/tag/create',
      name: 'Create Tag',
      component: CreateTag
    },
    {
      path: '/type/create',
      name: 'Create Type',
      component: CreateType
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    }
  ]
});
