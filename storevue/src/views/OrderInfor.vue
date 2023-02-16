<template>
    <div class="orderinfor">
        <div class="orderinfor1">
            <span>我 的 订 单</span>
        </div>
        <div class="orderinfor2">
            <template v-for="order in orders">
                <OrderBox :order="order"/>
                <div v-if="order.state==0">
                    <button @click="Receipt(order.orderId),order.state=1">确认收货</button>
                </div>
                <div v-if="order.state==1">
                    <span>订单已完成</span>
                </div>
            </template>
        </div>
    </div>

</template>

<script>
    import OrderBox from "@/components/OrderBox";
    export default {
        name: "OrderInfor",
        components: {OrderBox},
        data() {
            return {
                orders: null
            }
        },
        created() {
            this.getOrder()
        },
        methods: {
            getOrder() {
                const _this = this
                this.$axios.get("/orderInfor/getOrderList").then(function (resp) {
                    _this.orders = resp.data.data
                })
            },
            Receipt(orderId){
                this.$axios.get("/orderInfor/receipt",{params:{orderId:orderId}}).then(function (resp) {
                })
            }
        }
    }
</script>

<style scoped>
    .orderinfor {
        margin: auto;
        width: 700px;
    }
    .orderinfor1 {
        display: grid;
        width: 700px;
        height: 100px;
    }
    .orderinfor1 span {
        margin: auto;
        font-size: 25px;
        font-weight: 900;
        color: #444;
    }
    .orderinfor2 {
        display: grid;
        grid-template-rows: repeat(auto-fill,auto);
        grid-template-columns: 500px 180px;
        grid-gap: 30px;
    }
    .orderinfor2 div {
        width: 100%;
        height: 120px;

    }
    .orderinfor2 span {
        display: block;
        margin-top: 15px;
        font-size: 16px;
        font-weight: 600;
        color: #444;
    }
    .orderinfor2 button {
        font-size: 15px;
        font-weight: 600;
        margin-top: 15px;
        width: 60%;
        height: 30px;
        background: #0071e3;
        color: #ffffff;
        border-radius: 15px;
        border: 0px;
    }
</style>