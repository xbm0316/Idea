new Vue({
  el: '#pwd_vue',
  data () {
    return {
      pwdform: {
        upwd: '',
        npwd: '',
        cpwd: ''
      }
    }
  },
  methods: {
    changePassword () {
      if(this.pwdform.npwd!=this.pwdform.cpwd){
        alert("新密码不一致")
        return;
      }
      const token = window.sessionStorage.getItem('token')
      that = this;
      url = '/client/user/changePassword'
      axios.post(url, JSON.stringify(that.pwdform), {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': token
        }
      })
        .then(resp => {
          console.log(resp)
          alert(resp.data.msg)
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  }
})