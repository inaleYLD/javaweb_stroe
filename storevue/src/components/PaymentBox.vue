<template>
    <div class="paymentbox">
        <div class="payment">
            <div class="payment-3"><span>确 认 订 单</span></div>
            <div class="payment-4"><UserAddressBox :userAddress="order.userAddress"/></div>
            <div class="payment-1">
                <template v-for="cartproducts in order.cartproducts">
                    <div><OrderBox :order="cartproducts"/></div>
                </template>
            </div>
            <div class="payment-2">
                <div>
                    <button @click="$emit('payment')">取消</button>
                </div>
                <div>
                    <button @click="paying">付款</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import UserAddressBox from "@/components/UserAddressBox";
    import OrderBox from "@/components/OrderBox";
    export default {
        name: "Payment",
        components: {OrderBox, UserAddressBox},
        props:{order:{}},
        emits:['payment'],
        methods: {
            paying() {
                const orderInforList = new Array()
                for(const c in this.order.cartproducts) {
                    const order = {
                        addressId: this.order.userAddress.id,
                        cartId: this.order.cartproducts[c].cartId
                    }
                    orderInforList.push(order)
                }
                const _this = this
                this.$axios.post("/orderInfor/addOrder",orderInforList).then(function (rsep) {
                    _this.$router.push({
                        path: '/orderinfor'
                    })
                })
            }
        }
    }
</script>

<style scoped>
    .paymentbox {
        position: fixed;
        background: rgb(245, 245, 247);
        width: 100%;
        height: 100%;
    }
    .payment {
        display: grid;
        border: 1px solid #d2d2d7;
        position: absolute;
        width: 600px;
        height: 750px;
        border-radius: 20px;
        background: white;
        top: 20%;
        left: 50%;
        transform: translate(-50%, -20%);

    }
    .payment-4 {
        height: 120px;
        margin: auto;
    }
    .payment-1 {
        overflow-y: auto;
        display: grid;
        height: 480px;
        width: 100%;
        grid-template-rows: repeat(auto-fit,120px);
    }
    ::-webkit-scrollbar {
        display: none;
    }
    .payment-1 div {
        margin: auto;
    }
    .payment-2 {
        height: 100px;
        width: 100%;
    }
    .payment-2 {
        display: grid;
        grid-template-columns: 1fr 1fr;
    }
    .payment-2 div {
        margin: auto 50px;
    }
    .payment-2 button {
        width: 200px;
        height: 50px;
        background: #0071e3;
        border-radius: 15px;
        border: 0px;
        color: #ffffff;
        font-size: 18px;
        font-weight: 600;
    }
    .payment-3 {
        width: 100%;
        height: 50px;
        text-align: center;

    }
    .payment-3  span{
        color: #0071e3;
        font-size: 25px;
        font-weight: 600;
    }
</style>