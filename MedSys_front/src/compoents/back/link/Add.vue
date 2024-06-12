<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">添加友情链接信息</p>
      </div>
      <div style="min-height: 600px">
        <el-form ref="form" :model="flink" :rules="rules" label-width="100px" label-position="right" size="mini">
          <el-form-item label="网站名称" prop="title">
            <el-input v-model="flink.title"></el-input>
          </el-form-item>
          <el-form-item label="网址" prop="http">
            <el-input v-model="flink.http"></el-input>
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
        flink: {},
        rules: {
          title: [
            {
              required: true,
              message: '请输入网站名称',
              trigger: 'blur'
            },
            {
              min: 1,
              max: 20,
              message: '网站名称长度在1到20字符之间',
              trigger: 'blur'
            }
          ],
          http: [
            {
              required: true,
              message: '请输入网址',
              trigger: 'blur'
            },
            {
              min: 1,
              max: 500,
              message: '网址长度在1到500字符之间',
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
            var formData = new FormData()
            Object.keys(this.flink).forEach(key => {
              formData.append(key, this.flink[key])
            })
            this.$axios.post('back/flink/add', formData)
              .then(resp => {
                if (resp.data.code === 1) {
                  this.$message({
                    message: resp.data.msg,
                    type: 'success'
                  });
                  this.$router.push('/backHome/backlinkList')
                } else if (resp.data.code === 2) {
                  this.$message.error(resp.data.msg);
                }
              })
          } else {
            alert('验证没通过');
            return false
          }
        })
      }
    }
  }
</script>

<style>
</style>
