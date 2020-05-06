package com.hbhs.common.codegen.util;

import com.hbhs.common.codegen.model.TemplateObject;
import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtils {
    private static final SimpleTemplateEngine engine = new SimpleTemplateEngine();

    public static void loadGroovyTemplate(List<TemplateObject> templateObjectList){
        if (templateObjectList==null){return ;}
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        for (TemplateObject templateObject : templateObjectList) {
            try {
                URL url = classLoader.getResource(templateObject.getTemplateName());
                Template groovyTemplate = engine.createTemplate(url);
                templateObject.setGroovyTemplate(groovyTemplate);
            }catch (Exception e){
                throw new RuntimeException("Template " + templateObject.getTemplateName() + " cannot be found!", e);
            }
        }
    }

    public static void writeFile(String content, String filePath, boolean override){
        try {
            File file = new File(filePath);
            if (!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            if (file.exists()){
                file.delete();
            }
            file.createNewFile();
            Files.write(file.toPath(), content.getBytes("UTF-8"), StandardOpenOption.WRITE);
            System.out.println("write file: "+filePath);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
