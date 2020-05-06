package com.hbhs.common.codegen;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UserEntity {
    private String id;
    private String name;
    private UserTypeEnums type;
    private Integer age;


    public enum UserTypeEnums{

    }
}
