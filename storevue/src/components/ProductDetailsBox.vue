<template>
    <div class="productdetailsbox">
        <div class="imgbar"><img :src="require('../assets/images/productdetails/' + product.image)" style="height: 100%; border-radius: 30px"/></div>
        <div class="shopbar">
            <div class="shopbar-1">
                <div>
                    <h2>{{product.name}}</h2>
                </div>
                <div>
                    <h2>RMB : {{product.price}}</h2>
                </div>
            </div>
            <div class="shopbar-2">
                <button @click="addProduct">添加至购物车</button>
            </div>
        </div>
        <div style="grid-area: detailsbar; background: #f5f5f7; border-radius: 30px;">
            <template v-for="des in detailsbar()">
                <p align="center">{{des}}</p>
            </template>
        </div>
    </div>
</template>

<script scoped>
    export default {
        name: "ProductDetailsBox",
        props: {
            product: {
            }
        },
        methods: {
            detailsbar() {
                return this.product.des.split('，')
            },
            addProduct() {
                const _this = this
                this.$axios.get('/shoppingcart/addProduct',{params:{productId:_this.product.id}}).then(function (resp){})
            }
        }
    }
</script>

<style scoped>
    .productdetailsbox {
        display: grid;
        grid-template-columns: 1024px auto;
        grid-template-rows: 576px auto;
        grid-gap: 20px;
        grid-template-areas:
                "imgbar shopbar "
                "detailsbar detailsbar";
    }
    .productdetailsbox {
        width: 1400px;
        margin: 40px auto;
    }
    .imgbar {
        grid-area: imgbar;
        border-radius: 30px;
        margin: 0 auto;
    }
    .shopbar {
        grid-area: shopbar;
        position: relative;
        background: #f5f5f7;
        border-radius: 30px;
    }
    .shopbar-1 {
        width: 90%;
        position: absolute;
        left: 5%;
        display: grid;
        grid-template-rows: repeat(2,90px);

    }
    .shopbar-1 div {
        align-self: center;
        border-bottom: 2px solid #ffffff;
    }
    .shopbar-2 {
        position: absolute;
        width: 100%;
        height: 90px;
        bottom: 0px;
    }
    .shopbar-2 button {
        width: 90%;
        height: 40px;
        background: #0071e3;
        color: #ffffff;
        border-radius: 20px;
        border: 0px;
        position: absolute;
        top:50%;
        left:50%;
        transform:translate(-50%,-50%);
    }

</style>