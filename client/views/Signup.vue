<template>
	<div class="flex flex-auto flex-col h-full" style="background: rgba(26,26,26)">
		<div class="flex flex-auto flex-col justify-center w-full">
			<div class="SignInBox">
				<div class="Container">
					<div>
						<div class="mt-6 mb-8 text-lg font-medium" style="color: rgba(255,255,255, 1)">注册</div>
						<div class="mb-4 block">
							<div class="relative block">
								<label class="InputContainer">
									<input class="username" v-model="registerForm.username" placeholder="输入用户名" autocapitalize="off" spellcheck="false">
								</label>
							</div>
						</div>
						<div class="mb-4 block">
							<div class="relative block">
								<label class="InputContainer">
									<input class="password" v-model="registerForm.password" type="password" placeholder="输入密码" autocapitalize="off" spellcheck="false">
								</label>
							</div>
						</div>
						<div class="mb-4 block">
							<div class="hidden h-10 rounded-lg"></div>
						</div>
						<button class="StyledButton" @click="register">
							<span>注册</span>
						</button>
						<div class="mb-1 flex items-center">
							<div class="goto" @click="goLogin">已有帐号，前往登录</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import {signUp} from '@/api';
export default {
  name: 'signup',
  data() {
    return {
      registerForm: {
        username: '',
		password: ''
	  }
	}
  },
  methods: {
    register(){
      let _this = this;
      let params = new URLSearchParams();
      params.append('username', this.registerForm.username);
      params.append('password', this.registerForm.password);
      params.append('sex', '0');
      params.append('birth', '1234-12-12');
      params.append('phoneNum', '');
      params.append('location', '');
      params.append('email', '');
      params.append('introduction', '');
      params.append('avatar', '/img/default_avatar.jpg');
      signUp(params)
        .then(res => {
          if(res.code == 1){
            console.log("注册成功，跳转至题库");
            localStorage.setItem('username', this.registerForm.username);
            setTimeout(() => {
              _this.$router.push("/problemset");
            },2000)
          }else{
            alert("注册失败，用户名已存在");
          }
        })
        .catch(err => {
          console.log(err);
          alert("注册失败");
        });
    },
    goLogin() {
      this.$router.push("/login")
	}
  }
}
</script>

<style scoped lang="scss">
@import './src/assets/css/signup';
</style>