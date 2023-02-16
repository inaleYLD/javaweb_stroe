<template>
    <Payment v-if="payment" @payment="()=>payment=!payment" :order="order"/>
    <ChooseAddress v-if="chooseaddress" @chooseaddress="(msg)=>choose(msg)" />
    <div class="shoppingcart" v-if="!payment&&!chooseaddress">
        <div class="cart-1">
            <h1>你的购物带总计 RMB {{price}}。</h1>
            <div class="cart-1-1">
                <span>所有订单均可享受免费送货和退货服务。</span>
            </div>
            <div class="cart-1-2"><button @click="choose()">结账</button></div>
        </div>

        <div class="cart-2">
            <template v-for="cartproduct in cartproducts">
                <ShoppingCartBox :cartproduct="cartproduct" @price="(msg)=>price = price+msg"/>
            </template>
        </div>
    </div>
</template>

<script>
    import ShoppingCartBox from "@/components/ShoppingCartBox";
    import Payment from "@/components/PaymentBox";
    import ChooseAddress from "@/components/ChooseAddress";
    export default {
        name: "ShoppingCart",
        data() {
            return {
                cartproducts : null,
                price: 0,
                chooseaddress: false,
                payment: false,
                order: null
            }
        },
        components: {
            ChooseAddress,
            Payment,
            ShoppingCartBox
        },
        created() {
            this.getCartProducts()
        },
        methods: {
            getCartProducts() {
                let _this = this
                if (this.$axios.defaults.headers.common.token) {
                    this.$axios.get('/shoppingcart/getCart').then(function (resp) {
                        _this.cartproducts = resp.data.data
                    })
                }
            },
            choose(userAddress){
                this.chooseaddress=!this.chooseaddress
                if (userAddress == undefined){
                    this.payment = false
                }
                else {
                    this.payment = true
                     this.order = {
                        userAddress: userAddress,
                        cartproducts: this.cartproducts
                    }
                }
            }
        }
    }
</script>

<style scoped>
    .shoppingcart {
        margin: 40px auto;
        width: 900px;
        height: auto;
    }
    .cart-1 {
        text-align: center;
        border-bottom: 1px solid #d2d2d7;
    }
    .cart-1 h1{
        font-size: 35px;
        font-family:Helvetica;
    }
    .cart-1-1 {
        padding-bottom: 30px;
    }
    .cart-1-2 {
        padding-bottom: 60px;
    }
    .cart-1-2 button {
        width: 40%;
        height: 30px;
        background: #0071e3;
        color: #ffffff;
        border-radius: 15px;
        border: 0px;
    }
</style>
