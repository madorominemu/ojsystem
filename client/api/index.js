import {get,post} from '@/api/http';

//================题目=================
//查询所有题目  TAB键上的点·不是单引号
export const getAllProblem= () => get(`problem/allProblem`);
//查询题目根据id     TAB键上的点·不是单引号
export const selectProblemByPrimaryKey = (id) => get(`problem/selectProblemByPrimaryKey?id=${id}`);
//查询代码  根据题目id  TAB键上的点·不是单引号
export const getCode = (problemId) => get(`code/selectByProblemId?problemId=${problemId}`);
//提交代码
export const executeCode = (params) => post(`compile/execute`,params);

//================用户=================
//注册
export const signUp =(params) => post(`user/add`,params);
//登录
export const loginIn = (params) => post(`user/login`, params)