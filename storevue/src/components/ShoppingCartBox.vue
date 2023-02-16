<template >
    <div class="cartbox" v-if="hava">
        <div class="cartbox-1">
            <img :src="require('../assets/images/home/' + cartproduct.image)"/>
        </div>
        <div class="cartbox-2">
            <div class="cartbox-2-1">
                <div style="grid-area: cartbox-2-1-1">
                    <router-link :to="'/productdetails?productname='+cartproduct.name">{{cartproduct.name}}</router-link>
                </div>
                <div class="cartbox-2-1-2"><div><span>{{cartproduct.quantity}}</span></div></div>
                <div class="cartbox-2-1-3"><span>RMB {{cartproduct.price}}</span></div>
                <div class="cartbox-2-1-4"><button @click="removeProduct()">移除</button></div>
            </div>
        </div>
    </div>
</template>

<script scoped>
    export default {
        name: "ShoppingCartBox",
        props: {
            cartproduct: {}
        },
        emits: ['price','remove'],
        data() {
            return {
                hava:true
            }
        },
        created() {
            this.$emit('price',this.cartproduct.price*this.cartproduct.quantity)

        },
        methods: {
            removeProduct() {
                const _this = this
                this.$axios.get('/shoppingcart/removeProduct',{params: {cartId: _this.cartproduct.cartId}}).then(function () {
                    _this.$nextTick(function () {
                        _this.hava = false
                    })
                })
                this.$emit('price',-(this.cartproduct.price*this.cartproduct.quantity))
            }
        }
    }
</script>

<style scoped>
    span,a {
       color: #000000;
       font-size: 28px;
       font-family: Helvetica;
    }
    .cartbox {
        margin-top: 40px;
        height: 250px;
        border-bottom: 1px solid #d2d2d7;
    }
    .cartbox {
        display: grid;
        grid-template-columns: 240px auto;
        grid-template-rows: auto;
    }
    .cartbox-1 {
        text-align: center;
    }
    .cartbox-1 img {
        height: 200px;
        width: auto;
    }
    .cartbox-2-1 {
        margin-top: 20px;
        height: 100px;
        display: grid;
        grid-template-columns:50% 10% 40%;
        grid-template-areas:
                "cartbox-2-1-1 cartbox-2-1-2 cartbox-2-1-3"
                "cartbox-2-1-1 cartbox-2-1-2 cartbox-2-1-4";
    }
    .cartbox-2-1-2{
        grid-area: cartbox-2-1-2;
    }
    .cartbox-2-1-3 {
        grid-area: cartbox-2-1-3;
        text-align: right;
    }
    .cartbox-2-1-4 {
        grid-area: cartbox-2-1-4;
        text-align: right;
    }
    .cartbox-2-1-4 button {
        border: 0px;
        color: #06c;
        background: #ffffff;
    }
    .cartbox-2-1-4 button:hover {
        border-bottom: 1px solid #06c;
    }
</style>