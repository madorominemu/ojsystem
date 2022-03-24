<template>
	<div class="problem">
<!--		<p>传来的数据是：{{ this.$route.query.id }}</p>-->
		<div class="main-content">
			<div style="display: flex; flex-direction: row; flex: 1 1 0%;min-height: 0px;">
<!--				左-->
				<div class="left-container">
					<div class="wrapper">
						<div class="problem-info">
							<div class="tab-view-header" type="default" width="100%">
								<div class="tab-header-container">
									<div data-key="description" data-disabled="false" type="default"
										 class="active tab-header">
										<a>
											<div type="default" class="active tab-header-row">
												<span>
													<div class="tab-header">
														<svg viewBox="0 0 24 24" width="1.5em" height="1.5em" class="css-1lc17o4-icon"><path fill-rule="evenodd" d="M20 4H4c-1.1 0-2 .9-2 2v12c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V6c0-1.1-.9-2-2-2zm0 14H4V6h16v12zM6 10h2v2H6v-2zm0 4h8v2H6v-2zm10 0h2v2h-2v-2zm-6-4h8v2h-8v-2z"></path></svg>
														题目描述
													</div>
												</span>
											</div>
										</a>
									</div>
									<div data-key="submissions" data-disabled="false" type="default"
										 class="tab-header">
									</div>
								</div>
							</div>
							<div data-key="description-content" class="layer1 description-content">
								<div class="problem-description">
									<div class="title-level">
										<h4 class="title">
											<a>
												{{ problem.id }}. {{ problem.title }}
											</a>
										</h4>
										<div class="level">
											难度  {{ problem.level }}
										</div>
									</div>
									<div class="description text-white">
										{{ problem.description }}
									</div>
									<div class="summary"></div>
								</div>
							</div>
							<div data-key="submissions-content" class="layer1 submissions-content"></div>
						</div>
					</div>
					<div class="bottom-container"></div>
				</div>
<!--				中-->
				<div class="middle-resize-bar" data-is-collapsed="false"></div>
<!--				右-->
				<div class="right-container">
					<div class="code-area-container">
						<!--代码框-->
						<div class="editor-container">
							<div class="editor">
								<div class="code-type">
									<button class="lang-select" @click.stop="langTypeShow = !langTypeShow" ref="s1">
										<span>{{ typeString }}</span>
										<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="css-1rhb60f-Svg ea8ky5j0" style="margin-left: auto;"><path fill-rule="evenodd" d="M16.293 9.293a1 1 0 111.414 1.414l-5 5a1 1 0 01-1.414 0l-5-5a1 1 0 011.414-1.414L12 13.586l4.293-4.293z" clip-rule="evenodd"></path></svg>
<!--										<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="css-1rhb60f-Svg ea8ky5j0" style="margin-left: auto;"><path fill-rule="evenodd" d="M16.293 14.707a1 1 0 001.414-1.414l-5-5a1 1 0 00-1.414 0l-5 5a1 1 0 101.414 1.414L12 10.414l4.293 4.293z" clip-rule="evenodd"></path></svg>-->
									</button>
									<div class="lang-select-dropdown" v-show="langTypeShow">
										<div class="lang-select-dropdown-container">
											<div class="language-selector space-x-2" @click="this.type = 1">
												<div class="lang ">Java</div>
											</div>
											<div class="language-selector space-x-2" @click="this.type = 2">
												<div class="lang ">Python</div>
											</div>
											<div class="language-selector space-x-2" @click="this.type = 3">
												<div class="lang ">JavaScript</div>
											</div>
										</div>
									</div>
								</div>
								<div class="code-edit">
									<textarea cols="93" rows="20" v-model="templateCode">{{ templateCode }}</textarea>
								</div>
							</div>
						</div>
						<!--结果框-->
						<div class="closable">
							<div class="active">
								<div class="header-content">
									<div class="inner-wrapper">
										<div class="tab-view">
											<div class="tab-view-header">
												<div class="tab-header-container">
													<div class="tab-header">
														<div class="tab-header-row">
															<span>代码执行结果</span>
														</div>
													</div>
												</div>
											</div>
											<div class="runcode-result-content">
												<div class="container">
													<div class="finished-container">
														<div class="runtime-wrapper">
															<div class="placeholder" v-show="!hasExecute">
																<div class="executing" v-show="!executing">
																	请先运行您的代码
																</div>
																<div class="executing" v-show="executing">
																	. . . . .  运行中  . . . . .
																</div>
															</div>
															<div class="runtime-info" v-show="executeSucceed">
																<div class="execute-succeed">已完成</div>
																<div class="runtime" v-show="!executeRight">执行用时：{{ executeTimeTaken }} ms</div>
															</div>
															<div class="result-info" v-show="executeRight">
																<div class="submit-result-info">
																	<span>执行结果：</span>
																	<div class="error">解答出错</div>
																</div>
															</div>
															<div class="result-info" v-show="executeError">
																<div class="submit-result-info">
																	<span>执行结果：</span>
																	<div class="error">编译出错</div>
																</div>
															</div>
														</div>
														<div class="error-container" v-show="executeError">
															<div class="content-wrapper">
																<div class="error-description">
																	{{ compileReason }}
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--按钮框-->
						<div class="container">
							<div class="action">
								<button class="runcode" @click="execute">
									<svg viewBox="0 0 24 24" width="1em" height="1em" class="css-1lc17o4-icon"><defs><path id="play-arrow_svg__a" d="M8 5v14l11-7z"></path><mask id="play-arrow_svg__b"><use fill-rule="evenodd" xlink:href="#play-arrow_svg__a"></use></mask></defs><g fill-rule="evenodd"><use xlink:href="#play-arrow_svg__a"></use><g fill-rule="nonzero" mask="url(#play-arrow_svg__b)"><path d="M0 0h24v24H0z"></path></g></g></svg>
									<span class="mx-1">执行代码</span>
								</button>
								<button class="submit" @click="submit">
									<span>提交</span>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import {selectProblemByPrimaryKey,getCode,executeCode} from '../api/index'
import {mixin} from "../mixins";
// window.message = '';
export default {
  mixins: [mixin],
  name: 'problem',
  data() {
    return {
	  id: '',
	  problem: '',
	  templateCode: '',
      testCode: '',
	  codes: [],
	  type: '',
	  compileResponse: {
        errno: null,
        reason: '',
		stdout: ''
	  },
	  windowMsg: '',
	  hasExecute: false,
      executing: false,
	  executeSucceed: false,
      executeRight: false,
	  executeError: false,
	  executeTimeTaken: '',
      langTypeShow: false,
	}
  },
  // beforeRouteEnter(to,from,next) {
	// const store = from.matched[0].instances.default.$store;
  //   if(store.state.configure.loginIn === true) {
  //     next();
  //   } else {
  //     next("/login");
  //   }
  // },
  computed: {
    typeString() {
      if(this.type == 1){
        return 'Java';
      }
      if(this.type == 2){
        return 'Python';
      }
      if(this.type == 3){
        return 'JavaScript';
      }
      return this.type;
	},
	compileReason() {
      if (this.compileResponse.reason != '' && this.compileResponse.reason != null) {
        return this.compileResponse.reason.replace(/\.\\tmp\\\w{8}-\w{4}-\w{4}-\w{4}-\w{12}/g,"");
      }
	}
  },
  watch: {
    type() {
      this.templateCode = '';
      this.compileResponse = {errno: null, reason: '', stdout: ''};
      for(let code of this.codes){
        if(code.type == this.type){
          this.templateCode = code.templateCode;
          this.testCode = code.testCode;
          this.hasExecute = false;
          this.executing = false;
          this.executeRight = false;
          this.executeError = false;
          this.executeSucceed = false;
		}
	  }
	},
	"compileResponse.errno"() {
      if(this.compileResponse.errno == null) {
        this.hasExecute = false;
        this.executeRight = false;
        this.executeError = false;
        this.executeSucceed = false;
      }
      if(this.compileResponse.errno != null) {
        this.hasExecute = true;
      }
      if(this.compileResponse.errno == 0) {
        if(this.compileResponse.stdout.includes('Failed')) {
          this.executing = false;
          this.executeRight = true;
          this.executeError = false;
          this.executeSucceed = true;
		} else {
          this.executing = false;
          this.executeRight = false;
          this.executeError = false;
          this.executeSucceed = true;
		}
      }
      if(this.compileResponse.errno == 1) {
        this.executing = false;
        this.executeRight = false;
        this.executeError = true;
        this.executeSucceed = false;
      }
      if(this.compileResponse.errno == 2) {
        this.executing = false;
        this.executeRight = false;
        this.executeError = true;
        this.executeSucceed = false;
      }
	}
  },
  created() {
    this.id = this.$route.query.id;
    this.getData();
  },
  mounted() {
    // document.addEventListener('click', (e) => {
    //   let s1 = this.$refs.s1;
    //   if(!s1.contains(e.target)) {
    //     this.langTypeShow = false;
	//   }
	// })
  },
  errorCaptured (err, vm, info) {
    let error = `${err.stack}\n\nfound in ${info} of component`
	alert(error);
    this.compileResponse.reason = {errno: 1, reason: error, stdout: null};
    return false;
  },
  methods: {
    //获取当前id问题
	getData() {
      selectProblemByPrimaryKey(this.id).then(res => {
        this.problem = res;
	  });
      getCode(this.id).then(res => {
        this.codes = res;
        this.type = 1;
      })
	},
	//执行代码
	execute() {
      this.compileResponse = {errno: null, reason: '', stdout: ''};
      this.executing = true;
      if (this.type == 1) {
        setTimeout(() => {
          this.executeJava();
        },3000)
	  }
      if (this.type == 3) {
        // setTimeout(() => {
        //   this.executeJavaScript();
        // },1000)
        this.executeJavaScript();
	  }
	},
	//提交代码
    submit() {
      this.$store.commit('problem/setWindowMsg', window.message)
      //alert(this.window.message);
      // let str = this.window.message;
      // this.windowMsg = str;
      // console.log(this.windowMsg);
	},
	//执行Java代码
	executeJava() {
      let params = new URLSearchParams();
      params.append('problemId',this.id);
      params.append('type',this.type);
      params.append('templateCode',this.templateCode);
      let startTime = new Date();
      executeCode(params)
        .then(res => {
          let endTime = new Date();
          this.executeTimeTaken = endTime - startTime;
          this.compileResponse = res;
        })
        .catch(err => {
          console.log(err);
        })
	},
	//执行JavaScript代码
	executeJavaScript() {
      let head = document.getElementsByTagName('head')[0];
      let script = document.createElement('script');
      script.type = 'text/javascript';
      script.onload = script.onreadystatechange = function () {
        if(!this.readyState || this.readyState === "loaded" || this.readyState === "complete"){
          script.onload = script.onreadystatechange = null;
        }
      };
      let functions = this.templateCode.concat(this.testCode);
      script.innerText = functions;
      head.appendChild(script);
      let startTime = new Date();
      if (eval('JS()')) {
        this.compileResponse = {errno: 0, reason: '', stdout: 'OK'};
      }
      if (!eval('JS()')) {
        this.compileResponse = {errno: 0, reason: '', stdout: 'Failed'};
      }
      let endTime = new Date();
      this.executeTimeTaken = endTime - startTime;
	},
	//测试
	deliver() {
      this.executing = false;
	}
  },
}
// window.onerror = function (msg) {
//   window.message = msg;
//   console.log(window.message);
//   return true;
// }
</script>

<style scoped lang="scss">
@import './src/assets/css/problem';
</style>