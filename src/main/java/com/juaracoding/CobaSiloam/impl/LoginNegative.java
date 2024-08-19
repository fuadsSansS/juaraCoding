package com.juaracoding.CobaSiloam.impl;

import com.juaracoding.CobaSiloam.connectivity.DriverSingleton;
import com.juaracoding.CobaSiloam.page.LoginPage;
import com.juaracoding.CobaSiloam.util.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on 23/07/2024
@Author Acer a.k.a. Fuady Wahyudi
Java Developer
Created on 23/07/2024 0:03
@Last Modified 23/07/2024 0:03
Version 1.0
*/
public class LoginNegative {

    public static WebDriver driver;
    private LoginPage loginPage ;

    @BeforeTest
    public void initCase(){
        DriverSingleton.getInstance(Constants.FIREFOX);
        this.driver = DriverSingleton.getDriver();
        this.driver.get(Constants.URL_LOGIN);
        loginPage = new LoginPage();
    }

    @Test(priority = 0)
    public void invalidUsername(){
        loginPage.clear();
        loginPage.inputUsername("fhsfsjhsj");
        loginPage.inputPassword("a");
        loginPage.clickLogin();
        System.out.println(loginPage.getValidUsername());
        Assert.assertTrue(loginPage.getValidUsername(), "The username field should be invalid for an invalid username.");
    }

    @Test
    public void invalidPassword(){
        loginPage.clear();
        loginPage.inputUsername("K6400001");
        loginPage.inputPassword("jfdjfd");
        loginPage.clickLogin();
        Assert.assertEquals(true, loginPage.validPassword);
    }

    @Test
    public void emptyPassword(){
        loginPage.clear();
        loginPage.inputUsername("K6400001");
        loginPage.inputPassword("");
        loginPage.clickLogin();
        Assert.assertEquals(false,loginPage.validPassword);
    }

    @Test
    public void emptyUsername(){
        loginPage.clear();
        loginPage.inputUsername("");
        loginPage.inputPassword("a");
        loginPage.clickLogin();
        Assert.assertFalse(loginPage.getValidUsername());
    }

    @Test
    public void emptyUserPass(){
        loginPage.clear();
        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.clickLogin();
        Assert.assertFalse(loginPage.getValidUsername());
    }


    @AfterTest
    public void closeDriver(){
        DriverSingleton.closeObjectInstance();
    }



}





