<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">查看文章修改信息</p>
      </div>
      <div style="min-height: 600px">
        <el-card style="border-radius: 20px;background-image: linear-gradient(#BAF5DE, #FFFFFF);">
          <table border="1px" cellpadding="10px" style="border-collapse: collapse; border-radius: 20px">
            <tr>
              <td width="200px" align="right">文章ID:</td>
              <td align="left">{{applys.article.aid}}</td>
            </tr>
            <tr>
              <td width="200px" align="right">文章标题:</td>
              <td align="left">{{applys.article.title}}</td>
            </tr>
            <tr>
              <td width="200px" align="right">文章图片:</td>
              <td align="left"><img :src="applys.article.photo" width="300px"></td>
            </tr>
            <tr>
              <td width="200px" align="right">文章内容:</td>
              <td align="left">{{applys.article.amemo}}</td>
            </tr>
            <tr>
              <td width="200px" align="right">用户名:</td>
              <td align="left">{{applys.lname}}</td>
            </tr>

            <tr>
              <td align="right">修改后的内容:</td>
              <td align="left">{{applys.xmemo}}</td>
            </tr>
            <tr>
              <td align="right">提交时间:</td>
              <td align="left">{{applys.atime}}</td>
            </tr>
            <tr>
              <td align="right">审核结果:</td>
              <td align="left">{{applys.flag}}</td>
            </tr>
            <tr>
              <td align="right"></td>
              <td align="left">
                <el-button type="warning" @click="toList" size="mini">返回</el-button>
              </td>
            </tr>
          </table>
        </el-card>
      </div>
    </el-card>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        applys: {}
      }
    },
    methods: {
      toList() {
        this.$router.push('/backHome/backArticleRevisionAuditedList')
      }
    },
    created() {
      console.log(this.$route.query.applys)
      this.applys = JSON.parse(this.$route.query.applys)
    }
  }
</script>

<style scoped>

</style>
