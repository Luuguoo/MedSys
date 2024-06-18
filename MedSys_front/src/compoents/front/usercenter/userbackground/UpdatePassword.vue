<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">修改密码</p>
      </div>
      <div style="min-height: 600px">
        <el-row>
          <el-col :span="20" :offset="4">
            <el-form style="width: 500px;" :model="ruleForm" status-icon :rules="rules" ref="ruleForm"
                     label-width="100px" class="demo-ruleForm">
              <el-form-item label="原密码" prop="yuanPass">
                <el-input type="password" v-model="ruleForm.yuanPass" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="新密码" prop="pass">
                <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="确认密码" prop="checkPass">
                <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
              </el-form-item>
            </el-form>
          </el-col>
        </el-row>
      </div>
    </el-card>
  </div>
</template>

<script>
  export default {
    data() {
      var checkYuanPass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入原密码'));
        } else {
          callback();
        }
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      };
      return {
        ruleForm: {
          pass: '',
          checkPass: '',
          yuanPass: ''
        },
        rules: {
          pass: [
            {validator: validatePass, trigger: 'blur'}
          ],
          checkPass: [
            {validator: validatePass2, trigger: 'blur'}
          ],
          yuanPass: [
            {validator: checkYuanPass, trigger: 'blur'}
          ]
        }
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$confirm('您确定要修改密码吗？', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
              var formData = new FormData()
              formData.append('yuanPass', this.ruleForm.yuanPass)
              formData.append('pass', this.ruleForm.pass)
              this.$axios.post('front/protects/users/updatePass', formData)
                .then(resp => {
                  if (resp.data.code === 1) {
                    this.$message({
                      message: resp.data.msg,
                      type: 'success'
                    });
                    this.$refs[formName].resetFields();
                    this.$router.push('/frontHome/frontusercenteruserbackgroundIndex/frontusercenteruserbackgroundUserInfo')
                  } else if (resp.data.code === 2) {
                    this.$message.error(resp.data.msg);
                  }
                })
            }).catch(() => {
              this.$message({
                type: 'info',
                message: '已取消'
              });
            });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style scoped>

</style>
