<template>
    <div class="usermenu">
        <div class="usermenu-1" :style="{border: border}" >
            <button @click="openuser()"></button>
        </div>
        <div :class="{usermenu2}" :style="{display: display}">
            <div class="usermenu2_1">
                <template v-if="!this.$axios.defaults.headers.common.token">
                    <div><router-link  :to="{path:'/userlogin'}" @click="openuser()">登录</router-link></div>
                </template>
                <template v-else>
                    <div><router-link  :to="{path:'/mine'}" @click="openuser()">个人中心</router-link></div>
                    <div><router-link  :to="{path:'/orderinfor'}" @click="openuser()">我的订单</router-link></div>
                    <div><router-link  :to="{path:'/shoppingcart'}" @click="openuser()">购物车</router-link></div>
                    <div><router-link  :to="{path:'/home'}" @click="openuser(),logout()">注销</router-link></div>
                </template>
            </div>
        </div>
    </div>

</template>

<script>
    export default {
        name: "UserMenu",
        data() {
            return {
                usermenu2: false,
                border: 'none',
                display: 'none'
            }
        },
        methods: {
            logout() {
                this.$axios.get('/user/logout').then(function (resp) {
                    alert(resp.data.msg)
                })
                delete this.$axios.defaults.headers.common.token
            },
            openuser() {
                this.usermenu2 = !this.usermenu2
                if (this.border == "none"){
                    this.border = '2px solid #d2d2d7;'
                    this.display = 'block'
                }
                else {
                    this.border = 'none'
                    this.display = 'none'
                }

            }
        }
    }
</script>

<style scoped>
    .usermenu {
        position: relative;
        float: right;
        right: 40px;
    }
    .usermenu-1 {
        width: 40px;
        height: 40px;
        background: #ffffff;
        border-radius: 50%;
    }
    .usermenu-1 button{
        width: 100%;
        height: 100%;
        border-radius: 50%;
        border: none;
    }
    .usermenu2 {
        position: absolute;
        top: 50px;
        right: -20px;
        width: 200px;
        height: 300px;
        background: #ffffff;
        border: 1px solid #d2d2d7;
        border-radius: 10px;
    }
    .usermenu2_1 {
        position: absolute;
        left: 20px;
        bottom: 0;
        display: grid;
        max-height: 200px;
        grid-template-rows: repeat(auto-fit,50px);
        grid-template-columns: 160px;
    }
    .usermenu2_1 div {
        border-top: 1px solid #d2d2d7;
        padding-top: 5px;
    }
</style>