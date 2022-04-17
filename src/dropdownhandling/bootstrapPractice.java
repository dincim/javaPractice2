package dropdownhandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class bootstrapPractice {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver",
                "C:\\SeleniumDrivers\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

        driver.findElement(By.xpath("//button[@type='button']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//a//label"));

        for (int i =0; i< list.size(); i++){
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().contains("Angular"))
                list.get(i).click();
            break;
        }
        driver.quit();
    }
}
