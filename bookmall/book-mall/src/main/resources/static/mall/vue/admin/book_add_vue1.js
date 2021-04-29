new Vue({
  el: '#book_add_vue',
  data () {
    return {
      bookform: {},
    }
  },
  methods: {
    insertBook () {
      that = this;
      const token = window.sessionStorage.getItem('token')
      var formData = new FormData()
      for (let key in this.bookform) {
        formData.append(key, this.bookform[key])
      }
      formData.append('published', new Date())
      var arr = new Array(9);
      if (that.$refs.index.files.length !== 0) {
        formData.append('files', that.$refs.index.files[0])
      }
      if (that.$refs.intro.files.length !== 0) {
        formData.append('files', that.$refs.intro.files[0])
      }

      if (that.$refs.collect.files.length !== 0) {
        formData.append('files', that.$refs.collect.files[0])
      }
      if (that.$refs.detail1.files.length !== 0) {
        formData.append('files', that.$refs.detail1.files[0])
      }
      if (that.$refs.detail2.files.length !== 0) {
        formData.append('files', that.$refs.detail2.files[0])
      }
      if (that.$refs.detail3.files.length !== 0) {
        formData.append('files', that.$refs.detail3.files[0])
      }

      if (that.$refs.detail1big.files.length !== 0) {
        formData.append('files', that.$refs.detail1big.files[0])
      }

      if (that.$refs.detail2big.files.length !== 0) {
        formData.append('files', that.$refs.detail2big.files[0])
      }
      if (that.$refs.detail3big.files.length !== 0) {
        formData.append('files', that.$refs.detail3big.files[0])
      }
      axios.post('/admin/book/insertBook', formData, {
        'Content-Type': 'multipart/form-data',
        'Authorization': token
      })
        .then(resp => {

          console.log(resp);
          alert(resp.msg)
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  },
})