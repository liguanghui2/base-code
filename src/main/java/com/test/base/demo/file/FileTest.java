package com.test.base.demo.file;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author 李光辉
 * @version 1.0
 * @date 2021/3/30 17:29
 */
public class FileTest {
    final static String modePath = "temp/temp.docx";

    public static void main(String[] args) throws IOException {
        String filePath = System.getProperty("user.home") + File.separator + UUID.randomUUID().toString() + ".docx";
        Map map = new HashMap<String, Object>();
        map.put("name","测试名称");
        map.put("x","二");
        List<Student> list=new ArrayList<>();
        Student s1=new Student();
        s1.setName("张三");
        s1.setAge("2");
        s1.setSex("男");
        Student s2=new Student();
        s2.setName("李四");
        s2.setAge("1");
        s2.setSex("女");
        list.add(s1);
        list.add(s2);
        map.put("list",list);
        HackLoopTableRenderPolicy policy = new HackLoopTableRenderPolicy();
        //集合的操作放在这个tag里面
        Configure config = Configure.newBuilder().bind("list", policy).build();
        Resource resource = new ClassPathResource(modePath);
        InputStream inputStream = resource.getInputStream();
        XWPFTemplate template = XWPFTemplate.compile(inputStream, config).render(map);
        template.writeToFile(filePath);
        template.close();
        inputStream.close();
    }
}
