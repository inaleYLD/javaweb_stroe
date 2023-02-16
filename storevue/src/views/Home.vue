<template>
    <div style="margin: 40px auto;width: 80%;">
        <div class="productList">
            <template v-for="productInfor in productlist">
                <ProductListBox :productInfor="productInfor" />
            </template>
        </div>
    </div>
</template>

<script>
    import ProductListBox from "@/components/ProductListBox";
    import Menu from "@/components/Menu";
    import Payment from "@/components/PaymentBox";
    export default {
        name: "Home",
        data() {
            return{
                productlist: null,
            }
        },
        components:{
            Payment,
            ProductListBox
        },
        created() {
            this.productList(this.$route.query.producttype)
        },
        watch:{
            $route(){
                this.productList(this.$route.query.producttype)
            }
        },
        methods: {
            productList(producttype){
                let _this = this
                this.$axios.get('/product/productList',{params: {type: producttype}}).then(function (resp){
                    _this.productlist = resp.data.data
                })
            }
        }
    }
</script>

<style scoped>
    .productList {
        display: grid;
        grid-template-columns: repeat(auto-fill, 200px);
        grid-gap: 100px 40px;
    }
</style>