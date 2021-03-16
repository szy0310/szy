package com.hp.szy.service.img;

import com.hp.szy.Mapper.TSysuserMapper;
import com.hp.szy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceimg implements UserService {

    @Resource
    public TSysuserMapper tSysuserMapper;

    @Override
    public String getRolePermission(String loginName) {
        return tSysuserMapper.getRolePermission(loginName);
    }

    @Override
    public String getRole(String loginName) {
        return tSysuserMapper.getRole(loginName);
    }

    @Override
    public String getPermission(String loginName) {
        return tSysuserMapper.getPermission(loginName);
    }

    @Override
    public int checkUserBanStatus(String loginName) {
        return tSysuserMapper.checkUserBanStatus(loginName);
    }

    @Override
    public String getPassword(String loginName) {
        return tSysuserMapper.getPassword(loginName);
    }
}



