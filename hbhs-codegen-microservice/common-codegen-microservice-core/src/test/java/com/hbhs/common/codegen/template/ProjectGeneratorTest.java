package com.hbhs.common.codegen.template;

import com.hbhs.common.codegen.model.EntityObject;
import com.hbhs.common.codegen.template.ddd.DddProjectGenerator;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

public class ProjectGeneratorTest {

    @Test
    public void generateFramework() {
        EntityObject entity = EntityObject.builder()
                .targetFolder("D:/Code/self/ddd-template/")
                .groupId("com.hbhs.mtc")
                .artifactId("mtc-order")
                .build().setDefault();

        new DddProjectGenerator().generateFramework(entity);

        entity.setEntityName("User");
        entity.setTableName("t_user");
        entity.setFieldList(Arrays.asList(
                EntityObject.Field.builder().fieldName("id").fieldType(String.class.getName()).filedTable("id").build(),
                EntityObject.Field.builder().fieldName("name").fieldType(String.class.getName()).filedTable("name").build(),
                EntityObject.Field.builder().fieldName("age").fieldType(Integer.class.getName()).filedTable("age").build(),
                EntityObject.Field.builder().fieldName("companyId").fieldType(String.class.getName()).filedTable("company_id").build(),
                EntityObject.Field.builder().fieldName("userType").fieldType("UserTypeEnums").filedTable("user_type").build()
        ));
        entity.setCommonFieldList(Arrays.asList(
                EntityObject.Field.builder().fieldName("isDeleted").fieldType(Boolean.class.getName()).filedTable("is_deleted").build(),
                EntityObject.Field.builder().fieldName("createTime").fieldType(Date.class.getName()).filedTable("create_time").build(),
                EntityObject.Field.builder().fieldName("updateTime").fieldType(Date.class.getName()).filedTable("update_time").build()
                ));
        entity.setDefault();

        entity.setEnumFieldList(Arrays.asList(
                EntityObject.Field.builder().fieldName("userType").fieldType("UserTypeEnums").filedTable("user_type").build()
        ));
        entity.setDefault();

        new DddProjectGenerator().generateEntity(entity);

    }

    @Test
    public void generateFrameworkOfFolder() {
    }

    @Test
    public void generateFrameworkOfSource() {
    }

    @Test
    public void generateEntity() {
    }
}