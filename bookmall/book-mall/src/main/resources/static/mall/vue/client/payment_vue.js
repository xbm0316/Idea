new Vue({
  el: '#pay_form',
  data () {
    return {
      orderPayment: 0,
      orderId: 0,
      bank: ''
    }
  },
  created () {
    this.orderId = window.sessionStorage.getItem('orderId')
    this.orderPayment = window.sessionStorage.getItem('orderPayment')
  },
  methods: {
    selectBank (bank) {
      this.bank = bank
      // alert('444')
    },
    pay () {
      if (!this.bank) {
        //alert("dddddddddddd")
        return;
      }
      const token = window.sessionStorage.getItem('token')
      url = '/client/order/pay/' + this.orderId
      axios.get(url, {
        headers: {
          'Authorization': token
        }
      })
        .then(resp => {
          console.log(resp)
          window.location.href = "/mall/user/page/pay-success.html"
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  }
})