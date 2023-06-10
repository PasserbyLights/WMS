<template>
  <div>
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
            prop="levelId"
            label="客户级别ID">
          </el-table-column>
          <el-table-column
            prop="levelName"
            label="客户级别名称">
          </el-table-column>
          <el-table-column
            prop="createTime"
            label="创建时间">
          </el-table-column>
          <el-table-column
            prop="updateTime"
            label="更新时间">
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
            @prev-click="getLevelList(pages.pageNo-1,pages.pageSize)"
            @next-click="getLevelList(pages.pageNo+1,pages.pageSize)"
            @current-change="currentHandlerEvent">
          </el-pagination>
        </div>
      </el-col>
    </el-row>

    <!-- 添加员工弹出层 -->
    <el-dialog
      title="添加客户"
      :visible.sync="addVisible"
      width="30%">
      <el-form ref="ruleForm" :model="level" :rules="rules" label-width="80px">
        <el-form-item prop="levelName" label="行业名称">
          <el-input v-model="level.levelName"></el-input>
        </el-form-item>
        <el-form-item prop="createTime" label="创建时间">
          <el-date-picker
            v-model="level.createTime"
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
          <el-radio-group v-model="level.isDelete">
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
      title="更新客户"
      :visible.sync="updateVisible"
      width="30%">
      <el-form ref="ruleForm" :model="levelUpdate" :rules="rules" label-width="80px">
        <el-form-item prop="levelName" label="行业名称">
          <el-input v-model="levelUpdate.levelName"></el-input>
        </el-form-item>
        <el-form-item prop="createTime" label="创建时间">
          <el-date-picker
            v-model="levelUpdate.createTime"
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
          <el-radio-group v-model="levelUpdate.isDelete">
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
    import axios from "axios";

    export default {
        name: "level",
      data() {
        return {
          List: [],
          deptList: [],
          selectedRows: [],
          isAllSelected: false,
          pages: {
            pageNo: 1,
            pageSize: 5,
            total: 0
          },
          addVisible: false,
          showEmpId: false,
          updateTime: false,
          level: {
            levelId: undefined,
            levelName: '',
            createTime: '',
            updateTime: '',
            isDelete: '',
          },
          updateVisible: false,//显示隐藏
          originalData: {},//新增一个变量用于存储未修改时的数据
          levelUpdate: {
            levelId: '',
            levelName: '',
            createTime: '',
            updateTime: '',
            isDelete: '',
          },
          rules: {
            levelName: [
              {required: true, message: '请输入客户级别名称', trigger: 'blur'}
            ],
            createTime: [
              {required: true, message: '请输入创建时间', trigger: 'blur'}
            ],
            isDelete: [
              {required: true, message: '请输入是否有效', trigger: 'blur'}
            ],
          }
        }
      },
      created() {
        this.getLevelList(this.pages.pageNo, this.pages.pageSize)
      },
      methods: {


        /*更新功能*/
        updLevel(row) {
          const that = this
          that.updateVisible = true//设置更新页面打开

          that.levelUpdate.levelId = row.levelId
          that.levelUpdate.levelName = row.levelName
          that.levelUpdate.createTime = row.createTime
          that.levelUpdate.updateTime = row.updateTime
          that.levelUpdate.isDelete = row.isDelete
          /*保存需要修改的原来行数据*/
          that.originalData = Object.assign({}, row)
        },
        /*更新员工*/
        update(formName) {
          const that = this
          that.$refs[formName].validate((valid) => {
            if (valid) {
              //校验通过
              axios.post('http://localhost:8080/updateLevel', JSON.stringify(that.levelUpdate), {
                headers: {
                  'Content-Type': 'application/json'
                }
              }).then(function (obj) {
                if (obj.data.code === 0) {
                  //that.resetForm1(formName) // 添加成功后立即执行清空表单操作
                  that.updateVisible = false
                  that.$message({
                    type: 'success',
                    message: '更新成功！'
                  })
                  that.getLevelList(that.pages.pageNo, that.pages.pageSize)
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
          this.levelUpdate = Object.assign({}, this.originalData)
        },

        /* 添加员工 */
        add(formName) {
          const that = this
          that.$refs[formName].validate((valid) => {
            if (valid) {
              //校验通过
              axios.post('http://localhost:8080/addLevel', JSON.stringify(that.level), {
                headers: {
                  'Content-Type': 'application/json'
                }
              }).then(function (obj) {
                if (obj.data.code === 0) {
                  that.addVisible = false//关闭弹窗
                  that.$message({
                    type: 'success',
                    message: '添加成功！'
                  })
                  that.resetForm(formName) // 添加成功后立即执行清空添加表单操作
                  that.getLevelList(that.pages.pageNo, that.pages.pageSize)//返回
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
        delLevel: function (row) {
          const that = this
          that.$confirm('确认删除?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            axios.get('http://127.0.0.1:8080/deleteLevel', {
              params: {
                levelId: row.levelId
              }
            }).then(function (obj) {
              if (obj.data.code === 0) {
                that.$message({
                  type: 'success',
                  message: '删除成功！'
                })
                that.getLevelList(that.pages.pageNo, that.pages.pageSize)
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
        currentHandlerEvent: function (val) {
          this.pages.pageNo = val
          this.getLevelList(val, this.pages.pageSize)
        },
        /*分页*/
        getLevelList(pn, ps) {
          const that = this
          that.pages.pageNo = pn
          that.pages.pageSize = ps
          axios.get('http://127.0.0.1:8080/getLevelList', {
            params: {
              pageNo: pn,
              pageSize: ps
            }
          }).then(function (obj) {
            that.List = obj.data.data.data
            that.pages.total = obj.data.data.total
          })
        },

      }
    }
</script>

<style scoped>

</style>
