package top.caicai.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
*
*枚举
*
* 枚举是指固定示例参数的类，类似单例方式
* */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    //可以有多个对象，枚举直接可以使用，分开
    PARAMENT_not_null(400,"参数不能为空！"),
    ;
    private int code;
    private String msg;

}