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


public class KPtest {

    public static void main(String[] args) throws InterruptedException {
      
       // System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        // Test Scenario 1: 
        testSearchCriteria(driver);
        
        // Test Scenario 2: 
        testAddToAddressBook(driver);

        // Close the browser
        driver.quit();
    }

    public static void testSearchCriteria(WebDriver driver) throws InterruptedException {
        
       
        driver.get("https://www.kupujemprodajem.com");

        WebElement button = driver.findElement(By.className("Button_children__tDTVo"));
        //WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[1]/div/section/section/div/span[1]/button"));
        button.click();
        Thread.sleep(2000);
        
        WebElement button1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[1]/span/div[1]/div/section/div/div/div[2]"));
        button1.click();
        
        Thread.sleep(2000);
                
        WebElement parentElementSelectCategory = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[1]/span/div[1]/div/section/div/div[2]/div/div/div/div[3]/div[3]"));
        parentElementSelectCategory.click();
        ///ovde mi je logika bila da nadjem xpath diva kog vidim, pa da onda nadjem njegov 3. child element sa div[2], i da onda prikazem sve njegove child elemente, to mi je i proradilo.
        ///Stim da sam dodao jos jedan div. Pri tome sam koristio kod koji mi vraca strukturu divova, taj kod je u nastavku
        ///sve ovo je radjeno jer ne vidim lepo divove
        
        //WebElement parentElementSelectCategory = driver.findElement(By.className("css-12ymph9-menu"));  ///pokusaj da lociram po className
          
        /*
        // Find all <select> elements under the parent element
        List<WebElement> selectElementsSelectCategory = parentElementSelectCategory.findElements(By.xpath(".//*"));

        // Print the number of <select> elements found
        System.out.println("Number of <select>1 elements found: " + selectElementsSelectCategory.size());

        // Print information about each <select> element
        for (WebElement selectElement1 : selectElementsSelectCategory) {
            System.out.println("Select1 element text: " + selectElement1.getText());
            System.out.println("Select1 element tag name: " + selectElement1.getTagName());
            // Add more actions or assertions as needed
        }
        
        Actions actions = new Actions(driver);
        // Perform key down action 20 times
        for (int i = 0; i < 20; i++) {
            actions.keyDown(parentElementSelectCategory, Keys.ARROW_DOWN).perform();
        }
        parentElementSelectCategory.sendKeys(Keys.ENTER);
        */
        
        //Ovo je drugi nacin, da se direktno unese u input polje//
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        /*WebElement poljeZaUpis = driver.findElement(By.xpath("//*[@id=\"react-select-categoryId-input\"]"));
        poljeZaUpis.sendKeys("Odeća | Ženska");
        Thread.sleep(2000);
        poljeZaUpis.sendKeys(Keys.ENTER); 
        */
        
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
        					  
        WebElement sel = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[3]/span/div[1]/div/section/div/div[1]/div[2]"));
        sel.click();
        Thread.sleep(2000);
                
        WebElement poljeKaoNovo = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[3]/span/div[1]/div/section/div/div[2]/div/div[2]"));
        poljeKaoNovo.click();
        Thread.sleep(2000);///ovo radiii i super selektuje prvi element
        WebElement poljeNovo1= driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[3]/span/div[1]/div/section/div/div[2]/div"));
        poljeNovo1.click();
        Thread.sleep(2000);///ovo super radi i detektuje drugi trazeni element za selekciju
        
        /////////////////////////////dodato za trazenje child elemenata za select////////////////////////////////////////////////////
        WebElement parentElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[1]/div[3]/span/div[1]/div/section/div/div[2]"));

        // Find all <select> elements under the parent element
        List<WebElement> selectElements = parentElement.findElements(By.xpath(".//*"));

        // Print the number of <select> elements found
        System.out.println("Number of <select> elements found: " + selectElements.size());

        // Print information about each <select> element
        for (WebElement selectElement : selectElements) {
            System.out.println("Select element text: " + selectElement.getText());
            System.out.println("Select element tag name: " + selectElement.getTagName());
            // Add more actions or assertions as needed
        } 
        
        WebElement buttonFinalElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[2]/form/section/div/div[2]/div/div/div[2]/button[2]")); // 
        buttonFinalElement.click();
        
        Thread.sleep(5000);
        
        WebElement spanElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/div[2]/div[1]/div/div/span/div/span")); 
        String spanText = spanElement.getText();

        		// Extracting numbers from the text
        String numberStr = spanText.replaceAll("[^0-9]", "");
        int number = Integer.parseInt(numberStr);

        if (number > 1000) {
        	System.out.println("Number is higher than 1000. Test passed!");
        } else {
        	System.out.println("Number is not higher than 1000. Test failed!");
        }
    }
    
    public static void testAddToAddressBook(WebDriver driver) throws InterruptedException {
    	
    	driver.get("https://www.kupujemprodajem.com/odeca-zenska/bluze/zara-bluza/oglas/164403795?filterId=4361893340");
    	
    	WebElement dugmeAdresar = driver.findElement(By.className("ButtonTertiary_tertiary__eFrSO"));//ovde sam koristio className jer je potpuno isto na svim prikazima , ne zavisi od oglasa
    	
    	dugmeAdresar.click();
    	
    	Thread.sleep(1000);
    			//  html body div#__next div.ThreeColumnLayout_height__rXiFH.Grid_container-fluid__7Vrd5 div.ThreeColumnLayout_content__eTm7W div.Grid_container__u65Ag div.Grid_row__pl8x2 div.Grid_col-lg-10__FPLVk.Grid_col-xs__w58_v.Grid_col-sm__DsLxt.Grid_col-md__eg0dB section.Box_box__CCDqC.AdPage_adInfoBox__oxywY div.AdPage_adInfoHolder__wCKs4.AdPage_hasBorder__x5yTs section.UserSummary_userSummaryHolder__yvKCv div.UserSummary_userSummary__xaVWq div.UserSummary_userInfoActions__QLJ8Z button.Button_base__G3HTK.Button_small__32ZFH.ButtonTertiary_tertiary__eFrSO.ButtonTertiary_small__UAJjb
    	
    	WebElement emailForm = driver.findElement(By.id("email"));
    	emailForm.sendKeys("aleksandartasic2810@gmail.com");
    	Thread.sleep(1000);
    	
    	WebElement passwordForm = driver.findElement(By.id("password"));
    	passwordForm.sendKeys("sifra");
    	Thread.sleep(1000);
 
    }
}
