package top.caicai.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import top.caicai.item.po.Brand;
//映射、继承Mapper
public interface BrandMapper extends Mapper<Brand> {
    @Insert("INSERT INTO tb_category_brand (category_id,brand_id) VALUES(#{cid},#{bid})")
    int insetCategoryBrand(@Param("cid") long cid,@Param("bid") long bid);
}
