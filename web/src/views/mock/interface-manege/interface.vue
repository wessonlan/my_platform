<template>
  <div class="app-container">
    <el-input placeholder="接口名称" style="width: 200px; margin-right:10px" class="filter-item" clearable/>
    <el-select v-model="value8" filterable placeholder="搜索项目" clearable>
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select>
    <el-button class="filter-item"  type="primary" icon="el-icon-search" style="margin-left:10px;">
      查询
    </el-button>
    <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-edit"
               @click="InterfaceCreate">
      新建
    </el-button>
    <div style="margin-top:20px;"></div>
  <!--接口表单-->
  <el-dialog :visible.sync="dialogUpdateVisible">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="接口名称">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="所属项目">
        <el-select v-model="form.region" placeholder="请选择所属项目">
          <el-option label="区域一" value="shanghai"></el-option>
          <el-option label="区域二" value="beijing"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="接口方法">
        <el-select v-model="form.region" placeholder="请选择方法">
          <el-option label="GET" value="GET"></el-option>
          <el-option label="POST" value="POST"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="接口路径">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="项目描述">
        <el-input :autosize="{ minRows: 2, maxRows: 4}" type="textarea" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">创建</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>

  <!--接口规则表单-->

  <!--展开table-->
  <el-table
    :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
    style="width: 100%">
    <el-table-column type="expand" prop="ruleTable">
      <template slot-scope="scope">
        <el-table
          :data="tableDataRule"
          style="width: 100%">
          <el-table-column prop="id" label="规则ID"/>
          <el-table-column prop="title" label="规则名称"/>
          <el-table-column prop="resCode" label="返回码"/>
          <el-table-column
            align="right">
            <template slot="header" slot-scope="scope">
              <el-button type="success" size="mini" plain @click="ruleCreate()" style="margin-right: 100px">新增规则</el-button>
            </template>
            <template slot-scope="scope">
              <el-button size="mini" type="text" @click="ruleUpdate(scope.row.id)">修改</el-button>
              <el-button size="mini" type="text" @click="ruleDelete(scope.row.id)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </template>
    </el-table-column>
    <!--外层table-->
    <el-table-column
      label="接口ID"
      prop="date">
    </el-table-column>
    <el-table-column
      label="所属项目"
      prop="date">
    </el-table-column>
    <el-table-column
      label="接口名称"
      prop="name">
    </el-table-column>
    <el-table-column
      label="方法"
      prop="address">
    </el-table-column>
    <el-table-column
      label="路径"
      prop="path">
    </el-table-column>
    <el-table-column
      align="" label="操作">
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
  </div>
</template>

<script>
  export default {
    data() {
      return {
        dialogUpdateVisible: false,
        tableData: [{
          date: '1',
          name: '用户信息接口',
          address: 'GET',
          path: '/user/info'
        }, {
          date: '2',
          name: '查询交易数接口',
          address: 'POST',
          path: '/query/business'
        }, {
          date: '3',
          name: '提交申请接口',
          address: 'PUT',
          path: '/query/business'
        }, {
          date: '4',
          name: '更改交易状态接口',
          address: 'DELETE',
          path: '/query/business'
        }],
        search: '',
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        options: [{
          value: '选项1',
          label: '黄金糕'
        }, {
          value: '选项2',
          label: '双皮奶'
        }, {
          value: '选项3',
          label: '蚵仔煎'
        }, {
          value: '选项4',
          label: '龙须面'
        }, {
          value: '选项5',
          label: '北京烤鸭'
        }],
        value8: ''

      }
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      },
      onSubmit() {
        console.log('submit!');
      },
      InterfaceCreate() {
        this.dialogUpdateVisible = true
      }
    },
  }
</script>
