<template>
	<div class="flex flex-auto flex-col h-full" style="background: rgba(26,26,26)">
		<div class="flex flex-auto flex-col justify-center w-full">
			<div class="SignInBox">
				<div class="Container">
					<div>
						<div class="mt-6 mb-8 text-lg font-medium" style="color: rgba(255,255,255, 1)">登录</div>
						<div class="mb-4 block">
							<div class="relative block">
								<label class="InputContainer">
									<input class="username" v-model="loginForm.username" placeholder="输入用户名" autocapitalize="off" spellcheck="false">
								</label>
							</div>
						</div>
						<div class="mb-4 block">
							<div class="relative block">
								<label class="InputContainer">
									<input class="password" v-model="loginForm.password" type="password" placeholder="输入密码" autocapitalize="off" spellcheck="false">
								</label>
							</div>
						</div>
						<div class="mb-4 block">
							<div class="hidden h-10 rounded-lg"></div>
						</div>
						<button class="StyledButton" @click="login">
							<span>登录</span>
						</button>
						<div class="mb-1 flex items-center">
							<div class="goto" @click="goSignup">没有帐号，前往注册</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import {loginIn} from '../api/index'
export default {
  name: 'login',
  data() {
	return {
	  loginForm: {
		username: '',
		password: ''
	  }
	}
  },
  methods: {
	login() {
    let _this = this;
	  let params = new URLSearchParams();
	  params.append('username', this.loginForm.username);
	  params.append('password', this.loginForm.password);
	  loginIn(params)
		.then(res => {
		  if(res.code == 1){
            console.log("登录成功，跳转至题库");
            _this.$store.commit('setLoginIn', true);
            _this.$store.commit('setUserId', res.userMsg.id);
            _this.$store.commit('setUsername', res.userMsg.username);
            _this.$store.commit('setAvatar', res.userMsg.avatar);
            setTimeout(() => {
              _this.$router.push("/problemset");
			},2000)
		  }else{
            alert("登录失败，用户名或密码不正确");
		  }
		});
	},
    goSignup() {
      this.$router.push("/signup")
    }
  }
}
</script>

<style scoped lang="scss">
@import './src/assets/css/login';
</style>