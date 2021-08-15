package top.caicai.ItemControll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.caicai.ItemService.ItemCategoryService;
import top.caicai.item.po.Category;

import java.util.List;

@RestController
@RequestMapping("category")
public class ItemCategoryController {
    @Autowired
    private ItemCategoryService itemCategoryService;
    @RequestMapping("list")
    public ResponseEntity<List<Category>> queryCategoryListByPid(@RequestParam("pid") Long pid){

          return ResponseEntity.ok(itemCategoryService.queryCategoryListByPid(pid));
    }


}
