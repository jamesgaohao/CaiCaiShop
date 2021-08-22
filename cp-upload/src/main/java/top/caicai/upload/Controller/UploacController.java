package top.caicai.upload.Controller;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.caicai.common.vo.ResultVo;
import top.caicai.upload.Service.UploadService;

@RestController
@RequestMapping("upload")
public class UploacController {
     @Autowired
     private UploadService uploadService;
    //在上传文件的时候，spring MVC会把上传的文件封装成MultipartFile 对象，这里这个对象接收就好了。

    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam(value = "file") MultipartFile file){
        ResultVo resultVo = new ResultVo();
//        String uploadimage = uploadService.uploadimage(file);
//        if(!StringUtils.isEmpty(uploadimage)){
//            resultVo.setCode("200");
//            resultVo.setSuccess(true);
//            resultVo.setMsg("文件上传成功！");
//            resultVo.setDate(uploadimage);
//        }

       return  ResponseEntity.ok(uploadService.uploadimage(file));
//        return ResponseEntity.ok(resultVo);

    }


}
