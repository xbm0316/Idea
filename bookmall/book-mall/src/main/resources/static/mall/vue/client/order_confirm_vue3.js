new Vue({
  el: '#order_confirm_vue',
  data () {
    return {
      addressList: [],
      order: {},
      size: 0,
      addressId: 0
    }
  },
  created () {
    this.orderInfo()
    this.getAddressList()
  },
  methods: {
    checkAddress (item) {
      this.addressId = item.rid
      console.log(this.addressId)
    },
    getAddressList () {
      const token = window.sessionStorage.getItem('token')
      that = this;
      url = '/client/address/list'
      axios.get(url, {
        headers: {
          'Authorization': token
        }
      })
        .then(resp => {
          //console.log(resp)
          this.addressList = resp.data
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    orderInfo () {
      const token = window.sessionStorage.getItem('token')
      const orderId = window.sessionStorage.getItem('orderId')
      that = this;
      url = '/client/order/orderInfo/' + orderId
      axios.get(url, {
        headers: {
          'Authorization': token
        }
      })
        .then(resp => {
          this.order = resp.data
          this.size = this.order.orderItems.length
          console.log(resp)
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    confirmOrder () {
      if (this.addressId == 0) {
        alert('请选择地址')
        return;
      }
      const token = window.sessionStorage.getItem('token')
      url = '/client/order/confirmOrder'
      var order = { orderId: this.order.orderId, addressId: this.addressId }
      axios.post(url, JSON.stringify(order), {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': token
        }
      })
        .then(resp => {
          console.log(resp)
          if (resp.code == 1) {
            window.sessionStorage.setItem("orderPayment", this.order.payment)
            window.location.href = "/mall/user/page/payment.html"
          }
        })
        .catch(function (error) {
          console.log(error);
        });

    }
  }
})