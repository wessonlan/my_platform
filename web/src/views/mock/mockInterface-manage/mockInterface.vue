<template>
  <div class="app-container">
    <el-input placeholder="接口名称" style="width: 200px; margin-right:10px" class="filter-item" clearable/>
    <el-button class="filter-item"  type="primary" icon="el-icon-search" style="margin-left:10px;">
      查询
    </el-button>
    <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-edit" @click="interfaceCreate">
      新建
    </el-button>
    <div style="margin-top:20px;"></div>
    <el-table
      :data="list"
      style="width: 100%">
      <el-table-column type="expand">
<!--        这里要嵌入展开后的列表-->

<!--        <template slot-scope="props">-->
<!--          <el-form label-position="left" inline class="demo-table-expand">-->
<!--            <el-form-item label="规则ID">-->
<!--              <span>{{ props.row.id }}</span>-->
<!--            </el-form-item>-->
<!--            <el-form-item label="规则名称">-->
<!--              <span>{{ props.row.interfaceName }}</span>-->
<!--            </el-form-item>-->
<!--            <el-form-item label="返回码">-->
<!--              <span>{{ props.row.requestMethod }}</span>-->
<!--            </el-form-item>-->
<!--          </el-form>-->
<!--        </template>-->
        <template>
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
            <el-table-column label="操作">
              <template slot="header" slot-scope="scope">
                <el-button type="success" size="mini" plain @click="ruleCreate" style="margin-right: 100px">新增规则</el-button>
              </template>
            </el-table-column>

          </el-table>
        </template>
        <!--        这里要嵌入展开后的列表-->
      </el-table-column>
      <el-table-column
        label="接口ID"
        prop="id">
      </el-table-column>
      <el-table-column
        label="所属项目"
        prop="pid">
      </el-table-column>
      <el-table-column
        label="接口名称"
        prop="interfaceName">
      </el-table-column>
      <el-table-column
        label="方法"
        prop="requestMethod">
      </el-table-column>
      <el-table-column
        label="路径"
        prop="requestPath">
      </el-table-column>
      <el-table-column align="" label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--接口表单-->
    <el-dialog :visible.sync="interfaceDialogUpdateVisible">
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

    <!--新增/编辑接口规则-->
    <!--规则名称、过滤参数、过滤body、response_code、response_body、 -->
    <el-dialog :visible.sync="ruleDialogUpdateVisible">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="规则名称">
          <el-input v-model="form.rule_name"></el-input>
        </el-form-item>
        <el-form-item label="过滤-params">
          <el-input v-model="form.filter_name"></el-input>
        </el-form-item>
        <el-form-item label="过滤-body">
          <el-input v-model="form.filter_body"></el-input>
        </el-form-item>
        <el-form-item label="返回码">
          <el-input v-model="form.response_code"></el-input>
        </el-form-item>
        <el-form-item label="响应体">
          <el-input type="textarea" v-model="form.response_body"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">立即创建</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>


  </div>



</template>




<script>
  import { getMockInterfaceList } from "@/api/mockInterface";
  import Pagination from '@/components/Pagination'

  export default {
    name: 'MockInterface',
    data() {
      return {
        list: null,
        listLoading: true,
        interfaceDialogUpdateVisible: false,
        ruleDialogUpdateVisible: false,
        listQueryInfo: {
          page: 1,
          limit: 10,
          mockInterfaceName: undefined,
          projectId: undefined
        },
        pageInfo: {
          number: 1,
          size: 10,
          totalElements: NaN,
          totalPages: undefined,
          numberOfElements: undefined
        },




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
        //演示数据
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
        value8: '',
        //演示数据
        tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }]

      }
    },
    created() {
      this.mockInterfaceListGet()
    },
    methods: {
      //mock接口列表 查询
      mockInterfaceListGet() {
        this.listLoading = true
        getMockInterfaceList(this.pageInfo.number, this.pageInfo.size).then(response => {
          this.list = response.data.content
          this.pageInfo.size = response.data.size
          this.pageInfo.number = response.data.number + 1
          this.pageInfo.totalElements = response.data.totalElements
          this.pageInfo.totalPages = response.data.totalPages
          this.pageInfo.numberOfElements = response.data.totalPages
          this.listLoading = false
        })
      },


      //处理展开的编辑
      handleEdit(index, row) {
        console.log(index, row);
      },
      //处理展开的删除
      handleDelete(index, row) {
        console.log(index, row);
      },
      onSubmit() {
        console.log('submit!');
      },
      interfaceCreate() {
        this.interfaceDialogUpdateVisible = true
      },
      ruleCreate() {
        this.ruleDialogUpdateVisible = true
      }

    },
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
