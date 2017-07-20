import Vue from 'vue';
import Router from 'vue-router';

import Home from '../views/home.vue';
import Login from '../views/login.vue';
import Register from '../views/register.vue';

import ActivityDetails from '../views/activity-details.vue';
import LocationDetails from '../views/location-details.vue';
import TypeDetails from '../views/type-details.vue';
import TagDetails from '../views/tag-details.vue';

import CreateActivity from '../views/create-activity.vue';
import CreateLocation from '../views/create-location.vue';
import CreateTag from '../views/create-tag.vue';
import CreateType from '../views/create-type.vue';

import AllActivities from '../views/all-activities.vue';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
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
      path: '/activity/all',
      name: 'All Activities',
      component: AllActivities
    },
    {
      path: '/activity/:uuid',
      name: 'Activity Details',
      component: ActivityDetails
    },
    {
      path: '/location/:uuid',
      name: 'Location Details',
      component: LocationDetails
    },
    {
      path: '/type/:uuid',
      name: 'Type Details',
      component: TypeDetails
    },
    {
      path: '/tag/:uuid',
      name: 'Tag Details',
      component: TagDetails
    }
  ]
});
