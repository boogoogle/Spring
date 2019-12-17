package com.booo.spring.mapper;


import com.booo.spring.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

/**
 * 指定这是一个操作数据库的Mapper
 */
//@Mapper
public interface UserMapper {

    @Select("select * from users where id=#{id}")
    public User getUserByI(Integer id);

    @Delete("delete from users where id=#{id}")
    public int deleteUserByid(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id") // 获取自增主键
    @Insert("insert into users(username, password) values(#{username}, #{password})")
    public int insertUser(User user);

    @Update("update users set user=#{username} where id=#{id}")
    public int updateUser(User user);

    @Select("select * from users")
    public Collection<User> getAllUsers();



}
