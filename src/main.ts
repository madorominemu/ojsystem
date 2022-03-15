import { createApp } from 'vue'
import * as Icons from '@element-plus/icons'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import './assets/css/main.css'

const app = createApp(App)
app.use(store).use(router).use(ElementPlus).mount('#app')

//注册全局组件
Object.keys(Icons).forEach(key => {
    app.component(key, Icons[key as keyof typeof Icons])
})
