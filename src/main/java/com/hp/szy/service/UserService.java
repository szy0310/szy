package com.hp.szy.service;


public interface UserService {


    String getRolePermission(String loginName);


    String getRole(String loginName);


    String getPermission(String loginName);


    int checkUserBanStatus(String loginName);


    String getPassword(String loginName);


}
