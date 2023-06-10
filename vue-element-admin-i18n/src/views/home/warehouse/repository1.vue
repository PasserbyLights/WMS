<template>
  <div>
    <br>
    <form>
      <div>
        仓库名称：<input type="text" v-model="repo.repoName" placeholder="客户姓名">
        开始时间：
        <el-date-picker v-model="startTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择开始时间">
        </el-date-picker>
        结束时间：
        <el-date-picker v-model="endTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择结束时间">
        </el-date-picker>
        <button @click="search">搜索</button>
      </div>
    </form>
    <br>
    <el-row :gutter="20" style="margin-top: 10px;">
      <el-col :span="20" :offset="1">
        <el-button type="primary" plain @click="addVisible = true">添 &nbsp; 加</el-button>
      </el-col>
    </el-row>
    <!--布局容器-->
    <el-row :gutter="20" style="margin-top: 5px;">
      <el-col :span="20" :offset="1">
        <el-table
          :data="List"
          border
          style="width: 100%">
          <el-table-column type="index" label="序号" width="50px"/>
          <el-table-column
            prop="repoName"
            label="仓库名称" width="180">
          </el-table-column>
          <el-table-column
            prop="repoAddress"
            label="仓库地址" width="180">
          </el-table-column>
          <el-table-column
            prop="repoArea"
            label="仓库面积" width="150">
          </el-table-column>
          <el-table-column
            label="描述" width="150"
            prop="repoDesc">
          </el-table-column>
          <el-table-column
            label="仓库状态" width="150"
            prop="repoStatus">
            <template slot-scope="scope">
              <span v-if="scope.row.repoStatus === 0">故障</span>
              <span v-else-if="scope.row.repoStatus === 1">正常</span>
              <span v-else-if="scope.row.repoStatus === 2">已满</span>
              <span v-else-if="scope.row.repoStatus === 3">废弃</span>
              <span v-else-if="scope.row.repoStatus === 0">故障</span>
              <!-- 其他情况 -->
            </template>
          </el-table-column>
          <el-table-column
            prop="createTime"
            label="创建时间" width="180">
          </el-table-column>
          <el-table-column
            prop="updateTime"
            label="更新时间" width="180">
          </el-table-column>
          <el-table-column
            label="是否有效">
            <template slot-scope="scope">
              <el-tag :type="scope.row.isDelete.toString() === '0'?'info':'success'">
                {{ scope.row.isDelete.toString() === '0' ? '无效' : '有效' }}
              </el-tag>
            </template>
          </el-table-column>
          <el-table-column
            fixed="right"
            label="操作"
            width="180">
            <template slot-scope="scope">
              <el-button type="danger" icon="el-icon-delete" size="small" @click="delLevel(scope.row)">删除</el-button>
              <el-button type="warning" icon="el-icon-edit" size="small" @click="updLevel(scope.row)">更新</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div style="text-align: center;">
          <el-pagination
            background
            :page-size="pages.pageSize"
            prev-text="上一页"
            next-text="下一页"
            layout="prev, pager, next"
            :total="pages.total"
            style="margin-top: 5px;"
            @prev-click="getRepositoryList(pages.pageNo-1,pages.pageSize)"
            @next-click="getRepositoryList(pages.pageNo+1,pages.pageSize)"
            @current-change="currentHandlerEvent">
          </el-pagination>
        </div>
      </el-col>
    </el-row>

    <!-- 添加员工弹出层 -->
    <el-dialog
      title="添加仓库"
      :visible.sync="addVisible"
      width="30%">
      <el-form ref="ruleForm" :model="repo" label-width="80px">
        <el-form-item prop="repoName" label="仓库名称">
          <el-input v-model="repo.repoName"></el-input>
        </el-form-item>
        <el-form-item prop="repoArea" label="仓库面积">
          <el-input v-model="repo.repoArea"></el-input>
        </el-form-item>
        <el-form-item prop="repoAddress" label="仓库地址">
          <el-input v-model="repo.repoAddress"></el-input>
        </el-form-item>
        <el-form-item prop="repoDesc" label="仓库描述">
          <el-input v-model="repo.repoDesc"></el-input>
        </el-form-item>
        <el-form-item prop="repo" label="仓库状态">
          <el-select v-model="repo.repoStatus" placeholder="请选择">
            <el-option label="故障" value="0"></el-option>
            <el-option label="正常" value="1"></el-option>
            <el-option label="已满" value="2"></el-option>
            <el-option label="废弃" value="3"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item prop="createTime" label="创建时间">
          <el-date-picker
            v-model="repo.createTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择日期"></el-date-picker>
        </el-form-item>
        <el-form-item prop="updateTime" label="更新时间"
                      ref="updateTime" style="display:none">
          <el-date-picker
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择日期"></el-date-picker>
        </el-form-item>
        <el-form-item label="是否有效" prop="isDelete">
          <el-radio-group v-model="repo.isDelete">
            <el-radio label="1">有效</el-radio>
            <el-radio label="0">无效</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="add('ruleForm')">添加</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!--更新弹出层-->
    <el-dialog
      title="更新仓库"
      :visible.sync="updateVisible"
      width="30%">
      <el-form ref="ruleForm" :model="repoUpdate" label-width="80px">
        <el-form-item prop="repoName" label="仓库名称">
          <el-input v-model="repoUpdate.repoName"></el-input>
        </el-form-item>
        <el-form-item prop="repoArea" label="仓库面积">
          <el-input v-model="repoUpdate.repoArea"></el-input>
        </el-form-item>
        <el-form-item prop="repoAddress" label="仓库地址">
          <el-input v-model="repoUpdate.repoAddress"></el-input>
        </el-form-item>
        <el-form-item prop="repoDesc" label="仓库描述">
          <el-input v-model="repoUpdate.repoDesc"></el-input>
        </el-form-item>
        <el-form-item prop="repoStatus" label="仓库状态">
          <el-select v-model="repoUpdate.repoStatus" placeholder="请选择" value-key="value">
            <el-option label="故障" value="0" value-key="value"></el-option>
            <el-option label="正常" value="1" value-key="value"></el-option>
            <el-option label="已满" value="2" value-key="value"></el-option>
            <el-option label="废弃" value="3" value-key="value"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="createTime" label="创建时间">
          <el-date-picker
            v-model="repoUpdate.createTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择日期"></el-date-picker>
        </el-form-item>
        <el-form-item prop="updateTime" label="更新时间"
                      ref="updateTime" style="display:none">
          <el-date-picker
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择日期"></el-date-picker>
        </el-form-item>
        <el-form-item label="是否有效" prop="isDelete">
          <el-radio-group v-model="repoUpdate.isDelete">
            <el-radio :label="1">有效</el-radio>
            <el-radio :label="0">无效</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="update('ruleForm')">更新</el-button>
          <el-button @click="resetForm1('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
  import axios from 'axios'

  // import the component
  import Treeselect from '@riophae/vue-treeselect'
  // import the styles
  import '@riophae/vue-treeselect/dist/vue-treeselect.css'

  export default {
    name: 'repository1',
    // register the component
    components: { Treeselect },
    data() {
      return {
        List: [],
        deptList: [],
        selectedRows: [],
        repoList: [],//存储选中repo分类的repoId
        ListRepository: [],//存储部门分类数据
        //部门分类
        normalizer(node) {
          return {
            id: node.repoId,
            label: node.repoName,
            children: node.categories
          }
        },
        isAllSelected: false,
        pages: {
          pageNo: 1,
          pageSize: 5,
          total: 0
        },
        addVisible: false,
        showEmpId: false,
        updateTime: false,
        repo: {
          repoId: undefined,
          repoName: '',
          repoAddress: '',
          repoArea: '',
          repoDesc: '',
          repoStatus: '',
          createTime: '',
          updateTime: '',
          isDelete: ''
        },
        startTime: '',
        endTime: '',
        updateVisible: false,//显示隐藏
        originalData: {},//新增一个变量用于存储未修改时的数据
        repoUpdate: {
          repoId: undefined,
          repoName: '',
          repoAddress: '',
          repoArea: '',
          repoDesc: '',
          repoStatus: '',
          createTime: '',
          updateTime: '',
          isDelete: ''
        }
      }
    },
    created() {
      this.getRepositoryList(this.pages.pageNo, this.pages.pageSize)
    },

    methods: {

      // 根据 repoId 查找对应的部门分类节点

      /*更新功能*/
      updLevel(row) {
        const that = this
        that.updateVisible = true//设置更新页面打开

        that.repoUpdate.repoId = row.repoId
        that.repoUpdate.repoName = row.repoName
        that.repoUpdate.repoAddress = row.repoAddress
        that.repoUpdate.repoArea = row.repoArea
        that.repoUpdate.repoDesc = row.repoDesc
        that.repoUpdate.repoStatus = String(row.repoStatus)
        that.repoUpdate.createTime = row.createTime
        that.repoUpdate.updateTime = row.updateTime
        that.repoUpdate.isDelete = row.isDelete

        /*保存需要修改的原来行数据*/
        that.originalData = Object.assign({}, row)
      },
      /*更新员工*/
      update(formName) {
        const that = this
        that.$refs[formName].validate((valid) => {
          if (valid) {
            //校验通过
            axios.post('http://localhost:8080/updateRepository', JSON.stringify(that.repoUpdate), {
              headers: {
                'Content-Type': 'application/json'
              }
            }).then(function(obj) {
              if (obj.data.code === 0) {
                that.updateVisible = false
                that.$message({
                  type: 'success',
                  message: '更新成功！'
                })
                that.resetForm1(formName)
                that.getRepositoryList(that.pages.pageNo, that.pages.pageSize)
              } else {
                that.$message(obj.data.msg)
              }
            })
          } else {
            that.$message('参数不合法')
            return false
          }
        })
      },
      /*更新重置表单*/
      resetForm1(ruleForm1) {
        // 表单数据重置
        this.$refs[ruleForm1].resetFields()
        /*重置表单时回显需要修改的原来行数据*/
        this.repoUpdate = Object.assign({}, this.originalData)
      },

      /* 添加员工 */
      add(formName) {
        const that = this
        that.repo.repoId = that.repoList[0]
        //console.log(that.repoList)
        //console.log(that.repo)
        that.$refs[formName].validate((valid) => {
          if (valid) {
            //校验通过
            axios.post('http://localhost:8080/addRepository', JSON.stringify(that.repo), {
              headers: {
                'Content-Type': 'application/json'
              }
            }).then(function(obj) {
              if (obj.data.code === 0) {
                that.addVisible = false//关闭弹窗
                that.$message({
                  type: 'success',
                  message: '添加成功！'
                })
                that.resetForm(formName) // 添加成功后立即执行清空添加表单操作
                that.getRepositoryList(that.pages.pageNo, that.pages.pageSize)//返回
              } else {
                that.$message(obj.data.msg)
              }
            })
          } else {
            that.$message('参数不合法')
            return false
          }
        })
      },
      /*重置表单*/
      resetForm(formName) {
        // 表单数据重置
        this.$refs[formName].resetFields()
      },

      /* 删除员工 */
      delLevel: function(row) {
        const that = this
        that.$confirm('确认删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          axios.get('http://127.0.0.1:8080/deleteRepository', {
            params: {
              repoId: row.repoId
            }
          }).then(function(obj) {
            if (obj.data.code === 0) {
              that.$message({
                type: 'success',
                message: '删除成功！'
              })
              that.getRepositoryList(that.pages.pageNo, that.pages.pageSize)
            } else {
              that.$message(obj.data.msg)
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除！'
          })
        })
      },

      /*中间页*/
      currentHandlerEvent: function(val) {
        this.pages.pageNo = val
        this.getRepositoryList(val, this.pages.pageSize)
      },
      /*分页*/
      getRepositoryList(pn, ps, Name, start, end) {
        const that = this
        that.pages.pageNo = pn
        that.pages.pageSize = ps
        that.repo.repoName = Name
        that.startTime = start
        that.endTime = end
        console.log(that.repo.repoName)
        console.log(that.startTime)
        console.log(that.endTime)

        axios.get('http://127.0.0.1:8080/getRepositoryList', {
          params: {
            pageNo: pn,
            pageSize: ps,
            repoName: Name,
            startTime: start,
            endTime: end
          }
        }).then(function(obj) {
          that.List = obj.data.data.data
          that.pages.total = obj.data.data.total
          //console.log(that.List)
        })
      },
      search() {
        const that = this
        //console.log(that.repo.repoName)
        that.getRepositoryList(that.pages.pageNo, that.pages.pageSize,
          that.repo.repoName, that.startTime, that.endTime)
      }
    }
  }
</script>

<style scoped>

</style>
