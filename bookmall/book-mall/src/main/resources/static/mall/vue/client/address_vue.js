new Vue({
  el: '#address_vue',
  data () {
    return {
      address: {
        address: "",
        receiver: '',
        receiverPhone: ''
      }
    }
  },
  methods: {
    addAddress () {
      const token = window.sessionStorage.getItem('token')
      that = this;
      url = '/client/address/add'
      axios.post(url, JSON.stringify(that.address), {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': token
        }
      })
        .then(resp => {
          //console.log(resp)
          alert(resp.data.msg)
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  },
})