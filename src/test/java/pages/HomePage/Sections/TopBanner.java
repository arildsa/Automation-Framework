package pages.HomePage.Sections;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import util.CustomCommands;

public class TopBanner extends CustomCommands{

    public TopBanner(RemoteWebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void clickSaveButton(){
        System.out.println("clicking the save button");
    }
}
