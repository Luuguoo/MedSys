import Vue from 'vue'
import Router from 'vue-router'
import BackLogin from '../components/back/Login'
import BackHome from '../components/back/Home'
import BackWelcome from '../components/back/Welcome'
import BackYonghuAdd from '../components/back/user/Add'
import BackYonghuList from '../components/back/user/List'
import BackYonghuQualificationList from '../components/back/user/qualificationList'
import BackYonghuUpdate from '../components/back/user/Update'
import BackyixuexinwenAdd from '../components/back/medicalnews/Add'
import BackyixuexinwenDetail from '../components/back/medicalnews/Detail'
import BackyixuexinwenList from '../components/back/medicalnews/List'
import BackyixuexinwenUpdate from '../components/back/medicalnews/Update'
import Backarticle_categoriesAdd from '../components/back/articlecategories/Add'
import Backarticle_categoriesList from '../components/back/articlecategories/List'
import Backarticle_categoriesUpdate from '../components/back/articlecategories/Update'
import BackarticleAdd from '../components/back/article/Add'
import BackarticleDetail from '../components/back/article/Detail'
import BackarticleList from '../components/back/article/List'
import BackarticleUpdate from '../components/back/article/Update'
import BackarticleCheck from '../components/back/article/Check'
import BackyouqinglianjieAdd from '../components/back/link/Add'
import BackyouqinglianjieList from '../components/back/link/List'
import BackyouqinglianjieUpdate from '../components/back/link/Update'
import BackwenzhangpinglunList from '../components/back/articlereview/List'
import BackwenzhangxiugaiweishenheList from '../components/back/articlerevision/unaudited/List'
import BackwenzhangxiugaiweishenheDetail from '../components/back/articlerevision/unaudited/Detail'
import BackwenzhangxiugaiyishenheList from '../components/back/articlerevision/audited/List'
import BackwenzhangxiugaiyishenheDetail from '../components/back/articlerevision/audited/Detail'
import BackxitongUpdate from '../components/back/system/Update'
import FrontHome from '../components/front/Home'
import FrontIndex from '../components/front/Index'
import FrontInfo from '../components/front/Info'
import FrontyixuexinwenList from '../components/front/fmedicalnews/List'
import FrontyixuexinwenDetail from '../components/front/fmedicalnews/Detail'
import FrontwenzhangList from '../components/front/farticle/List'
import FrontwenzhangDetail from '../components/front/farticle/Detail'
import FrontyonghuzhongxinRegister from '../components/front/usercenter/Register'
import FrontyonghuzhongxinLogin from '../components/front/usercenter/Login'
import FrontyonghuzhongxinyonghuhoutaiIndex from '../components/front/usercenter/userbackground/Index'
import FrontyonghuzhongxinyonghuhoutaiUserInfo from '../components/front/usercenter/userbackground/UserInfo'
import FrontyonghuzhongxinyonghuhoutaiPublicArticle from '../components/front/usercenter/userbackground/PublicArticle'
import FrontyonghuzhongxinyonghuhoutaiMyArticle from '../components/front/usercenter/userbackground/MyArticle'
import FrontyonghuzhongxinyonghuhoutaiMyArticleDetail
  from '../components/front/usercenter/userbackground/MyArticleDetail'
import FrontyonghuzhongxinyonghuhoutaiMyArticleUpdateList
  from '../components/front/usercenter/userbackground/MyArticleUpdateList'
import FrontyonghuzhongxinyonghuhoutaiMyArticleUpdateDetail
  from '../components/front/usercenter/userbackground/MyArticleUpdateDetail'
import FrontyonghuzhongxinyonghuhoutaiMyDiscuss
  from '../components/front/usercenter/userbackground/MyDiscuss'
import FrontyonghuzhongxinyonghuhoutaiMyCollect
  from '../components/front/usercenter/userbackground/MyCollect'
import FrontyonghuzhongxinyonghuhoutaiUpdateUsers
  from '../components/front/usercenter/userbackground/UpdateUsers'
import FrontyonghuzhongxinyonghuhoutaiUpdatePassword
  from '../components/front/usercenter/userbackground/UpdatePassword'
import FrontyonghuzhongxinyonghuhoutaiUpdateArticle
  from '../components/front/usercenter/userbackground/UpdateArticle'

Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/',
      redirect: '/frontHome/frontIndex'
    },
    {
      path: '/backLogin',
      name: 'BackLogin',
      component: BackLogin
    },
    {
      path: '/frontHome',
      name: 'FrontHome',
      component: FrontHome,
      children: [
        {
          path: '/',
          redirect: 'frontIndex'
        },
        {
          path: 'frontIndex',
          name: 'FrontIndex',
          component: FrontIndex
        },
        {
          path: 'frontInfo',
          name: 'FrontInfo',
          component: FrontInfo,
          children: [
            {
              path: 'frontyixuexinwenList',
              name: 'FrontyixuexinwenList',
              component: FrontyixuexinwenList
            },
            {
              path: 'frontyixuexinwenDetail',
              name: 'FrontyixuexinwenDetail',
              component: FrontyixuexinwenDetail
            },
            {
              path: 'frontwenzhangList',
              name: 'FrontwenzhangList',
              component: FrontwenzhangList
            },
            {
              path: 'FrontwenzhangDetail',
              name: 'FrontwenzhangDetail',
              component: FrontwenzhangDetail
            },
            {
              path: 'frontyonghuzhongxinRegister',
              name: 'FrontyonghuzhongxinRegister',
              component: FrontyonghuzhongxinRegister
            },
            {
              path: 'frontyonghuzhongxinLogin',
              name: 'FrontyonghuzhongxinLogin',
              component: FrontyonghuzhongxinLogin
            },

          ]
        },
        {
          path: 'frontyonghuzhongxinyonghuhoutaiIndex',
          name: 'FrontyonghuzhongxinyonghuhoutaiIndex',
          component: FrontyonghuzhongxinyonghuhoutaiIndex,
          children: [
            {
              path: '/',
              redirect: 'frontyonghuzhongxinyonghuhoutaiUserInfo'
            },
            {
              path: 'frontyonghuzhongxinyonghuhoutaiUserInfo',
              name: 'FrontyonghuzhongxinyonghuhoutaiUserInfo',
              component: FrontyonghuzhongxinyonghuhoutaiUserInfo,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontyonghuzhongxinyonghuhoutaiPublicArticle',
              name: 'FrontyonghuzhongxinyonghuhoutaiPublicArticle',
              component: FrontyonghuzhongxinyonghuhoutaiPublicArticle,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontyonghuzhongxinyonghuhoutaiMyArticle',
              name: 'FrontyonghuzhongxinyonghuhoutaiMyArticle',
              component: FrontyonghuzhongxinyonghuhoutaiMyArticle,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontyonghuzhongxinyonghuhoutaiMyArticleDetail',
              name: 'FrontyonghuzhongxinyonghuhoutaiMyArticleDetail',
              component: FrontyonghuzhongxinyonghuhoutaiMyArticleDetail,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontyonghuzhongxinyonghuhoutaiMyArticleUpdateList',
              name: 'FrontyonghuzhongxinyonghuhoutaiMyArticleUpdateList',
              component: FrontyonghuzhongxinyonghuhoutaiMyArticleUpdateList,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontyonghuzhongxinyonghuhoutaiMyArticleUpdateDetail',
              name: 'FrontyonghuzhongxinyonghuhoutaiMyArticleUpdateDetail',
              component: FrontyonghuzhongxinyonghuhoutaiMyArticleUpdateDetail,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontyonghuzhongxinyonghuhoutaiMyDiscuss',
              name: 'FrontyonghuzhongxinyonghuhoutaiMyDiscuss',
              component: FrontyonghuzhongxinyonghuhoutaiMyDiscuss,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontyonghuzhongxinyonghuhoutaiMyCollect',
              name: 'FrontyonghuzhongxinyonghuhoutaiMyCollect',
              component: FrontyonghuzhongxinyonghuhoutaiMyCollect,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontyonghuzhongxinyonghuhoutaiUpdateUsers',
              name: 'FrontyonghuzhongxinyonghuhoutaiUpdateUsers',
              component: FrontyonghuzhongxinyonghuhoutaiUpdateUsers,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontyonghuzhongxinyonghuhoutaiUpdatePassword',
              name: 'FrontyonghuzhongxinyonghuhoutaiUpdatePassword',
              component: FrontyonghuzhongxinyonghuhoutaiUpdatePassword,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontyonghuzhongxinyonghuhoutaiUpdateArticle',
              name: 'FrontyonghuzhongxinyonghuhoutaiUpdateArticle',
              component: FrontyonghuzhongxinyonghuhoutaiUpdateArticle,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },

          ]
        },

      ]
    },
    {
      path: '/backHome',
      name: 'BackHome',
      component: BackHome,
      children: [
        {
          path: '/',
          redirect: 'backWelcome'
        },
        {
          path: 'backWelcome',
          name: 'BackWelcome',
          component: BackWelcome,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backYonghuUpdate',
          name: 'BackYonghuUpdate',
          component: BackYonghuUpdate,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backYonghuList',
          name: 'BackYonghuList',
          component: BackYonghuList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backYonghuQualificationList',
          name: 'BackYonghuQualificationList',
          component: BackYonghuQualificationList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backYonghuAdd',
          name: 'BackYonghuAdd',
          component: BackYonghuAdd,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backyixuexinwenUpdate',
          name: 'BackyixuexinwenUpdate',
          component: BackyixuexinwenUpdate,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backyixuexinwenList',
          name: 'BackyixuexinwenList',
          component: BackyixuexinwenList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backyixuexinwenAdd',
          name: 'BackyixuexinwenAdd',
          component: BackyixuexinwenAdd,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backyixuexinwenDetail',
          name: 'BackyixuexinwenDetail',
          component: BackyixuexinwenDetail,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backarticle_categoriesUpdate',
          name: 'Backarticle_categoriesUpdate',
          component: Backarticle_categoriesUpdate,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backarticle_categoriesList',
          name: 'Backarticle_categoriesList',
          component: Backarticle_categoriesList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backarticle_categoriesAdd',
          name: 'Backarticle_categoriesAdd',
          component: Backarticle_categoriesAdd,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backarticleUpdate',
          name: 'BackarticleUpdate',
          component: BackarticleUpdate,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backarticleDetail',
          name: 'BackarticleDetail',
          component: BackarticleDetail,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },

        {
          path: 'backarticleList',
          name: 'BackarticleList',
          component: BackarticleList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backarticleAdd',
          name: 'BackarticleAdd',
          component: BackarticleAdd,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backarticleCheck',
          name: 'BackarticleCheck',
          component: BackarticleCheck,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backyouqinglianjieUpdate',
          name: 'BackyouqinglianjieUpdate',
          component: BackyouqinglianjieUpdate,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backyouqinglianjieList',
          name: 'BackyouqinglianjieList',
          component: BackyouqinglianjieList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backyouqinglianjieAdd',
          name: 'BackyouqinglianjieAdd',
          component: BackyouqinglianjieAdd,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backwenzhangpinglunList',
          name: 'BackwenzhangpinglunList',
          component: BackwenzhangpinglunList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backwenzhangxiugaiweishenheDetail',
          name: 'BackwenzhangxiugaiweishenheDetail',
          component: BackwenzhangxiugaiweishenheDetail,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backwenzhangxiugaiweishenheList',
          name: 'BackwenzhangxiugaiweishenheList',
          component: BackwenzhangxiugaiweishenheList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backwenzhangxiugaiyishenheDetail',
          name: 'BackwenzhangxiugaiyishenheDetail',
          component: BackwenzhangxiugaiyishenheDetail,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backwenzhangxiugaiyishenheList',
          name: 'BackwenzhangxiugaiyishenheList',
          component: BackwenzhangxiugaiyishenheList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backxitongUpdate',
          name: 'BackxitongUpdate',
          component: BackxitongUpdate,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
      ],
      meta: {
        auth: true//添加字段判断该页面是否需要登录
      }
    },

  ]
})

// 路由守卫
router.beforeEach((to, from, next) => {
  // to要跳转到的路径
  // from从哪个路径来
  // next往下执行的回调
  // 在localStorage中获取token
  let admin = sessionStorage.getItem('lname')
  let user = sessionStorage.getItem('username')
  // 判断该页面是否需要登录
  if (to.meta.auth) {
    // 如果token存在直接跳转
    if (admin) {
      next()
    } else {
      // 否则跳转到login登录页面
      alert("请先登录")
      next({
        path: '/backLogin',
      })
    }
  } else if (to.meta.user) {
    // 如果token存在直接跳转
    if (user) {
      next()
    } else {
      // 否则跳转到login登录页面
      alert("请先登录")
      next({
        path: '/frontHome/frontInfo/frontyonghuzhongxinLogin',
      })
    }
  } else {
    // 如果不需要登录，则直接跳转到对应页面
    next()
  }
})
export default router

