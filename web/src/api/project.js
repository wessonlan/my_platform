import request from '@/utils/request'

export function getProjectList(params) {
  return request({
    url: '/my_platform/project/list',
    method: 'get',
    params
  })
}

export function createProject(data) {
  return request({
    url: '/my_platform/project/list',
    method: 'post',
    data
  })
}

export function updateProject(data) {
  return request({
    url: '/my_platform/project/list',
    method: 'put',
    data
  })
}
