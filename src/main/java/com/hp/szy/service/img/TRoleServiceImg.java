package com.hp.szy.service.img;

import com.hp.szy.Mapper.TRoleMapper;
import com.hp.szy.models.TRole;
import com.hp.szy.service.TRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TRoleServiceImg implements TRoleService {

    @Resource
    private TRoleMapper tRoleMapper;



    @Override
    public List<TRole> selectAll() {

        
        return tRoleMapper.selectAll();
    }
}
