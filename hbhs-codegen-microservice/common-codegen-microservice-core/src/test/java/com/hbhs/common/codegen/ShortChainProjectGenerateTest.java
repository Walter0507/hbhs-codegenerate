package com.hbhs.common.codegen;

import com.hbhs.common.codegen.house.*;
import com.hbhs.common.codegen.model.EntityObject;
import lombok.Data;
import org.testng.annotations.Test;

import java.util.Date;

public class ShortChainProjectGenerateTest {


    @Test
    public void testCreateProject(){
        EntityObject object = new EntityObject();
        object.setTargetFolder("D:/Code/self/ddd-template/example-project/");
        object.setGroupId("com.hbhs.house");
        object.setArtifactId("house-pricing");
        CodeGenerate generate = CodeGenerate.instance();
        generate.generateFramework(object);

        object.cleanEntityInfo();
        object.setTableName("t_province");
        object.setEntity(Province.class);
        object.setDefault();
        generate.generateEntity(object);

        object.cleanEntityInfo();
        object.setTableName("t_province_price");
        object.setEntity(ProvincePrice.class);
        object.setDefault();
        generate.generateEntity(object);

        object.cleanEntityInfo();
        object.setTableName("t_city");
        object.setEntity(City.class);
        object.setDefault();
        generate.generateEntity(object);

        object.cleanEntityInfo();
        object.setTableName("t_city_price");
        object.setEntity(CityPrice.class);
        object.setDefault();
        generate.generateEntity(object);

        object.cleanEntityInfo();
        object.setTableName("t_distinct");
        object.setEntity(Distinct.class);
        object.setDefault();
        generate.generateEntity(object);

        object.cleanEntityInfo();
        object.setTableName("t_distinct_price");
        object.setEntity(DistinctPrice.class);
        object.setDefault();
        generate.generateEntity(object);

        object.cleanEntityInfo();
        object.setTableName("t_generate_log");
        object.setEntity(GenerateLog.class);
        object.setDefault();
        generate.generateEntity(object);
    }


}
