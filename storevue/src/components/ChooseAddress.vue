<template>
    <div class="paymentbox">
        <div class="payment">
            <div class="payment-3"><span>选 择 地 址</span></div>
            <div class="payment-1">
                <template v-for="userAddress in userAddressList">
                    <div @click="$emit('chooseaddress',userAddress)"><UserAddressBox :userAddress="userAddress" /></div>
                </template>
            </div>
            <div class="payment-2">
                <div><button @click="$emit('chooseaddress')">取消</button></div>
            </div>
        </div>
    </div>
</template>

<script>
    import UserAddressBox from "@/components/UserAddressBox";
    export default {
        name: "ChooseAddress",
        components: {UserAddressBox},
        emits:['chooseaddress'],
        data() {
            return {
                userAddressList: null
            }
        },
        created() {
            this.getUserAddress()
        },
        methods: {
            getUserAddress() {
                const _this = this
                this.$axios("/userAddress/getAddress").then(function (resp) {
                    _this.userAddressList = resp.data.data
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
    .payment-1 {
        display: grid;
        height: 600px;
        width: 100%;
        grid-template-rows: repeat(auto-fit,120px);
    }
    .payment-1 div {
        margin: auto;
    }
    .payment-2 {
        display: grid;
        height: 100px;
        width: 100%;
    }
    .payment-2 div {
        margin: auto;
    }
    .payment-2 button {
        width: 500px;
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