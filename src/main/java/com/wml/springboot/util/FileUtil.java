package com.wml.springboot.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * <pre>
 * <b>Title：</b>FileUtil.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/6/8 - 15:01<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public class FileUtil {

    /**
     * 产生唯一文件名，包括缩略图文件名以T字母开头
     * @return 文件名及缩略图文件名
     */
    public static String[] getNewFileName(){
        String[] fileNames =new String[3];
        Random random = new Random();
        int add = random.nextInt(10000000); // 产生随机数10000000以内
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String  ti= sdf.format(new Date());
        String ret = add + ti;
        fileNames[0] = ret;
        fileNames[1] = "M" + ret;
        fileNames[2] = "T" + ret;
        return fileNames;
    }

    /**
     * 取得文件名及文件后缀名 [0]为文件名  [1]为文件后缀
     * @param fileName
     * @return
     */
    public static String[] splitFileName(String fileName){
        String fileAndExt[] ={fileName.substring(0,fileName.lastIndexOf(".")),
                fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase()};
        return fileAndExt;
    }

    public static boolean validateImgType(String type){
        boolean result = false;
        try{
            /*Resource resource = new ClassPathResource("/resource.properties");
            Properties props = PropertiesLoaderUtils.loadProperties(resource);*/
            String types = "png|jpg|gif|jpeg";
            String[] typesStr = types.split("\\|");
            for(String typeStr :typesStr){
                if(typeStr.equals(type)){
                    result = true;
                    break;
                }
            }
        }catch(Exception e){
        }
        return result;
    }

    public static boolean validateFileType(String type){
        boolean result = false;
        try{
            String types = "png|jpg|gif|jpeg|doc|xls|pdf|docx|xlsx";
            String[] typesStr = types.split("\\|");
            for(String typeStr :typesStr){
                if(typeStr.equals(type)){
                    result = true;
                    break;
                }
            }
        }catch(Exception e){
        }
        return result;
    }

    /**
     * 保存图片
     * @param file
     * @param newname
     * @param path
     * @return
     */
    public static String savePicture(MultipartFile file, String newname, String path) {
        String fileUrl = "";
        if(StringUtils.isEmpty(file.getOriginalFilename())){
            return  fileUrl;
        }
        String[]  name=	FileUtil.splitFileName(file.getOriginalFilename());
        boolean b =  FileUtil.validateImgType(name[1]);
        //文件类型验证通过
        if(b){
            try{
                File tempFile = new File(path,  newname+"." + name[1]);
                FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile );
                fileUrl = newname + "." + name[1];
                //大图裁剪

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return fileUrl;
    }

    public static String saveFiles(MultipartFile file,String newname, String path) {
        String fileUrl = "";
        if(StringUtils.isEmpty(file.getOriginalFilename())){
            return  fileUrl;
        }
        String[]  name=	FileUtil.splitFileName(file.getOriginalFilename());
        boolean b =  FileUtil.validateFileType(name[1]);
        //文件类型验证通过
        if(b){
            try{
                fileUrl = newname+"."+name[1];
                File tempFile = new File(path,  newname+"."+name[1]);
                FileUtils.copyInputStreamToFile(file.getInputStream(),tempFile );
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return fileUrl;
    }
}
