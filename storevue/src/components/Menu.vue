<template>
    <div class="menu">
        <div><router-link  :to="'/home'">首页</router-link></div>
        <div><router-link  :to="'/home?producttype=1'">airpods</router-link></div>
        <div><router-link  :to="'/home?producttype=2'">iphone</router-link></div>
    </div>
</template>

<script>
    export default {
        name: "Menu"
    }
</script>

<style scoped>
    a {
        color: #ffffff;
        font-size: 16px;
    }
    .menu {
        display: grid;
        grid-template-columns: repeat(3,120px);
        grid-template-rows: 45px;
        grid-column-gap: 20px;
    }
    .menu {
        float: left;
        font-size: 5px;
        text-align: center;
        color: #ffffff;
        align-items: center;
    }
</style>