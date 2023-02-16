<template>
    <div class="orderbox">
        <div class="order">
            <div style="grid-area: order1;margin: auto">
                <img :src="require('../assets/images/home/' + order.image)"/>
            </div>
            <div style="grid-area: order2"><span>{{order.name}}</span>
            </div>
            <div style="grid-area: order3"><span>RMB: {{order.price}}</span></div>
            <div style="grid-area: order4"><span>x{{order.quantity}}</span></div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "OrderBox",
        props: {
            order:{}
        }
    }
</script>

<style scoped>
    .orderbox {
        width: 500px;
        height: 120px;
    }
    .order {
        display: grid;
        grid-template-areas:"order1 order2 order3"
                            "order1 order2 order4";
        grid-template-columns: 150px 200px 130px;
        grid-template-rows: repeat(2,50px);
        grid-gap: 10px;
        border-bottom: 1px solid #d2d2d7;
    }
    .order img {
        height: 100px;
        width: auto;
    }
    .order :nth-child(2) {
        margin:15px 0;
        font-size: 20px;
    }
    .order :nth-child(3) {
        margin:15px 0;
        font-size: 20px;
    }
    .order :nth-child(4) {
        color: #a7a7a7;
    }
</style>