<template>
  <div>
    <el-row :gutter="20" style="margin-top: 5px;">
      <el-col :span="20" :offset="1">
        <div style="display: flex; flex-wrap: nowrap; justify-content: space-between;">
          <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="客户" style="width: 300px;">
              <el-select
                v-model="form.selectedOption"
                placeholder="请选择客户"
                filterable
                remote
                reserve-keyword
                :remote-method="getSuppliers"
                @focus="getSuppliers('')"
                @change="getCustomerOne">
                <el-option
                  :key="option.customerId"
                  :label="option.customerName"
                  :value="option.customerId"
                  v-for="option in filteredOptions"/>
              </el-select>
            </el-form-item>


            <el-form-item label="入库产品" style="width: 300px;">
              <el-select
                v-model="form1.selectedOption1"
                placeholder="请选择入库产品"
                filterable
                remote
                reserve-keyword
                :remote-method="getSuppliers1"
                @focus="getSuppliers1('')"
                @change="getProductIdOne">
                <el-option
                  :key="option.productId"
                  :label="option.productName"
                  :value="option.productId"
                  v-for="option in filteredOptions1"/>
              </el-select>
            </el-form-item>

            <el-form-item label="入库仓库" style="width: 300px;">
              <el-select
                v-model="form2.selectedOption2"
                placeholder="请选择入库仓库"
                filterable
                remote
                reserve-keyword
                :remote-method="getSuppliers2"
                @focus="getSuppliers2('')"
                @change="getListStockRecord">
                <el-option
                  :key="option.repoId"
                  :label="option.repoName"
                  :value="option.repoId"
                  v-for="option in filteredOptions2"/>
              </el-select>
            </el-form-item>
            <el-form-item label="入库数量" prop="recordOutNumber">
              <el-input v-model="recordOut.recordOutNumber"></el-input>
            </el-form-item>
            <span>库存：{{ productStock }}</span>
            <br>
            <br>
            <el-form-item>
              <el-button type="primary" @click="search">库存出库</el-button>
            </el-form-item>
          </el-form>
          <el-collapse v-model="activeNames" @change="handleChange" :title="$t('展开/折叠')">
            <el-collapse-item title="一致性 Consistency" name="1" :title="'展开/折叠'">
              <el-table :data="[{...SupplierOne}]"> <!-- 将 data 和 category 合并为新对象 -->
                <el-table-column prop="customerId" label="客户编号" width="50"></el-table-column>
                <el-table-column prop="customerName" label="客户名称" width="100"></el-table-column>
                <el-table-column prop="customerLeader" label="客户负责人" width="130"></el-table-column>
                <el-table-column prop="customerTel" label="手机号" width="130"></el-table-column>
                <el-table-column prop="customerEmail" label="邮箱" width="130"></el-table-column>
                <el-table-column prop="customerAddress" label="地址"width="130"></el-table-column>
                <el-table-column prop="createTime" label="创建时间" width="150"></el-table-column>
                <el-table-column prop="updateTime" label="更新时间" width="150"></el-table-column>
              </el-table>
              <br>
              <br>
              <br>
              <br>
              <br>
              <el-table :data="[{...ProductIdOne, ...ProductIdOne.category,productStock}]"> <!-- 将 data 和 category 合并为新对象 -->
                <el-table-column prop="productId" label="货物编号" width="100"></el-table-column>
                <el-table-column prop="productName" label="货物名称" width="120"></el-table-column>
                <el-table-column prop="productSize" label="产品尺寸" width="130"></el-table-column>
                <el-table-column prop="productPrice" label="产品价格"></el-table-column>
                <el-table-column prop="categoryName" label="分类名称"></el-table-column>
                <el-table-column label="库存">
                  <template slot-scope="scope">
                    {{ scope.row.productStock ? parseInt(scope.row.productStock) : '' }}
                  </template>
                </el-table-column>
              </el-table>
            </el-collapse-item>
          </el-collapse>
        </div>

      </el-col>
    </el-row>

  </div>
</template>


<script>
  import axios from 'axios'

  export default {
    name: 'in',

    data() {
      return {
        activeNames: [1],
        List: [],
        isAllSelected: false,
        pages: {
          pageNo: 1,
          pageSize: 5,
          total: 0
        },
        updateTime: false,
        ListProduct: '',//产品集合
        productId: '',
        //ListRepository: '',//仓库集合
        repoId: '',
        productStock: '',//库存
        recordStock: {
          recordStockId: undefined,
          productId: '',
          repoId: '',
          productStock: '',//产品数量
          productName: '',//产品名称
          repoName: '',//仓库名称
          createTime: '',
          updateTime: '',
          isDelete: ''
        },
        supplier: '',
        product: '',
        repository: '',
        form: { // 表单对象
          name: '', // 输入的客户名称
          options: [], // 下拉框选项
          selectedOption: ''// 所选客户选项的值
        },
        form1: { // 表单对象
          name: '', // 输入的客户名称
          options: [], // 下拉框选项
          selectedOption1: ''// 所选产品选项的值

        },
        form2: { // 表单对象
          name: '', // 输入的客户名称
          options: [], // 下拉框选项
          selectedOption2: '' // 所选仓库选项的值
        },
        list: [],
        list1: [],
        list2: [],
        recordOut: {
          recordOutId: '',
          customerId: '',
          productId: '',
          recordOutNumber: '',
          recordOutTime: '',
          userId: '',
          repoId: '',
          remarks: '',
          createTime: '',
          updateTime: '',
          isDelete: ''
        },
        SupplierOne: [],//客户集合
        ProductIdOne: []//产品集合

      }
    },
    created() {

    },
    computed: {
      filteredOptions() {
        return this.form.options.filter(option => {
          return option.customerName.toLowerCase().indexOf(this.form.name.toLowerCase()) !== -1
        })
      },
      filteredOptions1() {
        return this.form1.options.filter(option => {
          return option.productName.toLowerCase().indexOf(this.form1.name.toLowerCase()) !== -1
        })
      },
      filteredOptions2() {
        return this.form2.options.filter(option => {
          return option.repoName.toLowerCase().indexOf(this.form2.name.toLowerCase()) !== -1
        })
      }
    },
    methods: {
      //折叠筐
      handleChange(val) {
        //console.log(val)
      },
      //供客户下拉框
      getSuppliers(keyword) {
        if (keyword === '') {
          return Promise.resolve([])
        }
        return axios.get(`http://127.0.0.1:8080/getCustomerOne1?customerName=${keyword}`).then(response => {
          const results = response.data.data
          this.form.options = results
          return results
        }).catch(error => {
          console.log(error)
        })
      },
      //产品拉框
      getSuppliers1(keyword) {
        if (keyword === '') {
          return Promise.resolve([])
        }
        return axios.get(`http://127.0.0.1:8080/getProductOne1?productName=${keyword}`).then(response => {
          const results = response.data.data
          this.form1.options = results
          return results
        }).catch(error => {
          console.log(error)
        })
      },
      //仓库拉框
      getSuppliers2(keyword) {
        if (keyword === '') {
          return Promise.resolve([])
        }
        return axios.get(`http://127.0.0.1:8080/getRepositoryOne1?repoName=${keyword}`).then(response => {
          const results = response.data.data
          this.form2.options = results
          return results
        }).catch(error => {
          console.log(error)
        })
      },
      //库存查询
      getListStockRecord() {
        const that = this
        that.recordOut.customerId = that.form.selectedOption//选中客户ID
        that.recordOut.productId = that.form1.selectedOption1//选中产品ID
        that.recordOut.repoId = that.form2.selectedOption2//选中仓库id
        console.log('客户id(supplierId)：', that.form.selectedOption)
        console.log('入库产品id(productId)：', that.form1.selectedOption1)
        console.log('入库仓库id(repoId)：', that.form2.selectedOption2)
        that.productStock = that.getListStockRecord1(that.form2.selectedOption2, that.form1.selectedOption1)
      },
      //查询库存
      getListStockRecord1(repoId, productId) {
        const that = this
        console.log(repoId)
        console.log(productId)
        axios.get('http://127.0.0.1:8080/getListStockRecord', {
          params: {
            repoId: repoId,
            productId: productId
          }
        }).then(function(obj) {
          that.List = obj.data.data
          console.log(that.list.length)
          console.log(obj.data.data)
          if (obj.data.data.length === undefined || obj.data.data === null) {
            that.productStock = that.List.productStock
            console.log('库存0:', that.productStock)
            return that.productStock
          } else {
            that.productStock = that.List[0].productStock
            console.log('库存1:', that.productStock)
            return that.productStock
          }
        })
      },
      /*搜索功能*/
      search() {
        const that = this
        that.recordOut.isDelete = 1
        that.recordOut.userId = 1
        that.addRecordIn()
      },
      //提交
      addRecordIn() {
        const that = this
        //校验通过
        console.log('recordOut:', that.recordOut)
        axios.post('http://localhost:8080/addRecordOut', JSON.stringify(that.recordOut), {
          headers: {
            'Content-Type': 'application/json'
          }
        }).then(function(obj) {
          if (obj.data.code === 0) {
            //添加后运行
            that.getListStockRecord()
            that.addVisible = false//关闭弹窗
            that.$message({
              type: 'success',
              message: '提交成功！'
            })
          } else {
            that.$message(obj.data.msg)
          }
        })
      },
      //客户信息
      getCustomerOne() {
        const that = this
        that.recordOut.customerId = that.form.selectedOption//选中客户ID
        axios.get('http://127.0.0.1:8080/getCustomerOne', {
          params: {
            customerId: that.recordOut.customerId
          }
        }).then(function(obj) {
          if (obj.data.code === 0) {
            that.$message({
              type: 'success',
              message: '查询客户列表数据成功！'
            })
            that.SupplierOne = obj.data.data
            console.log('that.SupplierOne', that.SupplierOne)
          } else {
            that.$message(obj.data.msg)
          }
        })
      },
      //商品信息
      getProductIdOne() {
        const that = this
        that.recordOut.productId = that.form1.selectedOption1//选中产品ID
        axios.get('http://127.0.0.1:8080/getProductOne', {
          params: {
            productId: that.recordOut.productId
          }
        }).then(function(obj) {
          if (obj.data.code === 0) {
            that.$message({
              type: 'success',
              message: '查询产品列表数据成功！'
            })
            that.ProductIdOne = obj.data.data
            console.log('that.ProductIdOne', that.ProductIdOne)
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
