package top.caicai.common.vo;

import lombok.Data;
import top.caicai.common.enums.ExceptionEnum;

/*
* 异常VO
*
* */
@Data
public class ExceptionResult {
   private int status;
   private String Msg;
    //构造一个空参方法
    public ExceptionResult(ExceptionEnum exceptionEnum){
        this.status=exceptionEnum.getCode();
        this.Msg = exceptionEnum.getMsg();

    }
}
