import Vue from 'vue';
import App from './App';
import router from './router';
import store from './store';
import 'purecss/build/pure-min.css';
import 'font-awesome/css/font-awesome.css';
import WebFontLoader from 'webfontloader';

WebFontLoader.load({
  google: {
    families: ['Mukta Vaani', 'Cabin', 'Lobster']
  }
});

Vue.config.productionTip = false;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
});
