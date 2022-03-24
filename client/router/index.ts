import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from '../views/Home.vue'
import ProblemSet from '../views/ProblemSet.vue'
import Learn from '../views/Learn.vue'
import Problem from '../views/Problem.vue'
import Profile from '../views/Profile.vue'
import Login from '../views/Login.vue'
import Signup from '../views/Signup.vue'
import Test from '../views/test.vue'


const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    component: Home,
    children: [
      {
        path: '/home',
        name: 'Home',
        component: Home,
      },
      {
        path: '/login',
        name: 'Login',
        component: Login,
      },
      {
        path: '/signup',
        name: 'Signup',
        component: Signup,
      },
      {
        path: '/learn',
        name: 'Learn',
        component: Learn,
      },
      {
        path: '/problemset',
        name: 'ProblemSet',
        component: ProblemSet,
      },
      {
        path: '/problem',
        name: 'Problem',
        component: Problem,
      },
      {
        path: '/profile',
        name: 'Profile',
        component: Profile,
      },
      {
        path: '/test',
        name: 'Test',
        component: Test,
      },
    ]
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

// router.beforeEach((to, from, next) => {
//   if (to.name = 'login') {
//     next();
//   } else {
//     if(JSON.parse(window.sessionStorage.getItem('loginIn')) === true) {
//       next();
//     }
//   }
//   return false
// })

//全局路由守卫
router.beforeEach((to, from, next) => {
  if(to.path === '/login')
    return next();
  if(to.path === '/signup')
    return next();
  if(to.path === '/problemset')
    return next();
  // 从sessionStorage 中获取保存的 loginIn 值
  let loginIn = window.sessionStorage.getItem('loginIn');
  //  没有 loginIn ，强制跳转到登录页面
  if(!loginIn)
    return next('/login');

  next();
})

export default router
