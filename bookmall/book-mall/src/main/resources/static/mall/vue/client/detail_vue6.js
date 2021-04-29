new Vue({
  el: '#detail_vue',
  data () {
    return {
      book: {},
      rBooks: [],
      isCollectData: 0,
      bookCount: 1
    }
  },
  created () {
    this.bookInfo()
    this.recommendedBooks()
    this.isCollect()
  },
  methods: {
    upCount (count) {
      if (count <= 0) {
        this.bookCount = 1;
        return;
      }
      this.bookCount = count
    },
    cartAddBook () {
      const token = window.sessionStorage.getItem('token')
      that = this;
      url = '/client/cart/addBook/' + this.book.isbn + '/' + this.bookCount
      axios.get(url, {
        headers: {
          'Authorization': token
        }
      })
        .then(resp => {
          //console.log(resp)

          alert(resp.msg)

        })
        .catch(function (error) {
          console.log(error);
        });
    },
    collectBook (isbn) {
      const token = window.sessionStorage.getItem('token')
      that = this;
      url = '/client/collect/collectBook/' + isbn
      axios.get(url, {
        headers: {
          'Authorization': token
        }
      })
        .then(resp => {
          //console.log(resp)
          alert(resp.msg)
          this.isCollect()
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    bookInfo () {
      that = this;
      const isbn = window.sessionStorage.getItem('client_isbn')
      url = '/client/book/bookInfo/' + isbn
      axios.get(url)
        .then(resp => {
          this.book = resp.data
          console.log(this.book)
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    recommendedBooks () {
      url = '/client/book/recommendedBooks'
      axios.get(url)
        .then(resp => {
          this.rBooks = resp.data
          console.log(this.rBooks)
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    isCollect () {
      const isbn = window.sessionStorage.getItem('client_isbn')
      url = '/client/collect/isCollect/' + isbn
      axios.get(url)
        .then(resp => {
          this.isCollectData = resp.data
          console.log(this.isCollectData)
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    cancelCollect (isbn) {
      const token = window.sessionStorage.getItem('token')
      that = this;
      url = '/client/collect/cancelCollect/' + isbn
      axios.get(url, {
        headers: {
          'Authorization': token
        }
      })
        .then(resp => {
          console.log(resp)
          alert(resp.msg)
          this.isCollect()
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    tobookInfo (isbn) {
      //console.log(isbn)
      window.sessionStorage.setItem("client_isbn", isbn);
      window.location.href = 'detail.html'
    },
    buyNow () {
      var o = {
        payment: this.bookCount * this.book.price,
        orderItems: []
      }
      var orderItem = { count: this.bookCount, product: this.book.isbn, price: this.book.price }
      o.orderItems.push(orderItem)
      const token = window.sessionStorage.getItem('token')
      that = this;
      url = '/client/order/createOrder'
      axios.post(url, JSON.stringify(o), {
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