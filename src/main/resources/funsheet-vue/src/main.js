import Vue from 'vue';
import App from './App';
import router from './router';
import store from './store';
import '../node_modules/purecss/build/base-min.css';
import '../node_modules/purecss/build/grids-responsive-min.css';

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
});
