package com.hbhs.mtc.example.repository.dao.mapper.provider;

public class UserMapperConsts {

    public final static String TABLE_NAME = "t_user";

    public final static String FULL_FIELD = "is_deleted,create_time,update_time,id,name,type,age";

    public final static String BASIC_FIELD = "id,name,type,age";

    public final static String BASIC_FIELD_OF_ENTITY = "#{entity.id},#{entity.name},#{entity.type},#{entity.age}";

    public final static String UPDATE_SQL_OF_FIELD = "<if test = 'entity.id != null' >id=#{entity.id},</if><if test = 'entity.name != null' >name=#{entity.name},</if><if test = 'entity.type != null' >type=#{entity.type},</if><if test = 'entity.age != null' >age=#{entity.age},</if>" ;

    public final static String BASIC_FIELD_OF_ENTITY = "#{entity.id},#{entity.name},#{entity.type},#{entity.age}";

    public final static String UPDATE_SQL_OF_FIELD = "" +
            "<if test = 'entity.name != null'> name=#{entity.name},</if>" +
            "<if test = 'entity.type != null'> type=#{entity.type},</if>" +
            "<if test = 'entity.age != null'> age=#{entity.age},</if>" ;
}
