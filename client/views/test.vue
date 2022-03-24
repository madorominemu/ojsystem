<template>
	<div id="problem">
		<div class="left">
			<p style="white-space: pre-line;">{{ problem }}</p>
		</div>
		<div class="right">
			<div class="edit">
				<textarea cols="100" rows="20" v-model="templateCode"></textarea>
			</div>
			<div class="result">
				<p v-for="(val) in input">输入：{{ val }}</p>
				<p>输出：{{ output }}</p>
				<p>预期结果：{{ expected }}</p>
				<button @click="submit(testCode)">SUBMIT</button>
				<br>
				<button @click="executeJS">SUBMIT</button>
			</div>
		</div>
	</div>
</template>

<script>
export default {
  name: 'problem',
  data() {
    return {
      id: '',
      problem: '最长公共前缀',
	  templateCode: '',
      // testCode: 'function JS() {\n' +
      //   '      if ( longestCommonPrefix(["flower","flow","flight"]) != "fl" ) {\n' +
      //   '        return false;\n' +
      //   '      }else if ( longestCommonPrefix(["dog","racecar","car"]) != "" ) {\n' +
      //   '        return false;\n' +
      //   '      }else if ( longestCommonPrefix(["teacher","teach","teaching"]) != "teach" ) {\n' +
      //   '        return false;\n' +
      //   '      }\n' +
      //   '      return true;\n' +
      //   '    }',
	  testCode: 'function JS() {\n' +
        '  if ( twoSum([2,7,11,15],9)[0] == 0 && twoSum([2,7,11,15],9)[1] == 1) {\n' +
        '    if ( twoSum([3,2,4],6)[0] == 1 && twoSum([3,2,4],6)[1] == 2 ) {\n' +
        '      if ( twoSum([3,3],6)[0] == 0 && twoSum([3,3],6)[1] == 1 ) {\n' +
        '        return true;\n' +
        '      }\n' +
        '    }\n' +
        '  }\n' +
        '  return false;\n' +
        '}',
	  // testCode: 'function JS() {\n' +
      //   '  alert(twoSum([2,7,11,15],9)[1]);\n' +
      //   '}',
      codes: [],
      type: '',
      compileResponse: {
        errno: null,
        reason: '',
        stdout: ''
      },
      hasExecute: false,
      executing: false,
      executeSucceed: false,
      executeRight: false,
      executeError: false,
      executeTimeTaken: '',
      langTypeShow: false,
      input: {
        input1: '["flower","flow","flight"]',
      },
      output: '',
      expected: '"fl"',
    }
  },
  methods: {
    //执行方式2 打开新窗口执行
	runCode(obj) {
	  let winname = window.open('', "_blank", '');
	  winname.document.open('text/html', 'replace');
      winname.opener = null;
      winname.document.write(obj.value);
      winname.document.close();
	},
    //执行函数1
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
	//执行JavaScript代码
	executeJS() {
	  this.executing = true;
      this.compileResponse.errno = null;
      let head = document.getElementsByTagName('head')[0];
      let script = document.createElement('script');
      script.type = 'text/javascript';
      script.onload = script.onreadystatechange = function () {
        if(!this.readyState || this.readyState === "loaded" || this.readyState === "complete"){
          script.onload = script.onreadystatechange = null;
        }
      };
      let str = this.templateCode.concat(this.testCode);
      script.innerText = str;
      head.appendChild(script);
      this.output = eval('JS()');
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
        str += input[key] + ",";
      }
      str=str.slice(0,str.length-1);
      return eval(callback + "(" + str + ")");
    },
  }
}
// window.onerror = function (msg) {
//   console.error(msg);
//   alert(msg);
//   return true;
// }
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