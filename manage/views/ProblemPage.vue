<template>
	<div class="table">
		<div class="container">
			<div class="handle-box">
				<el-button type="primary" @click="delAll">批量删除</el-button>
				<el-input v-model="select_word" placeholder="请输入题目" class="handle-input"></el-input>
				<el-button type="primary" @click="centerDialogVisible = true">添加题目</el-button>
			</div>
		</div>
		<el-table :data="data" @selection-change="handleSelectionChange" height="710" style="width: 100%;">
			<el-table-column type="selection" width="55"></el-table-column>
			<el-table-column prop="id" label="编号" width="60"></el-table-column>
			<el-table-column prop="title" label="题目" width="300"></el-table-column>
			<el-table-column prop="level" label="难度" width="52"></el-table-column>
			<el-table-column prop="description" label="题目描述">
				<template #default="scope">
					<p style="height:50px;overflow-y: scroll">{{scope.row.description}}</p>
				</template>
			</el-table-column>
			<el-table-column fixed="right" label="操作" width="160">
				<template #default="scope">
					<el-button @click="handleEdit(scope.row)">编辑</el-button>
					<el-button type="danger" @click="handleDelete(scope.row.id)">删除</el-button>
				</template>
			</el-table-column>
		</el-table>
		<div class="pagination">
			<el-pagination
					background
					layout="total,prev,pager,next"
					:current-page="currentPage"
					:page-size="pageSize"
					:total="tableData.length"
					@current-change="handleCurrentChange"
			></el-pagination>
		</div>

		<el-dialog title="添加题目" v-model="centerDialogVisible" width="800px" top="30px" center>
			<el-form :model="registerForm" ref="registerForm" label-width="40px">
				<el-form-item prop="title" label="题目">
					<el-input v-model="registerForm.title" placeholder="题目"></el-input>
				</el-form-item>
				<el-form-item label="难度">
					<el-radio-group v-model="registerForm.level">
						<el-radio label="简单">简单</el-radio>
						<el-radio label="中等">中等</el-radio>
						<el-radio label="困难">困难</el-radio>
					</el-radio-group>
				</el-form-item>
				<el-form-item prop="description" label="简介">
					<el-input v-model="registerForm.description" placeholder="题目描述" type="textarea" :rows="28"></el-input>
				</el-form-item>
			</el-form>

			<div slot="footer">
				<el-button type="primary" @click="addProblem">确定</el-button>
                <el-button @click="centerDialogVisible = false">取消</el-button>
            </div>
		</el-dialog>

		<el-dialog title="编辑题目" v-model="editVisible" width="1500px" top="30px" center>
			<el-row type="flex">
				<el-col :span="12" style="flex-grow: 1">
					<el-form :model="codeForm" ref="codeForm" label-width="40px">
						<el-form-item prop="title" label="题目">
							<el-input v-model="codeForm.title" placeholder="题目"></el-input>
						</el-form-item>
						<el-form-item label="难度">
							<el-radio-group v-model="codeForm.level">
								<el-radio label="简单">简单</el-radio>
								<el-radio label="中等">中等</el-radio>
								<el-radio label="困难">困难</el-radio>
							</el-radio-group>
						</el-form-item>
						<el-form-item prop="description" label="简介">
							<el-input v-model="codeForm.description" type="textarea" :rows="29"></el-input>
						</el-form-item>
					</el-form>
				</el-col>
				<el-col :span="12" style="flex-grow: 1">
					<el-form :model="codeForm" ref="codeForm" label-width="100px">
						<el-form-item label="代码语言">
							<el-radio-group v-model="codeForm.type">
								<el-radio :label="1">Java</el-radio>
								<el-radio :label="2">Python</el-radio>
								<el-radio :label="3">JavaScript</el-radio>
							</el-radio-group>
						</el-form-item>
						<el-form-item prop="templateCode" label="模板代码">
							<el-input v-model="codeForm.templateCode" placeholder="模板代码" type="textarea" :rows="8"></el-input>
						</el-form-item>
						<el-form-item prop="testCode" label="测试代码">
							<el-input v-model="codeForm.testCode" placeholder="测试代码" type="textarea" :rows="22"></el-input>
						</el-form-item>
					</el-form>
				</el-col>
			</el-row>
			<div slot="footer" style="margin-left: 1310px;">
				<el-button type="primary" @click="editSave">确定</el-button>
				<el-button @click="editVisible = false">取消</el-button>
			</div>
		</el-dialog>

		<el-dialog title="删除题目" v-model="delVisible" width="300px" center>
			<div>删除不可恢复，是否确定删除？</div>
			<span slot="footer">
                <el-button type="danger" @click="deleteRow">确定</el-button>
				<el-button @click="delVisible = false">取消</el-button>
            </span>
		</el-dialog>
	</div>
</template>

<script>
import {getAllProblem, setProblem, delProblem, updateProblem, getCode} from "../api/index";
import {mixin} from "../mixins";
export default {
  mixins: [mixin],
  data() {
    return {
      centerDialogVisible: false, 	//添加弹窗是否显示
      editVisible: false, 			//编辑弹窗是否显示
      delVisible: false,  			//删除弹窗是否显示
      registerForm:{      			//添加框
        title: '',
        level: '',
        description: ''
      },
      codeForm:{		//编辑框
        id: '',
        title: '',
        level: '',
        description: '',
        type: '',
		templateCode: '',
		testCode: ''
	  },
      tableData: [],
      tempData: [],
      codes: [],
      select_word: '',			//搜索框内容
      pageSize: 10,    			//分页每页大小
      currentPage: 1, 			//当前页
      idx: -1,       			//当前选择项id
      multipleSelection: [],  	//哪些项已经打勾
    }
  },
  computed: {
    //计算当前搜索结果表里的数据
	data() {
    return this.tableData.slice((this.currentPage - 1) * this.pageSize,this.currentPage * this.pageSize)
	}
  },
  watch:{
    //搜索框里内容发生变化时，搜索结果table列表里的内容跟着它的内容发生变化
	select_word() {
      if(this.select_word == ''){
        this.tableData = this.tempData;
      }else {
        this.tableData = [];
        for(let item of this.tempData){
          if(item.title.includes(this.select_word)){
            this.tableData.push(item);
		  }
		}
	  }
	},
	"codeForm.type"() {
      this.codeForm.templateCode = '';
      this.codeForm.testCode = '';
      for(let code of this.codes){
        if(code.type == this.codeForm.type){
          this.codeForm.templateCode = code.templateCode;
          this.codeForm.testCode = code.testCode;
		}
	  }
	}
  },
  created() {
    this.getData();
  },
  methods: {
    //获取当前页
    handleCurrentChange(val){
      this.currentPage = val;
    },
    //查询所有题目
    getData() {
      this.tempData = [];
      this.tableData = [];
      getAllProblem().then(res => {
        this.tempData = res;
        this.tableData = res;
        this.currentPage = 1;
	  })
	},
    //添加题目
    addProblem(){
      let params = new URLSearchParams();
      params.append('title',this.registerForm.title);
      params.append('level',this.registerForm.level);
      params.append('description',this.registerForm.description);
      setProblem(params)
        .then(res => {
          if(res.code == 1){
            this.getData();
            this.notify("添加成功","success");
            this.registerForm.title = '';
            this.registerForm.level = '';
            this.registerForm.description = '';
          }else{
            this.notify("添加失败","error");
          }
        })
        .catch(err => {
          console.log(err);
        });
      this.centerDialogVisible = false;
    },
    //弹出编辑页面
    handleEdit(row){
      this.codes = [];
      this.editVisible = true;
      getCode(row.id).then(res => {
        this.codes = res;
        this.codeForm.type = 1;
      })
      this.codeForm = {
        id: row.id,
        title: row.title,
        level: row.level,
        description: row.description
      };

    },
	//保存编辑
	editSave() {
      let params = new URLSearchParams();
      params.append('id',this.codeForm.id);
      params.append('title',this.codeForm.title);
      params.append('level',this.codeForm.level);
      params.append('description',this.codeForm.description);
      params.append('problemId',this.codeForm.id);
      params.append('type',this.codeForm.type);
      params.append('templateCode',this.codeForm.templateCode);
      params.append('testCode',this.codeForm.testCode);

      updateProblem(params)
        .then(res => {
          if(res.code == 1){
            this.getData();
            this.notify("修改成功","success");
          }else{
            this.notify("修改失败","error");
          }
        })
        .catch(err => {
          console.log(err);
        });
      this.editVisible = false;
	},
    //删除一个题目
    deleteRow(){
      delProblem(this.idx)
        .then(res => {
          if(res){
            this.getData();
            this.notify("删除成功","success");
          }else{
            this.notify("删除失败","error");
          }
        })
        .catch(err => {
          console.log(err);
        })
      this.delVisible = false;
    },
  }
}
</script>

<style scoped lang="scss">
.handle-box {
  margin-bottom: 2px;
}
.handle-input {
  width: 300px;
  display: inline-block;
}
.pagination {
  display: flex;
  justify-content: center;
}

</style>