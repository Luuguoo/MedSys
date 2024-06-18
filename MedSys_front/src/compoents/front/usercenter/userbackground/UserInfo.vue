<template>
  <el-card class="box-card" shadow="always" style="border-radius: 20px;">
    <div slot="header" class="clearfix">
      <p align="left" style="font-size: 20px">后台首页</p>
    </div>
    <div style="min-height: 600px;">
      <el-row>
        <el-col :span="24">
          <img :src="users.pic" style="width: 150px">
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <span>您好,</span><span style="color: red">{{users.lname}}</span>
          <span class="vip"
                :style="users.level===0?'background-image: radial-gradient(darkgrey, darkgrey, darkgrey);':''"
                @click="toVip(users.level)">资深VIP</span>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="24">
          <span>欢迎您的登录！</span>
        </el-col>
      </el-row>
      <!--发布有奖模块 下一版发布-->
      <!--<el-row>
        <el-col>
          <div style="font-size: 20px;margin-top: 40px;color: red">
            推广：发布文章有奖
          </div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="20" :offset="2">
          <el-steps :active="1" align-center>
            <el-step v-for="(award, index) in awardsList" :key="index" :title="award.level"
                     :description="award.content"></el-step>
          </el-steps>
        </el-col>
      </el-row>
      <el-row>
        <el-col v-for="(award, index) in awardsList" :span="4" :offset='index===0?2:0' :key="index">
          <el-button size="mini" @click="lingqu(award.id)" >领取</el-button>
        </el-col>
      </el-row>-->



    </div>
    <el-dialog title="上传证明" :visible.sync="dialogFormVisible">
      <el-form  label-position="right" size="mini">
        <p style="font-size: 20px">上传医学院学生证或者医师资格证，进行认证</p>
        <el-form-item >
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
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="upload()">确 定</el-button>
      </div>
    </el-dialog>
  </el-card>
</template>

<script>
  export default {
    data() {
      return {
        imageUrl:'',
        ziGeZheng:'',
        dialogFormVisible:false,
        users: {},
        awardsList: []
      }
    },
    methods: {
      upload(){
        if (this.ziGeZheng===''){
          this.$message.error("照片不能为空");
          return
        }
        var formData = new FormData()
        formData.append("ziGeZheng", this.ziGeZheng.raw, this.ziGeZheng.name)
        this.$axios.post('front/protects/users/upLevel', formData)
          .then(resp => {
            if (resp.data.code === 1) {
              this.$message({
                message: resp.data.msg,
                type: 'success'
              });
              this.dialogFormVisible = false
            } else if (resp.data.code === 2) {
              this.$message.error(resp.data.msg);
            }
          })
      },
      toVip(level) {
        if (level === 1) {
          this.$alert('恭喜你已经成为资深VIP享有下载热搜关键词等特权', '尊敬的VIP您好', {
            confirmButtonText: '确定',
          });
        } else {
          this.$axios.get('front/protects/qualification/getByLname')
            .then(resp => {
              if (resp.data.code === 1) {
                if (resp.data.data!==0){
                  this.$confirm('认证资深VIP做特权王者,拥有更多特权, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'success'
                  }).then(() => {
                    this.dialogFormVisible=true
                  }).catch(() => {
                    this.$message({
                      type: 'info',
                      message: '已取消'
                    });
                  });
                }else{
                  this.$message({
                    type: 'info',
                    message: '您已提交成为资深VIP的申请，等待管理员审核'
                  });
                }
              }
            })
        }
      },
      getLoginInfo() {
        var lname = sessionStorage.getItem("username")
        this.$axios.get('front/protects/users/getInfo?lname=' + lname)
          .then(resp => {
            this.users = resp.data.data
          })
      },
      getAwardInfo() {
        this.$axios.get('front/protects/award/findAll')
          .then(resp => {
            this.awardsList = resp.data.data
            for (var i = 0; i < this.awardsList.length; i++) {
              var content = '发布文章数:' + this.awardsList[i].article_sum + '个奖励:' + this.awardsList[i].money + '元'
              var level = this.awardsList[i].level + '级'
              this.awardsList[i] = {'content': content, 'level': level, 'id': this.awardsList[i].id}
            }
          })
      },
      handleChange(file) {
        this.imageUrl = URL.createObjectURL(file.raw)
        this.ziGeZheng = file;
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
      load() {
        // this.getAwardInfo()
        this.getLoginInfo()
      }
    },
    created() {
      this.load()
    }
  }
</script>

<style scoped>
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


  .vip {
    font-size: 1px;
    padding: 3px;
    color: white;
    background-image: radial-gradient(darkorchid, red, gold);
  }

  .vip:hover {
    box-shadow: 1px 1px 1px #ff29a8;
    background: #f90200;
  }
</style>
