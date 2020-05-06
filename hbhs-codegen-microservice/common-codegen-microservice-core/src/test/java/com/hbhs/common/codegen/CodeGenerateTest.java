package com.hbhs.common.codegen;

import com.hbhs.common.codegen.model.EntityObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class CodeGenerateTest {

    @Test
    public void testAll(){
        String currentFolder = this.getClass().getClassLoader().getResource("").getFile();
        currentFolder = currentFolder.substring(0, currentFolder.indexOf("common-codegen-microservice-core"));
        EntityObject object = new EntityObject();
        object.setTargetFolder(currentFolder);
        object.setGroupId("com.hbhs.mtc");
        object.setArtifactId("mtc-example");
        object.setEntity(UserEntity.class);

        object.setTableName("t_user");
        object.setIncludingSpringDataElasticsearch(true);
        CodeGenerate generate = CodeGenerate.instance();
        generate.generateFramework(object);
        generate.generateEntity(object);
    }
}