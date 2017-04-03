package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	public void waitForElement(WebDriver driver){
		WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(PageObjectModel.emailField(driver)));
	}
}
