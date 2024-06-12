<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">管理友情链接信息</p>
      </div>
      <div style="min-height: 600px">
        <el-row>
          <el-col :span="24">
            <el-table :data="page.list" stripe style="width: 100%;">
              <el-table-column prop="title" label="网站名称" width=""></el-table-column>
              <el-table-column prop="http" label="网址" width=""></el-table-column>
              <el-table-column>
                <template slot-scope="scope">
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
      }
    },
    methods: {
      paging(curPage) {
        this.$axios.get('back/flink/list?curPage=' + curPage +'&pageSize=' + this.pageSize)
          .then(resp => {
            this.page = resp.data.data
          })
      },
      update(flink) {
        this.$router.push('/backHome/backlinkUpdate?flink=' + JSON.stringify(flink))
      },
      del(id) {
        this.$confirm('此操作将永久删除该文记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$axios.get('back/flink/del?id=' + id)
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
