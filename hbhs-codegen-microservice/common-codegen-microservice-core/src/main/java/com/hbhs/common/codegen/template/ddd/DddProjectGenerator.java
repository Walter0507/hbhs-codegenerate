package com.hbhs.common.codegen.template.ddd;

import com.hbhs.common.codegen.consts.CodeGenConst;
import com.hbhs.common.codegen.model.EntityObject;
import com.hbhs.common.codegen.model.TemplateObject;
import com.hbhs.common.codegen.template.ProjectGenerator;
import com.hbhs.common.codegen.util.FileUtils;
import groovy.text.SimpleTemplateEngine;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DddProjectGenerator implements ProjectGenerator {
    private SimpleTemplateEngine engine = new SimpleTemplateEngine();

    @Override
    public void generateFramework(EntityObject entityObject) {
        generateFrameworkOfFolder(entityObject);
        generateFrameworkOfSource(entityObject);
    }

    @Override
    public void generateFrameworkOfFolder(EntityObject entityObject) {
        try {
            String project = entityObject.getArtifactId();
            // api
            Files.createDirectories(new File(
                    entityObject.getTargetFolder() + "/" + project + "/" + project + "-api/src/main/java").toPath());

            // app
            Files.createDirectories(new File(
                    entityObject.getTargetFolder() + "/" + project + "/" + project + "-app/src/main/java").toPath());
            Files.createDirectories(new File(
                    entityObject.getTargetFolder() + "/" + project + "/" + project + "-app/src/main/resources").toPath());

            // common
            Files.createDirectories(new File(
                    entityObject.getTargetFolder() + "/" + project + "/" + project + "-common/src/main/java").toPath());

            // provider
            Files.createDirectories(new File(
                    entityObject.getTargetFolder() + "/" + project + "/" + project + "-provider/src/main/java").toPath());

            // test
            Files.createDirectories(new File(
                    entityObject.getTargetFolder() + "/" + project + "/" + project + "-test/src/test/java").toPath());
            Files.createDirectories(new File(
                    entityObject.getTargetFolder() + "/" + project + "/" + project + "-test/src/test/resources").toPath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateFrameworkOfSource(EntityObject entityObject) {
        List<TemplateObject> templateList = DddTemplateObjectBuilder.newInstance("template/ddd")
                .includingSpringDataElasticSearch(entityObject.isIncludingSpringDataElasticsearch())
                .initProjectTemplate()
                .build();
        Map<String, Object> context = buildGroovyContextMap(entityObject);
        try {
            String sourceFolder = entityObject.getTargetFolder() + entityObject.getArtifactId();
            for (TemplateObject templateObject : templateList) {
                try {
                    String targetFile = templateObject.getSourceFolderTemplate()
                            .replaceAll(CodeGenConst.KEY_PROJECT_NAME, entityObject.getArtifactId())
                            .replaceAll(CodeGenConst.KEY_PACKAGE_NAME,
                                    entityObject.getPackageName().replaceAll("\\.", "/"))

                            + templateObject.getSourceFileNameTemplate()
                            .replaceAll(CodeGenConst.KEY_PROJECT_CLASS_NAME, entityObject.getProjectName())
                            .replaceAll(CodeGenConst.KEY_PROJECT_NAME, entityObject.getArtifactId());
                    String content = templateObject.getGroovyTemplate().make(context).toString();
                    FileUtils.writeFile(content, sourceFolder + targetFile, true);
                } catch (Exception e) {
                    System.out.println(templateObject.getTemplateName());
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> buildGroovyContextMap(EntityObject entity) {
        Map<String, Object> context = new HashMap<>();
        context.put("groupId", entity.getGroupId());
        context.put("artifactId", entity.getArtifactId());
        context.put("projectClassName", entity.getProjectName());
        context.put("packageName", entity.getPackageName());
        context.put("entityClassName", entity.getEntityName());
        context.put("entityName", entity.getEntityNameLower());
        context.put("entityNamePackage", entity.getEntityNamePackage());

        return context;
    }

    private Map<String, Object> buildEntityGroovyContextMap(EntityObject entity) {
        Map<String, Object> context = new HashMap<>();
        context.put("groupId", entity.getGroupId());
        context.put("artifactId", entity.getArtifactId());
        context.put("projectClassName", entity.getProjectName());
        context.put("packageName", entity.getPackageName());
        context.put("entityClassName", entity.getEntityName());
        context.put("entityName", entity.getEntityNameLower());
        context.put("entityNamePackage", entity.getEntityNamePackage());

        context.put("prefixField",entity.buildEntityString());
        context.put("prefixFieldAll",entity.buildAllEntityString());
        context.put("tableName", entity.getTableName());
        context.put("fullField",entity.buildAllEntityFiled());
        context.put("basicField",entity.buildEntityFiled());
        context.put("basicFieldOfEntity",entity.buildBasicFieldOfEntity());
        context.put("updateSqlOfNotNullField",entity.buildUpdateSqlOfNotNullField());
//        context.put("sqlInsert",entity.buildInsertSQL());
//        context.put("sqlUpdate",entity.buildUpdateSQL());
//        context.put("sqlDelete",entity.buildDeleteSQL());
//        context.put("sqlSelect",entity.buildSelectSQL());
        return context;
    }

    @Override
    public void generateEntity(EntityObject entityObject) {
        List<TemplateObject> templateList = DddTemplateObjectBuilder.newInstance("template/ddd")
                .includingSpringDataElasticSearch(entityObject.isIncludingSpringDataElasticsearch())
                .initEntityTemplate()
                .build();
        Map<String, Object> context = buildEntityGroovyContextMap(entityObject);
        try {
            String sourceFolder = entityObject.getTargetFolder() + entityObject.getArtifactId();
            for (TemplateObject templateObject : templateList) {
                try {
                    String targetFile = templateObject.getSourceFolderTemplate()
                            .replaceAll(CodeGenConst.KEY_PROJECT_NAME, entityObject.getArtifactId())
                            .replaceAll(CodeGenConst.KEY_PACKAGE_NAME,
                                    entityObject.getPackageName().replaceAll("\\.", "/"))
                            .replaceAll(CodeGenConst.KEY_ENTITY_NAME_PACKAGE, entityObject.getEntityNamePackage())

                            + templateObject.getSourceFileNameTemplate()
                            .replaceAll(CodeGenConst.KEY_ENTITY_NAME, entityObject.getEntityName())
                            ;
                    String content = templateObject.getGroovyTemplate().make(context).toString();
                    FileUtils.writeFile(content, sourceFolder + targetFile, true);
                } catch (Exception e) {
                    System.out.println(templateObject.getTemplateName());
                    e.printStackTrace();
                }
            }
            
            if (entityObject.getEnumFieldList()!=null){
                for (EntityObject.Field field : entityObject.getEnumFieldList()) {
                    context.put("enumsClass", field.getFieldType());
                    TemplateObject templateObject = DddTemplateObjectBuilder.newInstance("template/ddd").getEntityEnumTemplate();
                    String targetFile = templateObject.getSourceFolderTemplate()
                            .replaceAll(CodeGenConst.KEY_PROJECT_NAME, entityObject.getArtifactId())
                            .replaceAll(CodeGenConst.KEY_PACKAGE_NAME,
                                    entityObject.getPackageName().replaceAll("\\.", "/"))
                            .replaceAll(CodeGenConst.KEY_ENTITY_NAME_PACKAGE, entityObject.getEntityNamePackage())

                            + templateObject.getSourceFileNameTemplate()
                            .replaceAll(CodeGenConst.KEY_ENUM_CLASS_NAME, field.getFieldType())
                            ;
                    String content = templateObject.getGroovyTemplate().make(context).toString();
                    FileUtils.writeFile(content, sourceFolder + targetFile, true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
