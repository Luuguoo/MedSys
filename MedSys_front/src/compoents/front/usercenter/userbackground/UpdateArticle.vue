<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">修改文章</p>
      </div>
      <div style="min-height: 600px">
        <el-row>
          <el-col :span="24">
            <el-form ref="form" :model="article" :rules="rules" label-width="100px"
                     label-position="right" size="mini">
              <el-form-item label="文章内容" prop="amemo">
                <el-input type="textarea" :autosize="{ minRows: 10}" v-model="article.amemo"></el-input>
              </el-form-item>
            </el-form>
          </el-col>
        </el-row>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="save" size="mini">确定</el-button>
          <el-button type="warning" @click="tofarticleDetail" size="mini">返回</el-button>
        </div>
      </div>
    </el-card>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        article: {},
        applys:{},
        rules: {
          amemo: [
            {
              required: true,
              message: '请输入文章内容',
              trigger: 'blur'
            },
            {
              min: 1,
              max: 2000,
              message: '文章内容长度在1到2000字符之间',
              trigger: 'blur'
            }
          ]
        }
      }
    },
    methods: {
      tofarticleDetail() {
        this.$router.push('/frontHome/frontInfo/frontfarticleDetail?article='+JSON.stringify(this.article))
      },
      // 提交
      save() {
        this.$refs.form.validate((valid) => {
          if (valid) {
            var formData = new FormData()
            formData.append('aid',this.article.aid)
            formData.append('xmemo',this.article.amemo)
            this.$axios.post('front/protects/applys/add', formData)
              .then(resp => {
                if (resp.data.code === 1) {
                  this.$message({
                    message: resp.data.msg,
                    type: 'success'
                  });
                  this.$router.push('/frontHome/frontusercenteruserbackgroundIndex/frontusercenteruserbackgroundMyArticleUpdateList')
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
      this.article = JSON.parse(this.$route.query.article)
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
