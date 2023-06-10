package qf.com.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Page;
import qf.com.dto.Result;
import qf.com.entity.Carrier;
import qf.com.entity.Supplier;
import qf.com.service.CarrierService;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 22:17
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class CarrierControler {
    @Resource
    private CarrierService carrierService;
    @RequestMapping(value = "/addCarrier")
    public Result addCarrier(@RequestBody Carrier carrier) {
        carrier.setUpdateTime(new Date());
        carrierService.addCarrier(carrier);
        return new Result();
    }

    @RequestMapping(value = "/deleteCarrier")
    public Result deleteCarrier(Integer carrierId) {
        carrierService.deleteCarrier(carrierId);
        return new Result();
    }

    @RequestMapping(value = "/updateCarrier")
    public Result updateCarrier(@RequestBody Carrier carrier) {
        carrier.setUpdateTime(new Date());
        carrierService.updateCarrier(carrier);
        return new Result();
    }

    @RequestMapping(value = "/getCarrierOne")
    public Result getCarrierOne(Integer carrierId) {
        Carrier carrierOne = carrierService.getCarrierOne(carrierId);
        return new Result(carrierOne);
    }
    @RequestMapping(value = "/getCarrierList")
    public Result getCarrierList(Integer pageNo,Integer pageSize) {
        Page carrierList = carrierService.getCarrierList(pageNo, pageSize);
        return new Result(carrierList);
    }
}
