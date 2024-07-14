<!--网页导航头部-->
<template>
  <div style="height: 50px;line-height: 50px;border-bottom: 1px solid #ccc;display: flex">
    <div style="width: 200px;padding-left: 30px;font-weight: bold;color: #3c7cfd">后台管理</div>
    <div style="flex: 1px"></div>
    <div style="width: 100px">
    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
  // props: ['user'],
  userinfo:{},//定义一个对象
  data() {
    return {

    }
  },
  created() {
    this.userinfo=JSON.parse(sessionStorage.getItem("user")); //将session的值取出来并存储到临时对象中
    console.log(this.userinfo.nickName)
  }
}
</script>

<style scoped>

  .el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }
</style>
