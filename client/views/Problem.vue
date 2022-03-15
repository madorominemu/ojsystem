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
									<button class="lang-select" @click="showLangDropdown">
										<span>Java</span>
										<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="css-1rhb60f-Svg ea8ky5j0" style="margin-left: auto;"><path fill-rule="evenodd" d="M16.293 9.293a1 1 0 111.414 1.414l-5 5a1 1 0 01-1.414 0l-5-5a1 1 0 011.414-1.414L12 13.586l4.293-4.293z" clip-rule="evenodd"></path></svg>
<!--										<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="css-1rhb60f-Svg ea8ky5j0" style="margin-left: auto;"><path fill-rule="evenodd" d="M16.293 14.707a1 1 0 001.414-1.414l-5-5a1 1 0 00-1.414 0l-5 5a1 1 0 101.414 1.414L12 10.414l4.293 4.293z" clip-rule="evenodd"></path></svg>-->
									</button>
									<div class="lang-select-dropdown" v-show="langTypeShow">
										<div class="lang-select-dropdown-container">
											<a class="space-x-2">
												<div class="lang flex-grow">Java</div>
											</a>
											<a class="space-x-2">
												<div class="lang flex-grow">JavaScript</div>
											</a>
											<a class="space-x-2">
												<div class="lang flex-grow">Python</div>
											</a>
										</div>
									</div>
								</div>
								<div class="code-edit">
									<textarea cols="93" rows="20"></textarea>
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
															<div class="runtime-info" v-show="false">
																<div class="excute-succeed">已完成</div>
																<div class="runtime">执行用时：60 ms</div>
															</div>
															<div class="result-info" v-show="true">
																<div class="submit-result-info">
																	<span>执行结果：</span>
																	<div class="error">编译出错</div>
																</div>
															</div>
														</div>
														<div class="error-container" v-show="true">
															<div class="content-wrapper">
																<div class="error-description">
																	{{ errorInfo }}
																</div>
															</div>
														</div>
														<div class="succeed-container" v-show="false">
															<div class="content-wrapper">
																<div class="error-description">
																	Line 4: error: missing return statement } ^
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
								<button class="runcode">
									<svg viewBox="0 0 24 24" width="1em" height="1em" class="css-1lc17o4-icon"><defs><path id="play-arrow_svg__a" d="M8 5v14l11-7z"></path><mask id="play-arrow_svg__b"><use fill-rule="evenodd" xlink:href="#play-arrow_svg__a"></use></mask></defs><g fill-rule="evenodd"><use xlink:href="#play-arrow_svg__a"></use><g fill-rule="nonzero" mask="url(#play-arrow_svg__b)"><path d="M0 0h24v24H0z"></path></g></g></svg>
									<span class="mx-1">执行代码</span>
								</button>
								<button class="submit">
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
export default {
  name: 'problem',
  data() {
    return {
      langTypeShow: false,
      code: '',
	  errorInfo: 'Line 4: error: missing return statement\n' +
        '    }\n' +
        '    ^\n' +
        'Line 4: error: missing return statement\n' +
        '    }\n' +
        '    ^\n',
	  problem: {
        id: 1,
		title: '两数之和',
		level: '简单',
		description: '给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。\n' +
          '\n' +
          '你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。\n' +
          '\n' +
          '你可以按任意顺序返回答案。\n' +
          '\n' +
          ' \n' +
          '\n' +
          '示例 1：\n' +
          '\n' +
          '输入：nums = [2,7,11,15], target = 9\n' +
          '输出：[0,1]\n' +
          '解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。\n' +
          '示例 2：\n' +
          '\n' +
          '输入：nums = [3,2,4], target = 6\n' +
          '输出：[1,2]\n' +
          '示例 3：\n' +
          '\n' +
          '输入：nums = [3,3], target = 6\n' +
          '输出：[0,1]\n' +
          ' \n' +
          '\n' +
          '提示：\n' +
          '\n' +
          '2 <= nums.length <= 104\n' +
          '-109 <= nums[i] <= 109\n' +
          '-109 <= target <= 109\n' +
          '只会存在一个有效答案\n' +
          '进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？\n' +
          '\n' + '给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。\n' +
          '\n' +
          '你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。\n' +
          '\n' +
          '你可以按任意顺序返回答案。\n' +
          '\n' +
          ' \n' +
          '\n' +
          '示例 1：\n' +
          '\n' +
          '输入：nums = [2,7,11,15], target = 9\n' +
          '输出：[0,1]\n' +
          '解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。\n' +
          '示例 2：\n'
	  }
	}
  },
  methods: {
    showLangDropdown() {
      this.langTypeShow = !this.langTypeShow
    },
  }
}
</script>

<style scoped lang="scss">
@import './src/assets/css/problem';
</style>