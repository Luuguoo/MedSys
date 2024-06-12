<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">添加用户信息</p>
      </div>
      <div style="min-height: 600px">
        <el-form ref="form" :model="users" :rules="rules" label-width="100px" label-position="right" size="mini">
          <el-form-item label="用户名" prop="lname">
            <el-input v-model="users.lname"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="users.password"></el-input>
          </el-form-item>
          <el-form-item label="真实姓名" prop="username">
            <el-input v-model="users.username"></el-input>
          </el-form-item>
          <el-form-item label="性别" prop="sex">
            <el-radio-group v-model="users.sex">
              <el-radio label="男">男</el-radio>
              <el-radio label="女">女</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="电话" prop="tel">
            <el-input v-model="users.tel"></el-input>
          </el-form-item>
          <el-form-item label="头像">
            <el-upload
              class="avatar-uploader"
              action=""
              :auto-upload="false"
              :show-file-list="false"
              accept=".png,.jpg,.gif"
              :on-change="handleChange"
              :before-upload="beforeAvatarUpload">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="save" size="mini">确定</el-button>
        </div>
      </div>
    </el-card>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        imageUrl: '',
        users: {},
        touxiang: '',
        rules: {
          username: [
            {
              required: true,
              message: '请输入真实姓名',
              trigger: 'blur'
            },
            {
              min: 2,
              max: 20,
              message: '姓名长度在2到20字符之间',
              trigger: 'blur'
            }
          ],
          lname: [
            {
              required: true,
              message: '请输入用户名',
              trigger: 'blur'
            },
            {
              min: 3,
              max: 20,
              message: '用户名长度在3到20字符之间',
              trigger: 'blur'
            }
          ],
          sex: [
            {
              required: true,
              message: '请输入性别',
              trigger: 'blur'
            }
          ],
          tel: [
            {
              required: true,
              message: '请输入手机号',
              trigger: 'blur'
            },
            {
              min: 11,
              max: 11,
              message: '手机号为11位',
              trigger: 'blur'
            }
          ],
          password: [
            {
              required: true,
              message: '请输入密码',
              trigger: 'blur'
            },
            {
              min: 6,
              max: 20,
              message: '密码长度在6到20字符之间',
              trigger: 'blur'
            }
          ]
        }
      }
    },
    methods: {
      // 提交
      save() {
        this.$refs.form.validate((valid) => {
          if (valid) {
            if (this.touxiang===''){
              this.$message.error("头像不能为空");
              return
            }
            var formData = new FormData()
            Object.keys(this.users).forEach(key => {
              formData.append(key, this.users[key])
            })
            formData.append("touxiang", this.touxiang.raw, this.touxiang.name)
            this.$axios.post('back/users/add', formData)
              .then(resp => {
                if (resp.data.code === 1) {
                  this.$message({
                    message: resp.data.msg,
                    type: 'success'
                  });
                  this.$router.push('/backHome/backuserList')
                } else if (resp.data.code === 2) {
                  this.$message.error(resp.data.msg);
                }
              })
          } else {
            alert('验证没通过');
            return false
          }
        })
      },
      handleChange(file) {
        this.imageUrl = URL.createObjectURL(file.raw)
        this.touxiang = file;
      },
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      }
    }
  }
</script>

<style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }

  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }

  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }

  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
