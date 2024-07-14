import Vue from 'vue'
import VueRouter from 'vue-router'
import Person from '../views/Person.vue'
import frames from '../framework/frames.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'frames',
    props:true,
    component: frames,
    redirect:'/Person', //当什么都不输入时，重定向到首页
    //  子路由  这些是在登录状态需要显示的路由
    children: [
      {
        path: 'Person',
        name: 'Person',
        component: ()=>import('@/views/Person')
      },
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: ()=>import('@/views/Login')
  },

  // {
  //   path: '/register',
  //   name: 'Register',
  //   component: ()=>import('@/views/Register')
  // },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
