<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">用户登录</p>
      </div>
      <div style="min-height: 200px;">
        <el-row>
          <el-col :span="20" :offset="4">
            <el-form style="width: 500px" ref="form" :model="users" :rules="rules" label-width="100px"
                     label-position="right"
                     size="mini">
              <el-form-item label="账号" prop="lname">
                <el-input v-model="users.lname"></el-input>
              </el-form-item>
              <el-form-item label="密码" prop="password">
                <el-input v-model="users.password" type="password"></el-input>
              </el-form-item>
            </el-form>
          </el-col>
        </el-row>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="login" size="mini">登录</el-button>
        </div>
      </div>

    </el-card>
  </div>

</template>

<script>
  export default {
    data() {
      return {
        users: {},
        rules: {
          lname: [
            {
              required: true,
              message: '请输入账号',
              trigger: 'blur'
            }
          ],
          password: [
            {
              required: true,
              message: '请输入密码',
              trigger: 'blur'
            }
          ]
        }
      }
    },
    methods: {
      // 提交
      login() {
        this.$refs.form.validate((valid) => {
          if (valid) {
            var formData = new FormData()
            Object.keys(this.users).forEach(key => {
              formData.append(key, this.users[key])
            })
            this.$axios.post('front/publics/users/login', formData)
              .then(resp => {
                if (resp.data.code === 1) {// 登录成功
                  sessionStorage.setItem("username", this.users.lname)
                  this.$router.push('/frontHome/frontIndex')
                } else if (resp.data.code === 2) {//账号不存在
                  alert("账号不存在,请重新输入")
                } else if (resp.data.code === 3) {//密码不正确
                  alert("密码不正确，请重新输入")
                }
              })
          } else {
            alert('验证没通过');
            return false
          }
        })
      }
    },
    created() {
    }
  }
</script>

<style scoped>
  #main {
    position: absolute;
    width: 480px;
    height: 200px;
    left: 50%;
    top: 50%;
    margin-left: -250px;
    margin-top: -400px;
  }

  .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }


</style>
