package com.okjiaoyu.qa.teacherspace.service.common;

import com.okjiaoyu.qa.teacherspace.domain.User;

/**
 * @Author: liuzhanhui
 * @Decription:
 * @Date: Created in 2018-11-22:09:44
 * Modify date: 2018-11-22:09:44
 */
public interface ILoginBusiness {

    void login(User user);

    boolean checkLogin();
}
