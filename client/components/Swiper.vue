<template>
	<div class="vueswiperwrap">
		<div class="vueswiper" @mouseenter="autoPlay = false" @mouseleave="autoPlay = true">
			<transition-group :name="direction">
				<div class="item" v-for="(i,index) in imgArr" :key=index v-show="index===this.CurrentIndex">
					<img :src="i.src"/>
				</div>
			</transition-group>
		</div>

		<ul class="iconlist">
			<li v-for="(i,index) in imgArr" @click="add(index)" :class="index===this.CurrentIndex?'active':''"></li>
		</ul>

		<a class="cursor-pointer to-left fa fa-angle-left" @click="left">《</a>
		<a class="cursor-pointer to-right fa fa-angle-right" @click="right">》</a>
	</div>
</template>

<script>
export default {
  name: 'swiper',
  data() {
    return {
      imgArr:[
        {src: require('../assets/img/CarouselPic1.jpg')},
        {src: require('../assets/img/CarouselPic2.jpg')},
        {src: require('../assets/img/CarouselPic3.jpg')},
        {src: require('../assets/img/CarouselPic4.jpg')},
        {src: require('../assets/img/CarouselPic5.jpg')},
	  ],
	  CurrentIndex: 0,
	  direction: "right",
	  autoPlay: true,
	  timer: null,
	  duration: 3000
	}
  },
  watch: {
    autoPlay() {
      if(this.autoPlay){
        this.play();
	  }
      if(!this.autoPlay){
        clearInterval(this.timer);
        this.timer = null;
	  }
	}
  },
  mounted() {
    this.play();
  },
  methods: {
    add(idx) {
      if(this.CurrentIndex < idx) {
        this.direction = "right";
	  } else {
        this.direction = "left";
	  }
      this.CurrentIndex = idx;
	},
	left() {
      this.direction = "left";
      this.CurrentIndex--;
      if(this.CurrentIndex < 0) {
        this.CurrentIndex = this.imgArr.length - 1;
	  }
	},
    right() {
      this.direction = "right";
      this.CurrentIndex++;
      if(this.CurrentIndex > this.imgArr.length - 1) {
        this.CurrentIndex = 0;
      }
    },
    play() {
      if(this.autoPlay) {
        this.timer = setInterval(() => {
          this.right();
        },this.duration)
	  }
    }
  }
}
</script>

<style scoped lang="scss">
  /* vueswiper */
  .vueswiperwrap {
    position: relative;
    width: 100%;
    height: 150px;
    box-sizing: border-box;
    overflow: hidden;
  }

  /* vueswiper */
  .vueswiper {
    width: 100%;
    height: 100%;
    position: relative;
    box-sizing: border-box;
  }

  .vueswiper .item {
    display: block;
    width: 100%;
    height: 100%;
    position: absolute;
    left: 0;
    top: 0;
    overflow: hidden;
  }

  .vueswiper .item img {
    display: block;
    width: 100%;
    height: 100%;
    object-fit: cover;
  }

  /* iconlist */
  .iconlist {
    width: 100%;
    position: absolute;
    bottom: 5px;
    display: flex;
    display: -webkit-flex;
    -webkit-justify-content: center;
    justify-content: center;
  }

  .iconlist li {
    display: block;
    width: 10px;
    height: 10px;
    border-radius: 50%;
    background-color: #FFFFFF;
    margin-right: 10px;
  }

  .iconlist li:last-child {
    margin-right: 0;
  }

  .iconlist li.active {
    background-color: #282828;
  }

  .vueswiperwrap .fa {
    display: block;
    width: 40px;
    height: 40px;
    border-radius: 50%;
    background-color: #313131;
    text-align: center;
    line-height: 40px;
    font-size: 20px;
    color: #ffffff;
    box-shadow: #313131;
    position: absolute;
    top: 50%;
    margin-top: -25px;
  }

  .vueswiperwrap .to-left {
    left: 2%;
  }

  .vueswiperwrap .to-right {
    right: 2%;
  }

  .right-enter-active,
  .left-enter-active,
  .right-leave-active,
  .left-leave-active {
    transition: all .5s ease;
  }

  .right-enter-active {
    transform: translateX(100%)
  }
  .right-enter-to {
    transform: translateX(0);
  }

  .right-leave-active {
    transform: translateX(0)
  }
  .right-leave-to {
    transform: translateX(-100%)
  }

  .left-enter-active {
    transform: translateX(-100%)
  }
  .left-enter-to {
    transform: translateX(0)
  }

  .left-leave-active {
    transform: translateX(0)
  }
  .left-leave-to {
    transform: translateX(100%)
  }

  .v-enter-active,
  .v-leave-active {
    transition: all .3s linear;
  }
  .v-enter-active {
	transform: translateX(100%);
  }
  .v-enter-to {
	transform: translateX(0);
  }
  .v-leave-active {
    transform: translateX(0);
  }
  .v-leave-to {
	transform: translateX(-100%);
  }
</style>