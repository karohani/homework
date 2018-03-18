<template>
<div class="coupon">

    <h1>등록</h1>
<div>
  <input type="text" v-model="newEmail"> {{ coupon }}
  <button v-on:click="add">ADD</button>
</div>
</div>
</template>

<script>

export default {
  data () {
    return {newEmail: '', coupon: ''}
  },
  methods: {
    add () {
      console.log(this.newEmail)
      const baseURI = 'http://localhost:8080'
      console.log(baseURI)
      localStorage.setItem(this.newEmail, this.newEmail)
      this.coupon = baseURI
      this.$http.get(`${baseURI}/person/insert/` + this.newEmail)
        .then((result) => {
          this.coupon = result.data
          console.log(result)
        })
    }
  }
}
</script>

<style scoped>

</style>
