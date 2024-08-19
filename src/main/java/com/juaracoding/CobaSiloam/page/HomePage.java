package com.juaracoding.CobaSiloam.page;

import com.juaracoding.CobaSiloam.connectivity.DriverSingleton;
import com.juaracoding.CobaSiloam.util.Constants;
import com.juaracoding.CobaSiloam.util.GlobalFunction;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on 20/07/2024
@Author Acer a.k.a. Fuady Wahyudi
Java Developer
Created on 20/07/2024 1:31
@Last Modified 20/07/2024 1:31
Version 1.0
*/
public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[5]/h1")
    private WebElement breadcum;

    @FindBy(xpath = "//span[normalize-space()='Input']")
    private WebElement inputSpan;

    @FindBy(xpath = "//span[@class='d-none d-md-inline']")
    private WebElement profilSpan;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    private WebElement btnLogout;

    public HomePage() {
        this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }


    public String homePageValidation(){
        return breadcum==null?"":breadcum.getText();
    }

    public void logout(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(profilSpan)).click();
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnLogout)).click();
    }

}





