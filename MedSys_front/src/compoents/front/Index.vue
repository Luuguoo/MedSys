<template>
  <div style="margin-top: 5px">
    <el-row>
      <el-col :offset="4" :span="16">
        <el-carousel style="width: 1187px;" height="415px">
          <el-carousel-item v-for="(item,index) in lunboList" :key="index">
            <img style="border-radius: 20px;" :src="item.lunbo">
          </el-carousel-item>
        </el-carousel>
      </el-col>
    </el-row>
    <div style="margin-top: 15px">
      <el-row>
        <el-col :offset="4" :span="16">
          <el-card style="margin-top: 15px;width: 1186px;border-radius: 20px;min-height: 400px"
                   v-for="(atype,index) in atypeList" :key="index">
            <div slot="header" class="clearfix">
              <span style="float: left;color: #00BCD4">{{atype.tname}}</span>
            </div>
            <div class="farticle" style="width: 570px; height: 180px;float: left" v-for="(article,index2) in atype.articles"
                 :key="index2" @click="toDetail(article)">
              <el-row>
                <el-col :span="10">
                  <img :src="article.photo" style="width: 200px;max-height: 140px">
                </el-col>
                <el-col :span="14">
                  <el-row style="text-align: left;margin-bottom: 10px">
                    <el-col :span="5">
                      {{article.title}}
                    </el-col>
                    <el-col :span="16" :offset="3">
                      发布人:{{article.lname}}
                      <span class="guanfang" v-if="article.lname==='admin'" >官方认证</span>
                      <span class="zishen" v-else-if="article.usersLevel===1">资深认证</span>
                    </el-col>


                  </el-row>
                  <el-row style="text-align: left;font-size: 13px">{{article.amemo| ellipsis}}</el-row>
                </el-col>
              </el-row>
            </div>
          </el-card>
          <el-card style="margin-top: 15px;width: 1186px;border-radius: 20px">
            <div slot="header" class="clearfix">
              <span style="float: left;color: #00BCD4">友情链接</span>
            </div>
            <div style="float: left;min-height: 50px;margin-right: 20px" v-for="(flink,index) in flinkList"
                 :key="index">
              <el-link :href="flink.http" target="_blank">{{flink.title}}</el-link>
            </div>
          </el-card>

        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        atypeList: [],
        flinkList: [],
        lunboList: [
          {lunbo: this.$baseVar.baseURL + 'static/images/banner1.png'},
          {lunbo: this.$baseVar.baseURL + 'static/images/banner2.png'},
          {lunbo: this.$baseVar.baseURL + 'static/images/banner3.png'}

        ]
      }
    },
    methods: {
      toDetail(article) {
        this.$router.push('/frontHome/frontInfo/frontfarticleDetail?article=' + JSON.stringify(article))
      },
      getAtypeAllAndArticle() {
        this.$axios.get("front/publics/atype/findAllAndArticle")
          .then(resp => {
            this.atypeList = resp.data.data
          })
      },
      getFlinkAll() {
        this.$axios.get("front/publics/flink/findAll")
          .then(resp => {
            this.flinkList = resp.data.data
          })
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
    created() {
      this.getAtypeAllAndArticle()
      this.getFlinkAll()
    }
  }
</script>

<style scoped>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

  .farticle:hover {
    color: #1EAFF1;
  }

  .zishen {
    font-size: 1px;
    padding: 3px;
    color: white;
    background-color: #FD0201;
    font-weight:bold
  }
  .guanfang {
    font-size: 1px;
    padding: 3px;
    background-color: #FFDE66;
    color: red;
    font-weight:bold
  }
</style>
