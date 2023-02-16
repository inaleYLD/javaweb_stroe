<template>
    <div class="mine">
        <div class="m-left"><MineLeftMenu/></div>
        <div class="m-right"><router-view/></div>
    </div>
</template>

<script>
    import MineLeftMenu from "@/components/MineLeftMenu";
    export default {
        name: "Mine",
        components: {MineLeftMenu},
        created() {
        },
        methods: {
        }
    }
</script>

<style scoped>
    .mine {
        margin: 3% auto;
        width: 70%;
        height: 70%;
    }
    .mine {
        display: grid;
        grid-template-columns: 2fr 5fr;

    }
    .m-left {
        background: rgba(0, 0, 0, 0.8);
        min-width: 250px;
        width: 100%;
        min-height: 600px;
        height: 100%;
    }
    .m-right {
        background: rgb(68, 68, 68);
        min-width: 625px;
        width: 100%;
        min-height: 600px;
        height: 100%;
    }
</style>