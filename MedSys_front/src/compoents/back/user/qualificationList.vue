<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">审核用户升级</p>
      </div>
      <div style="min-height: 600px">
        <el-row>
          <el-col :span="24">
            <el-table :data="page.list" stripe style="width: 100%;">
              <el-table-column prop="id" label="序号" width=""></el-table-column>
              <el-table-column prop="lname" label="用户名" width=""></el-table-column>
              <el-table-column label="资格证">
                <template slot-scope="scope">
                  <div class="demo-image__preview">
                    <el-image
                      style="width: 100px; height: 100px"
                      :src="scope.row.pic"
                      :preview-src-list="[scope.row.pic]">
                    </el-image>
                  </div>
                </template>
              </el-table-column>
              <el-table-column width="400px" label="操作">
                <template slot-scope="scope">
                  <el-button type="warning" size="mini" round
                             @click="check(scope.row.id,'1')">审核通过
                  </el-button>
                  <el-button type="info" size="mini" round
                             @click="check(scope.row.id,'2')">审核不通过
                  </el-button>
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
        this.$axios.get('/back/qualification/list?curPage=' + curPage + '&pageSize=' + this.pageSize)
          .then(resp => {
            this.page = resp.data.data
          })
      },
      check(id,checkResult){
        this.$axios.get('back/qualification/check?id=' + id+'&checkResult='+checkResult)
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
