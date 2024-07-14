<template>
  <div>
<!--    这里作为全局的访问界面，它可以是登录，也可以是主界面，他会根据路由自动展示-->
    <router-view />
  </div>
</template>

<script>
export default {
  name:"App",
}
</script>
