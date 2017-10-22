package util;

import org.apache.commons.io.FileUtils;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotOnFailure implements MethodRule  {

    private RemoteWebDriver driver;

    public ScreenShotOnFailure(RemoteWebDriver driver){
        this.driver = driver;
    }

    public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    statement.evaluate();
                } catch (Throwable t) {
                    // exception will be thrown only when a test fails.
                    captureScreenShot(frameworkMethod.getName());
                    // rethrow to allow the failure to be reported by JUnit
                    throw t;
                }
            }

            private void captureScreenShot(String fileName) throws IOException {
                File scrFile = driver.getScreenshotAs(OutputType.FILE);
                File targetFile = new File("screenshots/" + fileName + ".png");
                FileUtils.copyFile(scrFile, targetFile);
            }
        };
    }
}