import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
axios.defaults.baseURL='http://192.168.31.5:8082'

const app = createApp(App)
app.config.globalProperties.$axios = axios
app.use(store).use(router).mount('#app')
