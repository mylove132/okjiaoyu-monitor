package com.okjiaoyu.qa.teacherspace.cases;
import com.okjiaoyu.qa.teacherspace.domain.Config;
import com.okjiaoyu.qa.teacherspace.domain.User;
import com.okjiaoyu.qa.teacherspace.service.common.ILoginBusiness;
import com.okjiaoyu.qa.teacherspace.service.common.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Author: liuzhanhui
 * @Decription:
 * @Date: Created in 2018-11-22:09:56
 * Modify date: 2018-11-22:09:56
 */
public class LoginCase extends BaseCase {

    @Test
    public void login(){
        ILoginBusiness loginBusiness = new Login();
        User user = new User();
        user.setUserName(Config.ACCOUNT);
        user.setPassword(Config.PASSWORD);
        loginBusiness.login(user);
        Assert.assertTrue(loginBusiness.checkLogin());
    }
}
