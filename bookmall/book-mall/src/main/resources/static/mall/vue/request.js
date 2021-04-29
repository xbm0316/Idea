
axios.defaults.baseURL = 'http://localhost:8080'; //  请求服务器具体的地址
//axios.defaults.header['Content-Type'] = 'application/x-www-form-urlencoded';//  声明传给服务器的数据，通过请求传给服务器的数据application/x-www-form-urlencoded格式
//axios.defaults.headers.Token = "ssdfsd"; //  携带token请求头
// request interceptor
axios.interceptors.request.use(
  config => {
    const token = window.sessionStorage.getItem('token')
    if (token) {
      console.log('sass')
      config.headers.Authorization = token
    }
    return config
  },
  error => {
    // do something with request error
    //console.log(error) // for debug
    return Promise.reject(error)
  }
)

// response interceptor
axios.interceptors.response.use(
  response => {
    const res = response.data
    return res;
  },
  error => {
    return Promise.reject(error)
  }
)

// export service
