<template>
  <div>
    <img width="100%" height="940px" :src='backImg'>
    <div id="main">
      <h1 style="font-size: 40px;margin-bottom: 100px;color: white">医学知识科普平台</h1>
      <el-card class="box-card" style="border-radius: 20px;">
        <h2>请登录</h2>
        <el-form ref="form" :model="admin" :rules="rules" label-width="100px" label-position="right"
                 size="mini">
          <el-form-item label="管理员账号" prop="lname">
            <el-input v-model="admin.lname"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="pwd">
            <el-input v-model="admin.pwd" type="password"></el-input>
          </el-form-item>
        </el-form>
        <el-button type="primary" @click="login" size="mini">登录</el-button>
      </el-card>
    </div>
  </div>

</template>

<script>
  export default {
    data() {
      return {
        backImg: this.$baseVar.baseURL + 'static/image/5d2e7e7ccc59b26675.jpeg',
        admin: {},
        rules: {
          lname: [
            {
              required: true,
              message: '请输入账号',
              trigger: 'blur'
            }
          ],
          pwd: [
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
            Object.keys(this.admin).forEach(key => {
              formData.append(key, this.admin[key])
            })
            this.$axios.post('back/login', formData)
              .then(resp => {
                if (resp.data === 1) {// 登录成功
                  sessionStorage.setItem("lname", this.admin.lname)
                  this.$router.push('/backHome')
                } else if (resp.data === 2) {//账号不存在
                  alert("账号不存在,请重新输入")
                } else if (resp.data === 3) {//密码不正确
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

  .box-card {
    width: 480px;
  }
</style>
