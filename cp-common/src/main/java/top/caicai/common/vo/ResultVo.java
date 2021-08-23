package top.caicai.common.vo;

import javafx.scene.chart.PieChart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
* 通用结果返回对象
*
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo<T> implements Serializable{

    private String Msg;//结果

    private Boolean Success;//是否成功

    private String code;//状态码

    private T Date;//返回结果集

}
