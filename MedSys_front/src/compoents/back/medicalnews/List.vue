<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">管理医学新闻信息</p>
      </div>
      <div style="min-height: 600px">
        <el-row>
          <el-col :span="24">
            <el-card>
              <el-row :gutter="20">
                <el-col :span="5">
                  <el-input v-model="name" placeholder="标题"></el-input>
                </el-col>
                <el-col :span="6">
                  <el-button icon="el-icon-search" @click="paging(1)">搜索</el-button>
                </el-col>
              </el-row>
            </el-card>
            <el-table :data="page.list" stripe style="width: 100%;">
              <el-table-column prop="title" label="标题" width=""></el-table-column>
              <el-table-column prop="addtime" label="添加时间" width=""></el-table-column>
              <el-table-column>
                <template slot-scope="scope">
                  <el-button type="primary" icon="el-icon-more-outline" size="mini" circle
                             @click="toDetail(scope.row)"></el-button>
                  <el-button type="warning" icon="el-icon-edit" size="mini" circle
                             @click="update(scope.row)"></el-button>
                  <el-button type="danger" icon="el-icon-delete" size="mini" circle
                             @click="del(scope.row.id)"></el-button>
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
        name: ''
      }
    },
    methods: {
      paging(curPage) {
        this.$axios.get('back/news/list?curPage=' + curPage + '&name=' + this.name + '&pageSize=' + this.pageSize)
          .then(resp => {
            this.page = resp.data.data
          })
      },
      toDetail(news){
        this.$router.push('/backHome/backmedicalnewsDetail?news=' + JSON.stringify(news))
      },
      update(news) {
        this.$router.push('/backHome/backmedicalnewsUpdate?news=' + JSON.stringify(news))
      },
      del(id) {
        this.$confirm('此操作将永久删除该文记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$axios.get('back/news/del?id=' + id)
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
