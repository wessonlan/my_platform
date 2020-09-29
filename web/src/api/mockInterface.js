import request from '@/utils/request'

export function getMockInterfaceList(number, size) {
  return request({
    url: '/my_platform/mockInterface/list',
    method: 'get',
    params: {
      'number': number,
      'size': size
    }
  })
}
