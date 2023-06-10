package qf.com.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Result;
import qf.com.enums.BookStatus;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class BookExceptionHandler {



    /**
     * 统一异常处理方法
     */
    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public Result processException(Exception e){
        e.printStackTrace();//控制台异常输出
        if(e instanceof NullPointerException){
            return new Result(BookStatus.CATEGORY_ERROR);
        }else{
            return new Result(BookStatus.ERROR);
        }
    }
}
