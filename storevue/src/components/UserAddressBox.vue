<template>
    <div class="useraddressbox">
        <div style="grid-area: one"><p><strong>收件人: </strong>{{userAddress.addressee}}</p></div>
        <div style="grid-area: two"><p><strong>手机号: </strong>{{userAddress.phoneNum}}</p></div>
        <div style="grid-area: three;width: 88%"><p><strong>地址: </strong>{{userAddress.address}}</p></div>
    </div>
</template>

<script>
    export default {
        name: "UserAddressBox",
        props: {
            userAddress: {}
        }
    }
</script>

<style scoped>
    .useraddressbox {
        width: 500px;
        height: 90px;
        background: #ffffff;
        border-radius: 15px;
        border: 1px solid #d2d2d7;
    }
    .useraddressbox {
        display: grid;
        grid-template-areas: "one two" "three three";
        grid-template-columns: 2fr 3fr;

    }
    .useraddressbox div {
        border-bottom: 1px solid #d2d2d7;
        width: 80%;
        height: 90%;
        margin: 0 30px;
    }
    .useraddressbox p {
        margin: 10px 0;
    }
</style>