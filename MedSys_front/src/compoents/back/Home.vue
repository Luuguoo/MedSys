<template>
  <el-container>
    <el-header>
      <el-row>
        <el-col :span="1">
          <img style="width: 50px;height: 50px;margin-top: 5px;border-radius: 50%"
               :src="headPhoto"></img>
        </el-col>
        <el-col :span="1">
          <el-popover
            placement="bottom"
            trigger="click">
            <table>
              <tr>
                <td>
                  <el-link :underline="false" @click="systemUpdate">修改密码</el-link>
                </td>
              </tr>
              <tr>
                <td>
                  <el-link :underline="false" @click="logout">退出</el-link>
                </td>
              </tr>
            </table>
            <div slot="reference" style="margin-top: 15px;margin-left: -2px">
              <el-row>
                {{lname}}
              </el-row>
              <el-row>
                管理员<i class="el-icon-caret-bottom"></i>
              </el-row>
            </div>
          </el-popover>
        </el-col>
        <el-col :span="21">
          <h1>欢迎来到医学知识科普平台</h1>
        </el-col>
        <el-col :span="1">
          <i class="el-icon-full-screen" style="margin-top: 19px" @click="logout">退出</i>
        </el-col>
      </el-row>
    </el-header>
    <el-container style="background-image: linear-gradient(#BAF5DE, #FFFFFF);">
      <el-aside width="210px">
        <el-row>
          <el-col>
            <el-menu
              style="text-align: left;background-image: linear-gradient(#BAF5DE, #FFFFFF);"
              :unique-opened=true
              default-active="2"
              class="el-menu-vertical-demo"
              @open="handleOpen"
              @close="handleClose">
              <el-submenu index="0">
                <template slot="title">
                  <div @click="toFrontHome">
                    <i class="el-icon-s-home"></i>
                    <span>网站首页</span>
                  </div>
                </template>
              </el-submenu>
              <el-submenu index="1">
                <template slot="title">
                  <i class="el-icon-s-management"></i>
                  <span>用户管理</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="1-1" @click="userAdd">添加用户</el-menu-item>
                  <el-menu-item index="1-2" @click="userList">管理用户</el-menu-item>
                  <el-menu-item index="1-3" @click="userShenHe">审核用户</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <el-submenu index="2">
                <template slot="title">
                  <i class="el-icon-s-management"></i>
                  <span>医学新闻管理</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="2-1" @click="medicalnewsAdd">添加医学新闻</el-menu-item>
                  <el-menu-item index="2-2" @click="medicalnewsList">管理医学新闻</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <el-submenu index="3">
                <template slot="title">
                  <i class="el-icon-s-management"></i>
                  <span>文章分类管理</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="3-1" @click="articlecategoriesAdd">添加文件分类</el-menu-item>
                  <el-menu-item index="3-2" @click="articlecategoriesList">管理文件分类</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <el-submenu index="4">
                <template slot="title">
                  <i class="el-icon-s-management"></i>
                  <span>文章管理</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="4-1" @click="articleAdd">添加文章</el-menu-item>
                  <el-menu-item index="4-2" @click="articleCheck">审核文章</el-menu-item>
                  <el-menu-item index="4-3" @click="articleList">管理文章</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <el-submenu index="5">
                <template slot="title">
                  <i class="el-icon-s-management"></i>
                  <span>文章修改管理</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="5-1" @click="articlerevisionUnauditedList">待审核文章修改</el-menu-item>
                  <el-menu-item index="5-2" @click="articlerevisionauditedList">已审核文章修改</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <el-submenu index="6">
                <template slot="title">
                  <i class="el-icon-s-management"></i>
                  <span>文章评论管理</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="6-1" @click="articlereviewList">管理文章评论</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <el-submenu index="7">
                <template slot="title">
                  <i class="el-icon-s-management"></i>
                  <span>友情链接管理</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="7-1" @click="linkAdd">添加友情链接</el-menu-item>
                  <el-menu-item index="7-2" @click="linkList">管理友情链接</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <el-submenu index="8">
                <template slot="title">
                  <i class="el-icon-s-management"></i>
                  <span>系统管理</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="8-1" @click="systemUpdate">修改密码</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
            </el-menu>
          </el-col>
        </el-row>
      </el-aside>
      <el-container>
        <el-main>
          <router-view></router-view>
        </el-main>
        <el-footer>
          <div style="float: left">Powered by 医学知识科普平台</div>
          <div style="float: right;">当前时间：{{time}}</div>
          <div style="margin-top: 20px">
<!--            <img src="../../../../../../MedSys/MedSys_front/src/assets/foot.png">-->
          </div>
        </el-footer>
      </el-container>
    </el-container>
  </el-container>
</template>

<script>
  export default {
    data() {
      return {
        lname: localStorage.getItem("lname"),
        time: {},
        headPhoto: this.$baseVar.baseURL + 'static/image/profile_small.jpg'
      }
    },
    methods: {
      toFrontHome() {
        this.$router.push('/frontHome')
      },
      systemUpdate() {
        this.$router.push('/backHome/backsystemUpdate')
      },
      linkAdd() {
        this.$router.push('/backHome/backlinkAdd')
      },
      linkList() {
        this.$router.push('/backHome/backlinkList')
      },
      articlereviewList() {
        this.$router.push('/backHome/backarticlereviewList')
      },
      articlerevisionUnauditedList() {
        this.$router.push('/backHome/backarticlerevisionUnauditedList')
      },
      articlerevisionauditedList() {
        this.$router.push('/backHome/backarticlerevisionauditedList')
      },

      medicalnewsAdd() {
        this.$router.push('/backHome/backmedicalnewsAdd')
      },
      medicalnewsList() {
        this.$router.push('/backHome/backmedicalnewsList')
      },
      articleAdd() {
        this.$router.push('/backHome/backarticleAdd')
      },
      articleList() {
        this.$router.push('/backHome/backarticleList')
      },
      articleCheck() {
        this.$router.push('/backHome/backarticleCheck')
      },
      articlecategoriesAdd() {
        this.$router.push('/backHome/backarticlecategoriesAdd')
      },
      articlecategoriesList() {
        this.$router.push('/backHome/backarticlecategoriesList')
      },

      userAdd() {
        this.$router.push('/backHome/backuserAdd')
      },
      userList() {
        this.$router.push('/backHome/backuserList')
      },
      userShenHe() {
        this.$router.push('/backHome/backuserQualificationList')
      },
      logout() {
        this.$confirm('您确定要退出登录吗？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$axios.get('back/logout')
            .then(resp => {
              if (resp.data.code === 1) {
                sessionStorage.removeItem("lname")
                this.$router.push('/backLogin')
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
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      getTime() {
        this.time = new Date().format("yyyy-MM-dd hh:mm:ss");
      }
    },
    created() {
      this.getTime()
      this.timer = window.setInterval(() => {
        setTimeout(this.getTime(), 0);
      }, 1000);
    }
  }

</script>

<style scoped>
  /*//侧边框*/
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    width: 200px;
    min-height: 880px;

  }


  /*分模块样式*/
  .el-header {
    background-color: #000000;
    color: #FFFFFF;
    text-align: center;
    /*line-height: 60px;*/
  }

  .el-footer {
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    text-align: center;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>

