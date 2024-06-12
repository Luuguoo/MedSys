<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">修改医学新闻信息</p>
      </div>
      <div style="min-height: 600px">
        <el-form ref="form" :model="news" :rules="rules" label-width="100px" label-position="right" size="mini">
          <el-form-item label="标题" prop="title">
            <el-input v-model="news.title"></el-input>
          </el-form-item>
          <el-form-item label="内容">
            <el-input type="textarea" :autosize="{ minRows: 2}"  v-model="news.detail"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="save" size="mini">确定</el-button>
          <el-button type="warning" @click="toList" size="mini">返回</el-button>
        </div>
      </div>
    </el-card>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        news: {},
        rules: {
          title: [
            {
              required: true,
              message: '请输入标题',
              trigger: 'blur'
            },
            {
              min: 4,
              max: 20,
              message: '标题长度在4到20字符之间',
              trigger: 'blur'
            }
          ],
          detail: [
            {
              required: true,
              message: '请输入正文',
              trigger: 'blur'
            },
            {
              min: 1,
              max: 500,
              message: '正文长度在1到500字符之间',
              trigger: 'blur'
            }
          ]
        }
      }
    },
    methods: {
      toList(){
        this.$router.push('/backHome/backmedicalnewsList')
      },
      // 提交
      save() {
        this.$refs.form.validate((valid) => {
          if (valid) {
            var formData = new FormData()
            Object.keys(this.news).forEach(key => {
              formData.append(key, this.news[key])
            })
            this.$axios.post('back/news/update', formData)
              .then(resp => {
                if (resp.data.code === 1) {
                  this.$message({
                    message: resp.data.msg,
                    type: 'success'
                  });
                  this.$router.push('/backHome/backmedicalnewsList')
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
    },
    created() {
      this.news = JSON.parse(this.$route.query.news)
    }
  }
</script>

<style>
</style>
