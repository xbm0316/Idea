new Vue({
  el: '#collect_vue',
  data () {
    return {
      page: 1,
      limit: 8,
      books: [],
    }
  },
  created () {
    const token = window.sessionStorage.getItem('token')
    if(!token){
      window.location.href="/mall/user/page/login.html"
      return;
    }
    this.collectBooks()
  },
  methods: {
    collectBooks () {
      const token = window.sessionStorage.getItem('token')
      if (token) {
        that = this;
        url = '/client/collect/collectBookList/' + that.page + '/' + that.limit
        axios.get(url, {
          headers: {
            'Authorization': token
          }
        })
          .then(resp => {
            console.log(resp)
            that.books = resp.data.list;
          })
          .catch(function (error) {
            console.log(error);
          });
      }

    },
    bookInfo (isbn) {
      window.sessionStorage.setItem("client_isbn", isbn);
      window.location.href = 'detail.html'
    }
  },
})