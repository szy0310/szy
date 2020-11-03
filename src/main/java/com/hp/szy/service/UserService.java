package com.hp.szy.service;


public interface UserService {


    String getRolePermission(String username);


    String getRole(String username);


    String getPermission(String username);


    int checkUserBanStatus(String username);


    String getPassword(String loginName);


}
