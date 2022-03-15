<template>
	<div class="login-wrap">
		<div class="ms-title">music 后台管理登录</div>
		<div class="ms-login">
			<el-form :model="ruleForm" :rules="rules" ref="ruleForm">
				<el-form-item prop="username">
					<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
				</el-form-item>
				<el-form-item prop="password">
					<el-input type="password" v-model="ruleForm.password" placeholder="密码"></el-input>
				</el-form-item>
				<div class="login-btn">
					<el-button type="primary" @click="submitForm">登录</el-button>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>
  export default {
    name: ''
  }
</script>

<style scoped lang="scss">

</style>