<template>
  <div>
    <div>
      <el-row>
        <el-col :span="4" :offset="4" style="text-align: left">
          <span style="font-size: 13px;color: #747D87">医学百科管理平台，欢迎您的到来！</span>
        </el-col>
        <el-col :span="3" :offset="9" style="text-align: right">
          <div v-if="!isLogin">
            <el-button plain size="mini" @click="toRegister()">用户注册</el-button>
            <el-button plain type="danger" size="mini" @click="toLogin()">用户登录</el-button>
          </div>
          <div v-if="isLogin">
            欢迎你，{{username}}
            <el-button plain type="danger" size="mini" @click="logout()">退出登录</el-button>
          </div>
        </el-col>
      </el-row>
      <hr>
      <el-row>
        <el-col :span="4" :offset="4" style="text-align: left">
          <span @click="toIndex()" style="font-size: 30px;color: #00BCD4">医学百科管理平台</span>
        </el-col>
        <el-col :span="10" :offset="2">
          <el-row>
            <el-col :span="16" :offset="4">
              <el-input v-model="name" placeholder="请输入关键字">
                <el-button slot="append" icon="el-icon-search" @click="tofarticleLieBiaoByName(name)">搜索</el-button>
              </el-input>
            </el-col>
            <el-col :span="4">
              <el-button @click="faBufarticle()" plain type="danger">发布文章</el-button>
            </el-col>
          </el-row>
          <el-row style="margin-top: 5px">
            <el-col style="text-align: left" :offset="4">
              <span style="font-size: 14px;">热搜：
                <el-link :key="index" style="margin-left: 10px" :underline="false" v-for="(reSou,index) in reSouList"
                         v-if="index<5" @click="tofarticleLieBiaoByName(reSou.rname)">{{reSou.rname}}</el-link></span>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
      <el-row style="margin-top: 5px">
        <el-col :span="24" style="background-color: #00BCD4">
          <div style="margin: 15px">
            <span @click="toIndex()" class="daohang"
                  style="color: white;font-size: 15px;padding: 15px 40px;">网站首页</span>
            <span @click="toXinWenLieBiao()" class="daohang" style="color: white;font-size: 15px;padding: 15px 40px;">医学新闻</span>
            <span @click="tofarticleLieBiao(fenLei.tid)" class="daohang"
                  style="color: white;font-size: 15px;padding: 15px 40px;" :key="index"
                  v-for="(fenLei,index) in fenLeiList">{{fenLei.tname}} </span>
            <span @click="tousercenter()" class="daohang" style="color: white;font-size: 15px;padding: 15px 40px;">用户中心</span>
            <span @click="toAdmin()" class="daohang" style="color: white;font-size: 15px;padding: 15px 40px;">管理员中心</span>
          </div>

        </el-col>
      </el-row>
    </div>
    <div>
      <router-view></router-view>
    </div>
    <div style="margin-top: 20px">
      <img src="../../../../../../MedSys/MedSys_front/src/assets/foot.png">
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        name: '',
        reSouList: [],
        fenLeiList: [],
        isLogin: false,
        username: ''
      }
    },
    methods: {
      faBufarticle(){
        this.$router.push('/frontHome/frontusercenterUserbackgroundIndex/frontusercenterUserbackgroundPublicArticle')
      },
      tousercenter() {
        this.$router.push('/frontHome/frontusercenterUserbackgroundIndex')
      },
      toAdmin() {
        this.$router.push('/backLogin')
      },
      toRegister() {
        this.$router.push('/frontHome/frontInfo/frontusercenterRegister')
      },
      toLogin() {
        this.$router.push('/frontHome/frontInfo/frontusercenterLogin')
      },
      tofarticleLieBiaoByName(name) {
        this.$axios.get("/front/publics/records/add?name=" + name)
        this.$router.push('/frontHome/frontInfo/frontfarticleList?name=' + name)
      },
      toIndex() {
        this.$router.push('/frontHome')
      },
      toXinWenLieBiao() {
        this.$router.push('/frontHome/frontInfo/frontfmedicalnewsList')
      },
      tofarticleLieBiao(tid) {
        this.$router.push('/frontHome/frontInfo/frontfarticleList?tid=' + tid)
      },
      logout() {
        this.$confirm('您确定要退出登录吗？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$axios.get('/front/protects/users/logout')
            .then(resp => {
              if (resp.data.code === 1) {
                sessionStorage.removeItem("username")
                this.username = ''
                this.isLogin = false
                this.$router.push('/frontHome/frontIndex')
              }
            })
          this.$message({
            type: 'success',
            message: '退出成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消退出'
          });
        });
      },

      getReSou() {
        this.$axios.get("front/publics/records/getReSou")
          .then(resp => {
            this.reSouList = resp.data.data
          })
      },
      getFenLei() {
        this.$axios.get("front/publics/atype/findAll")
          .then(resp => {
            this.fenLeiList = resp.data.data
          })
      },
      seeLoginStatus() {
        var username = sessionStorage.getItem("username")
        if (username) {
          this.username = username
          this.isLogin = true
        }else {
          this.username = ''
          this.isLogin = false
        }
      },
      load() {
        this.getReSou()
        this.getFenLei()
        this.seeLoginStatus()
      }
    },
    created() {
      this.load()
    },
    watch: {
      '$route'(to, from) {
        this.load()
      }
    }
  }
</script>

<style scoped>
  .daohang:hover {
    background-color: #1784DB;
  }
</style>
