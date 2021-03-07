import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.itextpdf.text.BadElementException;



public class Configuracion extends Img {

	String nombre = "prueba 1";
	static Img arc = new Img();
	public static int img = 0;

		 public static WebDriver driver;
		 
		public static WebDriver getDriver() {
			return driver;
		}

		public void setDriver(WebDriver driver) {
			this.driver = driver;
		}

		public void crearconfiguracion() throws InterruptedException, BadElementException 
		{
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			System.setProperty("webdriver.chrome.driver", "D:\\driverSelenium\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\driverChrome\\chromedriver.exe");
			setDriver(new ChromeDriver(capabilities)); //D:\Eclipse\chromedriver_win32 (1)
			
			//D:\\eclipse-antony\\chromedriver\\chromedriver.exe

			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			getDriver().get(URL.URL_CENTAURO);
			getDriver().manage().window().maximize();
			
			
			WebElement borravalor = driver.findElement(By.id("mat-input-0"));
			borravalor.clear();
			//username.sendKeys("200");
			Thread.sleep(1000);
			
			WebElement agregarvalor = driver.findElement(By.id("mat-input-0"));
			agregarvalor.sendKeys("20000");
			Thread.sleep(1000);
	
			//Img.getCapturaImagen("" + img++);
			
			WebElement clic = driver.findElement(By.xpath("_ngcontent-serverapp-c79"));
			Thread.sleep(100);
			clic.click();
			//_ngcontent-serverapp-c79
		}
}
