import Vue from 'vue';
import App from './App';
import router from './router';
import store from './store';
import '../node_modules/skeleton-css/css/skeleton.css';
import '../node_modules/font-awesome/css/font-awesome.css';

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
});
