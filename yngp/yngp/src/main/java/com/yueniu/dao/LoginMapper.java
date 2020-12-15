package com.yueniu.dao;

import com.yueniu.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoginMapper {

    //查询所有用户
    List<User> selectAllUser();
    //将centralToken插入到user表用户id为1的数据中
    Integer addCentralTokenToUser(@Param("centralToken") String centralToken);

    //查询用户id为1的用户的centralToken
    String getCentralToken();

}
