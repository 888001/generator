package com.cittt.generator;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Generator {
    private static final Logger logger = LoggerFactory.getLogger(Generator.class);
    static VelocityEngine factory = new VelocityEngine();
    static VelocityContext container = new VelocityContext();

    static {
        factory.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        factory.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        factory.init();
    }

    public static void main(String[] args) throws Exception {
        Template t = factory.getTemplate("reqvo.vm");
        container.put("name", "velocity");
        container.put("date", (new Date()).toString());
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        container.put("list", list);
        StringWriter sw = new StringWriter();
        t.merge(container, sw);
        FileUtils.forceMkdir(new File("G:\\output\\test"));
        FileOutputStream os = new FileOutputStream(new File("G:\\output\\test\\test.java"));
        os.write(sw.toString().getBytes());
        os.close();
        logger.info("[{}]文件生成成功","G:\\output\\test\\test.java");
        System.out.println("开始打印>>>>>");
        System.out.println(sw.toString());
    }

    public static void main1(String[] a) {
        HashMap hashMap = new HashMap();
        hashMap.put("aaa", "aa");
    }
}
