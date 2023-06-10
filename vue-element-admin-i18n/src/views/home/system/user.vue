<template>
  <div>
    <br>
    <form>
      <div>
        姓名：<input type="text" v-model="user.userName" placeholder="姓名">
        手机号：<input type="text" v-model="user.userTel" placeholder="手机">
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
        <el-table :data="List" border style="width: 100%; table-layout: fixed;">
          <el-table-column type="index" label="序号" width="50"/>
          <el-table-column prop="userId" label="姓名ID" v-if="showUserId">
          </el-table-column>
          <el-table-column prop="userEmail" label="用户邮箱" v-if="showUserId">
          </el-table-column>
          <el-table-column prop="userNick" label="用户昵称" v-if="showUserId">
          </el-table-column>
          <el-table-column prop="password" label="用户密码" v-if="showUserId">
          </el-table-column>
          <el-table-column prop="salt" label="盐值" v-if="showUserId">
          </el-table-column>
          <el-table-column prop="avatar" label="头像" v-if="showUserId">
          </el-table-column>
          <el-table-column
            prop="userName"
            label="姓名" width="100">
          </el-table-column>
          <el-table-column
            prop="userTel"
            label="联系电话" width="230">
          </el-table-column>
          <el-table-column prop="createTime" label="创建时间" width="230"></el-table-column>
          <el-table-column prop="updateTime" label="更新时间" width="230"></el-table-column>
          <el-table-column label="是否有效" width="80">
            <template slot-scope="scope">
              <el-tag :type="scope.row.isDelete.toString() === '0'?'info':'success'" @click="getUser(scope.row)">
                {{ scope.row.isDelete.toString() === '0' ? '无效' : '有效' }}
              </el-tag>
            </template>
          </el-table-column>
          <el-table-column
            fixed="right"
            label="操作"
            width="180">
            <template slot-scope="scope">
              <el-button type="danger" size="small" @click="getUserDetails(scope.row)">详情</el-button>
              <el-button type="warning" icon="el-icon-edit" size="small" @click="updUser(scope.row)">更新</el-button>
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
            @prev-click="getUserList(pages.pageNo-1,pages.pageSize)"
            @next-click="getUserList(pages.pageNo+1,pages.pageSize)"
            @current-change="currentHandlerEvent">
          </el-pagination>
        </div>
      </el-col>
    </el-row>

    <!-- 添加员工弹出层 -->
    <el-dialog
      title="添加员工"
      :visible.sync="addVisible"
      width="30%">
      <el-form ref="ruleForm" :model="user" label-width="110px">
        <el-form-item prop="userName" label="用户名">
          <el-input v-model="user.userName"></el-input>
        </el-form-item>
        <el-form-item prop="userTel" label="手机号">
          <el-input v-model="user.userTel"></el-input>
        </el-form-item>
        <el-form-item prop="userEmail" label="邮箱">
          <el-input v-model="user.userEmail"></el-input>
        </el-form-item>
        <el-form-item prop="userNick" label="昵称">
          <el-input v-model="user.userNick"></el-input>
        </el-form-item>
        <el-form-item prop="deptId" label="部门分类">
          <treeselect value-consists-of="LEAF_PRIORITY" v-model="deptList"
                      :multiple="true" :normalizer="normalizer" :options="listDept"
                      label-prop="false"/>
        </el-form-item>
        <el-form-item prop="roleId" label="角色">
          <treeselect v-model="roleList"
                      :multiple="true" :normalizer="normalizer1" :options="ListRole"
                      label-prop="false"/>
        </el-form-item>
        <el-form-item prop="password" label="密码">
          <el-input v-model="user.password"></el-input>
        </el-form-item>

        <el-form-item prop="createTime" label="创建时间">
          <el-date-picker
            v-model="user.createTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择日期"></el-date-picker>
        </el-form-item>
        <el-form-item label="是否有效" prop="isDelete">
          <el-radio-group v-model="user.isDelete">
            <el-radio :label="1">有效</el-radio>
            <el-radio :label="0">无效</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="add('ruleForm')">添加</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!--更新-->
    <el-dialog
      title="更新员工"
      :visible.sync="updateVisible"
      width="30%">
      <el-form ref="ruleForm" :model="userUpdate" label-width="110px">
        <el-form-item prop="userName" label="用户名">
          <el-input v-model="userUpdate.userName"></el-input>
        </el-form-item>
        <el-form-item prop="userTel" label="手机号">
          <el-input v-model="userUpdate.userTel"></el-input>
        </el-form-item>
        <el-form-item prop="userEmail" label="邮箱">
          <el-input v-model="userUpdate.userEmail"></el-input>
        </el-form-item>
        <el-form-item prop="userNick" label="昵称">
          <el-input v-model="userUpdate.userNick"></el-input>
        </el-form-item>
        <el-form-item prop="password" label="密码">
          <el-input v-model="userUpdate.password" show-password></el-input>
        </el-form-item>
        <el-form-item prop="createTime" label="创建时间">
          <el-date-picker
            v-model="userUpdate.createTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择日期"></el-date-picker>
        </el-form-item>
        <el-form-item label="是否有效" prop="isDelete">
          <el-radio-group v-model="userUpdate.isDelete">
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
    <!--详情-->
    <el-dialog
      title="详情"
      :visible.sync="getVisible"
      width="30%">
      <el-form ref="ruleForm" :model="userUpdate" label-width="110px">
        <el-form-item prop="userId" label="用户编号">
          <el-input v-model="ListUserRole.userId" disabled></el-input>
        </el-form-item>
        <el-form-item prop="userName" label="用户名称">
          <el-input v-model="ListUserRole.userName" disabled></el-input>
        </el-form-item>
        <el-form-item prop="userTel" label="手机号">
          <el-input v-model="ListUserRole.userTel" disabled></el-input>
        </el-form-item>
        <el-form-item prop="userEmail" label="邮箱">
          <el-input v-model="ListUserRole.userEmail" disabled></el-input>
        </el-form-item>
        <el-form-item prop="userNick" label="用户昵称">
          <el-input v-model="ListUserRole.userNick" disabled></el-input>
        </el-form-item>
        <el-form-item prop="password" label="密码">
          <el-input v-model="ListUserRole.password" show-password disabled></el-input>
        </el-form-item>
        <el-form-item prop="userNick" label="盐值">
          <el-input v-model="ListUserRole.userNick" disabled></el-input>
        </el-form-item>
        <el-form-item prop="deptName" label="部门">
          <el-input :value="deptName.join('').replace(/,/g, ' ')" disabled></el-input>
        </el-form-item>
        <el-form-item prop="roleNames" label="角色">
          <el-input :value="roleNames.join('').replace(/,/g, ' ')" disabled></el-input>
        </el-form-item>
        <el-form-item prop="createTime" label="创建时间">
          <el-input v-model="ListUserRole.createTime" disabled></el-input>
        </el-form-item>
        <el-form-item prop="updateTime" label="更新时间">
          <el-input v-model="ListUserRole.updateTime" disabled></el-input>
        </el-form-item>
        <el-form-item label="是否有效" prop="isDelete">
          <el-radio-group v-model="ListUserRole.isDelete" disabled>
            <el-radio :label="1">有效</el-radio>
            <el-radio :label="0">无效</el-radio>
          </el-radio-group>
        </el-form-item>
        <div>

        </div>
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
    name: 'user',
    // register the component
    components: { Treeselect },

    data() {
      return {
        value: true,
        List: [],
        isAllSelected: false,
        pages: {
          pageNo: 1,
          pageSize: 5,
          total: 0
        },
        getVisible: false,
        addVisible: false,
        showUserId: false,
        updateTime: false,
        deptList: [],
        listDept: [],
        normalizer(node) {
          return {
            id: node.deptId,
            label: node.deptName,
            children: node.departments
          }
        },
        normalizer1(node) {
          return {
            id: node.roleId,
            label: node.roleName,
            children: node.roleName
          }
        },
        //roleId: [],//用户角色关联
        roleList: [],
        ListRole: [],
        startTime: '',
        endTime: '',
        roleNames: [],//角色查询出来的多个角色名称
        deptName: [],//部门查询出的多个部门名称
        ListUserDepartment: '',
        ListUserRole: '',
        user: {
          deptId: [],///用户部门关联
          roleId: [],//角色关联
          userId: undefined,
          userName: '',
          userTel: '',
          userEmail: '',
          userNick: '',
          password: '',
          salt: '',
          avatar: '',
          createTime: '',
          updateTime: '',
          isDelete: ''
        },
        updateVisible: false,//显示隐藏
        originalData: {},//新增一个变量用于存储未修改时的数据
        userUpdate: {
          userId: undefined,
          userName: '',
          userTel: '',
          userEmail: '',
          password: '',
          salt: '',
          avatar: '',
          createTime: '',
          updateTime: '',
          isDelete: ''
        }
      }
    },
    created() {
      this.getUserList(this.pages.pageNo, this.pages.pageSize)
      this.getListDepartment()
      this.getListRole()
    },
    methods: {
      /*判断功能*/
      getUser(row) {
        const that = this
        that.userUpdate.userId = row.userId
        that.userUpdate.userName = row.userName
        that.userUpdate.userEmail = row.userEmail
        that.userUpdate.userTel = row.userTel
        that.userUpdate.userNick = row.userNick
        that.userUpdate.password = row.password
        that.userUpdate.salt = row.salt
        that.userUpdate.avatar = row.avatar
        that.userUpdate.createTime = row.createTime
        that.userUpdate.updateTime = row.updateTime
        that.userUpdate.isDelete = row.isDelete
        /*保存需要修改的原来行数据*/
        that.originalData = Object.assign({}, row)
        if (that.userUpdate.isDelete !== 0) {
          axios.get('http://127.0.0.1:8080/deleteUser', {
            params: {
              userId: row.userId
            }
          }).then(function(obj) {
            if (obj.data.code === 0) {
              that.$message({
                type: 'success',
                message: '删除成功！'
              })
              that.getUserList(that.pages.pageNo, that.pages.pageSize)
            } else {
              that.$message(obj.data.msg)
            }
          })
        } else {
          that.userUpdate.isDelete = 1
          axios.post('http://localhost:8080/updateUser', JSON.stringify(that.userUpdate), {
            headers: {
              'Content-Type': 'application/json'
            }
          }).then(function(obj) {
            if (obj.data.code === 0) {
              //that.resetForm1(formName) // 添加成功后立即执行清空表单操作
              that.updateVisible = false
              that.$message({
                type: 'success',
                message: '更新成功！'
              })
              that.getUserList(that.pages.pageNo, that.pages.pageSize)
            } else {
              that.$message(obj.data.msg)
            }
          })
        }
      },
      /*更新功能*/
      updUser(row) {
        const that = this
        that.updateVisible = true//设置更新页面打开

        that.userUpdate.userId = row.userId
        that.userUpdate.userName = row.userName
        that.userUpdate.userEmail = row.userEmail
        that.userUpdate.userTel = row.userTel
        that.userUpdate.userNick = row.userNick
        that.userUpdate.password = row.password
        that.userUpdate.salt = row.salt
        that.userUpdate.avatar = row.avatar
        that.userUpdate.createTime = row.createTime
        that.userUpdate.updateTime = row.updateTime
        that.userUpdate.isDelete = row.isDelete

        /*保存需要修改的原来行数据*/
        that.originalData = Object.assign({}, row)
      },
      /*更新员工*/
      update(formName) {
        const that = this
        console.log(that.userUpdate)
        that.$refs[formName].validate((valid) => {
          if (valid) {
            //校验通过
            axios.post('http://localhost:8080/updateUser', JSON.stringify(that.userUpdate), {
              headers: {
                'Content-Type': 'application/json'
              }
            }).then(function(obj) {
              if (obj.data.code === 0) {
                //that.resetForm1(formName) // 添加成功后立即执行清空表单操作
                that.updateVisible = false
                that.$message({
                  type: 'success',
                  message: '更新成功！'
                })
                that.getUserList(that.pages.pageNo, that.pages.pageSize)
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
        this.userUpdate = Object.assign({}, this.originalData)
      },

      getUserDetails(row) {
        const that = this
        that.getVisible = true
        console.log('row:', row)
        that.getUserRole(row.userId)
        that.getUserDepartment(row.userId)
        //回显

      },
      /* 添加员工 */
      add(formName) {
        const that = this
        //console.log(that.deptList)
        that.user.deptId = that.deptList
        that.user.roleId = that.roleList
        //console.log(that.user)
        //console.log('that.user', that.user)
        that.$refs[formName].validate((valid) => {
          if (valid) {
            //校验通过
            axios.post('http://localhost:8080/addUser', JSON.stringify(that.user), {
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
                that.deptList = [],
                  that.resetForm(formName) // 添加成功后立即执行清空添加表单操作
                that.getUserList(that.pages.pageNo, that.pages.pageSize)//返回
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
      /*添加重置表单*/
      resetForm(formName) {
        // 表单数据重置
        this.$refs[formName].resetFields()
      },

      /* 删除员工 */
      /*delUser: function(row) {
        const that = this
        console.log('that.row', row)
        that.$confirm('确认删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          axios.get('http://127.0.0.1:8080/deleteUser', {
            params: {
              userId: row.userId
            }
          }).then(function(obj) {
            if (obj.data.code === 0) {
              that.$message({
                type: 'success',
                message: '删除成功！'
              })
              that.getUserList(that.pages.pageNo, that.pages.pageSize)
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
      },*/
      /*中间页*/
      currentHandlerEvent: function(val) {
        this.pages.pageNo = val
        this.getUserList(val, this.pages.pageSize)
      },
      /*分页*/
      getUserList(pn, ps, Name, Tel, start, end) {
        const that = this
        that.pages.pageNo = pn
        that.pages.pageSize = ps
        that.user.userName = Name
        that.user.userTel = Tel
        that.startTime = start
        that.endTime = end
        console.log('Tel:', that.user.userTel)
        axios.get('http://127.0.0.1:8080/getUserList', {
          params: {
            pageNo: pn,
            pageSize: ps,
            userName: Name,
            userTel: Tel,
            startTime: start,
            endTime: end
          }
        }).then(function(obj) {
          that.List = obj.data.data.data
          that.pages.total = obj.data.data.total
        })
      },
      search() {
        const that = this
        //console.log("1:",that.user.userTel)
        that.getUserList(that.pages.pageNo, that.pages.pageSize,
          that.user.userName, that.user.userTel,
          that.startTime, that.endTime)
      },
      //部门全部查询
      getListDepartment() {
        const that = this
        axios.post('http://localhost:8080/getListDepartment').then(function(obj) {
          if (obj.data.code === 0) {
            that.listDept = obj.data.data
          } else {
            that.$message(obj.data.msg)
          }
        })
      },
      //角色全部查询
      getListRole() {
        const that = this
        axios.post('http://localhost:8080/getListRole').then(function(obj) {
          if (obj.data.code === 0) {
            that.ListRole = obj.data.data
            console.log('that.ListRole:', that.ListRole)
          } else {
            that.$message(obj.data.msg)
          }
        })
      },
      //查询所有的部门
      getUserDepartment(userId) {
        const that = this
        that.user.userId = userId
        //console.log('userId:', that.user.userId)
        axios.get('http://localhost:8080/getUserOne1', {
            params: {
              userId: userId
            }
          }
        ).then(function(obj) {
          if (obj.data.code === 0) {
            that.ListUserDepartment = obj.data.data
            that.deptName = [...that.ListUserDepartment.userDepartment.map((department) => department.department.map((d) => d.deptName))]
            //console.log('that.deptName:', that.deptName)
            //console.log('that.ListUserDepartment:', that.ListUserDepartment)
          } else {
            that.$message(obj.data.msg)
          }
        })
      },
      //查询所有的角色
      getUserRole(userId) {
        const that = this
        that.user.userId = userId

        //console.log('userId:', that.user.userId)
        axios.get('http://localhost:8080/getUserOne', {
            params: {
              userId: userId
            }
          }
        ).then(function(obj) {
          if (obj.data.code === 0) {
            that.ListUserRole = obj.data.data
            that.roleNames = [...that.ListUserRole.userRole.map((role) => role.role.map((r) => r.roleName))]

            //console.log('that.ListUserRole:', that.ListUserRole)
            //console.log('troleNames:', that.roleNames)
          } else {
            that.$message(obj.data.msg)
          }
        })
      }
    }
  }
</script>

<style scoped>

</style>
