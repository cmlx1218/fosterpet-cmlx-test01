package com.fosterpet.cmlx.fosterpetcmlxtest01.controller;

import com.fosterpet.cmlx.remote.TestRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cmlx
 * @Date 2019-6-21 0021 16:08
 * @Version 1.0
 */
@RequestMapping("/test01")
@RestController
public class UserController {

    @Autowired
    private TestRemote testRemote;


    @RequestMapping("/getUserInfo")
    public String getUserInfo(String userName){
        return testRemote.getUserInfo(userName);
    }


}
