import {get,post} from '@/api/http';

//================题目相关=================
//查询所有题目  TAB键上的点·不是单引号
export const getAllProblem= () => get(`problem/allProblem`);
//添加题目     TAB键上的点·不是单引号
export const setProblem= (params) => post(`problem/add`,params);
//删除题目     TAB键上的点·不是单引号
export const delProblem = (id) => get(`problem/delete?id=${id}`);
//修改题目     TAB键上的点·不是单引号
export const updateProblem = (params) => post(`problem/update`,params);

//================代码相关=================
//查询代码  根据题目id  TAB键上的点·不是单引号
export const getCode= (problemId) => get(`code/selectByProblemId?problemId=${problemId}`);
//添加代码     TAB键上的点·不是单引号
export const setCode= (params) => post(`code/add`,params);
//删除代码     TAB键上的点·不是单引号
export const delCode = (problemId) => get(`code/delete?problemId=${problemId}`);

//================用户相关=================
//查询所有用户  TAB键上的点·不是单引号
export const getAllUser= () => get(`user/allUser`);
//添加用户     TAB键上的点·不是单引号
export const setUser= (params) => post(`user/add`,params);
//删除用户     TAB键上的点·不是单引号
export const delUser = (id) => get(`user/delete?id=${id}`);
//修改用户     TAB键上的点·不是单引号
export const updateUser = (params) => post(`user/update`,params);