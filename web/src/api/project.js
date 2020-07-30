import request from '@/utils/request'

export function getProjectList(number, size) {
  return request({
    url: '/my_platform/project/list',
    method: 'get',
    params: {
      'number': number,
      'size': size
    }
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

export function searchProject(projectName, number, size) {
    return request({
      url: '/my_platform/project/searchProject',
      method: 'get',
      params: {
        'projectName': projectName,
        'number': number,
        'size': size
      }
    })
}
