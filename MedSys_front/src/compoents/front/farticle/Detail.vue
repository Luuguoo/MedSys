<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">文章详情</p>
      </div>
      <div style="text-align: left">
        <el-row>
          <el-col :span="6" style="margin: 20px">
            <img :src="article.photo" style="width: 150px">
          </el-col>
          <el-col :span="16" style="text-align: left">
            <el-row style="margin-bottom: 10px">
              <span style="font-size: 17px">{{article.title}}</span>
            </el-row>
            <el-row>
              发布人:{{article.lname}}
              <span class="guanfang" v-if="article.lname==='admin'" >官方认证</span>
              <span class="zishen" v-else-if="article.usersLevel===1">资深认证</span>
            </el-row>
            <el-row style="margin-top: 10px">
              <span>发布时间：{{article.atime}}</span>
            </el-row>
            <el-row style="margin-top: 10px">
              <el-button @click="addCollect(article.aid)"
                         style="background-color: #00BCD4;color: white;font-size: 15px">加入收藏夹
              </el-button>
            </el-row>
          </el-col>
        </el-row>
        <div style="margin-top: 20px">
          <span style="background-color: #00BCD4;padding: 10px;color: white;font-size: 15px">文章内容</span>
          <el-link @click="toUpdate()" style="float: right;color: red;font-size: 10px">编辑</el-link>
          <hr style="border-color: #00BCD4">
          <span style="line-height: 50px;font-size: 13px">{{article.amemo}}</span>
        </div>
        <div style="margin-top: 20px">
          <span style="background-color: #00BCD4;padding: 10px;color: white;font-size: 15px">评论列表</span>
          <hr style="border-color: #00BCD4">
          <div v-for="(discuss,index) in page.list" :key="index">
            <el-row>
              <el-col :span="2">
                <img :src="discuss.users.pic" style="width: 60px;border-radius: 60px">
              </el-col>
              <el-col :span="22">
                <el-row style="margin: 10px">
                  <span style="font-size: 12px;margin-right: 15px">发表人：{{discuss.lname}}</span>
                  <span style="font-size: 12px">发表时间：{{discuss.dtime}}</span>
                </el-row>
                <el-row style="margin: 10px">
                  <span style="font-size: 12px">评论内容：{{discuss.dmemo}}</span>
                </el-row>
              </el-col>
            </el-row>
            <el-divider></el-divider>
          </div>
          <el-pagination
            style="text-align: center"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="page.pageNum"
            :page-sizes="[2,3,4,5]"
            :page-size="page.pageSize"
            layout="total,sizes,prev,pager,next,jumper"
            :total="page.total"></el-pagination>
        </div>
        <div style="margin-top: 20px">
          <span style="background-color: #00BCD4;padding: 10px;color: white;font-size: 15px">发表评论</span>
          <hr style="border-color: #00BCD4">

          <el-form ref="form" :model="pinglun" :rules="rules" label-width="100px" label-position="right" size="mini">
            <el-form-item label="评论内容:" prop="content">
              <el-input type="textarea" :autosize="{ minRows: 10}" v-model="pinglun.content"></el-input>
            </el-form-item>
          </el-form>
          <div style="text-align: center" slot="footer" class="dialog-footer">
            <el-button style="background-color: #00BCD4;color: white;text-align: center" @click="toPingLun()">发表
            </el-button>
          </div>

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
        page: {},
        aid: 0,
        pageSize: 2,
        pinglun: {},
        rules: {
          content: [
            {
              required: true,
              message: '请输入评论内容',
              trigger: 'blur'
            },
            {
              min: 1,
              max: 500,
              message: '评论内容长度在1到500字符之间',
              trigger: 'blur'
            }
          ]
        }
      }
    },
    methods: {
      toUpdate() {
        this.$router.push('/frontHome/frontUserCenteruserbackgroundIndex/frontUserCenteruserbackgroundUpdateArticle?article=' +
          JSON.stringify(this.article))
      },
      toPingLun() {
        //判断是否登陆
        var username = sessionStorage.getItem("username")
        if (!username){
          alert("请先登录")
          this.$router.push('/frontHome/frontInfo/frontUserCenterLogin')
          return
        }

        var aid = this.article.aid
        var content = this.pinglun.content
        var formData = new FormData()
        formData.append('aid', aid)
        formData.append('content', content)
        this.$axios.post('front/protects/discuss/add', formData)
          .then(resp => {
            if (resp.data.code === 1) {
              this.$message({
                message: resp.data.msg,
                type: 'success'
              });
              location.reload()
            } else if (resp.data.code === 2) {
              this.$message.error(resp.data.msg);
            }
          })

      },
      addCollect(aid) {
        //判断是否登陆
        var username = sessionStorage.getItem("username")
        if (!username){
          alert("请先登录")
          this.$router.push('/frontHome/frontInfo/frontUserCenterLogin')
          return
        }
        this.$axios.get('front/protects/collect/add?aid=' + aid)
          .then(resp => {
            if (resp.data.code === 1) {
              this.$message({
                message: resp.data.msg,
                type: 'success'
              });
            } else if (resp.data.code === 2) {
              this.$message.error(resp.data.msg);
            }
          })
      },
      paging(curPage) {
        this.$axios.get('front/publics/discuss/list?curPage=' + curPage + '&pageSize=' + this.pageSize + '&aid=' + this.aid)
          .then(resp => {
            this.page = resp.data.data
          })
      },
      handleSizeChange(newSize) {
        this.pageSize = newSize
        this.paging(1)
      },
      handleCurrentChange(newPage) {
        this.paging(newPage)
      },
        reload() {
        this.article = JSON.parse(this.$route.query.article)
        this.aid = this.article.aid
        this.paging(1)
      },
    },

    watch: {
      '$route'(to, from) {
        this.reload()
      }
    },
    created() {
      this.reload()
    }
  }
</script>

<style scoped>
  .zishen {
    font-size: 1px;
    padding: 3px;
    color: white;
    background-color: #FD0201;
    font-weight:bold
  }
  .guanfang {
    font-size: 1px;
    padding: 3px;
    background-color: #FFDE66;
    color: red;
    font-weight:bold
  }
</style>
