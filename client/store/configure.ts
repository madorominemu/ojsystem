const configure = {
    state: {
        HOST: 'http://localhost:8889',  //后台访问地址根目录
        loginIn: false,                 //是否登录

    },
    getters: {
        loginIn: state => {
            let loginIn = state.loginIn
            if(!loginIn){
                loginIn = JSON.parse(window.sessionStorage.getItem('loginIn'))
            }
            return loginIn
        },
    },
    mutations: {
        setLoginIn: (state,loginIn) => {
            state.loginIn = loginIn
            window.sessionStorage.setItem('loginIn',JSON.stringify(loginIn))
        },
    }
}

export default configure
