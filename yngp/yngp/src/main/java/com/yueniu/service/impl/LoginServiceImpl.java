package com.yueniu.service.impl;

import com.yueniu.dao.LoginMapper;
import com.yueniu.model.User;
import com.yueniu.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginMapper loginMapper;

    @Override
    public List<User> getAllUser() {

        List<User> users = loginMapper.selectAllUser();

        return users;
    }

    @Override
    public Integer addCentralTokenToUser(String centralToken) {

        Integer result = loginMapper.addCentralTokenToUser(centralToken);

        return result;
    }

    @Override
    public String getCentralToken() {

        List<User> users = loginMapper.selectAllUser();

        for (User user:users){
            String id = user.getId();
            if (id.equals("1")){
                String centralToken = user.getCentralToken();
                return centralToken;
            }
        }
        return null;
    }
}
