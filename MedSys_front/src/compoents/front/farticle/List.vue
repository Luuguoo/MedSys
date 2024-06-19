<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">文章列表</p>
      </div>
      <div style="min-height: 600px">
        <div @click="toDetail(article)" v-for="(article,index) in page.list" :key="index">
          <el-row>
            <el-col :span="8">
              <img :src="article.photo" style="width: 150px">
            </el-col>
            <el-col :span="16" style="text-align: left">
              <el-row style="margin-bottom: 10px">
                <span style="font-size: 17px">{{article.title}}</span>
                <span class="guanfang" v-if="article.lname==='admin'">官方认证</span>
                <span class="zishen" v-else-if="article.usersLevel===1">资深认证</span>
              </el-row>
              <el-row>
                <span style="font-size: 13px;color: #666666">{{article.amemo| ellipsis}}</span>
              </el-row>
              <el-row style="margin-top: 10px">
                <span style="font-size: 10px">发布时间：{{article.atime}}</span>
              </el-row>
            </el-col>
          </el-row>
          <el-divider></el-divider>
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
        tid: 1,
        title: '',
        page: {}
      }
    },
    filters: {
      //超过100位显示 ...
      ellipsis: function (value) {
        if (!value) return "";
        if (value.length > 100) {
          return value.slice(0, 100) + "...";
        }
        return value;
      }
    },
    methods: {
      paging(curPage) {
        this.$axios.get('front/publics/article/list?curPage=' + curPage + '&pageSize=' + this.pageSize + '&tid=' + this.tid + '&title=' + this.title)
          .then(resp => {
            this.page = resp.data.data
          })
      },
      toDetail(article) {
        this.$router.push('/frontHome/frontInfo/frontfarticleDetail?article=' + JSON.stringify(article))

      },
      handleSizeChange(newSize) {
        this.pageSize = newSize
        this.paging(1)
      },
      handleCurrentChange(newPage) {
        this.paging(newPage)
      },
      load() {
        if (this.$route.query.tid) {
          this.tid = this.$route.query.tid
        } else {
          this.tid = 0
        }
        if (this.$route.query.name) {
          this.title = this.$route.query.name
        } else {
          this.title = ''
        }
        this.paging(1)
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
  .xinwen:hover {
    color: #1784DB;
  }

  .zishen {
    font-size: 13px;
    padding: 3px;
    color: white;
    background-color: #FD0201;
    font-weight: bold
  }

  .guanfang {
    font-size: 13px;
    padding: 3px;
    background-color: #FFDE66;
    color: red;
    font-weight: bold
  }
</style>
