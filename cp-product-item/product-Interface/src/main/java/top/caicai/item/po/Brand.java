package top.caicai.item.po;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_brand")
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Value(value = "name")
    private String name;// 品牌名称
    @Value(value = "image")
    private String image;// 品牌图片
    @Value(value = "letter")
    private Character letter;
}