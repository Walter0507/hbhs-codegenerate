package com.hbhs.common.codegen.template.ddd;

import com.hbhs.common.codegen.consts.CodeGenConst;
import com.hbhs.common.codegen.model.TemplateObject;
import com.hbhs.common.codegen.util.FileUtils;
import lombok.Builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DddTemplateObjectBuilder {

    private String sourceFolder;
    private boolean includingSpringDataElasticSearch = false;
    private List<TemplateObject> objectList = new ArrayList<>();

    private DddTemplateObjectBuilder(String sourceFolder) {
        this.sourceFolder = sourceFolder == null ? "" : sourceFolder;
    }

    public static DddTemplateObjectBuilder newInstance(String sourceFolder) {
        return new DddTemplateObjectBuilder(sourceFolder == null ? "" : sourceFolder);
    }

    public DddTemplateObjectBuilder includingSpringDataElasticSearch(boolean includingSpringDataElasticSearch){
        this.includingSpringDataElasticSearch = includingSpringDataElasticSearch;
        return this;
    }

    public DddTemplateObjectBuilder initProjectTemplate() {
        initProjectBaseTemplate();
        initProjectApiTemplate();
        initProjectAppTemplate();
        initProjectCommonTemplate();
        initProjectProviderTemplate();
        initProjectTestTemplate();
        return this;
    }

    public DddTemplateObjectBuilder initProjectBaseTemplate() {
        TemplateObject template = TemplateObject.builder()
                .templateName(sourceFolder + "/project/pom.xml.template")
                .sourceFileNameTemplate("pom.xml")
                .sourceFolderTemplate("/")
                .build();
        objectList.add(template);
        return this;
    }

    public DddTemplateObjectBuilder initProjectApiTemplate() {
        TemplateObject template = TemplateObject.builder()
                .templateName(sourceFolder + "/project/api/pom.xml.template")
                .sourceFileNameTemplate("pom.xml")
                .sourceFolderTemplate("/" + CodeGenConst.KEY_PROJECT_NAME + "-api/")
                .build();
        objectList.add(template);
        return this;
    }

    public DddTemplateObjectBuilder initProjectAppTemplate() {
        TemplateObject template = TemplateObject.builder()
                .templateName(sourceFolder + "/project/app/pom.xml.template")
                .sourceFileNameTemplate("pom.xml")
                .sourceFolderTemplate("/" + CodeGenConst.KEY_PROJECT_NAME + "-app/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/project/app/application.properties.template")
                .sourceFileNameTemplate("application.properties")
                .sourceFolderTemplate("/" + CodeGenConst.KEY_PROJECT_NAME + "-app/src/main/resources/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/project/app/project_config.properties.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_PROJECT_NAME + ".properties.bak")
                .sourceFolderTemplate("/" + CodeGenConst.KEY_PROJECT_NAME + "-app/src/main/resources/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/project/app/applicationBoot.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_PROJECT_CLASS_NAME + "ApplicationBoot.java")
                .sourceFolderTemplate("/" + CodeGenConst.KEY_PROJECT_NAME + "-app/src/main/java/" + CodeGenConst.KEY_PACKAGE_NAME.replaceAll("\\.", "/") + "/")
                .build();
        objectList.add(template);


//        template = TemplateObject.builder()
//                .templateName(sourceFolder+"/project/app/swagger.java.template")
//                .sourceFileNameTemplate("SwaggerConfig.java")
//                .sourceFolderTemplate("/"+CodeGenConst.KEY_PROJECT_NAME+"-app/src/main/java/"+KEY_PACKAGE_NAME.replaceAll("\\.","/")+"/config/")
//                .build();
//        objectList.add(template);
        return this;
    }

    public DddTemplateObjectBuilder initProjectCommonTemplate() {
        TemplateObject template = TemplateObject.builder()
                .templateName(sourceFolder + "/project/common/pom.xml.template")
                .sourceFileNameTemplate("pom.xml")
                .sourceFolderTemplate("/" + CodeGenConst.KEY_PROJECT_NAME + "-common/")
                .build();
        objectList.add(template);
        return this;
    }

    public DddTemplateObjectBuilder initProjectProviderTemplate() {
        TemplateObject template = TemplateObject.builder()
                .templateName(sourceFolder + "/project/provider/pom.xml.template")
                .sourceFileNameTemplate("pom.xml")
                .sourceFolderTemplate("/" + CodeGenConst.KEY_PROJECT_NAME + "-provider/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/project/provider/databaseConfig.java.template")
                .sourceFileNameTemplate("DatabaseConfig.java")
                .sourceFolderTemplate("/" + CodeGenConst.KEY_PROJECT_NAME + "-provider/src/main/java/" + CodeGenConst.KEY_PACKAGE_NAME.replaceAll("\\.", "/") + "/config/")
                .build();
        objectList.add(template);
        return this;
    }

    public DddTemplateObjectBuilder initProjectTestTemplate() {
        TemplateObject template = TemplateObject.builder()
                .templateName(sourceFolder + "/project/test/pom.xml.template")
                .sourceFileNameTemplate("pom.xml")
                .sourceFolderTemplate("/" + CodeGenConst.KEY_PROJECT_NAME + "-test/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/project/test/application.properties.template")
                .sourceFileNameTemplate("application.properties")
                .sourceFolderTemplate("/" + CodeGenConst.KEY_PROJECT_NAME + "-test/src/test/resources/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/project/test/baseDao.java.template")
                .sourceFileNameTemplate("BaseDaoTest.java")
                .sourceFolderTemplate("/" + CodeGenConst.KEY_PROJECT_NAME + "-test/src/test/java/" + CodeGenConst.KEY_PACKAGE_NAME + "/repository/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/project/test/baseEsDao.java.template")
                .sourceFileNameTemplate("BaseEsTest.java")
                .sourceFolderTemplate("/" + CodeGenConst.KEY_PROJECT_NAME + "-test/src/test/java/" + CodeGenConst.KEY_PACKAGE_NAME + "/repository/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/project/test/baseClient.java.template")
                .sourceFileNameTemplate("BaseClientTest.java")
                .sourceFolderTemplate("/" + CodeGenConst.KEY_PROJECT_NAME + "-test/src/test/java/" + CodeGenConst.KEY_PACKAGE_NAME + "/api/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/project/test/testBoot.java.template")
                .sourceFileNameTemplate("TestBoot.java")
                .sourceFolderTemplate("/" + CodeGenConst.KEY_PROJECT_NAME + "-test/src/test/java/" + CodeGenConst.KEY_PACKAGE_NAME + "/api/")
                .build();
        objectList.add(template);

        return this;
    }


    public DddTemplateObjectBuilder initEntityTemplate() {
        initEntityApiTemplate();
        initEntityAppTemplate();
        initEntityCommonTemplate();
        initEntityProviderTemplate();
        initEntityTestTemplate();
        return this;
    }

    public DddTemplateObjectBuilder initEntityApiTemplate() {
        String baseFolder = "/" + CodeGenConst.KEY_PROJECT_NAME + "-api/src/main/java/" + CodeGenConst.KEY_PACKAGE_NAME ;
        TemplateObject template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/api/client.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "Client.java")
                .sourceFolderTemplate(baseFolder + "/api/client/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/api/endpoint.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "Endpoint.java")
                .sourceFolderTemplate(baseFolder + "/api/endpoint/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/api/fallback.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "ClientFallback.java")
                .sourceFolderTemplate(baseFolder + "/api/fallback/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/api/proxy.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "Proxy.java")
                .sourceFolderTemplate(baseFolder + "/api/proxy/")
                .build();
        objectList.add(template);
        return this;
    }

    public DddTemplateObjectBuilder initEntityAppTemplate() {

        return this;
    }

    public DddTemplateObjectBuilder initEntityCommonTemplate() {
        String baseFolder = "/" + CodeGenConst.KEY_PROJECT_NAME + "-common/src/main/java/" + CodeGenConst.KEY_PACKAGE_NAME ;
        TemplateObject template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/common/createParam.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "CreateParam.java")
                .sourceFolderTemplate(baseFolder + "/domain/request/param/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/common/queryParam.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "QueryParam.java")
                .sourceFolderTemplate(baseFolder + "/domain/request/param/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/common/updateParam.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "UpdateParam.java")
                .sourceFolderTemplate(baseFolder + "/domain/request/param/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/common/info.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "Info.java")
                .sourceFolderTemplate(baseFolder + "/domain/response/info/")
                .build();
        objectList.add(template);
        return this;
    }

    public DddTemplateObjectBuilder initEntityProviderTemplate() {
        String baseFolder = "/" + CodeGenConst.KEY_PROJECT_NAME + "-provider/src/main/java/" + CodeGenConst.KEY_PACKAGE_NAME ;
        // convertor
        TemplateObject template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/provider/commonDataConvertor.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "CommonDataConvertor.java")
                .sourceFolderTemplate(baseFolder + "/convertor/"+CodeGenConst.KEY_ENTITY_NAME_PACKAGE+"/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/provider/queryParamConveroter.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "QueryParam2CriteriaConvertor.java")
                .sourceFolderTemplate(baseFolder + "/convertor/"+CodeGenConst.KEY_ENTITY_NAME_PACKAGE+"/")
                .build();
        objectList.add(template);

        // endpoint
        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/provider/controller.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "Controller.java")
                .sourceFolderTemplate(baseFolder + "/endpoint/")
                .build();
        objectList.add(template);

        // entity
        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/provider/entity.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "Entity.java")
                .sourceFolderTemplate(baseFolder + "/domain/entity/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/provider/criteria.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "Criteria.java")
                .sourceFolderTemplate(baseFolder + "/domain/criteria/")
                .build();
        objectList.add(template);

        if (includingSpringDataElasticSearch){
            template = TemplateObject.builder()
                    .templateName(sourceFolder + "/entity/provider/es.entity.java.template")
                    .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "EsEntity.java")
                    .sourceFolderTemplate(baseFolder + "/domain/es/")
                    .build();
            objectList.add(template);
        }

        // dao
        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/provider/iDao.java.template")
                .sourceFileNameTemplate("I"+CodeGenConst.KEY_ENTITY_NAME + "Dao.java")
                .sourceFolderTemplate(baseFolder + "/repository/dao/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/provider/daoImpl.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "DaoImpl.java")
                .sourceFolderTemplate(baseFolder + "/repository/dao/impl/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/provider/mapper.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "Mapper.java")
                .sourceFolderTemplate(baseFolder + "/repository/dao/mapper/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/provider/mapperConst.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "MapperConsts.java")
                .sourceFolderTemplate(baseFolder + "/repository/dao/mapper/provider/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/provider/mapperProvider.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "MapperProvider.java")
                .sourceFolderTemplate(baseFolder + "/repository/dao/mapper/provider/")
                .build();
        objectList.add(template);

        if (includingSpringDataElasticSearch){
            template = TemplateObject.builder()
                    .templateName(sourceFolder + "/entity/provider/es.repository.java.template")
                    .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "EsRepository.java")
                    .sourceFolderTemplate(baseFolder + "/repository/es/")
                    .build();
            objectList.add(template);
        }

        // service
        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/provider/service.java.template")
                .sourceFileNameTemplate("I"+CodeGenConst.KEY_ENTITY_NAME + "Service.java")
                .sourceFolderTemplate(baseFolder + "/service/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/provider/serviceImpl.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "ServiceImpl.java")
                .sourceFolderTemplate(baseFolder + "/service/impl/")
                .build();
        objectList.add(template);
        return this;
    }

    public DddTemplateObjectBuilder initEntityTestTemplate() {
        String baseFolder = "/" + CodeGenConst.KEY_PROJECT_NAME + "-test/src/test/java/" + CodeGenConst.KEY_PACKAGE_NAME ;

        TemplateObject template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/test/clientTest.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "ClientTest.java")
                .sourceFolderTemplate(baseFolder + "/api/client/")
                .build();
        objectList.add(template);

        template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/test/daoTest.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "DaoImplTest.java")
                .sourceFolderTemplate(baseFolder + "/repository/dao/impl/")
                .build();
        objectList.add(template);

        if (includingSpringDataElasticSearch){
            template = TemplateObject.builder()
                    .templateName(sourceFolder + "/entity/test/esdaoTest.java.template")
                    .sourceFileNameTemplate(CodeGenConst.KEY_ENTITY_NAME + "RepositoryTest.java")
                    .sourceFolderTemplate(baseFolder + "/repository/es/")
                    .build();
            objectList.add(template);
        }

        return this;
    }

    public TemplateObject getEntityEnumTemplate(){
        String baseFolder = "/" + CodeGenConst.KEY_PROJECT_NAME + "-common/src/main/java/" + CodeGenConst.KEY_PACKAGE_NAME ;
        TemplateObject template = TemplateObject.builder()
                .templateName(sourceFolder + "/entity/common/enums.java.template")
                .sourceFileNameTemplate(CodeGenConst.KEY_ENUM_CLASS_NAME + ".java")
                .sourceFolderTemplate(baseFolder + "/domain/enums/")
                .build();
        FileUtils.loadGroovyTemplate(Collections.singletonList(template));
        return template;
    }
    public List<TemplateObject> build() {
        FileUtils.loadGroovyTemplate(objectList);
        return objectList;
    }
}


