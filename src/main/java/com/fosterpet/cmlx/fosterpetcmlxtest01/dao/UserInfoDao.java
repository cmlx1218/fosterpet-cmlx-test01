package com.fosterpet.cmlx.fosterpetcmlxtest01.dao;

import com.fosterpet.cmlx.fosterpetcmlxtest01.message.model.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * @Author cmlx
 * @Date 2019-6-26 0026 17:17
 * @Version 1.0
 */

public interface UserInfoDao extends CrudRepository<UserInfo,Long> {
    /* 通过username查找用户信息 */
    public UserInfo findByUsername(String usernaem);
}
