<template>
	<div class="sidebar">
		<el-menu
				class="sidebar-el-menu"
				:default-active="onRoutes"
				:collapse="collapse"
				background-color="#334256"
				text-color="#ffffff"
				active-text-color="#20a0ff"
				router>
			<el-menu-item v-for="item in items" :index="item.index" :key="item.index">
				<el-icon><document/></el-icon>
				{{item.title}}
			</el-menu-item>
		</el-menu>
	</div>
</template>

<script>
export default {
  data() {
    return {
      collapse: false,
      template: null,
	  items:[
        {
		  index: 'Info',
		  title: '系统首页'
		},
        {
          index: 'User',
          title: '用户管理'
        },
        {
          index: 'Problem',
          title: '题目管理'
        }
	  ]
	}
  },
  computed: {
    onRoutes() {
      return this.$route.path.replace('/','')
	}
  },
  created() {}
}
</script>

<style scoped>
.sidebar {
  display: block;
  position: absolute;
  left: 0;
  top: 70px;
  bottom: 0;
  background-color: #334256;
  overflow-y: scroll;
}
.sidebar::-webkit-scrollbar {
  width: 0px;
}
.sidebar-el-menu:not(.el-menu--collapse) {
  width: 150px;
}
.sidebar >ul {
  height: 100%;
}
</style>