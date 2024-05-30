<template>
  <div style="margin-top: 15px">
    <el-row>
      <el-col :offset="4" :span="16">
        <el-row style="">
          <el-col :span="5" style="background-color: #F1F1F1;border-radius: 20px">
            <div class="daohang public">
              导航菜单
            </div>
            <div class="public caidan" v-for="(item,index) in menu" :key="index" @click="toPage(item.index)">
              {{item.text}}
            </div>
          </el-col>
          <el-col :span="18" :offset="1">
            <router-view></router-view>
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
        menu: [
          {
            text: '后台首页',
            index: 0
          },
          {
            text: '发布文章',
            index: 1
          },
          {
            text: '我的文章',
            index: 2
          },
          {
            text: '我的文章修改',
            index: 3
          },
          {
            text: '和我的评论',
            index: 4
          },
          {
            text: '我的收藏夹',
            index: 5
          },
          {
            text: '修改个人信息',
            index: 6
          },
          {
            text: '修改密码',
            index: 7
          },
          {
            text: '退出登录',
            index: 8
          },

        ]

      }
    },
    methods: {
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
      toPage(index) {
        if (index === 0) {
          this.$router.push('/frontHome/frontUserCenterUserbackgroundIndex/frontUserCenterUserbackgroundUserInfo')
        } else if (index === 1) {
          this.$router.push('/frontHome/frontUserCenterUserbackgroundIndex/frontUserCenterUserbackgroundPublicArticle')
        } else if (index === 2) {
          this.$router.push('/frontHome/frontUserCenterUserbackgroundIndex/frontUserCenterUserbackgroundMyArticle')
        } else if (index === 3) {
          this.$router.push('/frontHome/frontUserCenterUserbackgroundIndex/frontUserCenterUserbackgroundMyArticleUpdateList')
        } else if (index === 4) {
          this.$router.push('/frontHome/frontUserCenterUserbackgroundIndex/frontUserCenterUserbackgroundMyDiscuss')
        } else if (index === 5) {
          this.$router.push('/frontHome/frontUserCenterUserbackgroundIndex/frontUserCenterUserbackgroundMyCollect')
        } else if (index === 6) {
          this.$router.push('/frontHome/frontUserCenterUserbackgroundIndex/frontUserCenterUserbackgroundUpdateUsers')
        } else if (index === 7) {
          this.$router.push('/frontHome/frontUserCenterUserbackgroundIndex/frontUserCenterUserbackgroundUpdatePassword')
        } else if (index === 8) {
          this.logout()
        }

      }
    }
  }
</script>

<style scoped>
  .daohang {
    background-color: #00BCD4
  }

  .public {
    border: 1px solid black;
    margin: 20px;
    padding: 15px 0px;
  }

  .caidan:hover {
    background-color: #00BCD4
  }
</style>
