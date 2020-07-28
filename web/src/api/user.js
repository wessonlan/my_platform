import request from '@/utils/request'

// export function login(data) {
//   return request({
//     url: '/vue-admin-template/user/login',
//     method: 'post',
//     data
//   })
// }

export function login(username, password) {
  return request({
    url: '/my_platform/user/login',
    method: 'post',
    data: { // 提交的数据
      username,
      password
    }
  })
}

export function getInfo(token) {
  return request({
    url: '/my_platform/user/useInfo',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/my_platform/user/logout',
    method: 'post'
  })
}
