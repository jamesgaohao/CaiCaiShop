package top.caicai.item.po;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Table(name = "tb_category")
public class Category {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private Long parent_id;
    private  Boolean is_parent;
    private Integer sort;
}
