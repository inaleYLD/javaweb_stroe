<template>
    <div class="loginbox">
        <div class="loginbox-1">
            <div class="loginbox-1-1">
                <img style="width: 50%;" src='../assets/images/logo/apple-login-logo.png'>
            </div>
            <div class="loginbox-1-2">
                <div class="loginbox-1-2-1">
                        <div>
                            <input v-model="user.account" type="text" placeholder="用户名">
                            <input v-model="user.password" type="password" placeholder="密码">
                        </div>
                        <div class="loginbox-1-2-1-2">
                            <div>
                                <button @click="login()">登录</button>
                            </div>
                            <div>
                                <button @click="signup()">注册</button>
                            </div>
                        </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "LoginBox",
        data() {
            return {
                user: {
                    account : null,
                    password: null
                }
            }
        },
        methods: {
            login() {
                const _this = this
                this.$axios.post('/user/login',_this.user).then(function (resp) {
                    _this.$axios.defaults.headers.common['token'] = resp.data.data.token
                    _this.$router.push({
                        path: '/home'
                    })
                })
            },
            signup() {
                const _this = this
                this.$axios.post('/user/signup',_this.user).then(function (resp) {
                    alert(resp.data.msg)
                })
            }
        }

    }
</script>

<style scoped>
    .loginbox {
        position: fixed;
        left: 0px;
        top: 0px;
        background: #ffffff/*linear-gradient(210deg,#6a6a6a,#ffffff)*/;
        width: 100%;
        height: 100%;
    }

    /*loginbox-1定位布局*/
    .loginbox-1 {
        display: grid;
        grid-template-columns: 300px auto;
        grid-template-rows: auto;
        position: absolute;
        top:50%;
        left:50%;
        transform:translate(-50%,-50%);
    }
    .loginbox-1-2-1-2 {
        display: grid;
        width: 100%;
        grid-template-columns: 50% 50%;
    }

    .loginbox-1 {
        background: #ffffff;
        width: 700px;
        height: 300px;
    }
    .loginbox-1-1 {
        text-align: center;
        align-self: center;
    }
    .loginbox-1-2 {
        border-left: 2px solid #444444;
        align-self: center;
    }

    .loginbox-1-2-1 input[type=text],input[type=password]{
        width: 80%;
        height: 50px;
        padding-left: 5%;
        margin: 10px 10%;
        box-sizing: border-box;
        border: 2px solid #444444;
        background: #f7f7f796;
        border-radius: 25px;
    }

    .loginbox-1-2-1-2 button{
        width: 75%;
        height: 50px;
        border-radius: 25px;
        color: #ffffff;
        margin-top: 10px;
    }
    .loginbox-1-2-1-2 :nth-child(1) button{
        background: #444;
        margin-left: 20%;
    }
    .loginbox-1-2-1-2 :nth-child(2) button{
        background: rgba(0,0,0,0.8);
        margin-left: 5%;
    }
</style>