package com.juaracoding.CobaSiloam.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.juaracoding.CobaSiloam.connectivity.DriverSingleton;

import com.juaracoding.CobaSiloam.page.HomePage;
import com.juaracoding.CobaSiloam.page.InputPage;

import com.juaracoding.CobaSiloam.page.LoginPage;
import com.juaracoding.CobaSiloam.util.Constants;
import com.juaracoding.CobaSiloam.util.DataGenerator;
import com.juaracoding.CobaSiloam.util.GlobalFunction;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on 24/07/2024
@Author Acer a.k.a. Fuady Wahyudi
Java Developer
Created on 24/07/2024 1:13
@Last Modified 24/07/2024 1:13
Version 1.0
*/
public class InputDataUser {

    public static WebDriver driver;
    private InputPage inputPage;
    private LoginPage loginPage;
    private DataGenerator dataGenerator;
    public static Map<String,Object> mapToCompare = new HashMap<>();
    private String dir;


    @BeforeTest
    public void initCase(){
//      DriverSingleton.getInstance(Constants.FIREFOX);
        DriverSingleton.getInstance(Constants.FIREFOX);
        this.driver = DriverSingleton.getDriver();
        this.driver.get(Constants.URL_LOGIN);
        inputPage = new InputPage();
        dataGenerator = new DataGenerator();
        GlobalFunction.delay(5);
        Constants.login("K6400001", "a");
        inputPage.clickInput();
        dir = System.getProperty("user.dir");


    }

    @Test
    public void inputData(){
        inputPage.inputNama(dataGenerator.dataNamaLengkap());
        inputPage.inputBpjs(dataGenerator.dataBPJS());
        inputPage.inpuKtp(dataGenerator.dataNoKTP());
        inputPage.inputAlamat(dataGenerator.dataAlamat());
        inputPage.clickKota();
        inputPage.inputKota("JAKARTA PUSAT");
        inputPage.inputFaskesAwal("Klinik Permata");
        inputPage.clickFaskesTujuan();
        inputPage.inputFaskesTujuan("Siloam Clinic Kepu Timur || Kota Jakarta Pusat");
        inputPage.clikBtnSubmitInputData();
        String validasi = inputPage.inputFormValidation();
        String validasi1 = validasi.substring(0,validasi.length()-2);
        Assert.assertEquals("Data berhasil Di Simpan",validasi1);
        inputPage.clickBtnUploadFaskesAwal();
        inputPage.inputFileFaskesAwal(dir +"\\src\\main\\resources\\data\\ajo.PNG");
        inputPage.clickBtnSave();
        inputPage.clickBtnSwall();
        inputPage.clickBtnUploadFaskesTujuan();
        inputPage.inputFileFaskesTujuan(dir +"\\src\\main\\resources\\data\\1nf.PNG");
        inputPage.clickBtnSave();
        inputPage.clickBtnSwall();
        inputPage.clickBtnUploadTtdDigital();
        inputPage.inputFileTtdDigital(dir +"\\src\\main\\resources\\data\\2nf.PNG");
        inputPage.clickBtnSave();
        inputPage.clickBtnSwall();
        inputPage.clickBtnDokumen();
        inputPage.handleAlert();
        inputPage.scrollToTextValid();
        String valid1 = inputPage.inputFormTTD();
        Assert.assertEquals(valid1, "Terima kasih dokumen anda sudah lengkap !");
        inputPage.clickBtnSubmitTtdDigital();
        inputPage.handleAlert();
        String valid2 = inputPage.validSuccesUpload();
        String strValid2 = valid2.substring(0,valid2.length()-2);
        Assert.assertEquals(strValid2,"TTD Digital Berhasil");
        Constants.logout();
    }


    @AfterTest
    public void closeDriver(){
        DriverSingleton.closeObjectInstance();
    }

}





