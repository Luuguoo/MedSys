<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">医学新闻列表</p>
      </div>
      <div style="min-height: 600px">
        <div>
          <el-row v-for="(news,index) in page.list" :key="index">
            <el-col :span="12" style="text-align: left">
              <span class="xinwen" @click="toDetail(news)">{{news.title}}</span>
            </el-col>
            <el-col :span="12" style="text-align: right">发布时间：{{news.addtime}}</el-col>
            <el-divider></el-divider>
          </el-row>

        </div>
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="page.pageNum"
          :page-sizes="[2,3,4,5]"
          :page-size="page.pageSize"
          layout="total,sizes,prev,pager,next,jumper"
          :total="page.total"></el-pagination>
      </div>
    </el-card>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        pageSize: 3,
        page: {}
      }
    },
    methods: {
      paging(curPage) {
        this.$axios.get('front/publics/news/list?curPage=' + curPage + '&pageSize=' + this.pageSize)
          .then(resp => {
            this.page = resp.data.data
            console.log(this.page)
          })
      },
      toDetail(news){
        this.$router.push('/frontHome/frontInfo/frontfmedicalnewsDetail?news=' + JSON.stringify(news))

      },
      handleSizeChange(newSize) {
        this.pageSize = newSize
        this.paging(1)
      },
      handleCurrentChange(newPage) {
        this.paging(newPage)
      }
    },
    created() {
      this.paging(1)
    }
  }
</script>

<style scoped>
  .xinwen:hover {
    color: #1784DB;
  }
</style>
