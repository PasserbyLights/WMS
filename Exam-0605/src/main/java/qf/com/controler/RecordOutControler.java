package qf.com.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Result;
import qf.com.entity.RecordIn;
import qf.com.entity.RecordOut;
import qf.com.service.RecordOutService;

import javax.annotation.Resource;

/**
 * @author：DengHaiWen
 * @date：2023/6/9 10:20
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class RecordOutControler {
    @Resource
    private RecordOutService recordOutService;

    @RequestMapping(value = "/addRecordOut")
    public Result addRecordOut(@RequestBody RecordOut recordOut) {
        System.out.println("recordOut:" + recordOut);
        recordOutService.addRecordOut(recordOut);
        return new Result();
    }
}
