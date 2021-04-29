new Vue({
  el: '#admin_login_vue',
  data () {
    return {
      loginform: {
        uname: "",
        upwd: ''
      }
    }
  },
  methods: {
    login () {
      that = this;
      url = '/admin/user/loginAdmin'
      axios.post(url, JSON.stringify(that.loginform), {
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then(resp => {
          console.log(resp)
          if (resp.code == 1) {
            window.sessionStorage.setItem('token', resp.data.token)
            window.sessionStorage.setItem('user', JSON.stringify(resp.data.user))
            window.location.href = "/mall/admin/page/index.html"
          }
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  },
})