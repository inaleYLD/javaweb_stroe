<template>
    <div :style="{height:size.height,minWidth:size.width}" >
        <div class="nav">
            <div style="background: #444444;"></div>
            <div  class="menu" style="background: rgba(0,0,0,0.8)">
                <div class="menu-left"><Menu/></div>
                <div class="menu-rigth"><UserMenu/></div>
            </div>
        </div>
        <router-view/>
    </div>
</template>

<script>
    import Menu from "@/components/Menu";
    import UserMenu from "@/components/UserMenu";
    export default {
        name: "App",
        components: {
            Menu,
            UserMenu
        },
        data() {
            return {
                size: {
                    width: null,
                    height: null
                }
            }
        },
        methods: {
            onResize() {
                this.size.width = window.innerWidth+"px"
                this.size.height = window.innerHeight+"px"
            }
        },
        created() {
            this.onResize()
            window.onresize = () =>{
                return (() => {
                    this.onResize()
                })()
            }
        }
    }
</script>
<style>

    button {cursor: pointer;}
    a {color: #06c;}
    a:link {text-decoration:none;}
    a:visited {text-decoration:none;}
    a:hover {text-decoration:underline;}
    a:active {text-decoration:underline;}
   #app {
       position: absolute;
       top: 0px;
       left: 0px;
   }
  .nav {
    position: sticky;
    top: 0px;
    background: #ffffff;
    display: grid;
    grid-template-rows: repeat(2,45px);
  }
  .menu-rigth {
    align-self: center;
  }
  .menu {
    display: grid;
    grid-template-columns: 1fr 1fr;
  }
</style>