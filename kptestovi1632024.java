package automationScripts;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class KPtestsWithReport {

    public static void main(String[] args) throws InterruptedException {
      
    	// System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        
        // Scenario 1: 
        testSearchCriteria(driver);
        
        // Scenario 2: 
        testAddToAddressBook(driver);
        
        driver.quit();
    }

    private static void findDivs(WebDriver driver, String link1) { // za nalazenje divova koji se dinamički menjaju
    	
    	WebElement parentElementSelectCategory2 = driver.findElement(By.xpath(link1));    
        
        List<WebElement> selectElementsSelectCategory = parentElementSelectCategory2.findElements(By.xpath(".//*"));

        System.out.println("Number of <select>1 elements found: " + selectElementsSelectCategory.size());

        for (WebElement selectElement1 : selectElementsSelectCategory) {
            System.out.println("Select podcat element text: " + selectElement1.getText());
            System.out.println("Select1 element tag name: " + selectElement1.getTagName());
        }
    }
    
    public static void testSearchCriteria(WebDriver driver) throws InterruptedException {
       
    	try {
    		driver.get("https://www.kupujemprodajem.com");


    		WebElement button = driver.findElement(By.className("Button_children__tDTVo"));

    		button.click();

    		Thread.sleep(2000);

        

    		String link	="/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[1]/span/div[1]/div/section/div";
    		// osnova za dalji rad sa input poljem gde se bira kategorija

    		WebElement button1 = driver.findElement(By.xpath(link+"/div/div[2]"));
    		button1.click();

    		Thread.sleep(2000);

    		WebElement parentElementSelectCategory = driver.findElement(By.xpath(link+"/div[2]/div/div/div/div[3]/div[3]"));
    		parentElementSelectCategory.click();

    		Thread.sleep(1000);

    		//Ovo je drugi nacin, da se direktno unese u input polje//

    		WebElement fieldInput = driver.findElement(By.xpath("//*[@id=\"react-select-categoryId-input\"]"));
    		fieldInput.sendKeys("Odeća | Ženska");
    		Thread.sleep(1000);

    		fieldInput.sendKeys(Keys.ENTER); 

    		Thread.sleep(1000);

    		// moguće je koristiti i dugme ARROW DOWN//

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
                
    		//findDivs(driver, linkDoInputPoljaZaPodkategoriju+"/div[2]/div[1]/div[1]/div[1]/div[1]/div"); 
        		
    		WebElement SelectSubcategory = driver.findElement(By.xpath(linkInputSubcategory +"/div[2]/div[1]/div[1]/div[1]/div[1]/div"));
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
        					        
    		WebElement dugmeValute = driver.findElement(By.xpath(linkCurrency+"/div/div[2]/div"));
    		dugmeValute.click();
    		Thread.sleep(2000);

    		//findDivs(driver,linkDoPolja + "/div[2]" );
        
    		WebElement divValute = driver.findElement(By.xpath(linkCurrency+"/div[2]/div/div"));
    		divValute.click();
    		Thread.sleep(2000);
                
    		//checkbox samo sa cenom
    		WebElement cb = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[2]/span/div[2]/div[1]/span/label/span[1]"));
    		cb.click();
    		Thread.sleep(500);
        
    		String linkSelectCondition="/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[3]/span/div[1]/div/section/div";
        
    		WebElement sel = driver.findElement(By.xpath(linkSelectCondition+"/div[1]/div[2]"));
    		sel.click();
    		Thread.sleep(2000);
                
    		WebElement KaoNovo = driver.findElement(By.xpath(linkSelectCondition+"/div[2]/div/div[2]"));
    		KaoNovo.click();/// selektuje prvi element
    		Thread.sleep(2000);
    		WebElement Novo= driver.findElement	(By.xpath(linkSelectCondition+"/div[2]/div"));
    		Novo.click();
    		Thread.sleep(2000);///detektuje drugi trazeni element za selekciju
    		
    		//findDivs(driver, "/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[3]/span/div[1]/div/section/div/div[2]");//dodato za trazenje child elemenata za select
        
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
    		
    	}catch (Exception e) {
    		System.out.println("PRVI TEST NIJE USPEŠNO OKONČAN");
    	}
        
    }
    
    public static void testAddToAddressBook(WebDriver driver) throws InterruptedException {
    	
    	try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("url oglasa:");
			//String urlOglasa = "https://www.kupujemprodajem.com/odeca-zenska/bluze/zara-bluza/oglas/164403795?filterId=4361893340";
			String urlOglasa = scanner.nextLine();
			try{
				driver.get(urlOglasa);
				
				WebElement dugmeAdresar = driver.findElement(By.className("ButtonTertiary_tertiary__eFrSO"));
				
				dugmeAdresar.click();
				
				Thread.sleep(4000);
				
				WebElement emailForm = driver.findElement(By.id("email"));
				emailForm.sendKeys("aleksandartasic@gmail.com");
				Thread.sleep(2000);
				
				WebElement passwordForm = driver.findElement(By.id("password"));
				passwordForm.sendKeys("sifra");
				Thread.sleep(2000);
				
				WebElement dugmePrijava = driver.findElement(By.xpath("//*[@id=\"kp-portal\"]/div/div/aside/div/div/div[2]/main/div[2]/form/button"));
				dugmePrijava.click();
				
				System.out.println("DRUGI TEST JE USPEŠNO OKONČAN");
			}catch (Exception e) {
				System.out.println("DRUGI TEST NIJE USPEŠNO OKONČAN");
			}
		}
    }
}
