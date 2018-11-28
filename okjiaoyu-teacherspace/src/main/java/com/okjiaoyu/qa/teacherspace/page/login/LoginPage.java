package com.okjiaoyu.qa.teacherspace.page.login;

import com.okjiaoyu.qa.teacherspace.BaseOperate;
import com.okjiaoyu.qa.util.annotation.Page;
import com.okjiaoyu.qa.util.entity.ElementEntity;
import org.testng.annotations.Test;

/**
 * @Author: liuzhanhui
 * @Decription:
 * @Date: Created in 2018-11-21:14:21
 * Modify date: 2018-11-21:14:21
 */
@Page(page = "login")
public class LoginPage extends BaseOperate {

    public void userNameEdit(String userName){
        setValue(getElementEntity(), userName);
    }

    public void passwordEdit(String password){
        setValue(getElementEntity(), password);
    }

    public void loginButton(){
        click(getElementEntity());
    }

    public boolean newPasswordEdit(){
        return isPrentElement(getElementEntity());
    }
}
