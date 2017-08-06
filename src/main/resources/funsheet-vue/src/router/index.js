import Vue from 'vue';
import Router from 'vue-router';

import Home from '../components/home.vue';
import Login from '../components/login.vue';
import Register from '../components/register.vue';

import ActivityDetails from '../components/details/activity-details.vue';
import LocationDetails from '../components/details/location-details.vue';
import TypeDetails from '../components/details/type-details.vue';
import TagDetails from '../components/details/tag-details.vue';

import CreateActivity from '../components/create/create-activity.vue';
import CreateLocation from '../components/create/create-location.vue';
import CreateTag from '../components/create/create-tag.vue';
import CreateType from '../components/create/create-type.vue';

import AllActivities from '../components/table/activity-table.vue';
import AllLocations from '../components/table/location-table.vue';
import AllTypes from '../components/table/type-table.vue';
import AllTags from '../components/table/tag-table.vue';

import EditActivity from '../components/edit/edit-activity.vue';
import EditLocation from '../components/edit/edit-location.vue';
import EditType from '../components/edit/edit-type.vue';
import EditTag from '../components/edit/edit-tag.vue';

import DeleteActivity from '../components/delete/delete-activity.vue';

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
      path: '/location/all',
      name: 'All Locations',
      component: AllLocations
    },
    {
      path: '/type/all',
      name: 'All Types',
      component: AllTypes
    },
    {
      path: '/tag/all',
      name: 'All Tags',
      component: AllTags
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
    },
    {
      path: '/activity/edit/:uuid',
      name: 'Edit Activity',
      component: EditActivity
    },
    {
      path: '/location/edit/:uuid',
      name: 'Edit Location',
      component: EditLocation
    },
    {
      path: '/type/edit/:uuid',
      name: 'Edit Type',
      component: EditType
    },
    {
      path: '/tag/edit/:uuid',
      name: 'Edit Tag',
      component: EditTag
    },
    {
      path: '/activity/delete/:uuid',
      name: 'Delete Activity',
      component: DeleteActivity
    }
  ]
});
