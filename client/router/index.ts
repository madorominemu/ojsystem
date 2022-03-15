import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from '../views/Home.vue'
import ProblemSet from '../views/ProblemSet.vue'
import Learn from '../views/Learn.vue'
import Problem from '../views/Problem.vue'
import Profile from '../views/Profile.vue'
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

export default router
