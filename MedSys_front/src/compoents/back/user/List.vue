<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">管理用户信息</p>
      </div>
      <div style="min-height: 600px">
        <el-row>
          <el-col :span="24">
            <el-card>
              <el-row :gutter="20">
                <el-col :span="5">
                  <el-input v-model="lname" placeholder="用户名"></el-input>
                </el-col>
                <el-col :span="5">
                  <el-input v-model="username" placeholder="姓名"></el-input>
                </el-col>
                <el-col :span="6">
                  <el-button icon="el-icon-search" @click="paging(1)">搜索</el-button>
                </el-col>
              </el-row>
            </el-card>
            <el-table :data="page.list" stripe style="width: 100%;">
              <el-table-column prop="lname" label="用户名" width=""></el-table-column>
              <el-table-column prop="password" label="密码" width=""></el-table-column>
              <el-table-column prop="username" label="真实姓名" width=""></el-table-column>
              <el-table-column prop="sex" label="性别" width=""></el-table-column>
              <el-table-column prop="tel" label="电话" width=""></el-table-column>
              <el-table-column label="头像">
                <template slot-scope="scope">
                  <img :src="scope.row.pic" width="80px">
                </template>
              </el-table-column>
              <el-table-column prop="regdate" label="注册时间" width=""></el-table-column>
              <el-table-column>
                <template slot-scope="scope">
                  <el-button type="warning" icon="el-icon-edit" size="mini" circle
                             @click="update(scope.row)"></el-button>
                  <el-button type="danger" icon="el-icon-delete" size="mini" circle
                             @click="del(scope.row.lname)"></el-button>
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
        lname: '',
        username: '',
        visible: [],
      }
    },
    methods: {
      paging(curPage) {
        this.$axios.get('back/users/list?curPage=' + curPage + '&lname=' + this.lname + '&username=' + this.username + '&pageSize=' + this.pageSize)
          .then(resp => {
            this.page = resp.data.data
            console.log(resp.data.data)
          })
      },

      update(users) {
        this.$router.push('/backHome/backuserUpdate?users=' + JSON.stringify(users))
      },
      del(lname) {
        this.$confirm('此操作将永久删除该文记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$axios.get('back/users/del?lname=' + lname)
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
