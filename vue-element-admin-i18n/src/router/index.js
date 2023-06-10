import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)


/* Layout */
import Layout from '@/layout'

/* Router Modules */
import componentsRouter from './modules/components'
import chartsRouter from './modules/charts'
import tableRouter from './modules/table'
import nestedRouter from './modules/nested'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    noCache: true                if set true, the page will no be cached(default is false)
    affix: true                  if set true, the tag will affix in the tags-view
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
    {
      path: '/redirect',
      component: Layout,
      hidden: true,
      children: [
        {
          path: '/redirect/:path(.*)',
          component: () => import('@/views/redirect/index')
        }
      ]
    },
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views/login/auth-redirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error-page/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error-page/401'),
    hidden: true
  },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/dashboard/index'),
        name: 'Dashboard',
        meta: {title: 'dashboard', icon: 'dashboard', affix: true}
      }
    ]
  },
  {
    path: '/documentation',
    component: Layout,
    children: [
      {
        path: 'index',
        component: () => import('@/views/documentation/index'),
        name: 'Documentation',
        meta: {title: 'documentation', icon: 'documentation', affix: true}
      }
    ]
  },
  {
    path: '/guide',
    component: Layout,
    redirect: '/guide/index',
    children: [
      {
        path: 'index',
        component: () => import('@/views/guide/index'),
        name: 'Guide',
        meta: {title: 'guide', icon: 'guide', noCache: true}
      }
    ]
  },
  {
    path: '/profile',
    component: Layout,
    redirect: '/profile/index',
    hidden: true,
    children: [
      {
        path: 'index',
        component: () => import('@/views/profile/index'),
        name: 'Profile',
        meta: {title: 'profile', icon: 'user', noCache: true}
      }
    ]
  }
]

/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
export const asyncRoutes = [
  {
    path: '/dashboard',
    component: Layout,
    redirect: '/dashboard/page',
    alwaysShow: true, // will always show the root menu
    name: 'dashboard',
    meta: {
      title: '系统设置',
      icon: 'lock',
      roles: ['admin', 'editor'] // you can set roles in root nav
    },
    children: [
      {
        path: 'user',
        component: () => import('@/views/home/system/user'),
        name: 'user',
        meta: {
          title: '用户管理',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
      {
        path: 'role',
        component: () => import('@/views/home/system/role'),
        name: 'role',
        meta: {
          title: '角色管理',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
      {
        path: 'dept',
        component: () => import('@/views/home/system/dept'),
        name: 'dept',
        meta: {
          title: '部门管理',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
      {
        path: 'menu1',
        component: () => import('@/views/home/system/menu1'),
        name: 'menu1',
        meta: {
          title: '菜单管理',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
    ]
  },
  {
    path: '/basic',
    component: Layout,
    redirect: '/basic/page',
    alwaysShow: true, // will always show the root menu
    name: 'basic',
    meta: {
      title: '基础数据',
      icon: 'lock',
      roles: ['admin', 'editor'] // you can set roles in root nav
    },
    children: [
      {
        path: 'product',
        component: () => import('@/views/home/basic/product'),
        name: 'product',
        meta: {
          title: '产品管理',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
      {
        path: 'client',
        component: () => import('@/views/home/basic/client'),
        name: 'client',
        meta: {
          title: '客户管理',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
      {
        path: 'supplier',
        component: () => import('@/views/home/basic/supplier'),
        name: 'supplier',
        meta: {
          title: '供应商管理',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
      {
        path: 'carrier',
        component: () => import('@/views/home/basic/carrier'),
        name: 'carrier',
        meta: {
          title: '承运商管理',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
    ]
  },
  {
    path: '/warehouse',
    component: Layout,
    redirect: '/warehouse/page',
    alwaysShow: true, // will always show the root menu
    name: 'warehouse',
    meta: {
      title: '仓库数据',
      icon: 'lock',
      roles: ['admin', 'editor'] // you can set roles in root nav
    },
    children: [
      {
        path: 'repository1',
        component: () => import('@/views/home/warehouse/repository1'),
        name: 'repository1',
        meta: {
          title: '仓库管理',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
      {
        path: 'put',
        component: () => import('@/views/home/warehouse/put'),
        name: 'put',
        meta: {
          title: '货物入库',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
      {
        path: 'in',
        component: () => import('@/views/home/warehouse/in'),
        name: 'in',
        meta: {
          title: '货物出库',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
      {
        path: 'select1',
        component: () => import('@/views/home/warehouse/select1'),
        name: 'select1',
        meta: {
          title: '库存查询',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
    ]
  },
  {
    path: '/dictionaries',
    component: Layout,
    redirect: '/dictionaries/page',
    alwaysShow: true, // will always show the root menu
    name: 'dictionaries',
    meta: {
      title: '字典数据',
      icon: 'lock',
      roles: ['admin', 'editor'] // you can set roles in root nav
    },
    children: [

      {
        path: 'category',
        component: () => import('@/views/home/dictionaries/category'),
        name: 'category',
        meta: {
          title: '产品类目',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
      {
        path: 'level',
        component: () => import('@/views/home/dictionaries/level'),
        name: 'level',
        meta: {
          title: '客户级别',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
      {
        path: 'source1 ',
        component: () => import('@/views/home/dictionaries/source1'),
        name: 'source1 ',
        meta: {
          title: '客户来源',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
      {
        path: 'industry1',
        component: () => import('@/views/home/dictionaries/industry1'),
        name: 'industry1',
        meta: {
          title: '客户行业',
          roles: ['admin'] // or you can only set roles in sub nav
        }
      },
    ]
  },

]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({y: 0}),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
