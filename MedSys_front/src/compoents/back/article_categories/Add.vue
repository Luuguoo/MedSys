<template>
  <div>
    <el-card class="box-card" shadow="always" style="border-radius: 20px;">
      <div slot="header" class="clearfix">
        <p align="left" style="font-size: 20px">添加文章分类信息</p>
      </div>
      <div style="min-height: 600px">
        <el-form ref="form" :model="atype" :rules="rules" label-width="200px" label-position="right" size="mini">
          <el-form-item label="类别名称" prop="tname">
            <el-input v-model="atype.tname"></el-input>
          </el-form-item>
          <el-form-item label="是否需要vip特权" prop="isNeedVip">
            <el-select v-model="atype.isNeedVip" placeholder="请选择">
              <el-option
                v-for="item in vipTypeDict"
                :key="item.id"
                :label="item.name"
                :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="save" size="mini">确定</el-button>
        </div>
      </div>
    </el-card>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        vipTypeDict: [
          {id: 0, name: '否'},
          {id: 1, name: '是'}
        ],
        atype: {},
        rules: {
          tname: [
            {
              required: true,
              message: '请输入类别名称',
              trigger: 'blur'
            },
            {
              min: 4,
              max: 20,
              message: '类别名称长度在4到20字符之间',
              trigger: 'blur'
            }
          ],
          isNeedVip: [
            {
              required: true,
              message: '请选择',
              trigger: 'blur'
            }
          ]
        }
      }
    },
    methods: {
      // 提交
      save() {
        this.$refs.form.validate((valid) => {
          if (valid) {
            var formData = new FormData()
            Object.keys(this.atype).forEach(key => {
              formData.append(key, this.atype[key])
            })
            this.$axios.post('back/atype/add', formData)
              .then(resp => {
                if (resp.data.code === 1) {
                  this.$message({
                    message: resp.data.msg,
                    type: 'success'
                  });
                  this.$router.push('/backHome/backarticle_categoriesList')
                } else if (resp.data.code === 2) {
                  this.$message.error(resp.data.msg);
                }
              })
          } else {
            alert('验证没通过');
            return false
          }
        })
      }
    }
  }
</script>

<style>
</style>
