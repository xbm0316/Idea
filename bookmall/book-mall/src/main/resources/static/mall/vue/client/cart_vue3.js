new Vue({
  el: '#cart_vue',
  data () {
    return {
      cartItems: [],
      order: {
        payment: 0,
        orderItems: []
      },
      ischeckAll: false
    }
  },
  created () {
    this.cartList()
  },
  methods: {
    gg (f, digit) {
      // Math.pow(指数，幂指数)
      var m = Math.pow(10, digit);
      // Math.round（） 四舍五入
      return Math.round(f * m, 10) / m;
    },
    check (item) {
      item.isSelect = !item.isSelect
      if (item.isSelect) {
        var orderitem = { count: item.count, product: item.book.isbn, price: item.book.price }
        this.order.orderItems.push(orderitem)
        this.order.payment = this.order.payment + (item.book.price * item.count)
        this.order.payment = this.gg(this.order.payment, 2)
        if (this.order.orderItems.length == this.cartItems.length) {
          this.ischeckAll = true
        }
      } else {
        for (var i = 0; i < this.order.orderItems.length; i++) {
          if (this.order.orderItems[i].product === item.book.isbn) {
            this.order.orderItems.splice(i, 1)
            this.order.payment = this.order.payment - (item.book.price * item.count)
            this.order.payment = this.gg(this.order.payment, 2)
          }
          if (this.order.orderItems.length != this.cartItems.length) {
            this.ischeckAll = false
          }
        }
      }
    },
    checkAll () {
      this.ischeckAll = !this.ischeckAll
      this.order.orderItems = []
      this.order.payment = 0
      if (this.ischeckAll) {
        for (var i = 0; i < this.cartItems.length; i++) {
          this.cartItems[i].isSelect = this.ischeckAll
          var orderitem = { count: this.cartItems[i].count, product: this.cartItems[i].book.isbn, price: this.cartItems[i].book.price }
          this.order.orderItems.push(orderitem)
          this.order.payment = this.order.payment + (this.cartItems[i].book.price * this.cartItems[i].count)
          this.order.payment = this.gg(this.order.payment, 2)
        }
      } else {
        for (var i = 0; i < this.cartItems.length; i++) {
          this.cartItems[i].isSelect = this.ischeckAll

        }
        //this.order.payment = 0
      }
    },
    cartList () {
      const token = window.sessionStorage.getItem('token')
      that = this;
      url = '/client/cart/list'
      axios.get(url, {
        headers: {
          'Authorization': token
        }
      })
        .then(resp => {
          this.cartItems = resp.data
          // console.log(resp)
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    del (isbn) {
      const token = window.sessionStorage.getItem('token')
      that = this;
      url = '/client/cart/delBook/' + isbn
      axios.get(url, {
        headers: {
          'Authorization': token
        }
      })
        .then(resp => {
          // console.log(resp)
          alert(resp.msg)
          this.cartList()
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    updateCount (isbn, count) {
      const token = window.sessionStorage.getItem('token')
      that = this;
      url = '/client/cart/updateCount/' + isbn + '/' + count
      axios.get(url, {
        headers: {
          'Authorization': token
        }
      })
        .then(resp => {
          console.log(resp)
          this.cartList()
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    createOrder () {
      const token = window.sessionStorage.getItem('token')
      that = this;
      url = '/client/order/createOrder'
      axios.post(url, JSON.stringify(this.order), {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': token
        }
      })
        .then(resp => {
          console.log(resp)
          window.sessionStorage.setItem('orderId', resp.data)
          window.location.href = "/mall/user/page/order-confirm.html"
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  }
})