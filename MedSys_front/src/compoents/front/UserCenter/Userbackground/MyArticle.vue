<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">我的文章</p>
      </div>
      <div style="min-height: 600px">
        <el-row>
          <el-col :span="24">
            <el-table :data="page.list" stripe style="width: 100%;">
              <!--<el-table-column prop="atype.tname" label="文章分类" width=""></el-table-column>-->
              <el-table-column prop="title" label="文章标题" width=""></el-table-column>
              <el-table-column label="文章图片">
                <template slot-scope="scope">
                  <img :src="scope.row.photo" width="80px">
                </template>
              </el-table-column>
              <!--<el-table-column prop="lname" label="发布人" width=""></el-table-column>-->
              <el-table-column prop="atime" label="发布时间" width=""></el-table-column>
              <el-table-column prop="flag" label="审核状态" width=""></el-table-column>
              <el-table-column>
                <template slot-scope="scope">
                  <el-button type="primary" icon="el-icon-more-outline" size="mini" circle
                             @click="toDetail(scope.row)"></el-button>
                  <el-button type="danger" icon="el-icon-delete" size="mini" circle
                             @click="del(scope.row.aid)"></el-button>
                </template>
              </el-table-column>
            </el-table>
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="page.pageNum"
              :page-sizes="[2,3,4,5]"
              :page-size="page.pageSize"
              layout="total,sizes,prev,pager,next,jumper"
              :total="page.total"></el-pagination>
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
        page: {},
        pageSize: 3,
      }
    },
    methods: {
      paging(curPage) {
        this.$axios.get('front/protects/article/list?curPage=' + curPage + '&pageSize=' + this.pageSize)
          .then(resp => {
            this.page = resp.data.data
          })
      },
      toDetail(article) {
        this.$router.push('/frontHome/frontUserCenterUserbackgroundIndex/frontUserCenterUserbackgroundMyArticleDetail?article=' + JSON.stringify(article))
      },
      del(aid) {
        this.$confirm('此操作将永久删除该文记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$axios.get('front/protects/article/del?aid=' + aid)
            .then(resp => {
              if (resp.data.code === 1) {
                this.$message({
                  type: 'success',
                  message: resp.data.msg
                });
              } else {
                this.$message.error(resp.data.msg);
              }
              this.paging(1)
              // this.paging(this.page.pages==1?1:(this.page.pageNum==this.page.pages?this.page.pageNum-1:this.page.pageNum))
            })

        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
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

</style>
