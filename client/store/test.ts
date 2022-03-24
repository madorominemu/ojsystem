// import { createStore } from 'vuex'
// import problem from './problem'
// import user from './user'
// export default createStore({
//     state: {
//         HOST: 'http://localhost:8888',  //后台访问地址根目录
//         loginIn: false,                  //是否登录
//         // username: ''
//     },
//     getters: {
//         loginIn: state => {
//             let loginIn = state.loginIn;
//             if (!loginIn) {
//                 loginIn = JSON.parse(window.localStorage.getItem('loginIn') || null)
//             }
//             return loginIn
//         },
//         // username: state => {
//         //   let username = state.username
//         //   if (!username) {
//         //     username = JSON.parse(window.localStorage.getItem('username') || null)
//         //   }
//         //   return username
//         // },
//     },
//     mutations: {
//         setLoginIn: (state, loginIn) => {
//             state.loginIn = loginIn
//             window.localStorage.setItem('loginIn', JSON.stringify(loginIn))
//         },
//         // setUsername: (state, username) => {
//         //   state.username = username
//         //   window.localStorage.setItem('username', JSON.stringify(username))
//         // },
//     },
//     modules: {
//         user,
//         problem
//     }
// })
