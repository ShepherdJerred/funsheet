import Vue from 'vue';
import Vuex from 'vuex';
import VueResource from 'vue-resource';

Vue.use(Vuex);
Vue.use(VueResource);

export default new Vuex.Store({
  state: {
    activities: []
  },
  mutations: {
    setActivities (state, value) {
      state.activities = value;
    }
  },
  actions: {
    getActivities (context) {
      Vue.http.get('/api/activities').then(response => {
        context.commit('setActivities', response.body);
      }, response => {
        console.log('Error');
      });
    }
  }
});
