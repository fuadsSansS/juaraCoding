package com.juaracoding.CobaSiloam.page;

import com.juaracoding.CobaSiloam.connectivity.DriverSingleton;
import com.juaracoding.CobaSiloam.util.Constants;
import com.juaracoding.CobaSiloam.util.GlobalFunction;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.juaracoding.CobaSiloam.util.Constants.TIMEOUT_DELAY;

/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-223.8214.52, built on 23/07/2024
@Author Acer a.k.a. Fuady Wahyudi
Java Developer
Created on 23/07/2024 18:07
@Last Modified 23/07/2024 18:07
Version 1.0
*/
public class InputPage {

    private WebDriver driver;


    @FindBy(xpath = "//a[@href='https://dev.ptdika.com/staging.siloam/sales/input']")
    private WebElement linkInput;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement inputNama;

    @FindBy(xpath = "//input[@id='no_bpjs']")
    private WebElement inputBpjs;

    @FindBy(xpath = "//input[@id='no_ktp']")
    private WebElement inputKtp;

    @FindBy(xpath = "//textarea[@id='address']")
    private WebElement fieldAlamat;

    @FindBy(xpath = "//span[@id='select2-ktp_city-container']")
    private  WebElement ddlKotaKTP ;//KOTA JAKARTA SELATAN

    @FindBy(xpath ="//input[@role='textbox']" )
    private WebElement inputKota;

    @FindBy(xpath = "//input[@id='origin_faskes']")
    private WebElement fieldFaskesAwal;

    @FindBy(xpath = "//span[@id='select2-destination_faskes-container']")
    private WebElement ddlFaskesTujuan ;//KOTA JAKARTA SELATAN

    @FindBy(xpath = "//input[@role='textbox']")
    private WebElement inputFaskesTujuan;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmitFormInputData;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]")
    private WebElement alerValid;

    @FindBy(xpath = "//a[@class='nav-link active']//span[@class='d-sm-block d-none']")
    private WebElement formUploadDocument; //beralih ke form upload document

    @FindBy(xpath = "//span[normalize-space()='Foto Faskes Awal']")
    private WebElement uploadFotoFaskesAwal;

    @FindBy(xpath = "//span[normalize-space()='Tanda Tangan Digital']")
    private WebElement uploadTTDDigital;

    @FindBy(xpath = "//span[normalize-space()='Foto Faskes Tujuan']")
    private WebElement uploadFotoFaskesTujuan ;

    @FindBy(xpath = "//input[@id='file']")
    private WebElement file ; // untuk milih file

    @FindBy(xpath = "//button[@id='btnSave']")
    private WebElement btnSave ;

    @FindBy(xpath = "//strong[normalize-space()='Terima kasih dokumen anda sudah lengkap !']")
    private WebElement alertDokumen;

    @FindBy(xpath = "//h1[@class='page-header']")
    private WebElement formInputTitle;

    @FindBy(xpath = "//button[@class='swal-button swal-button--confirm']")
    private  WebElement btnOK;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement btnConfirmUploadDocument;

    @FindBy(xpath = "//strong[normalize-space()='Terima kasih dokumen anda sudah lengkap !']")
    private WebElement pagevalidasiTTDdigital;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement btnSubmitTTDdigital;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement validationSucces;

    @FindBy(xpath = "//span[@class='d-none d-md-inline']")
    private WebElement profilSpan;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    private WebElement btnLogout;

    @FindBy(xpath = "//label[normalize-space()='Username :']")
    private WebElement logo;

    public InputPage() {
        this.driver= DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void clickInput(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(linkInput)).click();
        }catch (Exception e){
            System.out.println("1");
        }
    }

    public void inputNama(String nama){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(inputNama)).sendKeys(nama);
        }catch (Exception e){
            System.out.println("2");
        }
    }

    public void inputBpjs(String bpjs){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(inputBpjs)).sendKeys(bpjs);
        }catch (Exception e){
            System.out.println("3");
        }
    }

    public void inpuKtp(String ktp){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(inputKtp)).sendKeys(ktp);
        }catch (Exception e){
            System.out.println("4");
        }
    }

    public void inputAlamat(String alamat){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(fieldAlamat)).sendKeys(alamat);
        }catch (Exception e){
            System.out.println("5");
        }
    }

    public List<String> getCityList() {
        List<String> cityList = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY));

        try {
            // Tunggu hingga elemen <select> dengan XPath terlihat
            WebElement selectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div/div/div/form/div[5]/div/select")));

            // Temukan semua elemen <option> di dalam elemen <select>
            List<WebElement> optionElements = selectElement.findElements(By.tagName("option"));

            // Iterasi dan ambil teks dari setiap elemen <option>
            for (WebElement option : optionElements) {
                cityList.add(option.getAttribute("data-value").trim());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cityList;
    }

    public void clickKota(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(ddlKotaKTP)).click();
        }catch (Exception e){
            System.out.println("6");
        }
    }

    public String getRandomCity(List<String> cityList) {
        // Cek apakah daftar kota tidak kosong
        if (cityList.isEmpty()) {
            throw new IllegalStateException("City list is empty.");
        }
        // Mengacak daftar kota
        Collections.shuffle(cityList, new Random());

        // Mengembalikan kota pertama dari daftar yang telah diacak
        return cityList.get(0);
    }


    public void inputKota(String kota){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(inputKota)).sendKeys(kota + Keys.RETURN);
        }catch (Exception e){
            System.out.println("7");
        }

    }

    public void inputFaskesAwal(String faskesAwal){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(fieldFaskesAwal)).sendKeys(faskesAwal);
        }catch (Exception e){
            System.out.println("8");
        }
    }

    public void clickFaskesTujuan(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(ddlFaskesTujuan)).click();
        }catch (Exception e){
            System.out.println("9");
        }
    }

    public void inputFaskesTujuan(String faskesTujuan){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(inputFaskesTujuan)).sendKeys(faskesTujuan + Keys.RETURN);
        }catch (Exception e){
            System.out.println("10");
        }
    }

    public void clikBtnSubmitInputData(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try{
            new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(btnSubmitFormInputData)).click();
        }catch (Exception e){
            System.out.println("11");
        }
    }

    public String inputFormValidation(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        return alerValid==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(alerValid)).getText();
    }

    public void clickBtnUploadFaskesAwal(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(uploadFotoFaskesAwal)).click();
        }catch (Exception e){
            System.out.println("12");
        }
    }

    public void inputFileFaskesAwal(String fotoFaskesAwal){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.elementToBeClickable(file)).sendKeys(fotoFaskesAwal);
        }catch (Exception e){
            System.out.println("13");
            e.printStackTrace();
        }
    }

    public void clickBtnSave(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(btnSave)).click();
        }catch (Exception e){
            System.out.println("14");
        }
    }

    public void clickBtnSwall(){
        GlobalFunction.delay((TIMEOUT_DELAY));
        try {
            new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(btnOK)).click();
        }catch (Exception e){
            System.out.println("15");
        }
    }

    public void clickBtnUploadFaskesTujuan(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(uploadFotoFaskesTujuan)).click();
        }catch (Exception e){
            System.out.println("16");
        }
    }

    public void inputFileFaskesTujuan(String fotoFaskesTujuan){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.elementToBeClickable(file)).sendKeys(fotoFaskesTujuan);
        }catch (Exception e){
            System.out.println("17");
        }
    }

    public void clickBtnUploadTtdDigital(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(uploadTTDDigital)).click();
        }catch (Exception e){
            System.out.println("16");
        }
    }

    public void inputFileTtdDigital(String fotoTtdDigital){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.elementToBeClickable(file)).sendKeys(fotoTtdDigital);
        }catch (Exception e){
            System.out.println("17");
        }
    }

    public void clickBtnDokumen(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(btnConfirmUploadDocument)).click();
        }catch (Exception e){
            System.out.println("18");
        }
    }

    public void handleAlert() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept(); // Terima alert
        } catch (NoAlertPresentException e) {
            System.out.println("Alert tidak ditemukan.");
        }
    }

    public void scrollToTextValid(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(pagevalidasiTTDdigital));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pagevalidasiTTDdigital);
        }catch (Exception e){
            System.out.println("Element text yang menampilkan fitur tidak terlihat !!!");
        }

    }

    public String inputFormTTD(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        return pagevalidasiTTDdigital == null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(pagevalidasiTTDdigital)).getText();
    }

    public void scrollToBtn(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(btnSubmitTTDdigital));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnSubmitTTDdigital);
        }catch (Exception e){
            System.out.println("Element text yang menampilkan fitur tidak terlihat !!!");
        }
    }

    public void clickBtnSubmitTtdDigital(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnSubmitTTDdigital)).click();
    }

    public String validSuccesUpload(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        return validationSucces == null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(validationSucces)).getText();
    }

    public void logout(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(profilSpan)).click();
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnLogout)).click();
    }

    public String loginFormValidation(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        return logo==null?"":new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(logo)).getText();
    }


}





