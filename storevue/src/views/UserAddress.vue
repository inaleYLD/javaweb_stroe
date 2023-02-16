<template>
    <div class="addaddress"><button>添加地址</button></div>
    <div class="useraddress">
        <div class="useraddress-1">
            <template v-for="userAddress in userAddressList">
                <div><UserAddressBox :userAddress="userAddress" /></div>
            </template>
        </div>
    </div>

</template>

<script>
    import UserAddressBox from "@/components/UserAddressBox";
    export default {
        name: "UserAddress",
        components: {UserAddressBox},
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
    .useraddress {
        width: 100%;
        height: 100%;
    }
    .useraddress-1 {
        width: fit-content;
        margin: auto;
    }
    .useraddress-1 div{
        margin-top: 30px;
    }
    .addaddress {
        width: fit-content;
        margin: 25px auto;
    }
    .addaddress button {
        width: 500px;
        height: 40px;
        background: rgba(0,0,0,12);
        color: #ffffff;
        border-radius: 20px;
        border: 2px solid rgb(100,90,90);
        font-size: 17px;
        font-weight: 600;
    }
</style>