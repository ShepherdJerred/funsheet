import Vue from 'vue';
import VueAnalytics from 'vue-analytics';
import router from './router';
import store from './store';
import Buefy from 'buefy';

import WebFontLoader from 'webfontloader';

import 'font-awesome/css/font-awesome.css';
import 'buefy/lib/buefy.css';

import App from './App.vue';

WebFontLoader.load({
  google: {
    families: ['Cabin', 'Lobster']
  }
});

Vue.use(VueAnalytics, {
  id: 'UA-104313543-1',
  router
});

Vue.use(Buefy);

Vue.config.productionTip = !(process.env.NODE_ENV === 'production');

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
});
