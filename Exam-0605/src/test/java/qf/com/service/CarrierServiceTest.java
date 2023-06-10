package qf.com.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.dto.Page;
import qf.com.entity.Carrier;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 22:20
 * @version：1.0
 */
public class CarrierServiceTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    CarrierService carrierService = ioc.getBean(CarrierService.class);
    @Test
    public void addCarrier() {
        for (int i = 0; i < 20; i++) {
            Carrier carrier = new Carrier();
            carrier.setCarrierName("顺丰物流科技"+i);
            carrier.setCarrierAddress("jd管理001"+i);
            carrier.setCarrierEmail("199999999905"+i);
            carrier.setCarrierLeader("(bjcp@163.com");
            carrier.setCarrierTel("北京市昌平区,北七家");
            carrier.setCreateTime(new Date());
            carrier.setUpdateTime(new Date());
            carrier.setIsDelete(1);
            carrierService.addCarrier(carrier);
        }

    }

    @Test
    public void deleteCarrier() {
        carrierService.deleteCarrier(3);
    }

    @Test
    public void updateCarrier() {
        Carrier carrier = new Carrier();
        carrier.setCarrierName(new String(String.valueOf(Math.random())));
        carrier.setCarrierAddress(new String(String.valueOf(Math.random())));
        carrier.setCarrierEmail(new String(String.valueOf(Math.random())));
        carrier.setCarrierLeader(new String(String.valueOf(Math.random())));
        carrier.setCarrierTel(new String(String.valueOf(Math.random())));
        carrier.setCreateTime(new Date());
        carrier.setUpdateTime(new Date());
        carrier.setIsDelete(1);
        carrier.setCarrierId(3);
        carrierService.updateCarrier(carrier);
    }

    @Test
    public void getCarrierOne() {
        Carrier carrierOne = carrierService.getCarrierOne(3);
        System.out.println(carrierOne);
    }

    @Test
    public void getCarrierList() {
        Page carrierList = carrierService.getCarrierList(1, 5);
        System.out.println(carrierList);
    }
}
