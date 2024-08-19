package com.juaracoding.CobaSiloam.page;

import com.juaracoding.CobaSiloam.util.Constants;
import com.juaracoding.CobaSiloam.connectivity.DriverSingleton;
import com.juaracoding.CobaSiloam.util.GlobalFunction;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on 20/07/2024
@Author Acer a.k.a. Fuady Wahyudi
Java Developer
Created on 20/07/2024 1:10
@Last Modified 20/07/2024 1:10
Version 1.0
*/
public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement txtFieldUsername;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement txtFieldPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;

    @FindBy(xpath = "//label[normalize-space()='Username :']")
    private WebElement logo;

    private boolean validUsername;

    public boolean validPassword;

    public LoginPage() {
        this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }


    public void inputUsername(String username){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldUsername)).sendKeys(username);

            this.validUsername =(Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].validity.valid;",txtFieldUsername);
        }catch (Exception e){
            System.out.println("Komponen Text Field Username Tidak Ditemukan !!");
        }
    }

    public void inputPassword(String password){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldPassword)).sendKeys(password);

            this.validPassword =(Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].validity.valid;",txtFieldPassword);
        }catch (Exception e){
            System.out.println("Komponen Text Field Password Tidak Ditemukan !!");
        }
    }

    public void clickLogin(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(btnLogin)).click();
        }catch (Exception e){
            System.out.println("Komponen Tombol Tidak Ditemukan !!");
        }
    }

    public void clear(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try{
            /** Set Field Password Empty String */
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldPassword)).clear();
            /** Set Field Username Empty String */
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldUsername)).clear();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String loginFormValidation(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        return logo==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(logo)).getText();
    }

    public Boolean getValidUsername() {
        return validUsername;
    }


}





