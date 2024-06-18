package Post_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class registration {

    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void startBrowser() {

//        WebDriver driver = new ChromeDriver();

        driver.get("https://carshare.yomafleet.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test(enabled = true)
    public void SignUp() throws InterruptedException, AWTException {

        //Home page - Sign Up
        driver.findElement(By.cssSelector("div[class='flex flex-1 justify-end items-center'] a:nth-child(2)")).click();
        Thread.sleep(2000);
        //Sign up individually
        driver.findElement(By.xpath("(//button[@type='button'][text()='Join Now'])[1]")).click();
        Thread.sleep(2000);

        //Enter User credential
        driver.findElement(By.id("fullName")).sendKeys("ThandarTest");

        driver.findElement(By.id("username")).sendKeys("maythandaroo720@gmail.com");

        WebElement p1 = driver.findElement(By.id("password"));
        p1.sendKeys("Thandar@test2");
        driver.findElement(By.xpath("(//div[@class='cursor-pointer'])[1]")).click();

        WebElement p2 = driver.findElement(By.id("confirmPassword"));
        p2.sendKeys("Thandartest2");
        driver.findElement(By.xpath("(//div[@class='cursor-pointer'])[2]")).click();
        Thread.sleep(1500);

//        Assert.assertEquals(p2.getText(),p1.getText());

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(5000);

        //Input OTP from email manually//
        driver.findElement(By.id("verifying")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("swal-button swal-button--confirm")).click(); //click alert mesg OK button
        Thread.sleep(2000);

    }

    @Test(enabled = false)
    public void Login() throws InterruptedException, AWTException {

        driver.get("https://carshare.yomafleet.com/account/signin");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id='username']")).sendKeys("maythandaroo720@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Thandar@test2");
        driver.findElement(By.xpath("(//div[@class='cursor-pointer'])[1]")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);

        //Fill personal info
        driver.findElement(By.xpath("(//button[@type='button'][text()='Upload'])[1]")).click();
        //select image manually after clicking Upload
        Thread.sleep(4000);
        ///enter phone number
        driver.findElement(By.xpath("(//div[@class='select__input-container css-15ol6m4'])[1]")).sendKeys("MM");

        Robot k = new Robot();
        k.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        driver.findElement(By.id("national_number")).sendKeys("95126420");

        ///select DOB
        driver.findElement(By.className("numInput cur-year")).sendKeys("1999");
        driver.findElement(By.xpath("//option[@value='0']")).click();
        driver.findElement(By.cssSelector("span[aria-label='January 16, 1999']")).click();

        ///choose country
        driver.findElement(By.xpath("(//div[@class='select__input-container css-15ol6m4'])[2]")).sendKeys("myanmar");
        k.keyPress(KeyEvent.VK_ENTER);

        ///input city
        driver.findElement(By.id("city")).sendKeys("Yangon");

        ///input township
        driver.findElement(By.id("township")).sendKeys("Latha");

        ///input address
        driver.findElement(By.id("address")).sendKeys("No.11, 9th street");

        ///upload ID selfie
        driver.findElement(By.xpath("(//button[@type='button'][text()='Upload'])[2]")).click();
        //select image manually after clicking Upload
        Thread.sleep(4000);

        ///upload proof of address
        driver.findElement(By.xpath("(//button[@type='button'][text()='Upload'])[3]")).click();
        //select image manually after clicking Upload
        Thread.sleep(4000);

        //Select ID type

        driver.findElement(By.xpath("(//div[@class='select__indicator select__dropdown-indicator css-1xc3v61-indicatorContainer'])[1]")).click();
        k.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);

        //fill NRC value
        driver.findElement(By.xpath("(//div[@class='select__input-container css-15ol6m4'])[2]")).sendKeys("14");
        k.keyPress(KeyEvent.VK_ENTER);
        driver.findElement(By.xpath("(//div[@class='select__input-container css-15ol6m4'])[3]")).sendKeys("AhGaPa");
        k.keyPress(KeyEvent.VK_ENTER);
        driver.findElement(By.xpath("(//div[@class='select__input-container css-15ol6m4'])[4]")).sendKeys("N");
        k.keyPress(KeyEvent.VK_ENTER);
        driver.findElement(By.cssSelector("input[id='id_number']")).sendKeys("039282");
        Thread.sleep(2000);

        ///upload NRC image
        driver.findElement(By.xpath("(//button[@type='button'][text()='Upload'])[1]")).click();
        //select image manually after clicking Upload
        Thread.sleep(4000);
        ///upload NRC image
        driver.findElement(By.xpath("(//button[@type='button'][text()='Upload'])[2]")).click();
        //select image manually after clicking Upload
        Thread.sleep(4000);
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.quit();
        System.out.println("The driver closed the browser entirely.");
    }
}