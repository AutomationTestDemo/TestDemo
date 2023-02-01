package workbench.pages;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import runners.CucumberRunner;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class assignmentPage extends CucumberRunner {
    private int invalidImageCount;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    By email=By.id("email");
    By passVal= By.id("password");
    By loginBtn= By.xpath("//button[text()='Login']");
    By profile=By.xpath("//div[@class='dropdown action-dropdown user-actions']//span[@class='action-icons-text']");
    By addProductBtn=By.xpath("//img[@alt='add-product']");
    By nextStepBtn=By.xpath("//button[contains(text(),'Next Step')]");
    By auctionTitle=By.xpath("//input[@name='title']");
    By category=By.xpath("//input[@placeholder='select category']");
    By subCategory=By.xpath("//input[@placeholder='select subcategory']");
    By programingLanguage=By.xpath("//input[@placeholder='Select programming language']");
    By framework= By.xpath("//input[@placeholder='Select framework']");
    By quantity=By.xpath("//input[@placeholder='Quantity']");
    By mainImage =By.xpath("//label[@for='main_image']");
    By buyNow=By.name("value");
    By startBid= By.name("starting_bid");
    By bidIncrement= By.name("bid_increase");
    By date=By.name("date");
    By dateOk=By.id("mddtp-date__ok");
    By time=By.name("time");
    By timeOk=By.id("mddtp-time__ok");
    By auctionType=By.xpath("//input[@value='audio']/following-sibling::span");


    public void enterCredentials(String name, String pass) {
        WebElement user=driver.findElement(email);
        user.sendKeys(name);
        WebElement password=driver.findElement(passVal);
        password.sendKeys(pass);
    }
    public void clickLoginBtn() {
       WebElement loginButton= driver.findElement(loginBtn);
       loginButton.click();
    }

    public void clickAddProduct() throws InterruptedException {
        WebElement profilePic= driver.findElement(profile);
        profilePic.click();
        WebElement addProduct=driver.findElement(addProductBtn);
        addProduct.click();
    }

    public void clickAuctionType(String value) {
        driver.findElement(By.xpath("//label[@for='"+value+"']")).click();
    }

    public void clickNextStepButton(int i) {
        WebElement nextStepButton= driver.findElement(By.xpath("(//button[contains(text(),'Next Step')])["+i+"]"));
        nextStepButton.click();
    }

    public void enterRequiredFields() {

        WebElement title=driver.findElement(auctionTitle);
        title.sendKeys("Testing");
        WebElement selectCategory=driver.findElement(category);
        selectCategory.click();
        selectCategory.sendKeys("Information Technology");
        selectCategory.sendKeys(Keys.ENTER);
        WebElement selectSubCategory= driver.findElement(subCategory);
        js.executeScript("arguments[0].scrollIntoView();", selectSubCategory);
        selectSubCategory.click();
        selectSubCategory.sendKeys("software");
        selectSubCategory.sendKeys(Keys.ENTER);
        WebElement selectLanguage=driver.findElement(programingLanguage);
        js.executeScript("arguments[0].scrollIntoView();", selectLanguage);
        selectLanguage.click();
        selectLanguage.sendKeys("java");
        selectLanguage.sendKeys(Keys.ENTER);
        WebElement selectFramework=driver.findElement(framework);
        js.executeScript("arguments[0].scrollIntoView();", selectFramework);
        selectFramework.click();
        selectFramework.sendKeys("other");
        selectFramework.sendKeys(Keys.ENTER);
        WebElement enterQuantity=driver.findElement(quantity);
        js.executeScript("arguments[0].scrollIntoView();", enterQuantity);
        enterQuantity.sendKeys("2");
    }
    public void enterAuctionDetail(String value) {
        driver.switchTo().frame("tinymce_description_ifr");
        driver.findElement(By.xpath("//body[@id='tinymce']//p")).sendKeys(value);
        driver.switchTo().defaultContent();
    }
    public void enterPolicyDetail(String value) throws InterruptedException {
        driver.switchTo().frame("tinymce_policy_ifr");
        driver.findElement(By.xpath("//body[@id='tinymce']//p")).sendKeys(value);
        driver.switchTo().defaultContent();
//        Thread.sleep(10000);
    }

    public void uploadImage() throws AWTException, InterruptedException {
        WebElement uploadImage=driver.findElement(mainImage);
        js.executeScript("arguments[0].scrollIntoView();", uploadImage);
        uploadImage.click();
        Thread.sleep(4000);
        //put path to your image in a clipboard
        StringSelection ss = new StringSelection(System.getProperty("user.dir") + "\\ImageUpload\\demo.jpeg");
        System.out.println(System.getProperty("user.dir") + "\\ImageUpload\\demo.jpeg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(90);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(4000);
//        uploadImage.sendKeys(Keys.ENTER);
    }

    public void enterBuNowVale() throws InterruptedException {
        WebElement buyValue=driver.findElement(buyNow);
        buyValue.sendKeys("500");
    }

    public void enterStartBidValue() {
        WebElement startBidVal=driver.findElement(startBid);
        startBidVal.sendKeys("200");
    }

    public void enterIncreaseBid() {
        WebElement increaseBid=driver.findElement(bidIncrement);
        increaseBid.sendKeys("150");
    }

    public void enterDate() throws InterruptedException {
        WebElement enterDate=driver.findElement(date);
        enterDate.click();
        Thread.sleep(1000);
        WebElement dateBtn=driver.findElement(dateOk);
        dateBtn.click();
    }

    public void enterTime() throws InterruptedException {
        WebElement enterTime=driver.findElement(time);
        enterTime.click();
        WebElement timeBtn=driver.findElement(timeOk);
        timeBtn.click();
    }

    public void auctionShowType() {
        WebElement auctionToggle=driver.findElement(auctionType);
        auctionToggle.click();
    }
}