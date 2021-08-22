package top.caicai.ItemControll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.caicai.ItemService.ItemBrandService;
import top.caicai.common.vo.PageResult;
import top.caicai.item.po.Brand;

import java.util.List;

@RestController
@RequestMapping("brand")
public class ItemBrandContorller {

    @Autowired
    private ItemBrandService itemBrandService;
    /**
     * 分页查询品牌接口
     *
     * */

    @RequestMapping("page")
   public ResponseEntity<PageResult<Brand>> queryBrandPage(
           @RequestParam(value = "page",defaultValue = "1") Integer page,//当前页
           @RequestParam(value = "rows",defaultValue = "5") Integer rows,//当前页显示数量
           @RequestParam(value = "sortBy",required = false) String sortBy, //排序字段
           @RequestParam(value = "desc",defaultValue = "false") Boolean desc,//默认升序
           @RequestParam(value = "key",required = false) String key // 过滤字段，没有就表示查询所有
     ){
        return ResponseEntity.ok(itemBrandService.queryBrandByPage(page,rows,sortBy,desc,key));

    }

    /*
    * 新增品牌业务接口
    *
    * */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam(value = "cids") List<Long> cids){

        itemBrandService.SaveBrand(brand,cids);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    }



}
