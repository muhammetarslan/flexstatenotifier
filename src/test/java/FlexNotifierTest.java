import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class FlexNotifierTest {


    @Test
    public void notifierTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://flex.amazon.com/get-started");
        List<WebElement> divs = driver.findElements(By.xpath("//div[@class='container  padding-top-xlarge swa background-color-transparent']//div"));
        List<String> texts = divs.stream().map(x -> x.getText()).collect(Collectors.toList());
        Assert.assertTrue(texts.contains("Georgia"));
        System.out.println(texts);
        driver.quit();
    }
}