package com.fosterpet.cmlx.fosterpetcmlxtest01.service.impl;

import com.fosterpet.cmlx.fosterpetcmlxtest01.dao.UserInfoDao;
import com.fosterpet.cmlx.fosterpetcmlxtest01.message.model.UserInfo;
import com.fosterpet.cmlx.fosterpetcmlxtest01.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author cmlx
 * @Date 2019-6-26 0026 17:07
 * @Version 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}
