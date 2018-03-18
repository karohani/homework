<template>
  <div>
    <table class="table">
      <thead>
      <tr>
        <th v-for="(col, key) in columns">{{ col }} {{ key }}</th>
      </tr>
      </thead>
     <tbody>
      <tr v-for="col in rows">
        <td>{{ col.id}} </td>
        <td>{{ col.name}} </td>
        <td>{{ col.age}} </td>
        <td>{{ col.createAt}} </td>
      </tr>
     </tbody>
    </table>
    <b-pagination size="sm" :total-rows="100" v-model="currentPage" :per-page="10">
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
        'id', 'name', 'age', 'createAt', 'score'
      ],
      rows: [
        {id: 1, name: 'John', age: 20, createdAt: '201-10-31:9:35 am', score: 0.03343},
        {id: 2, name: 'Jane', age: 24, createdAt: '2011-10-31', score: 0.03343},
        {id: 3, name: 'Susan', age: 16, createdAt: '2011-10-30', score: 0.03343},
        {id: 4, name: 'Chris', age: 55, createdAt: '2011-10-11', score: 0.03343},
        {id: 5, name: 'Dan', age: 40, createdAt: '2011-10-21', score: 0.03343}
      ],
      currentPage: 1
    }
  },
  getMaxPage () {
    return {}
  }
}
</script>
