package com.okjiaoyu.qa.teacherspace.service.common;

import com.okjiaoyu.qa.teacherspace.domain.User;
import com.okjiaoyu.qa.teacherspace.page.login.LoginPage;

/**
 * @Author: liuzhanhui
 * @Decription:
 * @Date: Created in 2018-11-21:18:10
 * Modify date: 2018-11-21:18:10
 */
public class Login implements ILoginBusiness {

    private LoginPage loginPage = new LoginPage();

    @Override
    public void login(User user) {
        loginPage.userNameEdit(user.getUserName());
        loginPage.passwordEdit(user.getPassword());
        loginPage.loginButton();
    }

    @Override
    public boolean checkLogin() {
        return loginPage.newPasswordEdit();
    }

}
