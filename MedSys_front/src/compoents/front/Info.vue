<template>
  <div style="margin-top: 20px">
    <el-row>
      <el-col :span="11" :offset="4">
        <router-view></router-view>
      </el-col>
      <el-col :span="4" :offset="1">
        <el-row>
          <el-col>
            <el-card style="border-radius: 20px;min-height: 300px">
              <div slot="header" class="clearfix">
                <span style="float: left;color: #00BCD4">热搜关键词</span>
                <el-button type="text" plain style="float: right; padding: 3px 0" @click="outPut()">导出为excel</el-button>
              </div>
              <div style="margin: 5px">
                <div class="resou" :key="index"
                     v-for="(reSou,index) in reSouList" v-if="index<20" @click="tofarticleLieBiaoByName(reSou.rname)">
                  {{reSou.rname}}({{reSou.count}})
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>
        <el-row>
          <el-col>
            <el-card style="border-radius: 20px;min-height: 250px;margin-top: 20px">
              <div slot="header" class="clearfix">
                <span style="float: left;color: #00BCD4">最新文章</span>
              </div>
              <div style="margin: 5px 0px">
                <div style="margin: 5px" :key="index"
                     v-for="(article,index) in articleList">
                  <div @click="toDetail(article)">
                    <el-row>
                      <el-col :span="3" style="text-align: left">
                        <div style="float: left;padding: 2px 8px;color: white;background-color: red">{{index+1}}</div>
                      </el-col>
                      <el-col class="newArticle" :span="10" style="text-align: left">{{article.title}}</el-col>
                      <el-col :span="11" style="text-align: right">{{article.atime}}</el-col>
                    </el-row>
                  </div>

                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        reSouList: [],
        articleList: []
      }
    },
    methods: {
      outPut() {
        //判断是否登陆
        var username = sessionStorage.getItem("username")
        if (!username){
          alert("请先登录")
          this.$router.push('/frontHome/frontInfo/frontusercenterLogin')
          return
        }

        this.$axios.get("/front/protects/users/getInfo")
          .then(resp => {
            var users = resp.data.data
            if (users.level === 0) {
              this.$alert('需要成为资深VIP才能享有下载热搜关键词等特权', '抱歉', {
                confirmButtonText: '确定',
              });
            } else if (users.level === 1) {
              this.$alert('你为尊敬的资深VIP享有下载热搜关键词等特权，点击确定进行下载', '尊敬的VIP您好', {
                confirmButtonText: '确定',
                callback: action => {
                  if (action==="confirm"){
                    window.open(this.$baseVar.baseURL+"front/protects/users/download")
                  }
                }
              });
            }
          })
      },
      tofarticleLieBiaoByName(name) {
        this.$axios.get("/front/publics/records/add?name=" + name)
        this.$router.push('/frontHome/frontInfo/frontfarticleList?name=' + name)
      },
      toDetail(article) {
        this.$router.push('/frontHome/frontInfo/frontfarticleDetail?article=' + JSON.stringify(article))

      },
      getTrending() {
        this.$axios.get("front/publics/records/getTrending")
          .then(resp => {
            this.reSouList = resp.data.data
          })
      },
      getArticleTop6() {
        this.$axios.get("/front/publics/article/getArticleTop6")
          .then(resp => {
            this.articleList = resp.data.data
            this.articleList.forEach(article => {
              article.atime = article.atime.substring(article.atime.indexOf('-') + 1, article.atime.indexOf(' '))
            })
          })
      },

    },
    created() {
      this.getTrending()
      this.getArticleTop6()
    }
  }
</script>

<style scoped>
  .resou:hover {
    background-color: #1784DB;
  }

  .newArticle:hover {
    color: #1784DB;
  }

  .resou {
    height: 20px;
    background-color: #F1F1F1;
    margin: 2px;
    float: left;
    font-size: 15px;
    padding: 5px 5px;
  }
</style>
