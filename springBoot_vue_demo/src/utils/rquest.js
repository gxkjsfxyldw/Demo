//处理 axios数据交互
//导入包
import axios from 'axios'
import router from "@/router";

//创建axios对象
const request=axios.create({
    baseURL:"/api",//将vue.config.js跨域的拦截器名称写到这里来，就不用每次在其他url前加api了
    timeout:5000
})

// //request 拦截器
// //可以自请求前对清请求做一些处理
// //比如统一加token,对请求参数统一加密
// request.interceptors.request.use(config=> {
//     //设置请求头编码格式
//     config.headers['Content-Type'] = 'application/json;charset=utf-8';
//     // config.headers['token']=user.token;//设置token验证
//     //取出sessionStorage 里面缓存的用户信息
//     const userJson= sessionStorage.getItem("user")
//     if(!userJson){//为空说明没有登录
//         //强制跳转到登录界面
//         router.push("/login")
//     }
//     return config;
// },error => {
//     return Promise.reject(error);
// });


// response 拦截器
//可以在接口响应后统一处理结果
request.interceptors.response.use(
    response=>{
        let res=response.data;
    //    如果是返回文件
        if(response.config.responseType === 'blob'){
            return res
        }
    //    兼容服务端返回的字符串数据
        if(typeof res === 'string'){
            //三目运算
            res=res ? JSON.parse(res):res
        }
        return res;
    },

    error => {
        console.log('err'+error)// for debug
        return Promise.reject(error)
    }
)

export default request
