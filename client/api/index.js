import {get,post} from '@/api/http';

//================题目相关=================
//查询所有题目  TAB键上的点·不是单引号
export const getAllProblem= () => get(`problem/allProblem`);