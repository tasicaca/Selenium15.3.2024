package selenium4setup;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

	public class SeleniumDemo {
	    public static void main(String[] args) throws InterruptedException {
	        WebDriver driver = DriverSetup.getChromeDriver();

	        SearchCriteriaTest searchCriteriaTest = new SearchCriteriaTest(driver);
	        searchCriteriaTest.testSearchCriteria();

	        driver.quit();
	    }
	}

	class DriverSetup {
	    public static WebDriver getChromeDriver() {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");
	        return new ChromeDriver(options);
	    }
	}

	class SearchCriteriaTest {
	    private WebDriver driver;
	    private WebElementFinder webElementFinder;

	    public SearchCriteriaTest(WebDriver driver) {
	        this.driver = driver;
	        this.webElementFinder = new WebElementFinder(driver);
	    }

	    public void testSearchCriteria() throws InterruptedException {
	        try {
	            driver.get("https://www.kupujemprodajem.com");

	            WebElement button = driver.findElement(By.className("Button_children__tDTVo"));
	            button.click();
	            Thread.sleep(2000);

	            String link = Constants.SEARCH_CRITERIA_XPATH;

	            WebElement button1 = driver.findElement(By.xpath(link + "/div/div[2]"));
	            button1.click();

	            Thread.sleep(2000);

	            WebElement parentElementSelectCategory = driver.findElement(By.xpath(link + "/div[2]/div/div/div/div[3]/div[3]"));
	            parentElementSelectCategory.click();

	            Thread.sleep(1000);

	            WebElement fieldInput = driver.findElement(By.xpath("//*[@id=\"react-select-categoryId-input\"]"));
	            fieldInput.sendKeys("Odeća | Ženska");
	            Thread.sleep(1000);

	            fieldInput.sendKeys(Keys.ENTER);

	            Thread.sleep(1000);

	            Actions actions = new Actions(driver);

	            for (int i = 0; i < 85; i++) {
	                actions.keyDown(fieldInput, Keys.ARROW_DOWN).perform();
	            }

	            fieldInput.sendKeys(Keys.ENTER);
	            Thread.sleep(2000);

	            System.out.println("KATEGORIJA IZABRANA USPEŠNO");

	            String linkInputSubcategory = "/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[1]/span/div[2]/div/section/div";

	            WebElement divZaBiranjeVrsteOdece = driver.findElement(By.xpath(linkInputSubcategory + "/div[2]/div[1]"));
	            divZaBiranjeVrsteOdece.click();
	            Thread.sleep(2000);

	            WebElement SelectSubcategory = driver.findElement(By.xpath(linkInputSubcategory + "/div[2]/div[1]/div[1]/div[1]/div[1]/div"));
	            SelectSubcategory.click();
	            Thread.sleep(4000);

	            WebElement fieldBluze = driver.findElement(By.xpath("//*[@id=\"react-select-groupId-input\"]"));
	            fieldBluze.sendKeys("Bluze");
	            Thread.sleep(2000);
	            fieldBluze.sendKeys(Keys.ENTER);

	            Thread.sleep(500);
	            WebElement minPrice = driver.findElement(By.id("priceFrom"));
	            minPrice.sendKeys("100");
	            Thread.sleep(500);

	            System.out.println("POTKATEGORIJA IZABRANA USPEŠNO");

	            String linkCurrency = "/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[2]/span/div[1]/div[3]/section/div";

	            WebElement dugmeValute = driver.findElement(By.xpath(linkCurrency + "/div/div[2]/div"));
	            dugmeValute.click();
	            Thread.sleep(2000);

	            WebElement divValute = driver.findElement(By.xpath(linkCurrency + "/div[2]/div/div"));
	            divValute.click();
	            Thread.sleep(2000);

	            WebElement cb = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[2]/span/div[2]/div[1]/span/label/span[1]"));
	            cb.click();
	            Thread.sleep(500);

	            String linkSelectCondition = "/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[3]/span/div[1]/div/section/div";

	            WebElement sel = driver.findElement(By.xpath(linkSelectCondition + "/div[1]/div[2]"));
	            sel.click();
	            Thread.sleep(2000);

	            WebElement KaoNovo = driver.findElement(By.xpath(linkSelectCondition + "/div[2]/div/div[2]"));
	            KaoNovo.click();
	            Thread.sleep(2000);
	            WebElement Novo = driver.findElement(By.xpath(linkSelectCondition + "/div[2]/div"));
	            Novo.click();
	            Thread.sleep(2000);

	            WebElement buttonFinalElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[2]/button[2]"));
	            buttonFinalElement.click();

	            System.out.println("SVI FILTERI SU IZABRANI USPEŠNO");
	            Thread.sleep(5000);

	            WebElement spanElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/div[2]/div[1]/div/div/span/div/span"));
	            String spanText = spanElement.getText();
	            String numberStr = spanText.replaceAll("[^0-9]", "");
	            int number = Integer.parseInt(numberStr);

	            if (number > 1000) {
	                System.out.println("BROJ OGLASA JE VEĆI OD 1000");
	            } else {
	                System.out.println("BROJ OGLASA JE MANJI OD 1000");
	            }

	            System.out.println("PRVI TEST JE USPEŠNO OKONČAN");

	        } catch (Exception e) {
	            System.out.println("PRVI TEST NIJE USPEŠNO OKONČAN");
	        }
	    }
	}

	class WebElementFinder {
	    private WebDriver driver;

	    public WebElementFinder(WebDriver driver) {
	        this.driver = driver;
	    }

	    public List<WebElement> findDivs(String xpath) {
	        WebElement parentElement = driver.findElement(By.xpath(xpath));
	        return parentElement.findElements(By.xpath(".//*"));
	    }
	}

	class Constants {
	    public static final String SEARCH_CRITERIA_XPATH = "/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[1]/span/div[1]/div/section/div";
	    // Add other constants if needed
	}
