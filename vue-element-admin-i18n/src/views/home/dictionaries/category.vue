<template>
  <div>
    <el-row :gutter="20" style="margin-top: 10px;">
      <el-col :span="20" :offset="1">
        <el-button type="primary" plain @click="addVisible = true">添加一级商品</el-button>
      </el-col>
    </el-row>
    <!--布局容器-->
    <el-row :gutter="20" style="margin-top: 5px;">
      <el-col :span="20" :offset="1">
        <el-table
          :data="List"
          border
          style="width:100%"
          row-key="categoryId"
          :tree-props="{children: 'categories'}">
          <el-table-column
            prop="categoryName"
            label="商品名称">
          </el-table-column>
          <el-table-column
            prop="level"
            label="层级" width="50">
            <template slot-scope="scope">
              <el-tag :type="getLevelType(scope.row.level)">
                {{ scope.row.level }}
              </el-tag>
            </template>
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
            width="210">
            <template slot-scope="scope">
              <el-button type="danger" size="small" @click="delCategory(scope.row)">删除</el-button>
              <el-button type="warning" size="small" @click="updCategory(scope.row)">更新</el-button>
              <el-button v-if="scope.row.level !== 3" type="warning" size="small" @click="addCategory(scope.row)">添加
              </el-button>
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
            @prev-click="getCategoryList(pages.pageNo-1,pages.pageSize)"
            @next-click="getCategoryList(pages.pageNo+1,pages.pageSize)"
            @current-change="currentHandlerEvent">
          </el-pagination>
        </div>
      </el-col>
    </el-row>

    <!--添加层-->
    <el-dialog
      title="添加商品"
      :visible.sync="addVisible"
      width="30%">
      <el-form ref="ruleForm" :model="category" :rules="rules" label-width="80px">
        <el-form-item prop="categoryName" label="商品名称">
          <el-input v-model="category.categoryName"></el-input>
        </el-form-item>
        <el-form-item prop="createTime" label="创建时间">
          <el-date-picker
            v-model="category.createTime"
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
          <el-radio-group v-model="category.isDelete">
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
    <!--更新-->
    <el-dialog
      title="更新商品"
      :visible.sync="updateVisible"
      width="30%">
      <el-form ref="ruleForm" :model="categoryUpdate" :rules="rules" label-width="80px">
        <el-form-item prop="categoryName" label="商品名称">
          <el-input v-model="categoryUpdate.categoryName"></el-input>
        </el-form-item>
        <el-form-item prop="createTime" label="创建时间">
          <el-date-picker
            v-model="categoryUpdate.createTime"
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
          <el-radio-group v-model="categoryUpdate.isDelete">
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
    name: "category",
    data() {
      return {
        List: [],
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
        category: {
          categoryId: undefined,
          categoryName: '',
          level: '',
          parentId: '',
          createTime: '',
          updateTime: '',
          isDelete: '',
        },
        updateVisible: false,//显示隐藏
        originalData: {},//新增一个变量用于存储未修改时的数据
        categoryUpdate: {
          categoryId: '',
          categoryName: '',
          level: '',
          parentId: '',
          createTime: '',
          updateTime: '',
          isDelete: '',
        },
        rules: {
          categoryName: [
            {required: true, message: '请输入商品名称', trigger: 'blur'}
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
      this.getCategoryList(this.pages.pageNo, this.pages.pageSize)
    },
    methods: {
      /*级别样式*/
      getLevelType(level) {
        if (level === 1) {
          return 'success'
        } else if (level === 2) {
          return 'warning'
        } else if (level === 3) {
          return 'info'
        } else {
          return 'danger'
        }
      },

      /*更新功能*/
      updCategory(row) {
        const that = this
        that.updateVisible = true//设置更新页面打开

        that.categoryUpdate.categoryId = row.categoryId
        that.categoryUpdate.categoryName = row.categoryName
        that.categoryUpdate.level = row.level
        that.categoryUpdate.parentId = row.parentId
        that.categoryUpdate.createTime = row.createTime
        that.categoryUpdate.updateTime = row.updateTime
        that.categoryUpdate.isDelete = row.isDelete
        /*保存需要修改的原来行数据*/
        that.originalData = Object.assign({}, row)
      }
      ,
      /*更新员工*/
      update(formName) {
        const that = this
        that.$refs[formName].validate((valid) => {
          if (valid) {
            //校验通过
            axios.post('http://localhost:8080/updateCategory', JSON.stringify(that.categoryUpdate), {
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
                that.getCategoryList(that.pages.pageNo, that.pages.pageSize)
              } else {
                that.$message(obj.data.msg)
              }
            })
          } else {
            that.$message('参数不合法')
            return false
          }
        })
      }
      ,
      /*更新重置表单*/
      resetForm1(ruleForm1) {
        // 表单数据重置
        this.$refs[ruleForm1].resetFields()
        /*重置表单时回显需要修改的原来行数据*/
        this.categoryUpdate = Object.assign({}, this.originalData)
      }
      ,


      /*添加回显*/
      addCategory(row) {
        const that = this
        that.addVisible = true//设置更新页面打开
        //console.log(row.category)
        that.category.level = row.level + 1
        that.category.parentId = row.categoryId
        that.category.updateTime = row.updateTime
        /*保存需要修改的原来行数据*/
        that.originalData = Object.assign({}, row)
      }
      ,
      /* 添加员工 */
      add(formName) {
        const that = this
        if (that.category.level === "" && that.category.parentId === "") {
          that.category.level = 1;
          that.category.parentId = 0;
        }
        console.log(that.category)
        that.$refs[formName].validate((valid) => {
          if (valid) {
            //校验通过
            axios.post('http://localhost:8080/addCategory', JSON.stringify(that.category), {
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
                that.getCategoryList(that.pages.pageNo, that.pages.pageSize)//返回
              } else {
                that.$message(obj.data.msg)
              }
            })
          } else {
            that.$message('参数不合法')
            return false
          }
        })
      }
      ,
      /*重置表单*/
      resetForm(formName) {
        // 表单数据重置
        this.$refs[formName].resetFields()
      }
      ,

      /*删除功能*/
      delCategory: function (row) {
        //console.log("row:",row.categories)
        if (!row.categories || row.categories.length === 0) {

          const that = this
          that.$confirm('确认删除?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            axios.get('http://127.0.0.1:8080/deleteCategory', {
              params: {
                categoryId: row.categoryId
              }
            }).then(function (obj) {
              if (obj.data.code === 0) {
                that.$message({
                  type: 'success',
                  message: '删除成功！'
                })
                that.getCategoryList(that.pages.pageNo, that.pages.pageSize)
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
        } else {
          this.$message({
            type: 'info',
            message: '子节点下还有商品，不能删除！'
          })
        }
      }
      ,
      /*中间页*/
      currentHandlerEvent: function (val) {
        this.pages.pageNo = val
        this.getCategoryList(val, this.pages.pageSize)
      }
      ,
      /*分页*/
      getCategoryList(pn, ps) {
        const that = this
        that.pages.pageNo = pn
        that.pages.pageSize = ps
        axios.get('http://127.0.0.1:8080/getCategoryList', {
          params: {
            pageNo: pn,
            pageSize: ps
          }
        }).then(function (obj) {
          that.List = obj.data.data.data
          that.pages.total = obj.data.data.total
        })
      }
      ,
    }
  }

</script>

<style scoped>

</style>
