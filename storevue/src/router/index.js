import {createRouter, createWebHashHistory, createWebHistory} from 'vue-router'
import Home from '@/views/Home.vue'
import ProductDetails from "@/views/ProductDetails";
import UserLogin from "@/views/UserLogin";
import ShoppingCart from "@/views/ShoppingCart";
import Mine from "@/views/Mine";
import UserAddress from "@/views/UserAddress";
import Payment from "@/components/PaymentBox";
import OrderInfor from "@/views/OrderInfor";

const routes = [
  {
    path: '/home',
    name: 'Home',
    component: Home
  },
  {
    path: '/productdetails',
    name: 'ProductDetails',
    component: ProductDetails
  },
  {
    path: '/userlogin',
    name: 'UserLogin',
    component: UserLogin
  },
  {
    path: '/shoppingcart',
    name: 'ShoppingCart',
    component: ShoppingCart,
  },
  {
    path: '/mine',
    name: 'Mine',
    component: Mine,
    children: [
        {
          path:'/useraddress',
          name: 'UserAddress',
          component: UserAddress
        }]

  },
  {
    path: '/orderinfor',
    name: "OrderInfor",
    component: OrderInfor
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
