<template>
	<div class="problem-set">
		<div class="w-full md:max-w-[888px] lg:max-w-screen-xl mx-auto pt-[72px] px-4 md:p-6 flex-grow">
			<div class="grid grid-cols-4 gap-4 md:grid-cols-3 lg:grid-cols-4 lg:gap-6">
				<div class="col-span-4 z-base md:col-span-2 lg:col-span-3">
					<div class="-mr-2 md:mr-0"></div>
					<div class="mt-[32px] -mr-2 md:mr-0"></div>
					<div class="mt-[32px] block md:hidden"></div>
					<hr class="my-8" style="background-color: #3d3e40;height: 1px;border: none">
					<div class="relative flex mb-1"></div>
					<div class="flex items-center space-x-4 py-3 relative my-4 -ml-4 overflow-hidden pl-4"></div>
					<div class="text-xs">
<!----------------------------------------搜索条----------------------------------------->
						<div class="flex flex-col mb-3 text-xs">
							<div class="flex justify-between">
								<div class="flex space-x-2.5">
									<div class="relative">
										<div>
											<button class="flex items-center rounded px-3 py-1.5 text-left cursor-pointer focus:outline-none whitespace-nowrap leading-5 bg-fill-3 text-label-2 hover:bg-fill-2 active:bg-fill-3"
													id="headlessui-menu-button-12" type="button" aria-haspopup="true"
													aria-expanded="false">题单
												<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em"
													 height="1em" fill="currentColor"
													 class="w-4.5 h-4.5 ml-3 pointer-events-none transition duration-300 text-label-3"
													 aria-hidden="true">
													<path fill-rule="evenodd"
														  d="M4.929 7.913l7.078 7.057 7.064-7.057a1 1 0 111.414 1.414l-7.77 7.764a1 1 0 01-1.415 0L3.515 9.328a1 1 0 011.414-1.414z"
														  clip-rule="evenodd"></path>
												</svg>
											</button>
										</div>
									</div>
									<div class="relative">
										<div>
											<button class="flex items-center rounded px-3 py-1.5 text-left cursor-pointer focus:outline-none whitespace-nowrap leading-5 bg-fill-3 text-label-2 hover:bg-fill-2 active:bg-fill-3"
													id="headlessui-menu-button-13" type="button" aria-haspopup="true"
													aria-expanded="false">难度
												<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em"
													 height="1em" fill="currentColor"
													 class="w-4.5 h-4.5 ml-3 pointer-events-none transition duration-300 text-label-3"
													 aria-hidden="true">
													<path fill-rule="evenodd"
														  d="M4.929 7.913l7.078 7.057 7.064-7.057a1 1 0 111.414 1.414l-7.77 7.764a1 1 0 01-1.415 0L3.515 9.328a1 1 0 011.414-1.414z"
														  clip-rule="evenodd"></path>
												</svg>
											</button>
										</div>
									</div>
									<div class="relative">
										<div>
											<button class="flex items-center rounded px-3 py-1.5 text-left cursor-pointer focus:outline-none whitespace-nowrap leading-5 bg-fill-3 text-label-2 hover:bg-fill-2 active:bg-fill-3"
													id="headlessui-menu-button-14" type="button" aria-haspopup="true"
													aria-expanded="false">状态
												<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em"
													 height="1em" fill="currentColor"
													 class="w-4.5 h-4.5 ml-3 pointer-events-none transition duration-300 text-label-3"
													 aria-hidden="true">
													<path fill-rule="evenodd"
														  d="M4.929 7.913l7.078 7.057 7.064-7.057a1 1 0 111.414 1.414l-7.77 7.764a1 1 0 01-1.415 0L3.515 9.328a1 1 0 011.414-1.414z"
														  clip-rule="evenodd"></path>
												</svg>
											</button>
										</div>
									</div>
									<div class="relative">
										<button class="flex items-center rounded px-3 py-1.5 text-left cursor-pointer focus:outline-none whitespace-nowrap leading-5 bg-fill-3 text-label-2 hover:bg-fill-2"
												id="headlessui-popover-button-15" type="button" aria-expanded="false">
											<span>标签</span>
											<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em"
												 height="1em" fill="currentColor"
												 class="w-4.5 h-4.5 ml-3 pointer-events-none transition duration-300 text-label-3"
												 aria-hidden="true">
												<path fill-rule="evenodd"
													  d="M4.929 7.913l7.078 7.057 7.064-7.057a1 1 0 111.414 1.414l-7.77 7.764a1 1 0 01-1.415 0L3.515 9.328a1 1 0 011.414-1.414z"
													  clip-rule="evenodd"></path>
											</svg>
										</button>
									</div>
									<div class="flex-grow">
										<div class="relative rounded-md">
											<div class="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
												<span class="text-gray-6"><svg
														xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
														width="1em" height="1em" fill="currentColor" class="w-4 h-4 text-label-4"><path
														fill-rule="evenodd"
														d="M5.527 5.527a7.5 7.5 0 0111.268 9.852l3.581 3.583a1 1 0 01-1.414 1.415l-3.582-3.583A7.501 7.501 0 015.527 5.527zm1.414 1.414a5.5 5.5 0 107.779 7.779A5.5 5.5 0 006.94 6.94z"
														clip-rule="evenodd"></path></svg></span></div>
											<input class="block w-full border-none py-1.5 pr-3 rounded-md outline-none placeholder-label-4 text-label-2 bg-fill-3 focus:bg-fill-2 pl-9"
												   type="text" placeholder="搜索题目、编号或内容" value=""></div>
									</div>
									<div class="relative">
										<button aria-label="settings"
												class="flex items-center rounded px-3 py-1.5 text-left cursor-pointer focus:outline-none whitespace-nowrap leading-5 bg-fill-3 text-label-2 hover:bg-fill-2"
												id="headlessui-popover-button-17" type="button" aria-expanded="false">
											<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em"
												 height="1em" fill="currentColor" class="w-5 h-5 pointer-events-none"
												 aria-hidden="true">
												<path fill-rule="evenodd"
													  d="M7.174 5.619a8.064 8.064 0 011.635-.946l.29-1.158A2 2 0 0111.039 2h1.922a2 2 0 011.94 1.515l.29 1.158c.584.252 1.132.57 1.635.946l1.15-.329a2 2 0 012.282.923l.961 1.665a2 2 0 01-.342 2.437l-.86.832a8.151 8.151 0 010 1.888l.86.83a2 2 0 01.342 2.438l-.96 1.665a2 2 0 01-2.283.923l-1.15-.329a8.063 8.063 0 01-1.635.946l-.29 1.158a2 2 0 01-1.94 1.515H11.04a2 2 0 01-1.94-1.515l-.29-1.158a8.064 8.064 0 01-1.635-.946l-1.15.329a2 2 0 01-2.282-.923l-.961-1.665a2 2 0 01.342-2.437l.86-.831a8.158 8.158 0 010-1.889l-.86-.83a2 2 0 01-.342-2.438l.96-1.665a2 2 0 012.283-.923l1.15.329zm-1.7 1.594l-.961 1.665 1.57 1.518-.114.982a6.157 6.157 0 000 1.425l.114.982-1.57 1.518.96 1.665 2.104-.601.794.593c.38.284.793.523 1.23.711l.908.392.53 2.118h1.922l.53-2.118.909-.392a6.07 6.07 0 001.23-.711l.793-.593 2.103.601.961-1.665-1.57-1.518.114-.982a6.172 6.172 0 000-1.425l-.114-.982 1.57-1.518-.96-1.665-2.104.601-.794-.593a6.067 6.067 0 00-1.23-.71l-.908-.392L12.96 4H11.04l-.53 2.119-.909.391a6.064 6.064 0 00-1.23.711l-.793.593-2.103-.601zM12 16a4 4 0 100-8 4 4 0 000 8zm0-2a2 2 0 110-4 2 2 0 010 4z"
													  clip-rule="evenodd"></path>
											</svg>
										</button>
									</div>
								</div>
								<div class="inline-flex flex-shrink-0 items-center cursor-pointer">
									<span style="background-color: #3897ff;--tw-shadow: 0 4px 12px 0 rgba(0,122,255,0.4);" class="w-8 h-8 flex items-center justify-center shadow-md rounded-full bg-gradient-to-b from-fixed-blue to-blue shadow-fixed-blue">
										<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="text-white w-[18px] h-[18px]">
											<path fill-rule="evenodd" d="M18.48 17.5h-2.204a5 5 0 01-4.31-2.466l-.625-1.061-.624 1.061a5 5 0 01-4.31 2.466H2.661a1 1 0 110-2h3.746a3 3 0 002.586-1.48L10.181 12 8.993 9.98A3 3 0 006.407 8.5H2.661a1 1 0 110-2h3.746a5 5 0 014.31 2.466l.624 1.061.624-1.061a5 5 0 014.31-2.466h2.205V4.315a.5.5 0 01.874-.332l2.536 2.853a1 1 0 010 1.328l-2.536 2.853a.5.5 0 01-.874-.332V8.5h-2.204a3 3 0 00-2.587 1.48L12.501 12l1.188 2.02a3 3 0 002.587 1.48h2.204v-2.185a.5.5 0 01.874-.332l2.83 3.185a.5.5 0 010 .664l-2.83 3.185a.5.5 0 01-.874-.332V17.5z" clip-rule="evenodd"></path>
										</svg>
									</span>
									<span style="color: rgba(0,122,255)" class="pl-2.5 text-blue hidden md:inline">
										随机一题
									</span>
								</div>
							</div>
						</div>
<!---------------------------------------题目列表----------------------------------------->
						<div class="-mx-4 md:mx-0">
							<div role="table" style="min-width: 0px" class="border-spacing-0 overflow-auto">
								<div class="inline-block min-w-full">
									<div style="border-bottom-width: 1px;border-color: #3d3d3d">
<!--------------------------------------------题目表头--------------------------------------------------->
										<div role="row" style="display:flex;flex:1 0 auto;min-width:0px">
											<div colspan="1" role="columnheader"
												 style="box-sizing:border-box;flex:60 0 auto;min-width:0px;width:60px"
												 class="mx-2 py-[11px] font-normal text-dark-label-3">
												<div class="flex items-center justify-between">
													<div class="overflow-hidden overflow-ellipsis">状态</div>
												</div>
											</div>
											<div colspan="1" role="columnheader"
												 style="box-sizing:border-box;flex:160 0 auto;min-width:0px;width:160px;cursor:pointer"
												 class="mx-2 py-[11px] font-normal text-dark-label-3 group hover:text-dark-gray-7">
												<div class="flex items-center justify-between">
													<div class="overflow-hidden overflow-ellipsis">题目</div>
													<span class="ml-2 h-3.5 w-3.5 text-gray-5  group-hover:text-gray-7"><svg
															xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
															width="1em" height="1em" fill="currentColor"><path
															d="M18.695 9.378L12.83 3.769a1.137 1.137 0 00-.06-.054c-.489-.404-1.249-.377-1.7.06L5.303 9.381a.51.51 0 00-.16.366c0 .297.27.539.602.539h12.512a.64.64 0 00.411-.146.501.501 0 00.028-.762zM12.77 20.285c.021-.017.042-.035.062-.054l5.863-5.609a.5.5 0 00-.028-.762.64.64 0 00-.41-.146H5.743c-.332 0-.601.242-.601.54a.51.51 0 00.16.365l5.769 5.606c.45.437 1.21.464 1.698.06z"></path></svg></span>
												</div>
											</div>
											<div colspan="1" role="columnheader"
												 style="box-sizing:border-box;flex:96 0 auto;min-width:0px;width:96px;cursor:pointer"
												 class="mx-2 py-[11px] font-normal text-dark-label-3 group hover:text-dark-gray-7">
												<div class="flex items-center justify-between">
													<div class="overflow-hidden overflow-ellipsis">题解</div>
													<span class="ml-2 h-3.5 w-3.5 text-gray-5 group-hover:text-gray-7"><svg
															xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
															width="1em" height="1em" fill="currentColor"><path
															d="M18.695 9.378L12.83 3.769a1.137 1.137 0 00-.06-.054c-.489-.404-1.249-.377-1.7.06L5.303 9.381a.51.51 0 00-.16.366c0 .297.27.539.602.539h12.512a.64.64 0 00.411-.146.501.501 0 00.028-.762zM12.77 20.285c.021-.017.042-.035.062-.054l5.863-5.609a.5.5 0 00-.028-.762.64.64 0 00-.41-.146H5.743c-.332 0-.601.242-.601.54a.51.51 0 00.16.365l5.769 5.606c.45.437 1.21.464 1.698.06z"></path></svg></span>
												</div>
											</div>
											<div colspan="1" role="columnheader"
												 style="box-sizing:border-box;flex:82 0 auto;min-width:0px;width:82px;cursor:pointer"
												 class="mx-2 py-[11px] font-normal text-dark-label-3 group hover:text-dark-gray-7">
												<div class="flex items-center justify-between">
													<div class="overflow-hidden overflow-ellipsis">通过率</div>
													<span class="ml-2 h-3.5 w-3.5 text-gray-5 group-hover:text-gray-7"><svg
															xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
															width="1em" height="1em" fill="currentColor"><path
															d="M18.695 9.378L12.83 3.769a1.137 1.137 0 00-.06-.054c-.489-.404-1.249-.377-1.7.06L5.303 9.381a.51.51 0 00-.16.366c0 .297.27.539.602.539h12.512a.64.64 0 00.411-.146.501.501 0 00.028-.762zM12.77 20.285c.021-.017.042-.035.062-.054l5.863-5.609a.5.5 0 00-.028-.762.64.64 0 00-.41-.146H5.743c-.332 0-.601.242-.601.54a.51.51 0 00.16.365l5.769 5.606c.45.437 1.21.464 1.698.06z"></path></svg></span>
												</div>
											</div>
											<div colspan="1" role="columnheader"
												 style="box-sizing:border-box;flex:60 0 auto;min-width:0px;width:60px;cursor:pointer"
												 class="mx-2 py-[11px] font-normal text-dark-label-3 group hover:text-dark-gray-7">
												<div class="flex items-center justify-between">
													<div class="overflow-hidden overflow-ellipsis">难度</div>
													<span class="ml-2 h-3.5 w-3.5 text-gray-5 group-hover:text-gray-7"><svg
															xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
															width="1em" height="1em" fill="currentColor"><path
															d="M18.695 9.378L12.83 3.769a1.137 1.137 0 00-.06-.054c-.489-.404-1.249-.377-1.7.06L5.303 9.381a.51.51 0 00-.16.366c0 .297.27.539.602.539h12.512a.64.64 0 00.411-.146.501.501 0 00.028-.762zM12.77 20.285c.021-.017.042-.035.062-.054l5.863-5.609a.5.5 0 00-.028-.762.64.64 0 00-.41-.146H5.743c-.332 0-.601.242-.601.54a.51.51 0 00.16.365l5.769 5.606c.45.437 1.21.464 1.698.06z"></path></svg></span>
												</div>
											</div>
										</div>
									</div>
<!--------------------------------------------题目数据--------------------------------------------------->
									<div role="rowgroup" class="text-label-1">
										<div role="row" v-for="(problem,index) in tableData" :key="problem.id" style="display:flex;flex:1 0 auto;min-width:0px"
											 :class="{ even: index % 2 ? 1 : 0}">
											<div role="cell" style="box-sizing:border-box;flex:60 0 auto;min-width:0px;width:60px;color: #5c5c5c" class="mx-2 py-2">
												<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="text-gray-5" style="width: 18px;height: 18px">
													<path fill-rule="evenodd" d="M4 12a1 1 0 011-1h14a1 1 0 110 2H5a1 1 0 01-1-1z" clip-rule="evenodd"></path>
												</svg>
											</div>
											<div role="cell" style="box-sizing:border-box;flex:160 0 auto;min-width:0px;width:160px" class="mx-2 py-2">
												<div class="max-w-[302px] flex items-center">
													<div class="overflow-hidden">
														<div class="flex items-center">
															<div class="truncate overflow-hidden">
<!--																<a :href="'/problems?id='+problem.id" class="h-5 hover:text-primary-s">-->
<!--																	{{ problem.id }}. {{ problem.title}}-->
<!--																</a>-->
																<a class="h-5 cursor-pointer hover:text-primary-s" @click="routerTo(problem.id)">
																	{{ problem.id }}. {{ problem.title}}
																</a>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div role="cell" style="box-sizing:border-box;flex:96 0 auto;min-width:0px;width:96px" class="mx-2 py-2">
												<span class="flex items-center space-x-2">
													<a href="/problems/two-sum/solution" class="truncate" aria-label="solution">
<!--														{{ problem.answer }}-->
														0
													</a>
												</span>
											</div>
											<div role="cell" style="box-sizing:border-box;flex:82 0 auto;min-width:0px;width:82px" class="mx-2 py-2">
<!--												<span>{{ problem.rate }}%</span>-->
												<span>0%</span>
											</div>
											<div role="cell" style="box-sizing:border-box;flex:60 0 auto;min-width:0px;width:60px" class="mx-2 py-2">
												<span :style="color(problem.level)">{{ problem.level }}</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
<!----------------------------------------------分页条------------------------------------>
						<div class="flex mt-4 flex-col-reverse md:flex-row items-center md:justify-between">
							<div class="relative">
								<button class="flex items-center rounded px-3 py-1.5 text-left cursor-pointer focus:outline-none whitespace-nowrap bg-fill-3 text-label-2 hover:bg-fill-2 active:bg-fill-3"
										id="headlessui-listbox-button-11" type="button" aria-haspopup="true"
										aria-expanded="false">20 条/页
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em"
										 fill="currentColor" class="ml-3 pointer-events-none" aria-hidden="true">
										<path fill-rule="evenodd"
											  d="M4.929 7.913l7.078 7.057 7.064-7.057a1 1 0 111.414 1.414l-7.77 7.764a1 1 0 01-1.415 0L3.515 9.328a1 1 0 011.414-1.414z"
											  clip-rule="evenodd"></path>
									</svg>
								</button>
							</div>
							<nav role="navigation" class="mb-6 md:mb-0 flex flex-nowrap items-center space-x-2">
								<button class="flex items-center justify-center w-8 h-8 rounded select-none focus:outline-none bg-fill-3 text-label-2 hover:bg-fill-2 disabled:opacity-40 disabled:pointer-events-none"
										aria-label="prev" disabled="">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em"
										 fill="currentColor" class="w-4 h-4 text-gray-7 dark:text-gray-7">
										<path fill-rule="evenodd"
											  d="M16.091 4.929l-7.057 7.078 7.057 7.064a1 1 0 01-1.414 1.414l-7.764-7.77a1 1 0 010-1.415l7.764-7.785a1 1 0 111.415 1.414z"
											  clip-rule="evenodd"></path>
									</svg>
								</button>
								<button class="flex items-center justify-center w-8 h-8 rounded select-none focus:outline-none pointer-events-none bg-paper dark:bg-dark-gray-5 text-label-1 dark:text-dark-label-1 shadow-level1 dark:shadow-dark-level1">
									1
								</button>
								<button class="flex items-center justify-center w-8 h-8 rounded select-none focus:outline-none bg-fill-3 dark:bg-dark-fill-3 text-label-2 dark:text-dark-label-2 hover:bg-fill-2 dark:hover:bg-dark-fill-2">
									2
								</button>
								<button class="flex items-center justify-center w-8 h-8 rounded select-none focus:outline-none bg-fill-3 dark:bg-dark-fill-3 text-label-2 dark:text-dark-label-2 hover:bg-fill-2 dark:hover:bg-dark-fill-2">
									3
								</button>
								<button class="flex items-center justify-center w-8 h-8 rounded select-none focus:outline-none bg-fill-3 dark:bg-dark-fill-3 text-label-2 dark:text-dark-label-2 hover:bg-fill-2 dark:hover:bg-dark-fill-2 disabled:opacity-40 disabled:pointer-events-none"
										aria-label="gap" disabled="">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em"
										 fill="currentColor" class="w-4 h-4 text-gray-5 dark:text-gray-5">
										<path fill-rule="evenodd"
											  d="M4.4 14a2 2 0 100-4 2 2 0 000 4zm9.6-2a2 2 0 11-4 0 2 2 0 014 0zm7.6 0a2 2 0 11-4 0 2 2 0 014 0z"
											  clip-rule="evenodd"></path>
									</svg>
								</button>
								<button class="flex items-center justify-center w-8 h-8 rounded select-none focus:outline-none bg-fill-3 dark:bg-dark-fill-3 text-label-2 dark:text-dark-label-2 hover:bg-fill-2 dark:hover:bg-dark-fill-2">
									51
								</button>
								<button class="flex items-center justify-center w-8 h-8 rounded select-none focus:outline-none bg-fill-3 dark:bg-dark-fill-3 text-label-2 dark:text-dark-label-2 hover:bg-fill-2 dark:hover:bg-dark-fill-2"
										aria-label="next">
									<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em"
										 fill="currentColor" class="w-4 h-4 text-gray-7 dark:text-gray-7">
										<path fill-rule="evenodd"
											  d="M7.913 19.071l7.057-7.078-7.057-7.064a1 1 0 011.414-1.414l7.764 7.77a1 1 0 010 1.415l-7.764 7.785a1 1 0 01-1.414-1.414z"
											  clip-rule="evenodd"></path>
									</svg>
								</button>
							</nav>
						</div>
						>
					</div>
				</div>
				<div class="col-span-4 md:col-span-1"></div>
			</div>
			<p class="text-label-1">全部问题</p>
		</div>
	</div>
</template>

<script>
import {getAllProblem} from '../api/index'
export default {
  data() {
    return {
      problemListItems: [
        {id: 1, title: '两数之和', level: '简单', answer: '16309', rate: '52.3'},
        {id: 2, title: '两数相加', level: '中等', answer: '8526', rate: '41.4'},
        {id: 3, title: '无重复字符串的最长子串', level: '中等', answer: '9123', rate: '38.5'},
        {id: 4, title: '寻找两个正序数组的中位数', level: '困难', answer: '4644', rate: '41.1'},
        {id: 5, title: '最长回文子串', level: '中等', answer: '4870', rate: '36.2'},
        {id: 6, title: 'Z字形变换', level: '中等', answer: '2961', rate: '51.1'},
        {id: 7, title: '整数反转', level: '中等', answer: '5911', rate: '35.2'},
        {id: 8, title: '字符串转换整数', level: '中等', answer: '3137', rate: '21.8'},
        {id: 9, title: '回文数', level: '简单', answer: '5775', rate: '57.7'},
        {id: 10, title: '正则表达式匹配', level: '困难', answer: '1467', rate: '34.6'},
        {id: 11, title: '盛最多水的容器', level: '中等', answer: '3675', rate: '61.9'},
	  ],
	  tableData: [],
	  tempData: [],
	  select_word: '',
	}
  },
  computed: {
    color() {
      return (level) => {
		if (level === "简单") {
          return {'color': 'rgba(0,184,163)'}
        }
        else if (level === "中等") {
          return {'color': 'rgba(255,192,30)'}
        }
        else if (level === "困难") {
          return {'color': 'rgba(255,55,95)'}
        }
	  }
	}
  },
  created() {
    this.getData();
  },
  methods: {
    //查询所有题目
    getData() {
      this.tempData = [];
      this.tableData = [];
      getAllProblem().then(res => {
        this.tempData = res;
        this.tableData = res;
	  })
	},
    //跳转至选中题目页面
    routerTo(id) {
      this.$router.push({ path: '/Problem', query: { id }});
	}
  }
}
</script>

<style scoped lang="scss">
.problem-set {
  background-color: #1a1a1a;
}
.even {
  background-color: #2a2a2a;
}
</style>