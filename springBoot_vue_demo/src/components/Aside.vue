<!--后台管理-->
<template>
  <div>
    <el-menu
        style="width: 200px; min-height: calc(100vh - 50px)"
        :default-active="$route.path.substr(1)"
        router
        class="el-menu-vertical-demo">
    </el-menu>
  </div>
</template>

<script>
  export default {
    name: "Aside",
    data(){
      return{
        user:{},
        path:this.$route.path //默认高亮的菜单
         // path:this.$route.path
      }
    },
    created() {
       // console.log(this.$route.path)
      let userstr= sessionStorage.getItem("user")||"{}"; //将session的值取出来并存储到临时对象中
      this.user=JSON.parse(userstr)
      //请求服务端，确认当前登录用户的合法信息
      request.get("/user/"+this.user.id).then(res=>{
        if(res.code==='0'){
          this.user=res.data
        }
      })
    }
  }
</script>

<style scoped>

</style>
