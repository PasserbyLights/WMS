<template>
  <div>
    <br>
    <form>
      <div>
        姓名：<input type="text" v-model="customer.customerName" placeholder="客户姓名">
        手机号：<input type="text" v-model="customer.customerTel"  placeholder="手机号">
        开始时间：
        <el-date-picker v-model="startTime" type="datetime"  value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择开始时间">
        </el-date-picker>
        结束时间：
        <el-date-picker v-model="endTime" type="datetime"  value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择结束时间">
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
          <el-table-column prop="customerId" label="客户ID" v-if="showCustomerId">
          </el-table-column>
          <el-table-column
            prop="customerName"
            label="客户名称" width="130">
          </el-table-column>
          <el-table-column
            prop="customerLeader"
            label="联系人" width="120">
          </el-table-column>
          <el-table-column
            prop="customerTel"
            label="电话" width="120">
          </el-table-column>
          <el-table-column
            prop="customerEmail"
            label="邮箱" width="120">
          </el-table-column>
          <el-table-column
            prop="customerAddress"
            :show-overflow-tooltip="true"
            label="地址" width="200">
          </el-table-column>
          <el-table-column
            label="客户级别" width="150">
            <template slot-scope="scope">
              {{ scope.row.level.levelName }}
            </template>
          </el-table-column>
          <el-table-column
            label="客户来源" width="150">
            <template slot-scope="scope">
              {{ scope.row.source.sourceName }}
            </template>
          </el-table-column>
          <el-table-column
            label="客户行业" width="150">
            <template slot-scope="scope">
              {{ scope.row.industry.industryName }}
            </template>
          </el-table-column>
          <el-table-column prop="createTime" label="创建时间" width="180"></el-table-column>
          <el-table-column prop="updateTime" label="更新时间" width="180"></el-table-column>
          <el-table-column label="是否有效" width="100">
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
              <el-button type="danger" icon="el-icon-delete" size="small" @click="delCustomer(scope.row)">删除
              </el-button>
              <el-button type="warning" icon="el-icon-edit" size="small" @click="updCustomer(scope.row)">更新</el-button>
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
            @prev-click="getCustomerList(pages.pageNo-1,pages.pageSize)"
            @next-click="getCustomerList(pages.pageNo+1,pages.pageSize)"
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
      <el-form ref="ruleForm" :model="customer" :rules="rules">
        <el-form-item prop="customerName" label="客户名称">
          <el-input v-model="customer.customerName"></el-input>
        </el-form-item>
        <el-form-item prop="customerLeader" label="客户负责人">
          <el-input v-model="customer.customerLeader"></el-input>
        </el-form-item>
        <el-form-item prop="customerTel" label="联系电话">
          <el-input v-model="customer.customerTel"></el-input>
        </el-form-item>
        <el-form-item prop="customerEmail" label="邮箱">
          <el-input v-model="customer.customerEmail"></el-input>
        </el-form-item>
        <el-form-item prop="customerAddress" label="地址">
          <el-input v-model="customer.customerAddress"></el-input>
        </el-form-item>
        <el-form-item label="商品分类" prop="levelId">
          <el-select v-model="customer.levelId" placeholder="请选择客户级别">
            <el-option :label="level.levelName" :value="level.levelId" v-for="(level,index) in ListLevel"
                       :key="index"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="客户来源" prop="sourceId">
          <el-select v-model="customer.sourceId" placeholder="请选择客户来源">
            <el-option :label="source.sourceName" :value="source.sourceId" v-for="(source,index) in ListSource"
                       :key="index"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="商品行情" prop="industryId">
          <el-select v-model="customer.industryId" placeholder="请选择客户行情">
            <el-option :label="industry.industryName" :value="industry.industryId"
                       v-for="(industry,index) in ListIndustry"
                       :key="index"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="createTime" label="创建时间">
          <el-date-picker
            v-model="customer.createTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择日期"></el-date-picker>
        </el-form-item>
        <el-form-item label="是否有效" prop="isDelete">
          <el-radio-group v-model="customer.isDelete">
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
      <el-form ref="ruleForm" :model="customerUpdate" :rules="rules" label-width="110px">
        <el-form-item prop="customerName" label="客户信息">
          <el-input v-model="customerUpdate.customerName"></el-input>
        </el-form-item>
        <el-form-item prop="customerLeader" label="客户负责人">
          <el-input v-model="customerUpdate.customerLeader"></el-input>
        </el-form-item>
        <el-form-item prop="customerTel" label="联系电话">
          <el-input v-model="customerUpdate.customerTel"></el-input>
        </el-form-item>
        <el-form-item prop="customerEmail" label="邮箱">
          <el-input v-model="customerUpdate.customerEmail"></el-input>
        </el-form-item>
        <el-form-item prop="customerAddress" label="地址">
          <el-input v-model="customerUpdate.customerAddress"></el-input>
        </el-form-item>
        <el-form-item prop="createTime" label="创建时间">
          <el-date-picker
            v-model="customerUpdate.createTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择日期"></el-date-picker>
        </el-form-item>
        <el-form-item label="是否有效" prop="isDelete">
          <el-radio-group v-model="customerUpdate.isDelete">
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

  export default {
    name: 'client',

    data() {
      return {
        List: [],
        isAllSelected: false,
        ListLevel: '',//客户级别
        ListSource: '',//客户来源
        ListIndustry: '',//客户行情
        pages: {
          pageNo: 1,
          pageSize: 5,
          total: 0
        },
        addVisible: false,
        showCustomerId: false,
        updateTime: false,
        startTime: '',
        endTime: '',
        customer: {
          customerId: undefined,
          customerName: '',
          customerLeader: '',
          customerTel: '',
          customerEmail: '',
          customerAddress: '',
          levelId: '',
          sourceId: '',
          industryId: '',
          createTime: '',
          updateTime: '',
          isDelete: ''
        },
        updateVisible: false,//显示隐藏
        originalData: {},//新增一个变量用于存储未修改时的数据
        customerUpdate: {
          customerId: '',
          customerName: '',
          customerLeader: '',
          customerTel: '',
          customerEmail: '',
          customerAddress: '',
          levelId: '',
          sourceId: '',
          industryId: '',
          createTime: '',
          updateTime: '',
          isDelete: ''
        },
        rules: {
          customerName: [
            { required: true, message: '请输入客户名称', trigger: 'blur' }
          ],
          customerLeader: [
            { required: true, message: '请输入客户负责人', trigger: 'blur' }
          ],
          customerTel: [
            { required: true, message: '请输入联系电话', trigger: 'blur' }
          ],
          customerEmail: [
            { required: true, message: '请输入邮箱', trigger: 'blur' }
          ],
          customerAddress: [
            { required: true, message: '请输入地址', trigger: 'blur' }
          ],
          levelId: [
            { required: true, message: '请选择客户级别', trigger: 'blur' }
          ],
          sourceId: [
            { required: true, message: '请选择客户来源', trigger: 'blur' }
          ],
          industryId: [
            { required: true, message: '请选择客户行业', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '请输入创建时间', trigger: 'blur' }
          ],
          isDelete: [
            { required: true, message: '请选择是否有效', trigger: 'blur' }
          ]
        }
      }
    },
    created() {
      this.getCustomerList(this.pages.pageNo, this.pages.pageSize)
      this.getListIndustry()
      this.getListSource()
      this.getListLevel()
    },
    methods: {
      /*更新功能*/
      updCustomer(row) {
        const that = this
        that.updateVisible = true//设置更新页面打开

        that.customerUpdate.customerId = row.customerId
        that.customerUpdate.customerName = row.customerName
        that.customerUpdate.customerLeader = row.customerLeader
        that.customerUpdate.customerTel = row.customerTel
        that.customerUpdate.customerEmail = row.customerEmail
        that.customerUpdate.customerAddress = row.customerAddress
        that.customerUpdate.levelId = row.levelId
        that.customerUpdate.sourceId = row.sourceId
        that.customerUpdate.industryId = row.industryId
        that.customerUpdate.createTime = row.createTime
        that.customerUpdate.updateTime = row.updateTime
        that.customerUpdate.isDelete = row.isDelete
        /*保存需要修改的原来行数据*/
        that.originalData = Object.assign({}, row)
      },
      /*更新员工*/
      update(formName) {
        const that = this
        that.$refs[formName].validate((valid) => {
          if (valid) {
            //校验通过
            axios.post('http://localhost:8080/updateCustomer', JSON.stringify(that.customerUpdate), {
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
                that.getCustomerList(that.pages.pageNo, that.pages.pageSize)
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
        this.customerUpdate = Object.assign({}, this.originalData)
      },

      /* 添加员工 */
      add(formName) {
        const that = this
        that.$refs[formName].validate((valid) => {
          if (valid) {
            //校验通过
            axios.post('http://localhost:8080/addCustomer', JSON.stringify(that.customer), {
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
                that.getCustomerList(that.pages.pageNo, that.pages.pageSize)//返回
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
      delCustomer: function(row) {
        const that = this
        that.$confirm('确认删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          axios.get('http://127.0.0.1:8080/deleteCustomer', {
            params: {
              customerId: row.customerId
            }
          }).then(function(obj) {
            if (obj.data.code === 0) {
              that.$message({
                type: 'success',
                message: '删除成功！'
              })
              that.getCustomerList(that.pages.pageNo, that.pages.pageSize)
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
        this.getCustomerList(val, this.pages.pageSize)
      },
      /*分页*/
      getCustomerList(pn, ps,Name,Tel,start,end) {
        const that = this
        that.pages.pageNo = pn
        that.pages.pageSize = ps
        that.customer.customerName = Name
        that.customer.customerTel = Tel
        that.startTime = start
        that.endTime = end
        //console.log('startTime:', that.startTime)
        //console.log('endTime:', that.endTime)
        axios.get('http://127.0.0.1:8080/getCustomerList', {
          params: {
            pageNo: pn,
            pageSize: ps,
            customerName: Name,
            customerTel: Tel,
            startTime: start,
            endTime: end,
          }
        }).then(function(obj) {
          that.List = obj.data.data.data
          that.pages.total = obj.data.data.total
        })
      },
      search() {
        const that = this
        that.getCustomerList(that.pages.pageNo, that.pages.pageSize,
          that.customer.customerName, that.customer.customerTel,
          that.startTime, that.endTime)
        //const a = 1 / 0
      },
      //客户行业下拉框
      getListIndustry() {
        const that = this
        axios.post('http://localhost:8080/getListIndustry').then(function(obj) {
          if (obj.data.code === 0) {
            that.ListIndustry = obj.data.data
          } else {
            that.$message(obj.data.msg)
          }
        })
      },
      //客户来源下拉框
      getListSource() {
        const that = this
        axios.post('http://localhost:8080/getListSource').then(function(obj) {
          if (obj.data.code === 0) {
            that.ListSource = obj.data.data
          } else {
            that.$message(obj.data.msg)
          }
        })
      },
      //客户级别下拉框
      getListLevel() {
        const that = this
        axios.post('http://localhost:8080/getListLevel').then(function(obj) {
          if (obj.data.code === 0) {
            that.ListLevel = obj.data.data
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
