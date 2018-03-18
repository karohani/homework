import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
// import App from '@/App'
import SimpleCoupon from '@/components/SimpleCoupon'
import SimpleCouponList from '@/components/SimpleCouponList'
import BootstrapVue from 'bootstrap-vue'
Vue.use(Router)
Vue.use(BootstrapVue)
export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: SimpleCoupon
    },
    {
      path: '/list',
      name: 'CouponList',
      component: SimpleCouponList
    }
  ]
})
