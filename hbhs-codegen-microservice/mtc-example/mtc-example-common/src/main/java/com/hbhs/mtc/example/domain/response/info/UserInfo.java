package com.hbhs.mtc.example.domain.response.info;

import com.hbhs.common.domain.model.response.info.BaseInfo;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor@AllArgsConstructor
public class UserInfo extends BaseInfo {
    private java.lang.String id;
    private java.lang.String name;
    private UserTypeEnums type;
    private java.lang.Integer age;

}
