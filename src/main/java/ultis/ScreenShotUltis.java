package ultis;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenShotUltis {

    private ScreenShotUltis(){}

    public static String getScreenShoot(){
        return  ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

    public static Media getBase64Media(){
        return MediaEntityBuilder
                .createScreenCaptureFromBase64String(ScreenShotUltis.getScreenShoot()).build();
    }
}
