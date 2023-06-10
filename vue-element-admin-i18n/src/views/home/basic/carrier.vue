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
        <el-table :data="List" border style="width: 100%; table-layout: fixed;">
          <el-table-column type="index" label="序号" width="50"/>
          <el-table-column prop="carrierId" label="承运商ID" v-if="showCarrierId">
          </el-table-column>
          <el-table-column
            prop="carrierName"
            label="承运商名称"  width="130">
          </el-table-column>
          <el-table-column
            prop="carrierLeader"
            label="承运商联系人"   width="120">
          </el-table-column>
          <el-table-column
            prop="carrierTel"
            label="承运商联系电话" width="120">
          </el-table-column>
          <el-table-column
            prop="carrierEmail"
            label="承运商邮箱"  width="120">
          </el-table-column>
          <el-table-column
            prop="carrierAddress"
            :show-overflow-tooltip="true"
            label="承运商联系地址"  width="200">
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
              <el-button type="danger" icon="el-icon-delete" size="small" @click="delCarrier(scope.row)">删除
              </el-button>
              <el-button type="warning" icon="el-icon-edit" size="small" @click="updCarrier(scope.row)">更新</el-button>
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
            @prev-click="getCarrierList(pages.pageNo-1,pages.pageSize)"
            @next-click="getCarrierList(pages.pageNo+1,pages.pageSize)"
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
      <el-form ref="ruleForm" :model="carrier" :rules="rules">
        <el-form-item prop="carrierName" label="承运商名称" >
          <el-input v-model="carrier.carrierName"></el-input>
        </el-form-item>
        <el-form-item prop="carrierLeader" label="承运商负责人">
          <el-input v-model="carrier.carrierLeader"></el-input>
        </el-form-item>
        <el-form-item prop="carrierTel" label="联系电话">
          <el-input v-model="carrier.carrierTel"></el-input>
        </el-form-item>
        <el-form-item prop="carrierEmail" label="邮箱">
          <el-input v-model="carrier.carrierEmail"></el-input>
        </el-form-item>
        <el-form-item prop="carrierAddress" label="地址">
          <el-input v-model="carrier.carrierAddress"></el-input>
        </el-form-item>
        <el-form-item prop="createTime" label="创建时间">
          <el-date-picker
            v-model="carrier.createTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择日期"></el-date-picker>
        </el-form-item>
        <el-form-item label="是否有效" prop="isDelete">
          <el-radio-group v-model="carrier.isDelete">
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
      <el-form ref="ruleForm" :model="carrierUpdate" :rules="rules" label-width="110px">
        <el-form-item prop="carrierName" label="承运商信息">
          <el-input v-model="carrierUpdate.carrierName"></el-input>
        </el-form-item>
        <el-form-item prop="carrierLeader" label="承运商负责人">
          <el-input v-model="carrierUpdate.carrierLeader"></el-input>
        </el-form-item>
        <el-form-item prop="carrierTel" label="联系电话">
          <el-input v-model="carrierUpdate.carrierTel"></el-input>
        </el-form-item>
        <el-form-item prop="carrierEmail" label="邮箱">
          <el-input v-model="carrierUpdate.carrierEmail"></el-input>
        </el-form-item>
        <el-form-item prop="carrierAddress" label="地址">
          <el-input v-model="carrierUpdate.carrierAddress"></el-input>
        </el-form-item>
        <el-form-item prop="createTime" label="创建时间">
          <el-date-picker
            v-model="carrierUpdate.createTime"
            type="datetime"
            value-format="yyyy-MM-dd HH:mm:ss"
            placeholder="选择日期"></el-date-picker>
        </el-form-item>
        <el-form-item label="是否有效" prop="isDelete">
          <el-radio-group v-model="carrierUpdate.isDelete">
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
    name: "carrier",

    data() {
      return {
        List: [],
        isAllSelected: false,
        pages: {
          pageNo: 1,
          pageSize: 5,
          total: 0
        },
        addVisible: false,
        showCarrierId: false,
        updateTime: false,
        carrier: {
          carrierId: undefined,
          carrierName: '',
          carrierLeader: '',
          carrierTel: '',
          carrierEmail: '',
          carrierAddress: '',
          createTime: '',
          updateTime: '',
          isDelete: '',
        },
        updateVisible: false,//显示隐藏
        originalData: {},//新增一个变量用于存储未修改时的数据
        carrierUpdate: {
          carrierId: "",
          carrierName: '',
          carrierLeader: '',
          carrierTel: '',
          carrierEmail: '',
          carrierAddress: '',
          createTime: '',
          updateTime: '',
          isDelete: '',
        },
        rules: {
          carrierName: [
            {required: true, message: '请输入承运商信息', trigger: 'blur'}
          ],
          carrierLeader: [
            {required: true, message: '请输入承运商负责人', trigger: 'blur'}
          ],
          carrierTel: [
            {required: true, message: '请输入联系电话', trigger: 'blur'}
          ],
          carrierEmail: [
            {required: true, message: '请输入邮箱', trigger: 'blur'}
          ],
          carrierAddress: [
            {required: true, message: '请输入地址', trigger: 'blur'}
          ],
          createTime: [
            {required: true, message: '请输入创建时间', trigger: 'blur'}
          ],
          isDelete: [
            {required: true, message: '请选择是否有效', trigger: 'blur'}
          ],
        }
      }
    },
    created() {
      this.getCarrierList(this.pages.pageNo, this.pages.pageSize)
    },
    methods: {
      /*更新功能*/
      updCarrier(row) {
        const that = this
        that.updateVisible = true//设置更新页面打开

        that.carrierUpdate.carrierId = row.carrierId
        that.carrierUpdate.carrierName = row.carrierName
        that.carrierUpdate.carrierLeader = row.carrierLeader
        that.carrierUpdate.carrierTel = row.carrierTel
        that.carrierUpdate.carrierEmail = row.carrierEmail
        that.carrierUpdate.carrierAddress = row.carrierAddress
        that.carrierUpdate.createTime = row.createTime
        that.carrierUpdate.updateTime = row.updateTime
        that.carrierUpdate.isDelete = row.isDelete
        /*保存需要修改的原来行数据*/
        that.originalData = Object.assign({}, row)
      },
      /*更新员工*/
      update(formName) {
        const that = this
        that.$refs[formName].validate((valid) => {
          if (valid) {
            //校验通过
            axios.post('http://localhost:8080/updateCarrier', JSON.stringify(that.carrierUpdate), {
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
                that.getCarrierList(that.pages.pageNo, that.pages.pageSize)
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
        this.carrierUpdate = Object.assign({}, this.originalData)
      },


      /* 添加员工 */
      add(formName) {
        const that = this
        that.$refs[formName].validate((valid) => {
          if (valid) {
            //校验通过
            axios.post('http://localhost:8080/addCarrier', JSON.stringify(that.carrier), {
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
                that.getCarrierList(that.pages.pageNo, that.pages.pageSize)//返回
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
      delCarrier: function (row) {
        const that = this
        that.$confirm('确认删除?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          axios.get('http://127.0.0.1:8080/deleteCarrier', {
            params: {
              carrierId: row.carrierId
            }
          }).then(function (obj) {
            if (obj.data.code === 0) {
              that.$message({
                type: 'success',
                message: '删除成功！'
              })
              that.getCarrierList(that.pages.pageNo, that.pages.pageSize)
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
        this.getCarrierList(val, this.pages.pageSize)
      },
      /*分页*/
      getCarrierList(pn, ps) {
        const that = this
        that.pages.pageNo = pn
        that.pages.pageSize = ps
        axios.get('http://127.0.0.1:8080/getCarrierList', {
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
