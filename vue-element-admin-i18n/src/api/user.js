import request from '@/utils/request'

export function login(data) {
  return request({
    url: 'http://localhost:8080/login',
    method: 'get',
    params: {
      userEmail: data.userEmail,
      password: data.password
    }
  })
}

export function getInfo(token) {
  return request({
    url: 'http://localhost:8080/getLogin',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/vue-element-admin/user/logout',
    method: 'post'
  })
}
