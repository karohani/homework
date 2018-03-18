<template>
  <div id="app">

    <img src="./assets/logo.png">
    <router-link to="/">ADD</router-link>
    <router-link to="/list">LIST</router-link>
    <router-view/>
  </div>
</template>

<script>
import SimpleCoupon from './components/SimpleCoupon.vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

export default {
  component: {
    'SimpleCoupon': SimpleCoupon
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
