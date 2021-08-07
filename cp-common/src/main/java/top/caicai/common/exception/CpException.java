package top.caicai.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import top.caicai.common.enums.ExceptionEnum;

/*
* 自定义异常
*
* */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CpException extends RuntimeException {
   private ExceptionEnum exceptionEnums;

}
