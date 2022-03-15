<template>
	<div>
		<the-side-bar></the-side-bar>
		<the-header></the-header>
		<div class="content-box" :class="{'content-collapse':collapse}">
			<router-view></router-view>
		</div>
	</div>
</template>

<script>
import TheSideBar from '@/components/TheSideBar';
import TheHeader from '@/components/TheHeader';
export default {
  components: {
    TheHeader,
    TheSideBar
  },
  data(){
    return {
      collapse: false
    }
  },
}
</script>

<style scoped lang="scss">

</style>