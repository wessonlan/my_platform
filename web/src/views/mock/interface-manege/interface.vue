<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input placeholder="项目名称" style="width: 200px;" class="filter-item" />
      <el-button class="filter-item"  type="primary" icon="el-icon-search" style="margin-left:10px;">
        查询
      </el-button>
      <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-edit"
                 @click="projectCreate(createInfo)">
        新建
      </el-button>
    </div>
    <div style="margin-top:20px;"></div>
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row>
      <el-table-column align="center" label="项目ID" width="95">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column label="项目名称">
        <template slot-scope="scope">
          {{ scope.row.projectName }}
        </template>
      </el-table-column>
      <el-table-column label="项目描述">
        <template slot-scope="scope">
          {{ scope.row.description }}
        </template>
      </el-table-column>
      <el-table-column label="创建人" width="110" align="center">
        <template slot-scope="scope">
          <span>{{ scope.row.createUser }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" width="220" align="center">
        <template slot-scope="scope">
          {{ scope.row.createTime }}
        </template>
      </el-table-column>
      <el-table-column class-name="status-col" label="操作" width="150" align="center">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="projectUpdate(scope.row)">修改</el-button>
          <el-button type="text" size="small" @click="gotoInterface(scope.row.id)">接口mock</el-button>
        </template>
      </el-table-column>
    </el-table>


    <el-dialog :visible.sync="dialogUpdateVisible" :title="dialogStatus==='create'?'添加项目':'更新项目'" >
      <el-form ref="dataForm" :model="createInfo" label-position="left" label-width="70px" style="width: 400px; margin-left:50px;">
        <el-form-item label="项目名称" prop="title">
          <el-input v-model="createInfo.projectName" />
        </el-form-item>
        <el-form-item label="项目描述">
          <el-input v-model="createInfo.description" :autosize="{ minRows: 2, maxRows: 4}" type="textarea" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogUpdateVisible = false">
          取消
        </el-button>
        <el-button type="primary" @click="dialogStatus==='create'?handleProjectCreate():handleProjectUpdate()">
          {{ dialogStatus === 'create'?'添加':'更新' }}
        </el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import { getProjectList, createProject, updateProject } from '@/api/interface'

  export default {
    data() {
      return {
        list: null,
        listLoading: true,
        dialogStatus: undefined,
        dialogUpdateVisible: false,
        createInfo: {
          projectName: '',
          description: ''
        }
      }
    },
    created() {
      this.projectGet()
    },
    methods: {
      projectGet() { //调用后端接口，获取项目列表
        this.listLoading = true
        getProjectList().then(response => {
          this.list = response.data
          this.listLoading = false
        })
      },
      requestInfo() {
        this.createInfo.projectName = '',
          this.createInfo.description = ''
      },
      projectCreate() {
        this.requestInfo()
        this.dialogStatus = 'create'
        this.dialogUpdateVisible = true
      },
      handleProjectCreate() { //调用后端接口，创建项目
        createProject(this.createInfo).then(() => {
          this.dialogUpdateVisible = false
          this.projectGet()
          this.$notify({ //调用消息通知组件
            title: '成功',
            message: '项目添加成功',
            type: 'success',
            duration: 2000
          })
        })
      },
      projectUpdate(row) {
        this.createInfo = Object.assign({}, row)
        this.dialogStatus = 'update'
        this.dialogUpdateVisible = true
      },
      handleProjectUpdate() {
        updateProject(this.createInfo).then(() => {
          this.dialogUpdateVisible = false
          this.projectGet()
          this.$notify({
            title: '成功',
            message: this.createInfo.projectName + '项目更新成功',
            type: 'success',
            duration: 2000
          })
        })
      }
    }
  }
</script>
