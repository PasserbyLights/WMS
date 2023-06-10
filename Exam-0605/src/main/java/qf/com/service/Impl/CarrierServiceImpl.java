package qf.com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qf.com.dto.Page;
import qf.com.entity.Carrier;
import qf.com.entity.Industry;
import qf.com.mapper.CarrierMapper;
import qf.com.service.CarrierService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 22:10
 * @version：1.0
 */
@Service
@Transactional
public class CarrierServiceImpl implements CarrierService {
    @Resource
    private CarrierMapper carrierMapper;

    @Override
    public void addCarrier(Carrier carrier) {
        carrierMapper.addCarrier(carrier);
    }

    @Override
    public void deleteCarrier(Integer carrierId) {
        carrierMapper.deleteCarrier(carrierId);
    }

    @Override
    public void updateCarrier(Carrier carrier) {
        carrierMapper.updateCarrier(carrier);
    }

    @Override
    public Carrier getCarrierOne(Integer carrierId) {
        return carrierMapper.getCarrierOne(carrierId);
    }

    @Override
    public Page getCarrierList(Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Carrier> carriers = carrierMapper.getCarrierList();

        PageInfo info = new PageInfo(carriers);
        Page page = new Page();
        page.setPageNo(info.getPageNum());//当前页
        page.setPageSize(info.getPageSize());//页容量
        page.setPageCount(info.getPages());//总页数
        page.setTotal(info.getTotal());//总记录数
        page.setData(info.getList());//当前页
        page.setHasPre(info.isHasPreviousPage());//是否有上一页
        page.setHasNext(info.isHasNextPage());//是否有下一页
        return page;
    }
}
