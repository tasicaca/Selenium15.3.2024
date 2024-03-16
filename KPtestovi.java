package automationScripts;

import java.util.List;
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


public class KPtestovi {

    public static void main(String[] args) throws InterruptedException {
      
    	// System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        
        // Test Scenario 1: 
        testSearchCriteria(driver);
        
        // Test Scenario 2: 
        testAddToAddressBook(driver);
        
        driver.quit();
    }

    private static void findDivs(WebDriver driver, String link1) {
    	
    	WebElement parentElementSelectCategory2 = driver.findElement(By.xpath(link1));    
        
        List<WebElement> selectElementsSelectCategory = parentElementSelectCategory2.findElements(By.xpath(".//*"));

        System.out.println("Number of <select>1 elements found: " + selectElementsSelectCategory.size());

        for (WebElement selectElement1 : selectElementsSelectCategory) {
            System.out.println("Select podcat element text: " + selectElement1.getText());
            System.out.println("Select1 element tag name: " + selectElement1.getTagName());
        }
    }

	public static void testSearchCriteria(WebDriver driver) throws InterruptedException {
        
       
        driver.get("https://www.kupujemprodajem.com");

        WebElement button = driver.findElement(By.className("Button_children__tDTVo"));
        //WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[1]/div/section/section/div/span[1]/button"));
        button.click();
        Thread.sleep(2000);
        
        String link	="/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[1]/span/div[1]/div/section/div";
        //link koji je osnova za dalji rad sa input poljem gde se bira kategorija
        
        WebElement button1 = driver.findElement(By.xpath(link+"/div/div[2]"));
        button1.click();
        
        Thread.sleep(2000);
        
        WebElement parentElementSelectCategory = driver.findElement(By.xpath(link+"/div[2]/div/div/div/div[3]/div[3]"));
        parentElementSelectCategory.click();
        Thread.sleep(1000);
        
        ///ovde mi je logika bila da nadjem xpath diva kog vidim, pa da onda nadjem njegov 3. child element sa div[2], i da onda prikazem sve njegove child elemente, to mi je i proradilo.
        ///Stim da sam dodao jos jedan div. Pri tome sam koristio kod koji mi vraca strukturu divova, taj kod je u nastavku
        ///sve ovo je radjeno jer ne vidim lepo divove
        
        
        ////////////////////////////Ovo je drugi nacin, da se direktno unese u input polje//
        /*WebElement poljeZaUpis = driver.findElement(By.xpath("//*[@id=\"react-select-categoryId-input\"]"));
        poljeZaUpis.sendKeys("Odeća | Ženska");
        Thread.sleep(2000);
        poljeZaUpis.sendKeys(Keys.ENTER); */
        /////////////////////////////moguće je koristiti i dugme na dole//
        /*Actions actions = new Actions(driver);
        // Perform key down action 20 times
        for (int i = 0; i < 20; i++) {
            actions.keyDown(parentElementSelectCategory, Keys.ARROW_DOWN).perform();
        }
        parentElementSelectCategory.sendKeys(Keys.ENTER);
        */
        
        WebElement divZaBiranjeVrsteOdece = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[1]/span/div[2]/div/section/div/div[2]/div[1]"));
        divZaBiranjeVrsteOdece.click();
        Thread.sleep(2000);
        
        ///obratiti paznju da se divovi broje posebno, a posebno span-ovi
        
        String linkDoInputPoljaZaPodkategoriju = "/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[1]/span/div[2]/div/section/div";
        
        
        findDivs(driver, linkDoInputPoljaZaPodkategoriju+"/div[2]/div[1]/div[1]/div[1]/div[1]/div"); //koristi se za divove koji se dinamicki menjaju
        
        				
        WebElement SelectSubcategory = driver.findElement(By.xpath(linkDoInputPoljaZaPodkategoriju+"/div[2]/div[1]/div[1]/div[1]/div[1]/div"));
        SelectSubcategory.click();
        Thread.sleep(4000);
          
        
        WebElement poljeZaBluze = driver.findElement(By.xpath("//*[@id=\"react-select-groupId-input\"]"));
        poljeZaBluze.sendKeys("Bluze");
        Thread.sleep(2000);
        poljeZaBluze.sendKeys(Keys.ENTER);
        
        Thread.sleep(500);
        WebElement minPrice = driver.findElement(By.id("priceFrom"));
        minPrice.sendKeys("100");
        Thread.sleep(500);
        
        WebElement cb = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[2]/span/div[2]/div[1]/span/label/span[1]"));
        cb.click();
        Thread.sleep(500);
        
        String linkSelectCondition="/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[3]/span/div[1]/div/section/div";
        
        WebElement sel = driver.findElement(By.xpath(linkSelectCondition+"/div[1]/div[2]"));
        sel.click();
        Thread.sleep(2000);
                
        WebElement poljeKaoNovo = driver.findElement(By.xpath(linkSelectCondition+"/div[2]/div/div[2]"));
        poljeKaoNovo.click();
        Thread.sleep(2000);/// selektuje prvi element
        WebElement poljeNovo= driver.findElement	(By.xpath(linkSelectCondition+"/div[2]/div"));
        poljeNovo.click();
        Thread.sleep(2000);///detektuje drugi trazeni element za selekciju
        
        findDivs(driver, "/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[3]/span/div[1]/div/section/div/div[2]");
        
        /////////////////////////////dodato za trazenje child elemenata za select////////////////////////////////////////////////////
        
        WebElement buttonFinalElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[2]/button[2]")); // 
        buttonFinalElement.click();
        
        Thread.sleep(5000);
        
        WebElement spanElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/div[2]/div[1]/div/div/span/div/span")); 
        String spanText = spanElement.getText();

        // izdvajanje brojeva iz teksta
        String numberStr = spanText.replaceAll("[^0-9]", "");
        int number = Integer.parseInt(numberStr);

        if (number > 1000) {
        	System.out.println("BROJ OGLASA JE VEĆI OD 1000");
        } else {
        	System.out.println("BROJ OGLASA JE MANJI OD 1000");
        }
    }
    
    public static void testAddToAddressBook(WebDriver driver) throws InterruptedException {
    	
    	driver.get("https://www.kupujemprodajem.com/odeca-zenska/bluze/zara-bluza/oglas/164403795?filterId=4361893340");
    	
    	WebElement dugmeAdresar = driver.findElement(By.className("ButtonTertiary_tertiary__eFrSO"));
    	//ovde sam koristio className jer je potpuno isto na svim prikazima, ne zavisi od oglasa
    	
    	dugmeAdresar.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement emailForm = driver.findElement(By.id("email"));
    	emailForm.sendKeys("aleksandartasic2810@gmail.com");
    	Thread.sleep(2000);
    	
    	WebElement passwordForm = driver.findElement(By.id("password"));
    	passwordForm.sendKeys("sifra");
    	Thread.sleep(2000);
 
    }
}