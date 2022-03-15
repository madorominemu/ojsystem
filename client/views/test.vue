<template>
	<div id="problem">
		<div class="left">
			<p style="white-space: pre-line;">{{ question }}</p>
		</div>
		<div class="right">
			<div class="edit">
				<textarea cols="100" rows="20" v-model="code"></textarea>
			</div>
			<div class="result">
				<p v-for="(val) in input">输入：{{ val }}</p>
				<p>输出：{{ output }}</p>
				<p>预期结果：{{ expected }}</p>
				<button @click="submit(code)">SUBMIT</button>
			</div>
		</div>
	</div>
</template>

<script>
export default {
  name: 'problem',
  data() {
    return {
      code: '',
      input: {
        input1: '["flower","flow","flight"]',
        //input2: '9',
      },
      output: 'null',
      expected: '',
      question: '',
    }
  },
  methods: {
    submit(scriptText) {
      let head = document.getElementsByTagName('head')[0];
      let script = document.createElement('script');
      script.type = 'text/javascript';
      script.onload = script.onreadystatechange = function () {
        if(!this.readyState || this.readyState === "loaded" || this.readyState === "complete"){
          script.onload = script.onreadystatechange = null;
        }
      };
      script.innerText = scriptText;
      head.appendChild(script);
      let func = this.getFunctionName(scriptText);
      this.output = this.f(this.input,func);
    },
    //获取函数名
    getFunctionName(scriptText) {
      let str = scriptText.toString();
      str = str.substr('function '.length);
      str = str.substr(0, str.indexOf("("));
      return str;
    },
    //拼接输入参数，并代入到函数中执行函数
    f(input,callback) {
      let str = '';
      for(let key in input) {
        str = str + input[key] + ",";
      }
      str=str.slice(0,str.length-1);
      return eval(callback + "(" + str + ")");
    }
  }
}
</script>

<style scoped lang="scss">
#problem {
  display: flex;
}
.left {
  background-color: #42b983;
  height: 98vh;
  width: 49vw;
}
.right {
  display: flex;
  flex-direction: column;
  height: 98vh;
  width: 49vw;

  .edit {
    background-color: #fc8181;
    height: 95%;
  }

  .result {
    background-color: #b3b3b3;
    height: 15%;

    p {
      margin: 0;
    }
  }
}
</style>