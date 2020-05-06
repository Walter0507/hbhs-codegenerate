package com.hbhs.common.codegen.template;

import com.hbhs.common.codegen.model.EntityObject;

public interface ProjectGenerator<T> {

    void generateFramework(EntityObject entityObject);

    void generateFrameworkOfFolder(EntityObject entityObject);

    void generateFrameworkOfSource(EntityObject entityObject);

    void generateEntity(EntityObject entityObject);
}
