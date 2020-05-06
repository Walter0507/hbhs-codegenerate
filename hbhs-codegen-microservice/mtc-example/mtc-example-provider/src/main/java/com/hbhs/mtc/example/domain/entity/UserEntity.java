package com.hbhs.mtc.example.domain.entity;

import com.hbhs.common.domain.model.BaseEntity;
import lombok.*;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor@AllArgsConstructor
public class UserEntity extends BaseEntity {
    private java.lang.String id;
    private java.lang.String name;
    private UserTypeEnums type;
    private java.lang.Integer age;

}
