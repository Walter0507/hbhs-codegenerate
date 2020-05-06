package com.hbhs.mtc.example.domain.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "DATABASE_NAME",type = "TABLE_NAME",replicas = 1,shards = 1)
@Data
public class UserEsEntity implements Serializable {
// @Id
// @Field(type = FieldType.Keyword)

    private java.lang.String id;
    private java.lang.String name;
    private UserTypeEnums type;
    private java.lang.Integer age;


}
