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
    public String getRolePermission(String username) {
        return tSysuserMapper.getRolePermission(username);
    }

    @Override
    public String getRole(String username) {

        return tSysuserMapper.getRole(username);
    }
    @Override
    public String getPermission(String username) {

        return tSysuserMapper.getPermission(username);

    }

    @Override
    public int checkUserBanStatus(String username) {

        int sys=tSysuserMapper.checkUserBanStatus(username);

        return sys;
    }

    @Override
    public String getPassword(String username) {
        return tSysuserMapper.getPassword(username);
    }
}
