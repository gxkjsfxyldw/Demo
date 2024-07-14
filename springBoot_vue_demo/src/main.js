import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';  //引入插件  用plus会出错的
//引入Css
import 'element-ui/lib/theme-chalk/index.css';
import '@/assets/css/global.css'
//国际化
import locale from 'element-ui/lib/locale/lang/zh-CN'

Vue.use(ElementUI,{locale,size:'small'});
Vue.use(locale);

Vue.config.productionTip = false
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')







