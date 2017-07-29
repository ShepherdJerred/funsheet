import Vue from 'vue';
import router from './router';
import store from './store';
import WebFontLoader from 'webfontloader';
import 'font-awesome/css/font-awesome.css';
import 'normalize.css/normalize.css';
import 'flexboxgrid/css/flexboxgrid.min.css';

import App from './App';

WebFontLoader.load({
  google: {
    families: ['Cabin', 'Lobster']
  }
});

Vue.config.productionTip = !(process.env.NODE_ENV === 'production');

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
});
