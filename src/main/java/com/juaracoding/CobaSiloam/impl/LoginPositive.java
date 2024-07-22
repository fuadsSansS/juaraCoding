package com.juaracoding.CobaSiloam.impl;



import com.juaracoding.CobaSiloam.connectivity.DriverSingleton;
import com.juaracoding.CobaSiloam.page.HomePage;
import com.juaracoding.CobaSiloam.page.LoginPage;
import com.juaracoding.CobaSiloam.util.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on 20/07/2024
@Author Acer a.k.a. Fuady Wahyudi
Java Developer
Created on 20/07/2024 1:38
@Last Modified 20/07/2024 1:38
Version 1.0
*/
public class  LoginPositive {

    public static WebDriver driver;
    private LoginPage loginPage ;
    private HomePage homePage;

    @BeforeTest
    public void initCase(){
//        DriverSingleton.getInstance(Constants.FIREFOX);
        DriverSingleton.getInstance(Constants.CHROME);
        this.driver = DriverSingleton.getDriver();
        this.driver.get(Constants.URL_LOGIN);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(priority = 0)
    public void validLogin(){
        loginPage.clear();//STEP-1
        loginPage.inputUsername("admindika");//STEP-2
        loginPage.inputPassword("d1k4@passw0rd");//STEP-3
        loginPage.clickLogin();//STEP-4
        String strValidation = homePage.homePageValidation();
        System.out.println("Home Page Validation "+strValidation);

        /** tambahkan step logout */
        Assert.assertEquals("Home",strValidation);//STEP-5
    }

    @Test(priority = 1)
    public void logout(){
        homePage.logout();
        String strLoginFormValidation = loginPage.loginFormValidation();//setelah logout
        Assert.assertEquals("Username :",strLoginFormValidation);
    }

    @AfterTest
    public void closeDriver(){
        DriverSingleton.closeObjectInstance();
    }

}





