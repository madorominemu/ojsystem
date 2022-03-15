<template>
	<div class="table">
		<div class="container">
			<div class="handle-box">
				<el-button type="primary" @click="delAll">批量删除</el-button>
				<el-input v-model="select_word" placeholder="筛选相关用户" class="handle-input"></el-input>
				<el-button type="primary" @click="centerDialogVisible = true">添加新用户</el-button>
			</div>
		</div>
		<el-table :data="data" @selection-change="handleSelectionChange" height="710" style="width: 100%;">
			<el-table-column type="selection" width="40"></el-table-column>
			<el-table-column label="用户图片" width="100">
				<template #default="scope">
					<div class="user-img">
						<img :src="getUrl(scope.row.avatar)" style="width:100%" alt=""/>
					</div>
					<el-upload :action="uploadUrl(scope.row.id)"
							   :before-upload="beforeAvatarUpload"
							   :on-success="handleAvatarSuccess">
						<el-button>更新图片</el-button>
					</el-upload>
				</template>
			</el-table-column>
			<el-table-column prop="id" label="编号" width="55"></el-table-column>
			<el-table-column prop="username" label="用户名" width="120"></el-table-column>
			<el-table-column prop="sex" label="性别" width="55">
				<template #default="scope">
					{{changeSex(scope.row.sex)}}
				</template>
			</el-table-column>
			<el-table-column prop="birth" label="出生日期" width="100">
				<template #default="scope">
					{{attachBirth(scope.row.birth)}}
				</template>
			</el-table-column>
			<el-table-column prop="phoneNum" label="手机号" width="140"></el-table-column>
			<el-table-column prop="location" label="居住地" width="100"></el-table-column>
			<el-table-column prop="email" label="邮箱" width="250"></el-table-column>
			<el-table-column prop="introduction" label="个人介绍">
				<template #default="scope">
					<p style="height:50px;overflow-y: scroll">{{scope.row.introduction}}</p>
				</template>
			</el-table-column>
			<el-table-column prop="createTime" label="创建时间" width="155"></el-table-column>
			<el-table-column prop="updateTime" label="更新时间" width="155"></el-table-column>
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

		<el-dialog title="添加新用户" v-model="centerDialogVisible" width="400px" center>
			<el-form :model="registerForm" ref="registerForm" :rules="rules" label-width="80px">
				<el-form-item prop="username" label="用户名">
					<el-input v-model="registerForm.username" placeholder="用户名"></el-input>
				</el-form-item>
				<el-form-item prop="password" label="密码">
					<el-input v-model="registerForm.password" placeholder="密码" show-password></el-input>
				</el-form-item>
				<el-form-item label="性别">
					<el-radio-group v-model="registerForm.sex">
						<el-radio :label="0">保密</el-radio>
						<el-radio :label="1">男</el-radio>
						<el-radio :label="2">女</el-radio>
					</el-radio-group>
				</el-form-item>
				<el-form-item prop="birth" label="出生日期">
					<el-date-picker v-model="registerForm.birth" placeholder="选择日期" type="date" style="width: 100%"></el-date-picker>
				</el-form-item>
				<el-form-item prop="phoneNum" label="手机号">
					<el-input v-model="registerForm.phoneNum" placeholder="手机号"></el-input>
				</el-form-item>
				<el-form-item prop="location" label="居住地">
					<el-input v-model="registerForm.location" placeholder="居住地"></el-input>
				</el-form-item>
				<el-form-item prop="email" label="邮箱">
					<el-input v-model="registerForm.email" placeholder="邮箱"></el-input>
				</el-form-item>
				<el-form-item prop="introduction" label="个人介绍">
					<el-input v-model="registerForm.introduction" placeholder="个人介绍" type="textarea"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" style="margin-left: 218px">
				<el-button type="primary" @click="addUser">确定</el-button>
				<el-button @click="centerDialogVisible = false">取消</el-button>
			</div>
		</el-dialog>

		<el-dialog title="编辑用户" v-model="editVisible" width="400px" center>
			<el-form :model="userForm" ref="userForm" :rules="rules" label-width="80px">
				<el-form-item prop="username" label="用户名">
					<el-input v-model="userForm.username" placeholder="用户名"></el-input>
				</el-form-item>
				<el-form-item prop="password" label="密码">
					<el-input v-model="userForm.password" placeholder="密码" type="password" ></el-input>
				</el-form-item>
				<el-form-item label="性别">
					<el-radio-group v-model="userForm.sex">
						<el-radio :label="0">保密</el-radio>
						<el-radio :label="1">男</el-radio>
						<el-radio :label="2">女</el-radio>
					</el-radio-group>
				</el-form-item>
				<el-form-item prop="birth" label="出生日期">
					<el-date-picker v-model="userForm.birth" placeholder="选择日期" type="date" style="width: 100%"></el-date-picker>
				</el-form-item>
				<el-form-item prop="phoneNum" label="手机号">
					<el-input v-model="userForm.phoneNum" placeholder="手机号"></el-input>
				</el-form-item>
				<el-form-item prop="location" label="居住地">
					<el-input v-model="userForm.location" placeholder="居住地"></el-input>
				</el-form-item>
				<el-form-item prop="email" label="邮箱">
					<el-input v-model="userForm.email" placeholder="邮箱"></el-input>
				</el-form-item>
				<el-form-item prop="introduction" label="个人介绍">
					<el-input v-model="userForm.introduction" placeholder="个人介绍" type="textarea"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" style="margin-left: 218px">
				<el-button type="primary" @click="editSave">确定</el-button>
				<el-button @click="editVisible = false">取消</el-button>
			</div>
		</el-dialog>

		<el-dialog title="删除用户" v-model="delVisible" width="300px" center>
			<div>删除不可恢复，是否确定删除？</div>
			<span slot="footer">
                <el-button type="danger" @click="deleteRow">确定</el-button>
				<el-button @click="delVisible = false">取消</el-button>
            </span>
		</el-dialog>
	</div>
</template>

<script>
import {getAllUser, setUser, delUser, updateUser} from "../api/index";
import {mixin} from "../mixins";
export default {
  mixins: [mixin],
  data() {
    return {
	  centerDialogVisible: false, 	//添加弹窗是否显示
	  editVisible: false, 			//编辑弹窗是否显示
	  delVisible: false,  			//删除弹窗是否显示
	  registerForm:{      			//添加框
        username: '',
        password: '',
        sex: '',
		birth: '',
        phoneNum: '',
		location: '',
        email: '',
        introduction: '',
		createTime: '',
		updateTime: ''
	  },
	  userForm:{		//编辑框
		id: '',
        username: '',
        password: '',
        sex: '',
        birth: '',
        phoneNum: '',
        location: '',
        email: '',
        introduction: '',
	  },
      rules: {
        username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
        password: [{required: true, message: '密码不能为空', trigger: 'blur'}]
	  },
	  tableData: [],
	  tempData: [],
	  codes: [],
	  select_word: '',			//搜索框内容
	  pageSize: 5,    			//分页每页大小
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
            if(item.username.includes(this.select_word)){
              this.tableData.push(item);
            }
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
	//查询所有用户
	getData() {
	  this.tempData = [];
	  this.tableData = [];
	  getAllUser().then(res => {
		this.tempData = res;
		this.tableData = res;
		this.currentPage = 1;
	  })
	},
	//添加用户
    addUser(){
      let params = new URLSearchParams();
      params.append('username',this.registerForm.username);
      params.append('password',this.registerForm.password);
      if(this.registerForm.sex) {
        params.append('sex',this.registerForm.sex);
      }else{
        params.append('sex',0);
      }
      if(this.registerForm.birth) {
        let d = this.registerForm.birth;
        let datetime = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();
        params.append('birth',datetime);
      }else{
        params.append('birth','1234-12-12');
      }
      params.append('phoneNum',this.registerForm.phoneNum);
      params.append('location',this.registerForm.location);
      params.append('email',this.registerForm.email);
      params.append('introduction',this.registerForm.introduction);
      params.append('avatar','/img/user.jpg');
      setUser(params)
        .then(res => {
          if(res.code == 1){
            this.getData();
            this.notify("添加成功","success");
            this.centerDialogVisible = false;
            this.registerForm.username = '';
            this.registerForm.password = '';
            this.registerForm.sex = '';
            this.registerForm.birth = '';
            this.registerForm.phoneNum = '';
            this.registerForm.location = '';
            this.registerForm.email = '';
            this.registerForm.introduction = '';
          }else{
            this.notify("添加失败","error");
          }
        })
        .catch(err => {
          console.log(err);
        });
    },
	//弹出编辑页面
	handleEdit(row){
	  this.editVisible = true;
	  this.userForm = {
		id: row.id,
        username: row.username,
        password: row.password,
        sex: row.sex,
        birth: new Date(Date.parse(new Date(row.birth))),
        phoneNum: row.phoneNum,
        location: row.location,
        email: row.email,
        introduction: row.introduction,
	  };
	},
	//保存编辑
	editSave() {
      if(this.userForm.username && this.userForm.password){
        let d = this.userForm.birth;
        let datetime = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate();
        let params = new URLSearchParams();
        params.append('id',this.userForm.id);
        params.append('username',this.userForm.username);
        params.append('password',this.userForm.password);
        params.append('sex',this.userForm.sex);
        params.append('birth',datetime);
        params.append('phoneNum',this.userForm.phoneNum);
        params.append('location',this.userForm.location);
        params.append('email',this.userForm.email);
        params.append('introduction',this.userForm.introduction);
        updateUser(params)
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
	  }else{
        this.notify("用户名或密码不能为空","error");
	  }
	},
    //更新用户图片
    uploadUrl(id){
      return `${this.$store.state.HOST}/user/updateUserPic?id=${id}`
    },
	//删除一个用户
	deleteRow(){
	  delUser(this.idx)
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