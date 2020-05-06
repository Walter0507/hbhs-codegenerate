package com.hbhs.common.codegen;

import com.hbhs.common.codegen.model.EntityObject;
import com.hbhs.common.codegen.template.ProjectGenerator;
import com.hbhs.common.codegen.template.ddd.DddProjectGenerator;
import com.hbhs.common.codegen.util.ParamChecker;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class CodeGenerate<T> {
    private ProjectGenerator generator = null;
    private CodeGenerate(){
        this.generator = new DddProjectGenerator();
    }
    public static CodeGenerate instance(){
        return new CodeGenerate();
    }

    public void generateFramework(EntityObject entityObject){
        checkParamForProject(entityObject);
        generator.generateFramework(entityObject);
    }

    public void generateEntity(EntityObject entityObject){
        checkParamForProject(entityObject);
        checkParamForEntity(entityObject);
        generator.generateEntity(entityObject);
    }

    private void checkParamForProject(EntityObject entity){
        ParamChecker.assertNotNull(entity,"参数为空");
        ParamChecker.assertNotEmpty(entity.getTargetFolder(), "目标目录'targetFolder'未设置");
        ParamChecker.assertNotEmpty(entity.getArtifactId(), "项目名'artifactId'未设置");
        ParamChecker.assertNotEmpty(entity.getGroupId(), "包名'groupId'未设置");

        entity.setDefault();
    }
    private void checkParamForEntity(EntityObject entity){
        ParamChecker.assertNotNull(entity.getEntity(), "对应实体'entity'为空");
        ParamChecker.assertNotEmpty(entity.getTableName(), "表名'tableName'为空");
        setDefaulEntityInfo(entity);
        entity.setDefault();
    }
    private void setDefaulEntityInfo(EntityObject entity){
        Field[] fields = entity.getEntity().getDeclaredFields();
        entity.setFieldList(new ArrayList<>());
        entity.setEnumFieldList(new ArrayList<>());
        for (Field field : fields) {
            Class fieldClass = field.getType();
            String name = field.getName();
            if (fieldClass.isEnum()){
                String fieldName = fieldClass.getName();
                if (fieldClass.getName().contains("$")){
                    fieldName = fieldName.substring(fieldName.lastIndexOf("$")+1);
                }else{
                    fieldName = fieldName.substring(fieldName.lastIndexOf(".")+1);
                }

                entity.getEnumFieldList().add(EntityObject.Field.builder().fieldName(name).fieldType(fieldName).build().setDefault());
                entity.getFieldList().add(EntityObject.Field.builder().fieldName(name).fieldType(fieldName).build().setDefault());
            }else{
                entity.getFieldList().add(EntityObject.Field.builder().fieldName(name).fieldType(fieldClass.getName()).build().setDefault());
            }
        }
        if (entity.getCommonFieldList()==null||entity.getCommonFieldList().size()==0){
            entity.setCommonFieldList(new ArrayList<>());
            entity.setCommonFieldList(Arrays.asList(
                    EntityObject.Field.builder().fieldName("isDeleted").fieldType(Boolean.class.getName()).filedTable("is_deleted").build(),
                    EntityObject.Field.builder().fieldName("createTime").fieldType(Date.class.getName()).filedTable("create_time").build(),
                    EntityObject.Field.builder().fieldName("updateTime").fieldType(Date.class.getName()).filedTable("update_time").build()
            ));
        }

        if (entity.getEntityName()==null||"".equalsIgnoreCase(entity.getEntityName())){
            String name = entity.getEntity().getName();
            if (name.endsWith("Entity")){
                name = name.substring(0, name.length()-6);
            }
            String entityName = name.substring(name.lastIndexOf(".")+1);
            if (entityName.contains("$")){
                entityName = entityName.substring(entityName.lastIndexOf("$")+1);
            }
            entity.setEntityName(entityName);
        }
    }
}
