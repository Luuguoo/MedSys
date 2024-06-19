import Vue from 'vue'
import Router from 'vue-router'
import BackLogin from '../compoents/back/Login'
import BackHome from '../compoents/back/Home'
import BackWelcome from '../compoents/back/Welcome'
import BackUserAdd from '../compoents/back/user/Add'
import BackUserList from '../compoents/back/user/List'
import BackUserQualificationList from '../compoents/back/user/qualificationList'
import BackUserUpdate from '../compoents/back/user/Update'
import BackmedicalnewsAdd from '../compoents/back/medicalnews/Add'
import BackmedicalnewsDetail from '../compoents/back/medicalnews/Detail'
import BackmedicalnewsList from '../compoents/back/medicalnews/List'
import BackmedicalnewsUpdate from '../compoents/back/medicalnews/Update'
import BackarticlecategoriesAdd from '../compoents/back/articlecategories/Add'
import BackarticlecategoriesList from '../compoents/back/articlecategories/List'
import BackarticlecategoriesUpdate from '../compoents/back/articlecategories/Update'
import BackarticleAdd from '../compoents/back/article/Add'
import BackarticleDetail from '../compoents/back/article/Detail'
import BackarticleList from '../compoents/back/article/List'
import BackarticleUpdate from '../compoents/back/article/Update'
import BackarticleCheck from '../compoents/back/article/Check'
import BacklinkAdd from '../compoents/back/link/Add'
import BacklinkList from '../compoents/back/link/List'
import BacklinkUpdate from '../compoents/back/link/Update'
import BackarticlereviewList from '../compoents/back/articlereview/List'
import BackarticlerevisionunauditedList from '../compoents/back/articlerevision/unaudited/List'
import BackarticlerevisionunauditedDetail from '../compoents/back/articlerevision/unaudited/Detail'
import BackarticlerevisionauditedList from '../compoents/back/articlerevision/audited/List'
import BackarticlerevisionauditedDetail from '../compoents/back/articlerevision/audited/Detail'
import BacksystemUpdate from '../compoents/back/system/Update'
import FrontHome from '../compoents/front/Home'
import FrontIndex from '../compoents/front/Index'
import FrontInfo from '../compoents/front/Info'
import FrontfmedicalnewsList from '../compoents/front/fmedicalnews/List'
import FrontfmedicalnewsDetail from '../compoents/front/fmedicalnews/Detail'
import FrontfarticleList from '../compoents/front/farticle/List'
import FrontfarticleDetail from '../compoents/front/farticle/Detail'
import FrontusercenterRegister from '../compoents/front/usercenter/Register'
import FrontusercenterLogin from '../compoents/front/usercenter/Login'
import FrontusercenteruserbackgroundIndex from '../compoents/front/usercenter/userbackground/Index'
import FrontusercenteruserbackgroundUserInfo from '../compoents/front/usercenter/userbackground/UserInfo'
import FrontusercenteruserbackgroundPublicArticle from '../compoents/front/usercenter/userbackground/PublicArticle'
import FrontusercenteruserbackgroundMyArticle from '../compoents/front/usercenter/userbackground/MyArticle'
import FrontusercenteruserbackgroundMyArticleDetail
  from '../compoents/front/usercenter/userbackground/MyArticleDetail'
import FrontusercenteruserbackgroundMyArticleUpdateList
  from '../compoents/front/usercenter/userbackground/MyArticleUpdateList'
import FrontusercenteruserbackgroundMyArticleUpdateDetail
  from '../compoents/front/usercenter/userbackground/MyArticleUpdateDetail'
import FrontusercenteruserbackgroundMyDiscuss
  from '../compoents/front/usercenter/userbackground/MyDiscuss'
import FrontusercenteruserbackgroundMyCollect
  from '../compoents/front/usercenter/userbackground/MyCollect'
import FrontusercenteruserbackgroundUpdateUsers
  from '../compoents/front/usercenter/userbackground/UpdateUsers'
import FrontusercenteruserbackgroundUpdatePassword
  from '../compoents/front/usercenter/userbackground/UpdatePassword'
import FrontusercenteruserbackgroundUpdateArticle
  from '../compoents/front/usercenter/userbackground/UpdateArticle'

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
              path: 'frontfmedicalnewsList',
              name: 'FrontfmedicalnewsList',
              component: FrontfmedicalnewsList
            },
            {
              path: 'frontfmedicalnewsDetail',
              name: 'FrontfmedicalnewsDetail',
              component: FrontfmedicalnewsDetail
            },
            {
              path: 'frontfarticleList',
              name: 'FrontfarticleList',
              component: FrontfarticleList
            },
            {
              path: 'FrontfarticleDetail',
              name: 'FrontfarticleDetail',
              component: FrontfarticleDetail
            },
            {
              path: 'frontusercenterRegister',
              name: 'FrontusercenterRegister',
              component: FrontusercenterRegister
            },
            {
              path: 'frontusercenterLogin',
              name: 'FrontusercenterLogin',
              component: FrontusercenterLogin
            },

          ]
        },
        {
          path: 'frontusercenteruserbackgroundIndex',
          name: 'FrontusercenteruserbackgroundIndex',
          component: FrontusercenteruserbackgroundIndex,
          children: [
            {
              path: '/',
              redirect: 'frontusercenteruserbackgroundUserInfo'
            },
            {
              path: 'frontusercenteruserbackgroundUserInfo',
              name: 'FrontusercenteruserbackgroundUserInfo',
              component: FrontusercenteruserbackgroundUserInfo,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontusercenteruserbackgroundPublicArticle',
              name: 'FrontusercenteruserbackgroundPublicArticle',
              component: FrontusercenteruserbackgroundPublicArticle,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontusercenteruserbackgroundMyArticle',
              name: 'FrontusercenteruserbackgroundMyArticle',
              component: FrontusercenteruserbackgroundMyArticle,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontusercenteruserbackgroundMyArticleDetail',
              name: 'FrontusercenteruserbackgroundMyArticleDetail',
              component: FrontusercenteruserbackgroundMyArticleDetail,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontusercenteruserbackgroundMyArticleUpdateList',
              name: 'FrontusercenteruserbackgroundMyArticleUpdateList',
              component: FrontusercenteruserbackgroundMyArticleUpdateList,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontusercenteruserbackgroundMyArticleUpdateDetail',
              name: 'FrontusercenteruserbackgroundMyArticleUpdateDetail',
              component: FrontusercenteruserbackgroundMyArticleUpdateDetail,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontusercenteruserbackgroundMyDiscuss',
              name: 'FrontusercenteruserbackgroundMyDiscuss',
              component: FrontusercenteruserbackgroundMyDiscuss,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontusercenteruserbackgroundMyCollect',
              name: 'FrontusercenteruserbackgroundMyCollect',
              component: FrontusercenteruserbackgroundMyCollect,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontusercenteruserbackgroundUpdateUsers',
              name: 'FrontusercenteruserbackgroundUpdateUsers',
              component: FrontusercenteruserbackgroundUpdateUsers,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontusercenteruserbackgroundUpdatePassword',
              name: 'FrontusercenteruserbackgroundUpdatePassword',
              component: FrontusercenteruserbackgroundUpdatePassword,
              meta: {
                user: true//添加字段判断该页面是否需要登录
              },
            },
            {
              path: 'frontusercenteruserbackgroundUpdateArticle',
              name: 'FrontusercenteruserbackgroundUpdateArticle',
              component: FrontusercenteruserbackgroundUpdateArticle,
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
          path: 'backUserUpdate',
          name: 'BackUserUpdate',
          component: BackUserUpdate,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backUserList',
          name: 'BackUserList',
          component: BackUserList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backUserQualificationList',
          name: 'BackUserQualificationList',
          component: BackUserQualificationList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backUserAdd',
          name: 'BackUserAdd',
          component: BackUserAdd,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backmedicalnewsUpdate',
          name: 'BackmedicalnewsUpdate',
          component: BackmedicalnewsUpdate,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backmedicalnewsList',
          name: 'BackmedicalnewsList',
          component: BackmedicalnewsList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backmedicalnewsAdd',
          name: 'BackmedicalnewsAdd',
          component: BackmedicalnewsAdd,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backmedicalnewsDetail',
          name: 'BackmedicalnewsDetail',
          component: BackmedicalnewsDetail,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backarticlecategoriesUpdate',
          name: 'BackarticlecategoriesUpdate',
          component: BackarticlecategoriesUpdate,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backarticlecategoriesList',
          name: 'BackarticlecategoriesList',
          component: BackarticlecategoriesList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backarticlecategoriesAdd',
          name: 'BackarticlecategoriesAdd',
          component: BackarticlecategoriesAdd,
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
          path: 'backlinkUpdate',
          name: 'BacklinkUpdate',
          component: BacklinkUpdate,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backlinkList',
          name: 'BacklinkList',
          component: BacklinkList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backlinkAdd',
          name: 'BacklinkAdd',
          component: BacklinkAdd,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backarticlereviewList',
          name: 'BackarticlereviewList',
          component: BackarticlereviewList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backarticlerevisionunauditedDetail',
          name: 'BackarticlerevisionunauditedDetail',
          component: BackarticlerevisionunauditedDetail,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backarticlerevisionunauditedList',
          name: 'BackarticlerevisionunauditedList',
          component: BackarticlerevisionunauditedList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backarticlerevisionauditedDetail',
          name: 'BackarticlerevisionauditedDetail',
          component: BackarticlerevisionauditedDetail,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backarticlerevisionauditedList',
          name: 'BackarticlerevisionauditedList',
          component: BackarticlerevisionauditedList,
          meta: {
            auth: true//添加字段判断该页面是否需要登录
          }
        },
        {
          path: 'backsystemUpdate',
          name: 'BacksystemUpdate',
          component: BacksystemUpdate,
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
        path: '/frontHome/frontInfo/frontusercenterLogin',
      })
    }
  } else {
    // 如果不需要登录，则直接跳转到对应页面
    next()
  }
})
export default router

