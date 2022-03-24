import { createStore } from 'vuex'
import configure from './configure'
import user from './user'

// 创建一个新的 store 实例
const store = createStore({
  modules: {
    configure,
    user
  }
})

export default store