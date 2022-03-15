<template>
	<div class="the-header">
		<div class="nav-container">
			<ul class="navbar-list">
				<li v-for="(navbarListItem,index) in navbarListItems" class="navbar-list-item" @click="change(index)">
					<router-link :to="{ path: navbarListItem.path }">
						<a>{{ navbarListItem.name }}</a>
					</router-link>
				</li>
			</ul>
			<div class="navbar-menu">
				<div class="navbar-menu-icon-item">
					<button class="avatar" @click="showDropdown">
						<div class="w-6 h-6">
							<img src="../assets/avatar.jpg">
						</div>
					</button>
					<div class="avatar-dropdown" v-show="show">
						<div class="avatar-dropdown-container">
							<div class="user">
								<a class="user-pic">
									<img src="../assets/avatar.jpg">
								</a>
								<div class="user-name">
									<a>{{ user.name }}</a>
								</div>
							</div>
							<div class="option space-y-2">
								<a class="space-x-2">
									<img src="./../assets/icons/svg/file.svg">
									<div class="flex-grow">个人资料</div>
								</a>
								<a class="space-x-2">
									<img src="./../assets/icons/svg/exit.svg">
									<div class="flex-grow">退出</div>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {
  name: 'the-header',
  data() {
    return {
      navbarListItems: [
        {name: '首页', path: 'home'},
        {name: '学习', path: 'learn'},
        {name: '题库', path: 'problemset'}
	  ],
	  user: {
        name: 'madoromi_nemu_',
	  },
	  show: false
	}
  },
  methods: {
    showDropdown() {
      this.show = !this.show
	},
    change(index) {

	}
  }
}
</script>

<style scoped lang="scss">
@import './src/assets/css/the-header';
</style>