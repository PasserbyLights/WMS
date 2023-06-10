package qf.com.dto;

/**
 * 封装分页信息的类
 */
public class Page {

    /**
     * 当前页
     */
    private Integer pageNo;
    /**
     * 每一位显示多少条数
     */
    private Integer pageSize;
    /**
     * 数据库表总记录数
     */
    private Long total;
    /**
     * 是否有上一页
     */
    private Boolean hasPre;
    /**
     * 是否有下一页
     */
    private Boolean hasNext;
    /**
     * 总页数
     */
    private Integer pageCount;
    /**
     * 当前页数据
     */
    private Object data;

    public Page() {
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Boolean getHasPre() {
        return hasPre;
    }

    public void setHasPre(Boolean hasPre) {
        this.hasPre = hasPre;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", hasPre=" + hasPre +
                ", hasNext=" + hasNext +
                ", pageCount=" + pageCount +
                ", data=" + data +
                '}';
    }
}
