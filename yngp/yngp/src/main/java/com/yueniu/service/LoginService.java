package com.yueniu.service;

import com.yueniu.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginService {

    List<User> getAllUser();

    //给id为1的数据插入centralToken
    Integer addCentralTokenToUser(String centralToken);

    //获取centralToken
    String getCentralToken();
}
