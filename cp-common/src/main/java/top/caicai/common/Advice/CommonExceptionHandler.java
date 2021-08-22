package top.caicai.common.Advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import top.caicai.common.exception.CpException;
import top.caicai.common.vo.ExceptionResult;

/*
* 结合SpringMvc AOP切点概念，拦截一切control异常请求
*
* 对象处理器
*
* */
@ControllerAdvice
public class CommonExceptionHandler {

    //这样的方法可以写多个
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResult> handleException(CpException e){
        return ResponseEntity.status(e.getExceptionEnums().getCode()).body(new ExceptionResult(e.getExceptionEnums()));

    }



}
