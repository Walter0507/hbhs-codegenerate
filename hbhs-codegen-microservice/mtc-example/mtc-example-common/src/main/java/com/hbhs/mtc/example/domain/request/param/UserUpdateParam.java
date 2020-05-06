package com.hbhs.mtc.example.domain.request.param;

import com.hbhs.common.domain.model.request.param.BaseParam;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
public class UserUpdateParam extends BaseParam {
    private java.lang.String id;
    private java.lang.String name;
    private UserTypeEnums type;
    private java.lang.Integer age;


    @Override
    public void checkParam() {
        // TODO
    }
}
