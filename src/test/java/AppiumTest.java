import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AppiumTest {
    static AndroidDriver<MobileElement> driver;
    static WebDriverWait wait;


    @BeforeAll
    static void enterApp() throws MalformedURLException {
        //set up
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // local appium
//        setLocalCapabilities(capabilities);
        //Perfecto appium
        setPerfectoCapabilities(capabilities);

        String cloudName = "campusm-public";
        driver = new AndroidDriver<>(new URL("https://" + cloudName.replace(".perfectomobile.com", "")
                + ".perfectomobile.com/nexperience/perfectomobile/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 45);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //login
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[5]/android.widget.TextView")).click();
        driver.findElement(By.id("com.ombiel.campusm.manual2222beta:id/acceptcontactContainer")).click();
        driver.findElement(By.id("com.ombiel.campusm.manual2222beta:id/email")).sendKeys("hannan");
        driver.findElement(By.id("com.ombiel.campusm.manual2222beta:id/password")).sendKeys("campusm");
        driver.findElement(By.id("com.ombiel.campusm.manual2222beta:id/login")).click();
        // login thomas
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
                "FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget." +
                "ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget." +
                "TextView")).click();
        //skip fingerprint
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.ombiel.campusm.manual2222beta:id/btnSkipBiometrics")));
//        driver.findElement(By.id("com.ombiel.campusm.manual2222beta:id/btnSkipBiometrics")).click();
    }

    private static void setPerfectoCapabilities(DesiredCapabilities capabilities) {
        String securityToken = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIzMTU4OWQ5OS01ZGJjLTQzMDYtYWE5OC03YzZkNzBhZDJjMWIifQ.eyJpYXQiOjE2MzM1ODk3Mjks" +
                "Imp0aSI6IjgwOGFmNGY0LTQ5MDctNDMzZC05NzU1LThiYWU1ZDI3Nzg2ZCIsImlzcyI6Imh0dHBzOi8vYXV0aDQucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2NhbXB1c20tc" +
                "HVibGljLXBlcmZlY3RvbW9iaWxlLWNvbSIsImF1ZCI6Imh0dHBzOi8vYXV0aDQucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2NhbXB1c20tcHVibGljLXBlcmZlY3RvbW9ia" +
                "WxlLWNvbSIsInN1YiI6ImY2ZDI0MDlkLThlOTAtNGE1Yi1iYzBkLTY0NDczMmNhZDM2ZSIsInR5cCI6Ik9mZmxpbmUiLCJhenAiOiJvZmZsaW5lLXRva2VuLWdlbmVyYXRvciIsIm5vb" +
                "mNlIjoiOWZiMzY5OGQtNTE4NC00M2RkLThlNTUtYzMzZTI4YzI1MDJkIiwic2Vzc2lvbl9zdGF0ZSI6IjljMmMzYjliLWY1ZDQtNGU2Yi1hNWFkLThiMjFhZTFmMTQzMiIsInNjb3BlI" +
                "joib3BlbmlkIHByb2ZpbGUgb2ZmbGluZV9hY2Nlc3MgZW1haWwifQ.ACW2Pot_eIuKj4_ycdyCS_GrqVhbTFA_vg4jmue2dAo";
        capabilities.setCapability("securityToken", securityToken);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("model", "Galaxy S.*|LG.*");
        capabilities.setCapability("app", "PUBLIC:QA2-2222-Android.apk");
        capabilities.setCapability("appPackage", "com.ombiel.campusm.autoqa22222beta");
        capabilities.setCapability("autoLaunch", true); // Whether to install and launch the app automatically.
        capabilities.setCapability("takesScreenshot", false);
        capabilities.setCapability("screenshotOnError", true);
        capabilities.setCapability("openDeviceTimeout", 5);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("enableAppiumBehavior", true);
        capabilities.setCapability("useAppiumForHybrid", true);
    }

    private static void setLocalCapabilities(DesiredCapabilities capabilities) throws MalformedURLException {
        capabilities.setCapability("deviceName", "Auto");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", "C:\\Users\\thomask\\Downloads\\QA2-master-2222-Debug.apk");
        capabilities.setCapability("appActivity", "com.ombiel.campusm.startup.Main");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("autoGrantPermissions", true);
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url, capabilities);
    }

    @Test
    public void checkSite() throws InterruptedException, MalformedURLException {
        Thread.sleep(2000);
        //enter site
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"android#\"]/android.view.View")).click();
        //accept cookies
        driver.context("WEBVIEW_com.ombiel.campusm.manual2222beta");
        Set<String> handles = driver.getWindowHandles();
        String winHandle = driver.getWindowHandle();
        handles.remove(winHandle);
        String winHandle1 = handles.iterator().next();
        if (!Objects.equals(winHandle, winHandle1)) {
            driver.switchTo().window(winHandle1);
        }
        try {
            driver.findElement(By.xpath("//*[@id=\"close_DFP_href\"]/img")).click();
        } catch (Exception e) {
            System.out.println("Banner never showed");
        }
        try {
            driver.findElement(By.xpath("//*[@id=\"fcbarcelona-button-accept\"]")).click();
        } catch (Exception e) {
            System.out.println("Cookies already accepted");
        }
        Thread.sleep(2000);
        String title = driver.getTitle();
        if (title.equals("Official FC Barcelona Website")) {
            System.out.println("Title is ok: " + title);
        } else {
            System.out.println("Wrong title, the title was found is " + title);
        }
        // back to app
        driver.context("NATIVE_APP");
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
    }

    @Test
    public void checkPoll() throws InterruptedException {
        //enter poll
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"Poll Of The Week\"]")).click();
        //choose poll
        try {
            driver.findElement(By.xpath("//android.view.View[@content-desc=\"Choose Answer poa 25 October 2021\"]/android.view.View[3]/android.widget.Image")).click();
        }
        catch (Exception e){
            System.out.println("Poll not found");
            //go home
            driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
            return;
        }
        //choose answer and confirm
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"1\"]/android.view.View[1]/android.widget.Image")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget." +
                "FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx." +
                "slidingpanelayout.widget.SlidingPaneLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android." +
                "widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android." +
                "view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button")).click();
        //check results
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"Show Quick Poll Results\"]")).click();
        Thread.sleep(2000);
        // back to app
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
    }

    @AfterAll
    static void quit()
    {
        driver.quit();
    }
}
