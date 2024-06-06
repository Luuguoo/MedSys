<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">已审核文章修改</p>
      </div>
      <div style="min-height: 600px">
        <el-row>
          <el-col :span="24">
            <el-card>
              <el-row :gutter="20">
                <el-col :span="5">
                  <el-input v-model="name" placeholder="用户名"></el-input>
                </el-col>
                <el-col :span="6">
                  <el-button icon="el-icon-search" @click="paging(1)">搜索</el-button>
                </el-col>
              </el-row>
            </el-card>
            <el-table :data="page.list" stripe style="width: 100%;">
              <el-table-column prop="aid" label="文章ID" width=""></el-table-column>
              <el-table-column prop="lname" label="用户名" width=""></el-table-column>
              <el-table-column prop="atime" label="提交时间" width=""></el-table-column>
              <el-table-column prop="flag" label="审核结果" width=""></el-table-column>
              <el-table-column label="操作">
                <template slot-scope="scope">
                  <el-button type="primary" icon="el-icon-more-outline" size="mini" circle
                             @click="toDetail(scope.row)"></el-button>
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
        name: '',
        check:'已审核',
        visible: [],
      }
    },
    methods: {
      paging(curPage) {
        this.$axios.get('back/applys/list?curPage=' + curPage + '&check=' + this.check+ '&name=' + this.name + '&pageSize=' + this.pageSize)
          .then(resp => {
            this.page = resp.data.data
          })
      },
      toDetail(applys){
        this.$router.push('/backHome/backarticlerevisionauditedDetail?applys=' + JSON.stringify(applys))
      },
      del(id) {
        this.$confirm('此操作将永久删除该文记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$axios.get('back/applys/del?id=' + id)
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
