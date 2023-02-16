<template>
        <div class="product">
            <div><img :src="require('../assets/images/home/' + productInfor.image)" style="width: 100%;height: auto;"/></div>
            <div><span>{{productInfor.name}}</span></div>
            <div><span>RMB: {{productInfor.price}}</span></div>
            <div><button @click="productdetails(productInfor.name)">购买</button></div>
            <div><button @click="productdetails(productInfor.name)">进一步了解</button></div>
        </div>
</template>

<script>
    export default {
        name: "ProductBox",
        props:{
            productInfor: {
                name: String,
                image: String,
                price: String
            }
        },
        methods: {
            productdetails(name) {
                this.$router.push({
                    path: '/productdetails',
                    query: {
                        productname: name
                    }
                })
            }
        }
    }
</script>

<style scoped>
    .product {
        display: grid;
        grid-template-columns: auto;
        grid-template-rows: 200px repeat(4,30px);
    }

    .product {
        background: #ffffff;
        width: 200px;
        height: 350px;
        border-bottom: 2px solid #6a6a6a;
        align-items: center;
        text-align: center;
        font-size: 15px;
        font-weight: 600;
    }
    .product :nth-child(4) button{
        margin-top: 10px;
        background: #0071e3;
        color: #ffffff;
        border: none;
        width: 50px;
        height: 24px;
        border-radius: 12px;
    }
    .product :nth-child(5) button{
        margin-top: 25px;
        color: #0071e3;
        border: none;
        background: none;
    }
    .product :nth-child(5) button:hover{
        border-bottom: 1px solid #0071e3;
    }
</style>