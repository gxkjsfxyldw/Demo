<template>
<div  style="background-color: #80caf8;width: 100%;height: 100vh">
  <div>                                                 <!--  :rules="rules"   表单校验-->
    <el-form ref="form" :model="form" label-width="65px" class="login-box" :rules="rules">
      <h3 class="login-title">欢迎 登录</h3>
      <el-form-item prop="username">
        <span slot="label" style="color: white">账号</span>
        <el-input prefix-icon="el-icon-user-solid" type="text" placeholder="请输入账号" v-model="form.username"/>
      </el-form-item>
      <el-form-item prop="password">
        <span slot="label" style="color: white">密码</span>
        <el-input prefix-icon="el-icon-lock" type="password" show-password placeholder=" 请输入密码" v-model="form.password"/>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" style="width: 80%;margin-left: 20px" @click="login">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</div>
</template>

<script>
  import request from "@/utils/rquest";

  export default {
    name: "Login",
    data() {
      return {
        form: {},
        // form: {role:1},
        //表单校验
        rules: {
          username:[ //对应 prop="username"
            {required:true,message:'请输入用户名',trigger:'blur'},
          ],
          password:[ //对应 prop="password"
            {required:true,message:'请输入密码',trigger:'blur'},
          ],
        },
      }
    },
    methods:{ //请求数据
      login(){    //this.form将表当存储的账号密码传输给后端
        //请求登录
        request.post("/user/login",this.form).then(res=>{

          if(res.code === '0'){
            this.$message({
              type:"success",
              message:"登录成功"
            })
            //  登录成功之后，路由跳转到首页
            sessionStorage.setItem("user", JSON.stringify(res.data))//将用户信息缓存到session中
            // console.log("登录成功！"+res.data.nickName)
            this.$router.push("/") //登录成功后跳转到主页
          }else{
            this.$message({
              type:"error",
              message:res.msg
            })
          }
        })
      }
    }
  }
</script>

<style scoped>
.login-box {
  background: #328be3;
  border: 1px solid #DCDFE6;
  width: 350px;
  margin: 0px auto;
  position: absolute;
  top: 23%;
  left: 35%;
  padding: 35px 35px 15px 0px;
  border-radius: 5px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  box-shadow: 0 0 25px #ffffff;
}

.login-title {
  font-size: 25px;
  text-align: center;
  margin: 0 auto 35px auto;
  margin-left: 20px;
  color: #ffffff;
}
</style>
