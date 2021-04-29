new Vue({
  el: '#container',
  data () {
    return {
      orderPayment: 0,
      orderId: 0
    }
  },
  created () {
    this.orderId = window.sessionStorage.getItem('orderId')
    this.orderPayment = window.sessionStorage.getItem('orderPayment')
  },
  methods: {
  }
})