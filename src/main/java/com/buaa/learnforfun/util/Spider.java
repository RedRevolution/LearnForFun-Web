package com.buaa.learnforfun.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Spider {
    private final String driverPath = "/root/chromedriver";
    private final String vpnUrl = "https://e2.buaa.edu.cn/users/sign_in";
    private String username;
    private String password;
    private WebDriver driver;
    private List<String> courseInfo;

    public Spider(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private void init() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) " +
                "Chrome/80.0.3987.163 Safari/537.36";
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--user-agent=" + userAgent);
        options.addArguments("--lang=zh-cn");
        driver = new ChromeDriver(options);
        courseInfo = new ArrayList<>();
    }

    private void login() throws InterruptedException {
        driver.get(vpnUrl);
        WebElement inputUserName = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
        WebElement inputPassword = driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        WebElement commit = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/input"));
        inputUserName.sendKeys(username);
        inputPassword.sendKeys(password);
        commit.click();
        Thread.sleep(2000);
    }

    private void switchToJiaoWu() throws InterruptedException {
        WebElement pushButton = driver.findElement(By.xpath("/html/body/div[5]/div/ul/li[5]/a"));
        pushButton.click();
        String FirstHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String winHandle : driver.getWindowHandles()) {    //得到浏览器所有窗口的权柄为Set集合，遍历
            if (winHandle.equals(FirstHandle)) continue;                //如果为 最先的窗口 权柄跳出
            driver.switchTo().window(winHandle);             //如果不为 最先的窗口 权柄，将 新窗口的操作权柄  给 driver
        }
        Thread.sleep(2000);
    }

    private void switchToSelectedCourse() throws InterruptedException {
        WebElement pushButton1 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/a[6]"));
        pushButton1.click();
        Thread.sleep(2000);
        WebElement pushButton2 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[6]/div/a[9]"));
        pushButton2.click();
        Thread.sleep(2000);
        driver.switchTo().frame("iframename");
    }

    private void parseTable(boolean isQiTa) {
        WebElement table = driver.findElement(By.xpath("/html/body/div[5]/div/div[7]/table/tbody"));
        List<WebElement> tableList = driver.findElements(By.tagName("tr"));
        int i = 0;
        for (WebElement tr : tableList) {
            if (i == 0) {
                i++;
                continue;
            }
            List<WebElement> tdList = tr.findElements(By.tagName("td"));
            int j = 1;
            for (WebElement td : tdList) {
                if (!isQiTa) {
                    if (j == 3 || j == 4 || j == 5 || j == 6) {
                        courseInfo.add(td.getText());
                    }
                }
                else {
                    if (j == 3 || j == 4 || j == 6 || j == 7) {
                        courseInfo.add(td.getText());
                    }
                }
                j++;
            }
        }
    }

    private void getCourse() throws InterruptedException {
        for (int i = 1; i <= 6; i++) {
            WebElement pushButton = driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/table/tbody/tr/td[1]/ul/li[" + String.valueOf(i) + "]/a"));
            pushButton.click();
            Select s1 = new Select(driver.findElement(By.xpath("//*[@id=\"pageXnxqid\"]")));
            if (i == 6) s1.selectByIndex(0);
            else s1.selectByIndex(1);
            WebElement pushButton1 = driver.findElement(By.xpath("//*[@id=\"queryform\"]/ul/li[3]/div/a"));
            pushButton1.click();
            Thread.sleep(2000);
            if(i == 6) parseTable(true);
            else parseTable(false);
        }
    }


    public void run() throws InterruptedException {
        init();
        login();
        switchToJiaoWu();
        switchToSelectedCourse();
        getCourse();
        driver.quit();
    }

    public List<String> getCourseInfo(){
        return courseInfo;
    }

}
