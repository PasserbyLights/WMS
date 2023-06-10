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
            prop="productName"
            label="产品名称">
          </el-table-column>

          <el-table-column
            prop="productPrice"
            label="产品价格">
          </el-table-column>
          <el-table-column
            prop="productSize"
            label="产品尺寸">
          </el-table-column>
          <el-table-column
            label="产品分类" width="150">
            <template slot-scope="scope">
              {{ scope.row.category.categoryName }}
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
            @prev-click="getProductList(pages.pageNo-1,pages.pageSize)"
            @next-click="getProductList(pages.pageNo+1,pages.pageSize)"
            @current-change="currentHandlerEvent">
          </el-pagination>
        </div>
      </el-col>
    </el-row>

    <!-- 添加员工弹出层 -->
    <el-dialog
      title="添加产品"
      :visible.sync="addVisible"
      width="30%">
      <el-form ref="ruleForm" :model="product" :rules="rules" label-width="80px">
        <el-form-item prop="productName" label="产品名称">
          <el-input v-model="product.productName"></el-input>
        </el-form-item>
        <el-form-item prop="productSize" label="产品尺寸">
          <el-input v-model="product.productSize"></el-input>
        </el-form-item>
        <el-form-item prop="productPrice" label="产品价格">
          <el-input v-model="product.productPrice"></el-input>
        </el-form-item>
        <el-form-item prop="categoryId" label="产品分类">
          <treeselect value-consists-of="LEAF_PRIORITY" v-model="categoryList"
                      :multiple="true" :normalizer="normalizer" :options="ListCategory"
                      label-prop="false"/>
        </el-form-item>
        <el-form-item prop="createTime" label="创建时间">
          <el-date-picker
            v-model="product.createTime"
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
          <el-radio-group v-model="product.isDelete">
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
      title="更新产品"
      :visible.sync="updateVisible"
      width="30%">
      <el-form ref="ruleForm" :model="productUpdate" :rules="rules" label-width="80px">
        <el-form-item prop="productName" label="产品名称">
          <el-input v-model="productUpdate.productName"></el-input>
        </el-form-item>
        <el-form-item prop="productSize" label="产品尺寸">
          <el-input v-model="productUpdate.productSize"></el-input>
        </el-form-item>
        <el-form-item prop="productPrice" label="产品价格">
          <el-input v-model="productUpdate.productPrice"></el-input>
        </el-form-item>
        <el-form-item prop="productId" label="产品分类">
          <treeselect value-consists-of="LEAF_PRIORITY" v-model="categoryList"
                      :multiple="true" :normalizer="normalizer" :options="ListCategory"
                      label-prop="false" />
        </el-form-item>
        <el-form-item prop="createTime" label="创建时间">
          <el-date-picker
            v-model="productUpdate.createTime"
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
          <el-radio-group v-model="productUpdate.isDelete">
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
    name: 'product',
    // register the component
    components: { Treeselect },
    data() {
      return {
        List: [],
        deptList: [],
        selectedRows: [],
        categoryList: [],//存储选中category分类的categoryId
        ListCategory: [],//存储部门分类数据
        //部门分类
        normalizer(node) {
          return {
            id: node.categoryId,
            label: node.categoryName,
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
        product: {
          productId: undefined,
          productName: '',
          categoryId: '',
          productSize: '',
          productPrice: '',
          createTime: '',
          updateTime: '',
          isDelete: ''
        },
        updateVisible: false,//显示隐藏
        originalData: {},//新增一个变量用于存储未修改时的数据
        productUpdate: {
          productId: undefined,
          productName: '',
          categoryId: '',
          productSize: '',
          productPrice: '',
          createTime: '',
          updateTime: '',
          isDelete: ''
        },
        rules: {
          productName: [
            { required: true, message: '请输入产品级别名称', trigger: 'blur' }
          ],
          categoryId: [
            { required: true, message: '请输入产品类目', trigger: 'blur' }
          ],
          productSize: [
            { required: true, message: '请输入产品尺寸', trigger: 'blur' }
          ],
          productPrice: [
            { required: true, message: '请输入产品价格', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '请输入创建时间', trigger: 'blur' }
          ],
          isDelete: [
            { required: true, message: '请输入是否有效', trigger: 'blur' }
          ]
        }
      }
    },
    created() {
      this.getProductList(this.pages.pageNo, this.pages.pageSize)
      this.getListCategory()
    },

    methods: {

      // 根据 categoryId 查找对应的部门分类节点
      findNodeByCategoryId(nodes, categoryId) {
        for (const node of nodes) {
          if (node.categoryId === categoryId) {
            return node.categoryId
          }
          if (node.categories) {
            const childNode = this.findNodeByCategoryId(node.categories, categoryId)
            if (childNode) {
              return childNode
            }
          }
        }
        return null
      },
      /*更新功能*/
      updLevel(row) {
        const that = this
        that.updateVisible = true//设置更新页面打开

        that.productUpdate.productId = row.productId
        that.productUpdate.productName = row.productName
        that.productUpdate.categoryId = row.categoryId
        that.productUpdate.productSize = row.productSize
        that.productUpdate.productPrice = row.productPrice
        that.productUpdate.createTime = row.createTime
        that.productUpdate.updateTime = row.updateTime
        that.productUpdate.isDelete = row.isDelete

        const categoryId = that.productUpdate.categoryId
        //console.log('categoryId:', categoryId)
        const categoryNode = that.findNodeByCategoryId(that.ListCategory, categoryId)
        if (categoryNode) {
          // 将找到的部门分类节点对象加入 categoryList 中
          that.categoryList.push(categoryNode)
          console.log(that.ListCategory)
          console.log('that.categoryList:', that.categoryList)
        }
        /*保存需要修改的原来行数据*/
        that.originalData = Object.assign({}, row)
      },
      /*更新员工*/
      update(formName) {
        const that = this
        //console.log('that.categoryList:', that.categoryList)
        that.productUpdate.categoryId = that.categoryList[0]
        //console.log('that.productUpdate:', that.productUpdate)
        that.$refs[formName].validate((valid) => {
          if (valid) {
            //校验通过
            axios.post('http://localhost:8080/updateProduct', JSON.stringify(that.productUpdate), {
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
                that.categoryList = [],
                  that.getProductList(that.pages.pageNo, that.pages.pageSize)
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
        this.productUpdate = Object.assign({}, this.originalData)
      },

      /* 添加员工 */
      add(formName) {
        const that = this
        that.product.categoryId = that.categoryList[0]
        //console.log(that.categoryList)
        //console.log(that.product)
        that.$refs[formName].validate((valid) => {
          if (valid) {
            //校验通过
            axios.post('http://localhost:8080/addProduct', JSON.stringify(that.product), {
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
                that.categoryList = [],
                  that.resetForm(formName) // 添加成功后立即执行清空添加表单操作
                that.getProductList(that.pages.pageNo, that.pages.pageSize)//返回
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
          axios.get('http://127.0.0.1:8080/deleteProduct', {
            params: {
              productId: row.productId
            }
          }).then(function(obj) {
            if (obj.data.code === 0) {
              that.$message({
                type: 'success',
                message: '删除成功！'
              })
              that.getProductList(that.pages.pageNo, that.pages.pageSize)
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
        this.getProductList(val, this.pages.pageSize)
      },
      /*分页*/
      getProductList(pn, ps) {
        const that = this
        that.pages.pageNo = pn
        that.pages.pageSize = ps
        axios.get('http://127.0.0.1:8080/getProductList', {
          params: {
            pageNo: pn,
            pageSize: ps
          }
        }).then(function(obj) {
          that.List = obj.data.data.data
          that.pages.total = obj.data.data.total
          //console.log(that.List)
        })
      },
      /*查询分类*/
      getListCategory() {
        const that = this
        axios.post('http://localhost:8080/getListCategory').then(function(obj) {
          if (obj.data.code === 0) {
            that.ListCategory = obj.data.data
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
