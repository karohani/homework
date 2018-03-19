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
import axios from 'axios'
import validator from 'validator'

export default {
  data () {
    return {newEmail: '', coupon: ''}
  },
  methods: {
    add () {
      console.log(this.newEmail)
      const baseURI = 'http://localhost:8080'
      console.log(baseURI)
      this.coupon = baseURI
      var data = {email: this.newEmail}
      if (validator.isEmail(this.newEmail)) {
        axios({
          method: 'POST',
          url: `${baseURI}/coupon`,
          header: 'application/json',
          data: data
        }).then((result) => {
          this.coupon = result.data.coupon
          console.log(result)
          this.newEmail = ''
        })
      } else {
        this.coupon = 'INVAID EMAIL!!'
      }
    }
    // emailValidation (email) {
    //   const regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    //   return regex.test(email)
    // }
  }
}
</script>

<style scoped>

</style>
