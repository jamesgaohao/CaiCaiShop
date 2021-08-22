package top.caicai.upload.Service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.caicai.common.enums.ExceptionEnum;
import top.caicai.common.exception.CpException;
import top.caicai.upload.config.UploadProperties;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.IOException;

@EnableConfigurationProperties(UploadProperties.class)//引入application.xml自定义的变量
@Service
@Slf4j
public class UploadService  {
    @Autowired
    private FastFileStorageClient StorageClient;

    @Autowired
    private UploadProperties uploadProperties;//引入application.xml自定义的变量
//    //asList 给元素，自动封装成集合
//    private static final List<String> allowimageType= Arrays.asList("image/jpeg","image/png");

    public String uploadimage(MultipartFile file) {

         //保存文件到本地
        try {
            //校验文件类型
            String contentType = file.getContentType();
            //判断文件类型
            if(!uploadProperties.getAllowType().contains(contentType)){
                throw  new CpException(ExceptionEnum.INVALID_FILE_TYPE );

            }
            //校验文件内容

            BufferedImage image = ImageIO.read(file.getInputStream());

            if(image==null){
                log.error("上传文件类型错误!");
                throw  new CpException(ExceptionEnum.INVALID_FILE_TYPE );
            }
            //截取文件末尾，文件格式
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(),".");
            //获取路径
            StorePath storePath = StorageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);

            return  uploadProperties.getBaseUrl()+storePath.getFullPath();
//            //目标路径
//            File dest = new File("F:\\DevelopmentProject\\CaiCaiShop\\cp-upload\\src\\main\\resources\\upload\\"+file.getOriginalFilename());
//
//            file.transferTo(dest);
//           return  "http://image.caicai.top/"+file.getOriginalFilename();
        } catch (IOException e) {
            //保存失败
            log.error("文件上传，失败!",e);
            throw  new CpException(ExceptionEnum.UPLOAD_FILE_falid );
        }


    }
}
