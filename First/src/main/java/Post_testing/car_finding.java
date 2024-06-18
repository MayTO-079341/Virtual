package Post_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class car_finding {

    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void startBrowser() {

//        WebDriver driver = new ChromeDriver();

        driver.get("https://carshare.yomafleet.com/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void FindACar() throws InterruptedException, AWTException {

        driver.findElement(By.xpath("//a[contains(@class,'text-textBlack hover:text-primary p-2 rounded-md text-sm font-medium font-source-serif uppercase dark:text-dOnSurface dark:hover:text-secondary')][text()='Find A Car']")).click();
        Thread.sleep(1000);

        WebElement dropdown = driver.findElement(By.xpath("//div[@class='select__indicators css-1wy0on6']"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", dropdown);
        dropdown.sendKeys("Yangon Airport (Coach Parking) , Mingalardon Township");
//        Select city = new Select(dropdown);
//        city.selectByVisibleText("Yangon Airport (Coach Parking) , Mingalardon Township");
        Robot k = new Robot();
        k.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);

        //pickup date&time
//        driver.findElement(By.className("numInput cur-year")).sendKeys("2024");
//        driver.findElement(By.xpath("//option[@value='5']")).click();
        driver.findElement(By.cssSelector("span[class='flatpickr-day today selected']")).click(); // today date selected
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[placeholder='Select Pick-up Time']")).click();
        Thread.sleep(2000);

        //return date&time
        driver.findElement(By.className("numInput cur-year")).sendKeys("2024");
        driver.findElement(By.xpath("//option[@value='5']")).click();
        driver.findElement(By.cssSelector("span[class='flatpickr-day selected']")).click(); // any date select
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@class='numInput flatpickr-hour'])[2]")).sendKeys("9");
        driver.findElement(By.xpath("(//input[@class='numInput flatpickr-minute'])[2]")).sendKeys("00");
        Thread.sleep(2000);

        //Click Find A Car button
        driver.findElement(By.xpath("//button[@id='SimulateButton']")).click();
        Thread.sleep(2000);

    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        driver.quit();
        System.out.println("The driver closed the browser entirely.");
    }
}
