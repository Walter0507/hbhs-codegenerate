package com.hbhs.mtc.example.domain.enums;

import com.hbhs.common.domain.model.BaseEnum;

public enum UserTypeEnums implements BaseEnum {
    // TODO
    ;

    private int code;
    private String name;

    UserTypeEnums(int code, String name){
        this.code = code;
        this.name = name;
    }

    public static UserTypeEnums findByName(String name){
        for (UserTypeEnums value : values()) {
            if (value.name.equalsIgnoreCase(name)){
                return value;
            }
        }
        return null;
    }

    public static UserTypeEnums findByCode(int code){
        for (UserTypeEnums value : values()) {
            if (value.code == code){
                return value;
            }
        }
        return null;
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }
}
