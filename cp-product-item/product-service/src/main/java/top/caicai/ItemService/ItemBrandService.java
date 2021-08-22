package top.caicai.ItemService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;
import top.caicai.common.enums.ExceptionEnum;
import top.caicai.common.exception.CpException;
import top.caicai.common.vo.PageResult;
import top.caicai.item.po.Brand;
import top.caicai.mapper.BrandMapper;

import java.util.List;

@Service
public class ItemBrandService {
    //注入通用Mapper
    @Autowired
    private BrandMapper brandMapper;


    public PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key) {

        //分页查询
        PageHelper.startPage(page,rows); //使用第三方工具分页助手，简单语句,就能实现分页

        //过滤
        Example example = new Example(Brand.class);//传入字节码，就可以根据字节码利用反射获取要查哪张表，那个字段

         if(StringUtils.isNotBlank(key)){
             //createCriteria : 标准条件  toUpperCase：转换成大写
              example.createCriteria().orEqualTo("name","%"+key+"%").orEqualTo("letter",key.toUpperCase());
        }

        //排序
        if(StringUtils.isNotBlank(sortBy)){
            //注意，这里的ASC 与desc 前面要有空格
            String Sort_sql = sortBy+(desc ? " DESC" : " ASC");
            //配置orderby 关键字
            example.setOrderByClause(Sort_sql);
        }

        //查询
        List<Brand> list = brandMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){

            throw  new CpException(ExceptionEnum.Brand_not_found);

        }
        //解析分页结构
        PageInfo<Brand> Info = new PageInfo<>(list);

        return new PageResult<>(Info.getTotal(),list);
    }

    @Transactional
    public void SaveBrand(Brand brand, List<Long> cids) {
         //新增品牌
         brand.setId(null);//设置ID为空，让该字段自增长
         int count = brandMapper.insert(brand);
         if (count !=1){
             throw  new CpException(ExceptionEnum.Brand_save_falid);
         }
         //新增中间表
         for (Long cid :cids){
            count =  brandMapper.insetCategoryBrand(cid,brand.getId());
            if(count !=1){
                throw  new CpException(ExceptionEnum.Brand_save_falid);
            }

         }
    }
}
