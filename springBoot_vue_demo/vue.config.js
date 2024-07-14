// 跨域配置
module.exports = {
  devServer: {      //不要写错，devdevServer 是设置本地默认接口 选填
    port:9091,//将前端8080改为9091
    proxy: {    //设置代理，必须
      '/api': {   //设置拦截器，拦截格式，斜杠+拦截器名称，名称可自定义
        target:'http://localhost:9090',//代理的目标地址，这里写了之后当请求/api时会自动转变为这个地址
        changeOrigin:true,  //设置是否同源，true是
        pathRewrite:{   //路径重写
          '/api' : ''    //选择忽视拦截器里面的单词，
        }
      }
    }
  }
}
