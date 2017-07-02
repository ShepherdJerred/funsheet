import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    activities: []
  },
  mutations: {
    getActivities (state) {
      this.$http.get('/api/activities').then(response => {
        state.activities = response.body;
        console.log(state.activities);
      }, response => {
        console.log('Error');
      });
    }
  }
});
