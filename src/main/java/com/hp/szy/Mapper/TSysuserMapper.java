package com.hp.szy.Mapper;

import com.hp.szy.models.TSysuser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSysuserMapper {

    /**

     * 获得密码

     */

    String getPassword(String loginName);



    /**

     * 获得角色权限

     */

    String getRole(String loginName);



    /**

     * 修改密码

     */

    void updatePassword(@Param("loginName") String loginName, @Param("Password") String Password);



    /**

     * 获得存在的用户

     */

    List<String> getUser();



    /**

     * 封号

     */

    void banUser(String loginName);



    /**

     * 检查用户状态

     */

    int checkUserBanStatus(String loginName);



    /**

     * 获得用户角色默认的权限

     */

    String getRolePermission(String loginName);



    /**

     * 获得用户的权限

     */

    String getPermission(String loginName);


}