<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">管理文章分类信息</p>
      </div>
      <div style="min-height: 600px">
        <el-row>
          <el-col :span="24">
            <el-table :data="page.list" stripe style="width: 100%;">
              <el-table-column prop="tname" label="类别名称" width=""></el-table-column>
              <el-table-column prop="isNeedVip" label="vip特权(1代表是)" width=""></el-table-column>
              <el-table-column>
                <template slot-scope="scope">
                  <el-button type="warning" icon="el-icon-edit" size="mini" circle
                             @click="update(scope.row)"></el-button>
                  <el-button type="danger" icon="el-icon-delete" size="mini" circle
                             @click="del(scope.row.tid)"></el-button>
                </template>
              </el-table-column>
            </el-table>
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="page.pageNum"
              :page-sizes="[10,20,30,80]"
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
        pageSize: 10,
      }
    },
    methods: {
      paging(curPage) {
        this.$axios.get('back/atype/list?curPage=' + curPage + '&pageSize=' + this.pageSize)
          .then(resp => {
            this.page = resp.data.data
          })
      },
      update(atype) {
        this.$router.push('/backHome/backarticlecategoriesUpdate?atype=' + JSON.stringify(atype))
      },
      del(tid) {
        this.$confirm('此操作将永久删除该文记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$axios.get('back/atype/del?tid=' + tid)
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
