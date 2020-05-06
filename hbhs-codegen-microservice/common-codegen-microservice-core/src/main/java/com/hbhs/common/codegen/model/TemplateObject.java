package com.hbhs.common.codegen.model;

import groovy.text.Template;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@Builder
public class TemplateObject {
    private String templateName;
    private String sourceFolderTemplate;
    private String sourceFileNameTemplate;

    /** Groovy编译好的模板 **/
    private Template groovyTemplate;

    public static enum TemplateType{
        JAVA,
        RESOURCE,
        POM,;
    }
}
