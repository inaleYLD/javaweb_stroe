<template>
    <template v-if="product != null">
        <ProductDetailsBox :product='product'/>
    </template>
</template>

<script>
    import ProductDetailsBox from "@/components/ProductDetailsBox";
    export default {
        name: "ProductDetails",
        components: {
            ProductDetailsBox
        },
        data() {
            return {
                product : null
            }
        },
        created() {
            this.productOne(this.$route.query.productname)
        },
        methods: {
            productOne(producrtname){
                let _this = this
                this.$axios.get('/product/productOne',{params:{name:producrtname}}).then(function (resp){
                    _this.product = resp.data.data
                })
            }
        }
    }
</script>
