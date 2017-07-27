import Vue from 'vue';
import router from './router';
import store from './store';
import buefy from 'buefy';
import WebFontLoader from 'webfontloader';
import 'buefy/lib/buefy.css';
import 'font-awesome/css/font-awesome.css';
import App from './App';

WebFontLoader.load({
  google: {
    families: ['Cabin', 'Lobster']
  }
});

Vue.config.productionTip = false;

Vue.use(buefy, {
  defaultIconPack: 'fa'
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
});
