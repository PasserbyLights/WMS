package qf.com.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Result;
import qf.com.entity.Carrier;
import qf.com.entity.RecordIn;
import qf.com.service.RecordInService;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author：DengHaiWen
 * @date：2023/6/8 19:21
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class RecordInControler {
    @Resource
    private RecordInService recordInService;
    @RequestMapping(value = "/addRecordIn")
    public Result addRecordIn(@RequestBody RecordIn recordIn) {
        System.out.println("recordIn:"+recordIn);
        recordInService.addRecordIn(recordIn);
        return new Result();
    }
}
