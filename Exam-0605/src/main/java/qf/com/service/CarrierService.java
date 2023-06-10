package qf.com.service;

import qf.com.dto.Page;
import qf.com.entity.Carrier;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 22:09
 * @version：1.0
 */
public interface CarrierService {
    //增加
    void addCarrier(Carrier carrier);

    //删除
    void deleteCarrier(Integer carrierId);

    //更改
    void updateCarrier(Carrier carrier);

    //查询单个
    Carrier getCarrierOne(Integer carrierId);

    //查询列表
    Page getCarrierList(Integer pageNo,Integer pageSize);
}
