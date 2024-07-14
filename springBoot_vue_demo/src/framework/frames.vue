<template>
  <div>
    <!--头部-->
    <Header />

    <!--主体-->
    <div style="display: flex">
      <!--侧边栏-->
      <Aside/>
      <!--内容区域-->
      <router-view style="flex: 1"/>
    </div>
  </div>
</template>

<style scoped>
  @import url("//unpkg.com/element-ui@2.15.6/lib/theme-chalk/index.css");
</style>

<script>

  import Header from "@/components/Header";
  import Aside from "@/components/Aside";

  export default {
    name: "frames",
    components: {
      Aside,
      Header
    }
  }
</script>
