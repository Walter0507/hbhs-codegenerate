package com.hbhs.common.codegen.model;

import lombok.*;
import org.junit.Assert;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter@Setter@Builder
@NoArgsConstructor@AllArgsConstructor
public class EntityObject {
    private String targetFolder ;
    private String groupId;   // com.hbhs.common
    private String artifactId;   // common-user
    private String projectName;  // CommonUser
    private String packageName;  // com.hbhs.common.user

    private Class entity;

    private String entityName;  // BizUser
    private String entityNameLower; // bizUser
    private String entityNamePackage; // biz_user
    private List<Field> fieldList;   // 参数列表
    private List<Field> commonFieldList; // 通用参数列表
    private List<Field> enumFieldList;
    private String tableName;   // zb_biz_user

    private boolean includingSpringDataElasticsearch;


    public EntityObject setDefault(){
        Assert.assertNotNull(targetFolder);
        Assert.assertNotNull(groupId);
        Assert.assertNotNull(artifactId);

        setProjectInfoDefault();
        setEntityDefault();
        return this;
    }

    public EntityObject cleanEntityInfo(){
        setEntityName(null);
        setEntityNameLower(null);
        setEntityNamePackage(null);
        setFieldList(null);
        setCommonFieldList(null);
        setEnumFieldList(null);
        setCommonFieldList(null);
        return this;
    }

    private void setProjectInfoDefault(){
        String[] artifactDetail = artifactId.split("-");
        if (packageName==null||"".equalsIgnoreCase(packageName)){
            packageName = groupId;
            if (!groupId.endsWith(artifactDetail[0])){
                packageName += "."+artifactDetail[0];
            }
            for (int i = 1; i < artifactDetail.length; i++) {
                packageName += "."+artifactDetail[i];
            }
        }
        StringBuilder str = new StringBuilder();
        for (String artifact : artifactDetail) {
            str.append(artifact.substring(0,1).toUpperCase()+artifact.substring(1));
        }
        this.projectName = str.toString();
    }

    private void setEntityDefault(){
        if (entityName == null){return;}
        if (entityNameLower == null){
            entityNameLower = entityName.substring(0,1).toLowerCase()+entityName.substring(1);
        }
        if (entityNamePackage == null){
            String[] entityArray = entityName.split("(?<!^)(?=[A-Z])");
            entityNamePackage = "";
            for (String s : entityArray) {
                entityNamePackage += "_"+s.toLowerCase();
            }
            entityNamePackage = entityNamePackage.substring(1);
        }

    }

    @Getter@Setter@Builder
    public static class Field{
        private String fieldName;
        private String filedTable;
        private String fieldType;

        public Field setDefault(){
            if (filedTable==null||"".equalsIgnoreCase(filedTable)){
                filedTable = "";
                String[] array = fieldName.split("(?<!^)(?=[A-Z])");
                for (String s : array) {
                    filedTable += "_"+s.toLowerCase();
                }
                this.filedTable = filedTable.substring(1);

            }
            return this;
        }
    }


    public String buildEntityString(){
        StringBuilder str = new StringBuilder();
        if (fieldList!=null){
            for (Field field : fieldList) {
                str.append("    private ").append(field.getFieldType()).append(" ").append(field.getFieldName()).append(";\n");
            }
        }
        return str.toString();
    }

    public String buildAllEntityString(){
        StringBuilder str = new StringBuilder();
        if (commonFieldList!=null){
            for (Field field : commonFieldList) {
                str.append("    private ").append(field.getFieldType()).append(" ").append(field.getFieldName()).append(";\n");
            }
            str.append("\n");
        }
        if (fieldList!=null){
            for (Field field : fieldList) {
                str.append("    private ").append(field.getFieldType()).append(" ").append(field.getFieldName()).append(";\n");
            }
        }
        return str.toString();
    }

    public String buildAllEntityFiled(){
        StringBuilder str = new StringBuilder();
        if (commonFieldList!=null){
            for (Field field : commonFieldList) {
                str.append(",").append(field.getFiledTable());
            }
        }

        if (fieldList!=null){
            for (Field field : fieldList) {
                str.append(",").append(field.getFiledTable());
            }
        }
        return str.substring(1);
    }

    public String buildEntityFiled(){
        StringBuilder str = new StringBuilder();
        if (fieldList!=null){
            for (Field field : fieldList) {
                str.append(",").append(field.getFiledTable());
            }
        }
        return str.substring(1);
    }

    public String buildBasicFieldOfEntity(){
        StringBuilder str = new StringBuilder();
        if (fieldList!=null){
            for (Field field : fieldList) {
                str.append(",#{entity.").append(field.getFieldName()).append("}");
            }
        }
        return str.substring(1);
    }

    public String buildUpdateSqlOfNotNullField(){
        StringBuilder str = new StringBuilder();
        if (fieldList!=null){
            for (Field field : fieldList) {
                // <if test = 'entity.name != null'> name=#{entity.name},</if>
                str.append("<if test = 'entity.").append(field.getFieldName()).append(" != null' >")
                        .append(field.getFiledTable()).append("=#{entity.").append(field.getFieldName()).append("},</if>");
            }
        }
        return str.toString();
    }



   /* public static void main(String[] args) {
        System.out.println(Arrays.toString("bizUser".split("(?<!^)(?=[A-Z])")));
        System.out.println(Arrays.toString("BizUser".split("(?<!^)(?=[A-Z])")));
    }*/
}
