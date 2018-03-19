<template>
  <div v-model="rows">
    <table class="table">
      <thead>
      <tr>
        <th v-for="(col, key) in columns">{{ col }} {{ key }}</th>
      </tr>
      </thead>
     <tbody>
      <tr v-for="col in rows">
        <td>{{ col.id}} </td>
        <td>{{ col.email}} </td>
        <td>{{ col.coupon}} </td>
        <td>{{ col.regDate}} </td>
        <td>{{ col.updateDate}} </td>
      </tr>
     </tbody>
    </table>
    <b-pagination v-on:click.native="paging" align="center" :total-rows="100" v-model.lazy="currentPage" :per-page="5">
    </b-pagination>
    <br>
    {{ currentPage }} page
  </div>
</template>
<script>
export default {
  name: 'LIST',
  data () {
    return {
      columns: [
        'id', 'email', 'coupon', 'regDate', 'updateDate'
      ],
      rows: this.getList(1),
      currentPage: 1,
      rowCount: 0
    }
  },
  methods: {
    getList (currentPage) {
      this.$http({
        method: 'GET',
        url: 'http://localhost:8080/coupon',
        params: {
          page: currentPage - 1,
          perPage: 10
        }
      }).then((result) => {
        console.log(result.data)
        this.rows = result.data
      })
    },
    paging () {
      this.getList(this.currentPage)
    }
  }
}

</script>
