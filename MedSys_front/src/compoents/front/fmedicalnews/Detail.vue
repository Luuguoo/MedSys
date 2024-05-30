<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">医学新闻详情</p>
      </div>
      <div style="line-height: normal;">
        <el-row>
          <el-col>
            <span style="font-size: 25px">{{news.title}}</span>
          </el-col>
        </el-row>
        <el-row>
          <el-col>
            <span style="font-size: 10px">发布时间：{{news.addtime}}</span>
          </el-col>
        </el-row>
        <el-row>
          <el-col>
            <span style="font-size: 13px">{{news.detail}}</span>
          </el-col>
        </el-row>
      </div>
    </el-card>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        news:{}
      }
    },
    methods: {},
    created() {
      this.news = JSON.parse(this.$route.query.news)
    }
  }
</script>

<style scoped>

</style>
