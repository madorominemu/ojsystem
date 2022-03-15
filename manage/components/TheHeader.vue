<template>
	<div class="header">
		<!-- 折叠左侧栏 -->
		<div class="collapse-btn" @click="collapseChange">
			<el-icon><more-filled /></el-icon>
		</div>
		<div class="logo">编程训练网站后台管理</div>
		<div class="header-right">
			<div class="btn-fullscreen" @click="handleFullScreen">
				<el-tooltip :content="fullscreen?'取消全屏':'全屏'" placement="bottom">
					<el-icon><full-screen /></el-icon>
				</el-tooltip>
			</div>
		</div>
	</div>
</template>

<script>
export default {
  name: 'the-header',
  data(){
    return{
      collapse: false,
      fullscreen: false,
    }
  },
  computed:{},
  methods:{
    //全屏事件
    handleFullScreen(){
      if(this.fullscreen){
        if(document.exitFullscreen()){
          document.exitFullscreen();
        }else if(document.webkitCancelFullScreen){      //safari,Chorome
          document.webkitCancelFullScreen();
        }else if(document.mozCancelFullScreen){       //firefox
          document.mozCancelFullScreen();
        }else if(document.msExitFullScreen){        //IE
          document.msExitFullScreen();
        }
      }else{
        let element = document.documentElement;
        if(element.requestFullscreen){
          element.requestFullscreen();
        }else if(element.webkitRequestFullScreen){      //safari,Chorome
          element.webkitRequestFullScreen();
        }else if(element.mozRequestFullScreen){       //firefox
          element.mozRequestFullScreen();
        }else if(element.msRequestFullScreen){        //IE
          element.msRequestFullScreen();
        }
      }
      this.fullscreen = !this.fullscreen;
    },
  }
}
</script>

<style scoped lang="scss">
.header {
  position: relative;
  background-color: #253041;
  box-sizing: border-box;
  width: 100%;
  height: 70px;
  font-size: 22px;
  color: #ffffff;
}
.collapse-btn {
  float: left;
  padding: 0 21px;
  cursor: pointer;
  line-height: 70px;
}
.logo {
  float: left;
  line-height: 70px;
}
.header-right {
  float: right;
  padding-right: 50px;
  display: flex;
  height: 70px;
  align-items: center;
}
.btn-fullscreen {
  transform: rotate(45deg);
  margin-right: 5px;
  font-size: 24px;
}
.user-avator {
  margin-left: 20px;
}
.user-avator img{
  display: block;
  width: 40px;
  height: 40px;
  border-radius: 50%;
}
.user-name {
  margin-left: 10px;
}
.el-dropdown-link {
  color: #ffffff;
  cursor: pointer;
}
</style>