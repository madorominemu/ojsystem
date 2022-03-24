const state = {
    windowMsg: ''
}
const getters = {
    // windowMsg: state => {
    //     let windowMsg = state.windowMsg
    //     if (!windowMsg) {
    //         windowMsg = JSON.parse(window.localStorage.getItem('windowMsg') || null)
    //     }
    //     return windowMsg
    // }
}
const actions = {}
const mutations = {
    // setWindowMsg: (state, windowMsg) => {
    //     state.windowMsg = windowMsg
    //     window.localStorage.setItem('windowMsg', JSON.stringify(windowMsg))
    // },
}
export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}