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
    Brand_save_falid(500,"新增品牌，保存数据失败！"),
    INVALID_FILE_TYPE(400,"文件上传类型有误！"),
    UPLOAD_FILE_falid(500,"上传文件失败！"),
    Brand_not_found(400,"品牌查询结果为空！"),
    PARAMENT_not_null(400,"参数不能为空！"),
    CATEGORY_NOT_NULL(404,"商品分类未查询到结果！"),
    ;
    private int code;
    private String msg;

}
