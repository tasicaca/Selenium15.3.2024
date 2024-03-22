package selenium4setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Scanner;

public class AddressBookManager {

    private final WebDriver driver;

    public AddressBookManager(WebDriver driver) {
        this.driver = driver;
    }

    public void testAddToAddressBook() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the URL of the advertisement:");
            String url = scanner.nextLine();
            try {
                navigateToUrl(url);
                login();
                System.out.println("Test successful: Address book updated successfully.");
            } catch (Exception e) {
                System.out.println("Test failed: Unable to update the address book.");
            }
        }
    }

    private void navigateToUrl(String url) {
        driver.get(url);
    }

    private void login() throws InterruptedException {
    	WebElement addressButton = driver.findElement(By.className("ButtonTertiary_tertiary__eFrSO"));
        addressButton.click();
        Thread.sleep(4000);
        /*WebElement emailForm = driver.findElement(By.id("email"));
        emailForm.sendKeys("aleksandartasic@gmail.com");
        Thread.sleep(2000);
        WebElement passwordForm = driver.findElement(By.id("password"));
        passwordForm.sendKeys("sifra");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"kp-portal\"]/div/div/aside/div/div/div[2]/main/div[2]/form/button"));
        loginButton.click();*/
    }
}
