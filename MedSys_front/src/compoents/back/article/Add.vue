<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">添加文章信息</p>
      </div>
      <div style="min-height: 600px">
        <el-form ref="form" :model="article" :rules="rules" label-width="100px" label-position="right" size="mini">
          <el-form-item label="文章分类" prop="tid">
            <el-select v-model="article.tid" placeholder="请选择">
              <el-option
                  v-for="item in atypes"
                  :key="item.tid"
                  :label="item.tname"
                  :value="item.tid">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="文章标题" prop="title">
            <el-input v-model="article.title"></el-input>
          </el-form-item>
          <el-form-item label="文章图片">
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
          <el-form-item label="内容" prop="amemo">
            <el-input type="textarea" :autosize="{ minRows: 10}" v-model="article.amemo"></el-input>
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
      article: {},
      atypes:[],
      photo: '',
      rules: {
        title: [
          {
            required: true,
            message: '请输入文章标题',
            trigger: 'blur'
          },
          {
            min: 2,
            max: 20,
            message: '文章标题长度在2到20字符之间',
            trigger: 'blur'
          }
        ],
        amemo: [
          {
            required: true,
            message: '请输入文章内容',
            trigger: 'blur'
          }
        ],
        tid: [
          {
            required: true,
            message: '请选择文章分类',
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
          if (this.photo===''){
            this.$message.error("头像不能为空");
            return
          }
          this.article.lname = sessionStorage.getItem("lname")
          this.article.flag2 = 1
          var formData = new FormData()
          Object.keys(this.article).forEach(key => {
            formData.append(key, this.article[key])
          })
          formData.append("tupian", this.photo.raw, this.photo.name)
          this.$axios.post('back/article/add', formData)
              .then(resp => {
                if (resp.data.code === 1) {
                  this.$message({
                    message: resp.data.msg,
                    type: 'success'
                  });
                  this.$router.push('/backHome/backarticleList')
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
      this.photo = file;
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
    },
    getAtypeList(){
      this.$axios.get('back/atype/findAll')
          .then(resp=>{
            this.atypes = resp.data.data
          })
    }
  },
  created() {
    this.getAtypeList()
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
