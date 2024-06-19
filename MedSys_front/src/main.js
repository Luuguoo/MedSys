// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'
import axios from 'axios'
import router from './router'
import globalvariable from './compoents/global_variable'

Vue.prototype.$baseVar = globalvariable

Vue.config.productionTip = false

Vue.use(ElementUI)

Vue.prototype.$axios = axios
axios.defaults.withCredentials = true
axios.defaults.baseURL = globalvariable.baseURL

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})
