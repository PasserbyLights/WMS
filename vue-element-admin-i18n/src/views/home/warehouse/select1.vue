<template>
  <div>
    <br>
    <!--布局容器-->
    <el-row :gutter="20" style="margin-top: 5px;">
      <el-col :span="20" :offset="1">
        <form>
          <div>
            仓库名称:
            <el-select v-model="repoId" placeholder="请选择仓库">
              <el-option
                v-for="repo in ListRepository"
                :key="repo.repoId"
                :label="repo.repoName"
                :value="repo.repoId">
              </el-option>
            </el-select>
            产品名称：
            <el-select v-model="productId" placeholder="请选择产品">
              <el-option
                v-for="product in ListProduct"
                :key="product.productId"
                :label="product.productName"
                :value="product.productId">
              </el-option>
            </el-select>
            <el-button type="success" plain @click="search">搜索</el-button>
          </div>
        </form>
        <br>
        <el-table :data="List" border style="width: 100%; table-layout: fixed;">
          <!--<el-table-column type="index" label="序号" width="50px"/>-->
          <el-table-column
            prop="repoId"
            label="仓库ID" width="80">
          </el-table-column>
          <el-table-column
            prop="repoName"
            label="仓库名称">
            <template slot-scope="scope">
              <span>{{ scope.row.repository[0].repoName}}</span>
            </template>
          </el-table-column>
          <el-table-column
            prop="productName"
            label="产品名称">
            <template slot-scope="scope">
              <span>{{ scope.row.product[0].productName}}</span>
            </template>
          </el-table-column>
          <el-table-column
            prop="productStock"
            label="产品库存" width="80">
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
            @prev-click="getRecordStockList(pages.pageNo-1,pages.pageSize)"
            @next-click="getRecordStockList(pages.pageNo+1,pages.pageSize)"
            @current-change="currentHandlerEvent">
          </el-pagination>
        </div>
      </el-col>
    </el-row>

  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: 'select1',

    data() {
      return {
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
        ListRepository: '',//仓库集合
        repoId: '',
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
      }
    },
    created() {
      this.getRecordStockList(this.pages.pageNo, this.pages.pageSize)
      this.getListProduct()//产品查询
      this.getListRepository()//仓库查询
    },
    activated() {
      this.getRecordStockList(this.pages.pageNo, this.pages.pageSize)
    },
    methods: {
      /*搜索功能*/
      search() {
        const that = this
        console.log(that.productId)
        console.log(that.repoId)
        that.getRecordStockList(that.pages.pageNo, that.pages.pageSize, that.productId, that.repoId)
      },
      /*中间页*/
      currentHandlerEvent: function(val) {
        this.pages.pageNo = val
        this.getRecordStockList(val, this.pages.pageSize)
      },
      /*分页*/
      getRecordStockList(pn, ps, repoId, productId) {
        const that = this
/*        that.pages.pageNo = pn
        that.pages.pageSize = ps
        that.recordStock.repoId = repoId
        that.recordStock.productId = productId*/
        console.log(that.recordStock)
        axios.get('http://127.0.0.1:8080/getRecordStockList', {
          params: {
            pageNo: pn,
            pageSize: ps,
            repoId: repoId,
            productId: productId
          }
        }).then(function(obj) {
          that.List = obj.data.data.data
          that.pages.total = obj.data.data.total
        })
      },
      //产品全部查询
      getListProduct() {
        const that = this
        axios.post('http://localhost:8080/getListProduct').then(function(obj) {
          if (obj.data.code === 0) {
            that.ListProduct = obj.data.data
            //console.log('that.ListProduct:', that.ListProduct)
          } else {
            that.$message(obj.data.msg)
          }
        })
      },
      //查询所有的仓库
      getListRepository() {
        const that = this
        axios.post('http://localhost:8080/getListRepository').then(function(obj) {
          if (obj.data.code === 0) {
            that.ListRepository = obj.data.data
            //console.log('that.ListProduct:', that.ListProduct)
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
