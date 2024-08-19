package com.juaracoding.CobaSiloam.util;

import com.juaracoding.CobaSiloam.page.HomePage;
import com.juaracoding.CobaSiloam.page.LoginPage;

public class Constants {

	public static final int TIMEOUT = 35;
	public static final int TIMEOUT_DELAY = 1;
	public static final String GLOB_PARAM_DELAY = "y";
	public static final String DEV_MODE = "n";
	public static final String CHROME = "Chrome";
	public static final String FIREFOX = "Firefox";
	public static final String EDGE = "Edge";
	public static final String OPERA = "Opera";
	public static final String IE = "IE";
	public static final String SAFARI = "Safari";
	public static final String URL_LOGIN = "https://dev.ptdika.com/staging.siloam/";
	private static LoginPage loginPage ;
	private static HomePage homePage;




	public static void login(String username, String password){
		loginPage = new LoginPage();
		loginPage.inputUsername(username);//STEP-2
		loginPage.inputPassword(password);//STEP-3
		loginPage.clickLogin();//
	}

	public static void logout(){
		homePage = new HomePage();
		homePage.logout();
	}
}