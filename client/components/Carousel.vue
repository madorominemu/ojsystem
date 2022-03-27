<template>
	<div class="-mr-2 md:mr-0">
		<div class="flex items-center pb-3">
			<h3 class="truncate text-lg font-medium text-label-2 dark:text-dark-label-2">推荐</h3>
			<div class="ml-auto flex items-center">
				<button class="rounded text-[24px] focus:outline-none bg-fill-4 dark:bg-dark-fill-4 hover:bg-fill-3 dark:hover:bg-dark-fill-3 active:text-label-3 dark:active:text-dark-label-3 text-label-2 dark:text-dark-label-2"
						aria-label="Prev">
					<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="">
						<path fill-rule="evenodd" d="M14.707 16.293a1 1 0 01-1.414 1.414l-5-5a1 1 0 010-1.414l5-5a1 1 0 111.414 1.414L10.414 12l4.293 4.293z" clip-rule="evenodd"></path>
					</svg>
				</button>
				<button class="rounded text-[24px] focus:outline-none bg-fill-4 dark:bg-dark-fill-4 hover:bg-fill-3 dark:hover:bg-dark-fill-3 active:text-label-3 dark:active:text-dark-label-3 text-label-2 dark:text-dark-label-2 ml-1.5" aria-label="Next">
					<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="">
						<path fill-rule="evenodd" d="M9.293 7.707a1 1 0 011.414-1.414l5 5a1 1 0 010 1.414l-5 5a1 1 0 01-1.414-1.414L13.586 12 9.293 7.707z" clip-rule="evenodd"></path>
					</svg>
				</button>
			</div>
		</div>
		<div class="container swiper swiper-initialized swiper-horizontal swiper-pointer-events">
			<swiper></swiper>
		</div>
	</div>
</template>

<script>
import swiper from '@/components/Swiper';
export default {
  name: 'carousel',
  components: {swiper},
}
</script>

<style scoped>

</style>
