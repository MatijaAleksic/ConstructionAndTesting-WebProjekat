package rs.ac.uns.kts.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage {

	private WebDriver driver;

	@FindBy(xpath = "//*[@id='center_column']/p")
	private WebElement searchAlertDiv;

	@FindBy(className = "heading-counter")
	private WebElement counterSpan;

	@FindBy(xpath = "//*[@class='product_list grid row']//*[@class='product-name']")
	private List<WebElement> productTitles;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean productContainsText(String text) {
		for (WebElement element : productTitles) {
			if (!element.getText().contains(text))
				return false;
		}

		return true;
	}

	public boolean resultMessagePresent(String text) {
		return Utilities.textWait(driver, this.counterSpan, text, 10);
	}

	public boolean errorMessagePresent(String text) {
		return Utilities.textWait(driver, this.searchAlertDiv, text, 10);
	}

}
