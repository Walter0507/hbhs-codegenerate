package com.hbhs.mtc.example.repository.dao.mapper;

import com.hbhs.mtc.example.domain.criteria.UserCriteria;
import com.hbhs.mtc.example.domain.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.hbhs.mtc.example.repository.dao.mapper.provider.UserMapperConsts.*;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ") VALUES(" + BASIC_FIELD_OF_ENTITY + ")")
    Boolean insertUser(@Param("entity") UserEntity entity);

    @Insert("<script>" +
            "INSERT INTO " + TABLE_NAME + "(" + BASIC_FIELD + ")" +
            " VALUES " +
            "<foreach collection='entityList' item='entity' open='' close='' separator=',' > " +
            "(" + BASIC_FIELD_OF_ENTITY + ")" +
            "</foreach>" +
            "</script>")
    Boolean batchInsertUser(@Param("entityList") List<UserEntity> entityList);

    @Update("<script> UPDATE " + TABLE_NAME + " SET " + UPDATE_SQL_OF_FIELD + " update_time=NOW() WHERE id = #{entity.id} </script>")
    Boolean updateUser(@Param("entity") UserEntity entity);

    @Update("UPDATE " + TABLE_NAME + " SET is_deleted = 1 where id = #{id}")
    Boolean deleteUser(@Param("id") String id);

    @Select("SELECT " + FULL_FIELD + " FROM " + TABLE_NAME + " WHERE id = #{id} AND is_deleted = 0")
    UserEntity findUserById(@Param("id") String id);


    List<UserEntity> findUserByCriteria(@Param("criteria") UserCriteria criteria);

}
