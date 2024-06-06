<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">查看文章信息</p>
      </div>
      <div style="min-height: 600px">
        <el-card style="border-radius: 20px;background-image: linear-gradient(#BAF5DE, #FFFFFF);">
          <table border="1px" cellpadding="10px" style="border-collapse: collapse; border-radius: 20px">
            <tr>
              <td width="200px" align="right">文章标题:</td>
              <td align="left">{{article.title}}</td>
            </tr>
            <tr>
              <td width="200px" align="right">文章图片:</td>
              <td align="left"><img :src="article.photo" width="300px"></td>
            </tr>
            <tr>
              <td width="200px" align="right">文章内容:</td>
              <td align="left">{{article.amemo}}</td>
            </tr>
            <tr>
              <td align="right">发布时间:</td>
              <td align="left">{{article.atime}}</td>
            </tr>
            <tr>
              <td align="right">审核状态:</td>
              <td align="left">{{article.flag}}</td>
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
        article: {},
      }
    },
    methods: {
      toList() {
        this.$router.push('/frontHome/frontusercenteruserbackgroundIndex/frontusercenteruserbackgroundMyArticle')
      }
    },
    created() {
      this.article = JSON.parse(this.$route.query.article)
    }
  }
</script>

<style scoped>

</style>
