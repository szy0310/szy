package com.hp.szy.Controller;

import com.hp.szy.Mapper.TRoleMapper;
import com.hp.szy.Utils.model.Msg;
import com.hp.szy.models.TRole;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TRoleController {

    @Resource
 private TRoleMapper tRoleMapper;
    @RequestMapping("/getselect")
@ResponseBody
    public Msg getselect(){
        List<TRole> tRoleList=tRoleMapper.selectAll();

        if(tRoleList!=null && !tRoleList.isEmpty()){
            return Msg.fail().add("info",tRoleList);
        }else{
            return Msg.fail().add("info","数据为空");

        }
    }

}
