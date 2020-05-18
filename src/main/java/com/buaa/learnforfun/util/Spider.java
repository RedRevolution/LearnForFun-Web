package com.buaa.learnforfun.util;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Spider {
    //private final String driverPath = "C:\\Anaconda3\\chromedriver.exe";
    private final String driverPath = "./chromedriver";
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
        courseInfo = new ArrayList<>();
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        String userAgent = "Chrome/81.0.4044.138";
        //options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--user-agent=" + userAgent);
        options.addArguments("--lang=zh-cn");
        driver = new ChromeDriver(options);
    }

    private void login() throws TimeoutException {
        driver.get(vpnUrl);
        //输入统一身份认证账号和密码
        wait(10,"//*[@id=\"user_login\"]");
        WebElement inputUserName = driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
        WebElement inputPassword = driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        WebElement commit = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/input"));
        inputUserName.sendKeys(username);
        inputPassword.sendKeys(password);
        commit.click();
    }

    private void switchToJiaoWu() throws TimeoutException {
        //点击教务
        wait(10,"/html/body/div[5]/div/ul/li[5]/a");
        WebElement pushButton = driver.findElement(By.xpath("/html/body/div[5]/div/ul/li[5]/a"));
        pushButton.click();
        //切换到新的窗口
        String FirstHandle = driver.getWindowHandle();
        //得到浏览器所有窗口的权柄为Set集合，遍历
        for (String winHandle : driver.getWindowHandles()) {
            //如果为 最先的窗口 权柄跳出
            if (winHandle.equals(FirstHandle)) continue;
            //如果不为 最先的窗口 权柄，将 新窗口的操作权柄 给 driver
            driver.switchTo().window(winHandle);
        }
    }

    private void switchToSelectedCourse() throws TimeoutException, InterruptedException {
        //点击学生选课
        wait(10,"/html/body/div[2]/div[1]/div[1]/div[2]/div/a[6]");
        WebElement pushButton1 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/a[6]"));
        pushButton1.click();
        Thread.sleep(2000);
        //点击已选课程
        wait(10,"/html/body/div[2]/div[2]/div/div[6]/div/a[9]");
        WebElement pushButton2 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[6]/div/a[9]"));
        pushButton2.click();
        driver.switchTo().frame("iframename");
    }

    private void parseTable(boolean isQiTa) throws TimeoutException {
        //查看table的元素
        wait(10,"/html/body/div[5]/div/div[7]/table/tbody");
        WebElement table = driver.findElement(By.xpath("/html/body/div[5]/div/div[7]/table/tbody"));
        List<WebElement> tableList = table.findElements(By.tagName("tr"));
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
                } else {
                    if (j == 3 || j == 4 || j == 6 || j == 7) {
                        courseInfo.add(td.getText());
                    }
                }
                j++;
            }
        }
    }

    private void getCourse() throws TimeoutException {
        for (int i = 1; i <= 6; i++) {
            wait(10,"/html/body/div[5]/div/div[3]/table/tbody/tr/td[1]/ul/li[" + String.valueOf(i) + "]/a");
            //点击课程分类
            WebElement pushButton = driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/table/tbody/tr/td[1]/ul/li[" + String.valueOf(i) + "]/a"));
            pushButton.click();
            //下拉选择时间
            wait(10,"//*[@id=\"pageXnxqid\"]");
            Select s1 = new Select(driver.findElement(By.xpath("//*[@id=\"pageXnxqid\"]")));
            if (i == 6) s1.selectByIndex(0);
            else s1.selectByIndex(1);
            //点击查询
            wait(10,"//*[@id=\"queryform\"]/ul/li[3]/div/a");
            WebElement pushButton1 = driver.findElement(By.xpath("//*[@id=\"queryform\"]/ul/li[3]/div/a"));
            pushButton1.click();
            if (i == 6) parseTable(true);
            else parseTable(false);
        }
    }

    private void wait(int time,String element) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
    }

    public String run() {
        try {
            init();
            login();
            //System.out.println("\n\n\n\n\n\n\n login success \n\n\n\n\n\n");
            switchToJiaoWu();
            //System.out.println("\n\n\n\n\n\n\n switchtojiaowu success \n\n\n\n\n\n");
            switchToSelectedCourse();
            //System.out.println("\n\n\n\n\n\n\n switchtoselectedcourse success \n\n\n\n\n\n");
            getCourse();
            //System.out.println("\n\n\n\n\n\n\n getcourse success \n\n\n\n\n\n");
            driver.quit();
            //System.out.println(courseInfo);
            return "success";
        } catch (Exception e) {
            System.out.println(e);
            driver.quit();
            return "failure";
        }
    }

    public List<String> getCourseInfo() {
        return courseInfo;
    }

}
