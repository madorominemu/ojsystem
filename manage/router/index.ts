import { createRouter, createWebHistory} from 'vue-router'
import Home from '../components/Home.vue'
import Info from '../views/InfoPage.vue'
import User from '../views/UserPage.vue'
import Problem from '../views/ProblemPage.vue'

const routes = [
  {
    path: '/',
    component: Home,
    children:[
      {
        path: '/Info',
        component: Info,
      },
      {
        path: '/User',
        component: User,
      },
      {
        path: '/Problem',
        component: Problem,
      },
    ]
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
