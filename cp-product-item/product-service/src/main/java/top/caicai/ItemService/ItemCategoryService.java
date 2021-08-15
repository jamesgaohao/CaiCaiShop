package top.caicai.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.caicai.item.po.Category;
import top.caicai.mapper.CategoryMapper;

import java.util.List;

@Service
public class ItemCategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByPid(Long pid) {
        //通用mapper会把非空参数作为where条件进行查询
        Category category = new Category();
        category.setParent_id(pid);
        List<Category> list = categoryMapper.select(category);
        //判断结果是否为空
        if(CollectionUtils.isEmpty(list)){
//           throw new CpException(ExceptionEnum.CATEGORY_NOT_NULL);
            System.out.println("没查询到结果" );

        }
        return list;
    }

}
