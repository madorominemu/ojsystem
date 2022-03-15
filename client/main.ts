import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './index.css'
//svg组件
import './assets/icons'
import SvgIcon from '@/components/SvgIcon.vue'

createApp(App)
    .use(store)
    .use(router)
    .component('svg-icon', SvgIcon)
    .mount('#app')
