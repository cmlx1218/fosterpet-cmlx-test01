package com.fosterpet.cmlx.fosterpetcmlxtest01.service;

import com.fosterpet.cmlx.fosterpetcmlxtest01.message.model.UserInfo;

/**
 * @Author cmlx
 * @Date 2019-6-26 0026 17:06
 * @Version 1.0
 */
public interface UserInfoService {
    /**
     * 通过username查找用户信息;
     */
    public UserInfo findByUsername(String username);
}
