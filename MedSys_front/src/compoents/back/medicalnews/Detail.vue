<template>
    <div>
      <el-card class="box-card" shadow="always" style="border-radius: 20px;">
        <div slot="header" class="clearfix" >
          <p align="left" style="font-size: 20px">查看医学新闻信息</p>
        </div>
        <div style="min-height: 600px">
          <el-card style="border-radius: 20px;background-image: linear-gradient(#BAF5DE, #FFFFFF);">
            <table border="1px" cellpadding="10px" style="border-collapse: collapse; border-radius: 20px">
              <tr>
                <td width="200px" align="right">标题:</td>
                <td align="left">{{news.title}}</td>
              </tr>
              <tr>
                <td align="right">内容:</td>
                <td align="left">{{news.detail}}</td>
              </tr>
              <tr>
                <td align="right">发布时间:</td>
                <td align="left">{{news.addtime}}</td>
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
      data(){
        return{
          news:{}
        }
      },
      methods:{
        toList(){
          this.$router.push('/backHome/backmedicalnewsList')
        }
      },
      created() {
        console.log(this.$route.query.news)
        this.news = JSON.parse(this.$route.query.news)
      }
    }
</script>

<style scoped>

</style>
