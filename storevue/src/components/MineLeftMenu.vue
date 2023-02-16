<template>
    <div class="mineleft">
        <div>
            <div class="m-1">
                <div class="avatar"><div></div></div>
                <div style="grid-area: two"><p>{{user.account}}</p></div>
                <div style="grid-area: three"><p>UID: {{user.id}}</p></div>
            </div>
        </div>
        <div><div class="m-2"><router-link  :to="{path:'/useraddress'}">我的地址</router-link></div></div>
        <div><div class="m-2"><router-link  :to="{path:'/orderinfor'}">我的订单</router-link></div></div>
        <div><div class="m-2"><router-link  :to="{path:'/shoppingcart'}">购物车</router-link></div></div>
    </div>
</template>

<script>
    export default {
        name: "MineLeftMenu",
        data() {
           return {
               user: {
                   account: null,
                   id: null
               }
           }
        },
        created() {
            this.getuser()
        },
        methods: {
            getuser() {
                const _this = this
                if (this.$axios.defaults.headers.common.token) {
                    this.$axios.get("/user/getuser").then(function (resp) {
                        _this.user = resp.data.data
                    })
                }
            }
        }
    }
</script>

<style scoped>
    a,p {
        color: #ffffff;
        font-size: 18px;
    }
    a {
        font-weight: 600;
        display: block;
    }
    .mineleft {
        display: grid;
        grid-template-rows: 120px repeat(3,60px);
    }
    .m-1 {
        width: 90%;
        height: 100%;
        margin: auto;
        border-bottom: 2px solid #6a6a6a;
    }
    .m-1 {
        display: grid;
        grid-template-areas:
                "one two"
                "one three";
        grid-template-columns: 4fr 6fr;
        grid-template-rows: repeat(2,1fr);

    }
    .avatar {
        grid-area: one;
        margin: auto;
    }
    .avatar div {
        width: 80px;
        height: 80px;
        border-radius: 40px;
        background: #ffffff;
    }
    .m-2 {
        width: 90%;
        height: 100%;
        margin: 0 auto;
        border-bottom: 2px solid #6a6a6a;
    }
    .m-2 a {
        padding-top: 20px;
    }
</style>