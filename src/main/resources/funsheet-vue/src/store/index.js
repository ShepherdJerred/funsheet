import Vue from 'vue';
import Vuex from 'vuex';
import VueResource from 'vue-resource';

Vue.use(Vuex);
Vue.use(VueResource);

export default new Vuex.Store({
  state: {
    activities: [],
    tags: [],
    types: [],
    locations: []
  },
  mutations: {
    setActivities (state, value) {
      state.activities = value;
    },
    setTags (state, value) {
      state.tags = value;
    },
    setTypes (state, value) {
      state.types = value;
    },
    setLocations (state, value) {
      state.locations = value;
    }
  },
  actions: {
    getActivities (context) {
      Vue.http.get('/api/activities').then(response => {
        context.commit('setActivities', response.body);
      }, response => {
        console.log(response.body);
      });
    },
    getTags (context) {
      Vue.http.get('/api/tags').then(response => {
        context.commit('setTags', response.body);
      }, response => {
        console.log(response.body);
      });
    },
    getTypes (context) {
      Vue.http.get('/api/types').then(response => {
        context.commit('setTypes', response.body);
      }, response => {
        console.log(response.body);
      });
    },
    getLocations (context) {
      Vue.http.get('/api/locations').then(response => {
        context.commit('setLocations', response.body);
      }, response => {
        console.log(response.body);
      });
    }
  }
});
