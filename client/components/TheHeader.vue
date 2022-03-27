<template>
	<div class="the-header">
		<div class="nav-container">
			<ul class="navbar-list">
				<li v-for="navbarListItem in navbarListItems" class="navbar-list-item">
					<router-link :to="{ path: navbarListItem.path }">
						<a>{{ navbarListItem.name }}</a>
					</router-link>
				</li>
			</ul>
			<div class="navbar-menu">
				<div class="navbar-menu-icon-item" v-show="loginIn">
					<button class="avatar" @click.stop="this.show = !this.show" ref="s2">
						<div class="w-6 h-6">
<!--							<img src="../assets/avatar.jpg">-->
							<img :src="attachImageUrl(this.avatar)" alt="">
						</div>
					</button>
					<div class="avatar-dropdown" v-show="show">
						<div class="avatar-dropdown-container">
							<div class="user">
								<a class="user-pic">
<!--									<img src="../assets/avatar.jpg">-->
									<img :src="attachImageUrl(this.avatar)" alt="">
								</a>
								<div class="user-name">
									<a>{{ username }}</a>
								</div>
							</div>
							<div class="option space-y-2" @click="goInfo">
								<a class="space-x-2">
									<img src="./../assets/icons/svg/file.svg">
									<div class="flex-grow">个人资料</div>
								</a>
								<a class="space-x-2" @click="logout">
									<img src="./../assets/icons/svg/exit.svg">
									<div class="flex-grow">退出</div>
								</a>
							</div>
						</div>
					</div>
				</div>
				<div class="login-signup" v-show="!loginIn">
					<a v-for="navbarMenuItem in navbarMenuItems" class="navbar-menu-item">
						<router-link :to="{ path: navbarMenuItem.path }">
							<a>{{ navbarMenuItem.name }}</a>
						</router-link>
					</a>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import {mapGetters} from 'vuex';
import {mixin} from '@/mixins';

export default {
  name: 'the-header',
  mixins: [mixin],
  data() {
    return {
      navbarListItems: [
        {name: '首页', path: 'home'},
        {name: '学习', path: 'learn'},
        {name: '题库', path: 'problemset'}
	  ],
	  navbarMenuItems: [
        {name: '注册', path: 'signup'},
		{name: '登录', path: 'login'}
      ],
	  user: {
        name: 'madoromi_nemu_',
	  },
	  picurl: '',
	  show: false
	}
  },
  computed: {
    ...mapGetters([
      'userId',
      'username',
      'avatar',
      'loginIn'
	]),
  },
  created() {

  },
  mounted() {
    // document.addEventListener('click', (e) => {
    //   let s2 = this.$refs.s2;
    //   if (!s2.contains(e.target)) {
    //     this.langTypeShow = false;
    //   }
    // })
    // document.querySelector('.avatar').addEventListener('click',function(e){
    //   document.querySelector('.avatar-dropdown').classList.add("show");
    //   e.stopPropagation();
    // },false);
	// document.querySelector('.avatar-dropdown').addEventListener('click',function(e){
    //   e.stopPropagation();
	// },false);
    // document.addEventListener('click',function(){
    //   document.querySelector('.avatar-dropdown').classList.remove("show");
    // },false);
  },
  methods: {
    logout() {
      this.$store.commit('setLoginIn', false);
      this.show = false;
      window.sessionStorage.clear();
      window.localStorage.clear();
      // this.$router.go(0);
      this.$router.push("/problemset");
	},
	goInfo() {
      // console.log(this.loginIn);
      // console.log(this.userId);
      // console.log(this.username);
      // console.log(this.avatar);
	}
  }
}
</script>

<style scoped lang="scss">
@import './src/assets/css/the-header';
</style>