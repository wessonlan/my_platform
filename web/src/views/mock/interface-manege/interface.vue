<template>
  <el-table
    :data="tableData"
    style="width: 100%">
    <el-table-column type="expand">
      <template slot-scope="props">
        <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item label="规则id">
            <span>11011</span>
          </el-form-item>
          <el-form-item label="规则名称">
            <span>测试返回的结果中不包含未入住的酒店</span>
          </el-form-item>
          <el-form-item label="返回码">
            <span>200</span>
          </el-form-item>
          <el-form-item label="备注">
            <span>测试异常的case数据</span>
          </el-form-item>
          <el-button size="mini" type="primary" icon="el-icon-edit"></el-button>
          <el-button size="mini" type="primary" icon="el-icon-delete"></el-button>
        </el-form>
      </template>
    </el-table-column>


      <el-table
        :data="tableData"
        style="width: 100%">
        <el-table-column
          label="日期"
          width="180">
          <template slot-scope="scope">
            <i class="el-icon-time"></i>
            <span style="margin-left: 10px">{{ scope.row.date }}</span>
          </template>
        </el-table-column>
        <el-table-column
          label="姓名"
          width="180">
          <template slot-scope="scope">
            <el-popover trigger="hover" placement="top">
              <p>姓名: {{ scope.row.name }}</p>
              <p>住址: {{ scope.row.address }}</p>
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">{{ scope.row.name }}</el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button
              size="mini"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>


    <el-table-column
      label="接口名称"
      prop="id">
    </el-table-column>
    <el-table-column
      label="方法"
      prop="name">
    </el-table-column>
    <el-table-column
      label="路径"
      prop="desc">
    </el-table-column>
    <el-table-column
      label="备注"
      prop="desc">
    </el-table-column>
    <el-table-column
      label="操作"
      prop="desc">
      <template slot-scope="scope">
        <el-button type="primary" size="mini">
          新增规则
        </el-button>
        <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">
          编辑
        </el-button>
        <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">
          删除
        </el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
  export default {
    data() {
      return {
        tableData: [{
          id: '查询用户信息接口',
          name: 'GET',
          category: '1',
          desc: '/getUserInfo',
          address: '1',
          shop: '111',
          shopId: '123'
        }]
      }
    }
  }
</script>


<style>
  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>
