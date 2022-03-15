<template>
	<div id="app">
		<TheHeader></TheHeader>
		<router-view></router-view>
	</div>
</template>

<script>
import TheHeader from '@/components/TheHeader';
export default {
  name: 'App',
  components: {TheHeader},
}
</script>

<style lang="scss">
#app {
  background-color: #222325;
  min-height: 100vh;
}
</style>
