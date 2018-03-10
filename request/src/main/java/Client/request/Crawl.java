package Client.request;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Crawl {
	public static ChromeDriver driver;
	
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "/httprequest/request/src/chrome/chromedriver.exe");
		driver = new ChromeDriver();

		String productID = "K6561605,K6563602,K6552301,551624116,561544408,561542401,561544214,561543213,551634826B,551634807A,551511401,K6551501,K6543202,K6553503,K6543001,K6541303,K6542401,K6541401,K6552405,K6543402,571546724,571544408,K5652508,K5641102,K5644201,K6632406,K6611402,K5634310,K5614301,K5552307,K5542305,K5542104,K5544104,K5542105,571612249,561612310,561612304,551619606,561539618,561539631,561534701,571612246,571612237,561543203,581636801,571633309,581616811,561534625,561539623,561613401,561639105,561639101,561633315,571536704,551543212,551543405,K5515302,561632403,551549710,551549211,551549224,K6653109,K6643106,581626804,571626706";
		String[] productIDarr = productID.split(",");
		
		int flag = 0;
		for (int i = 0; i < productIDarr.length; i++) {
			if(flag < 10){
				getImageFromTaobao(productIDarr[i]);
				flag++;
			}else{
				try {
					System.out.println("Sleep... 60s");
					Thread.sleep(TimeUnit.SECONDS.toMillis(30));
					flag = 0;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
			
		/*Crawl product image on Tmall site*/
//		String productID = "K5651606";
//		String[] productIDarr = productID.split(",");
//		
//		int flag = 0;
//		for (int i = 0; i < productIDarr.length; i++) {
//			if(flag < 10){
//				getImageFromTmall(productIDarr[i]);
//				flag++;
//			}else{
//				try {
//					System.out.println("Sleep... 60s");
//					Thread.sleep(TimeUnit.SECONDS.toMillis(60));
//					flag = 0;
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}/*End Crawl product image on Tmall site*/
		
//		/*Crawl product detail on JD site*/
//		String productID = "K6614101,K6624304,K7624026,K6552504,K6543208,K5552106,K5551504,K5512401";
//		String[] productIDarr = productID.split(",");
//		
//		int flag = 0;
//		for (int i = 0; i < productIDarr.length; i++) {
//			if(flag < 10){
//				crawlImageJDSite(productIDarr[i]);
//				flag++;
//			}else{
//				try {
//					System.out.println("Sleep... 60s");
//					Thread.sleep(TimeUnit.SECONDS.toMillis(60));
//					flag = 0;
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}/*End Crawl product detail*/
		
		/*Crawl product detail*/
//		String productID = "K6622107,K6622105,K6634905,K6632406,K6632405,K6612103,K6611402,K5634406,K5634310,K5634114,K5632406,K5632115,K5614203,K5614301,K5552307,K5562506,K5542305,K5542210,K5542104,K5544104,K5542105,K5515101,K5515302,K5512304,K5515202,K6653109,K6643316,K6643206,K6643204,K6643106,K6621307,K6621304,K6621303,K6621107";
//		String[] productIDarr = productID.split(",");
//
//		int flag = 0;
//		
//		for (int i = 0; i < productIDarr.length; i++) {
//			if(flag < 5){
//				getProductDetail(productIDarr[i]);
//				flag++;
//			}else{
//				try {
//					System.out.println("Sleep... 60s");
//					Thread.sleep(TimeUnit.SECONDS.toMillis(60));
//					flag = 0;
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		/*End Crawl product detail*/
		
		/* Crawl photo for each product on paixie*/
//		String productID = "K5651606,K5644204,551637907,551637603,551637601,551639640,551637906,551539616,551531401,551531606,551539623,581543305,581546649,551611902,551613304,551611617,551613402,551633308,K5614401,K5614303,K5622404,561633610,551534401,551534307,551534122,551539603,551637704,551637604,K8611032,K8611012,551612701,551619303,551619121,551539631,551612705,551614624,K5552404,551637908,551637703,551637602,561512703,551613310,581536627,581536605,581536712,561612703,K6614402,K6614401,K6614303,K6612302,K6612207,K6612206,K6612204,K7645003,K7645001,K7643002,K7642001,K7655011,K7653005,K7651063,571542204,571542238,K8645005,K8641026,571616815,571615502,571611103,571612205,K7553021,561534405,561539713,561534624,571636737,571636801,561614322,K7615003,K7615001,K7613028,K7613008,K5612206,K5612102,K5611402,K5611203,561613402,561634810A,K5641301,K5614205,K5614102,K5614101,K5612401,581616806,581612246,581613313,581622244,581546618,581542219,561619303,551534804A,551534403,551533307,551531902AB,551534106,551614322,K6514205,K6514401,K6513401,571616806,551619804A,581616609,551629807B,551549601,K5541303,K5541702,K5562310,K5551107,K5562605,K5544307,K5564603,K5541204,K5551306,K5551404,K5511205,K5512104,561544823B,561549229,571635514,551544405,551549225,551544401,551541404,551544402,551544228,551637902,551612803A,551614129,581632240,581636732,551533607,551637903,551637701,551637702,K8613012,K8563037,K5541108,K5561603,K5552504,K5554405,K5551501,K5564311,K5552508,K5564604,K5561309,K5552302,K5554302,K5554607,K5561602,K5554502,K5551504,551541209,551549204,551544213,561634101,561634402,561613305,561614110,K6611204,K6611115,K6611202,K6614101,K6541104,K6561309,K6552601,K6561310,K6553405,K6543304,K6551403,561614821A,561619613,561629178,K6513208,571536707,K7647003,K7647002,551637103,551639615,561634830A,K6515101,K6515201,K6525112,K6543106,K6553104,K6542102,K6541101,K6542206,K6543101,K6541103,K6553502,K6541202,K6552504,K6562602,K6553501,K6542202,K6541302,K6563601,K6561605,K6563602,K6552301,551624116,561544408,561542401,561544214,561543213,551634826B,551634807A,551511401,K6551501,K6543202,K6553503,K6543001,K6541303,K6542401,K6541401,K6552405,K6543402,571546724,571544408,K5652508,K5641102,K5644201,K6632406,K6611402,K5634310,K5614301,K5552307,K5542305,K5542104,K5544104,K5542105,571612249,561612310,561612304,551619606,561539618,561539631,561534701,571612246,571612237,561543203,581636801,571633309,581616811,561534625,561539623,561613401,561639105,561639101,561633315,571536704,551543212,551543405,K5515302,561632403,551549710,551549211,551549224,K6653109,K6643106,581626804,571626706";
//		String[] productIDarr = productID.split(",");
//
//		int flag = 0;
//		
//		for (int i = 0; i < productIDarr.length; i++) {
//			if(flag <10){
//				crawlImage(productIDarr[i]);
//				flag++;
//			}else{
//				try {
//					System.out.println("Sleep... 30s");
//					Thread.sleep(TimeUnit.SECONDS.toMillis(30));
//					flag = 0;
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		/* End Crawl photo for each product*/

		/* Crawl photo decscription on OKbuy site */
//		String productID = "K5621001,K5642302,K5642205,K5642202,K5641304,K5641301,K5641206,K5641203,K5611103,K5614205,K5614102,K5614101,K5612401,K5612304,K7524006,K6524112,K6524110,K6523903,K6514205,K6514401,K6513401,K6643104,K6641203,K5542702,K5541303,K5552106,K5541105,K5552001,K5541702,K5562310,K5542204,K5551107,K5562605,K5544307,K5564603,K5541204,K5551306,K5551404,K5512207,K5512101,K5511103,K5511102,K5512203,K5511305,K5512103,K5511205,K5522107,K5512104,K5521112,K8634048,K8624046,K8623024,K8613012,K8563037,K8543016,K8551039,K8553041,K5541108,K5561603,K5552504,K5542202,K5554405,K5551501,K5564311,K5544106,K5552508,K5564604,K5561309,K5552302,K5542301,K5544208,K5541101,K5554608,K5544203,K5554302,K5554607,K5551302,K5544102,K5541202,K5561602,K5554502,K5551504,K5544202,K6611204,K6611115,K6611101,K6611202,K6611301,K6612301,K6614101,K6541104,K6561309,K6552601,K6561310,K6553405,K6543304,K6551403,K6513302,K6513101,K6523113,K6523107,K6514101,K6513208,K6513201,K6524109,K6514203,K6525106,K6515402,K6513103,K6533117,K6534806,K5535119,K5511402,K5512401,K5515204,K5512402,K7647003,K7647002,K7621057,K7621044,K7621019,K7634043,K7634031,K7634012,K7625021,K7613007,K7566008,K7566009,K6514103,K6524113,K6515105,K6515101,K6515201,K6525112,K6514304,K6524108,K6551507,K6543106,K6553104,K6542102,K6541101,K6561601,K6542206,K6552105,K6543101,K6541103,K6553502,K6543701,K6541202,K6552504,K6551106,K6562602,K6542201,K6552503,K6542302,K6562603,K6553501,K6542202,K6541302,K6563601,K6561605,K6543208,K6563602,K6552301,551634807A,K6551501,K6543202,K6553302,K6543105,K6553503,K6543001,K6541303,K6542401,K6541401,K6552405,K6543402,K6524319,K5652508,K5641202,K5641102,K5644201,K6622107,K6622105,K6634905,K6632406,K6632405,K6612103,K6611402,K5634406,K5634310,K5634114,K5632406,K5632115,K5614203,K5614301,K5552307,K5562506,K5542305,K5542210,K5542104,K5544104,K5542105,K5515101,K5515302,K5512304,K5515202,K6653109,K6643316,K6643206,K6643204,K6643106,K6621307,K6621304,K6621303,K6621107";
//		String[] productIDarr = productID.split(",");
//
//		for (int i = 0; i < productIDarr.length; i++) {
//			crawlDes(productIDarr[i]);
//		}
		/* End Crawl photo decscription on OKbuy site */
	  
	  
		/* Crawl Product Name on OKBuy site */
//		String productID = "K8551022,K5651606,K5644311,K5644205,K5644204,551639612,551637907,551639640,551637906,551539616,551531401,551531606,581546649,551613402,551637907,K5614401,K5614303,K5614302,K5624801,K5624308,K5624109,K5624108,K5622404,K5622308,K5622307,K5622306,K5622111,K5622107,561633610,551534401,551534307,551534122,551637704,551637604,K8623023,K8613043,K8611061,K8611043,K8611032,K8611012,551612701,551619121,551621901,551534805A,551532704,551534601,551539607,551539310,551531603,551533408,551532703,551534605,551539712,551539631,551534801A,551534607,551534603,551612705,K5552502,K5542402,K5552404,K5515103,K5512201,K5511210,551634105,551637908,551637901,551637703,551637602,551639612,551637604,561512703,551613310,581536605,581536712,561612703,K6614402,K6614401,K6614303,K6614205,K6614203,K6612302,K6612207,K6612206,K6612204,K6624306,K6624304,K6624112,K6624104,K6622901,K6622116,K6622111,K7645003,K7645001,K7643004,K7643002,K7643001,K7642003,K7642001,K7641059,K7641008,K7641005,K7641002,K7641001,K7655011,K7653005,K7651063,571541119,571542241,571542220,571542215,571546649,571542204,571544421,571543317,571541112,571542228,571541101,571544402,571542238,571544422,571543316,571542213,571546727,K8641017,K8641014,K8641013,K8645005,K8643008,K8643007,K8641026,571616815,571611103,K7545019,K7551035,K7551018,K7553021,561534405,561539713,571636737,571636801,571636801,K7615003,K7615001,K7613028,K7613008,K7611042,K7611007,K7611006,K7625009,K7624026,K7624025,K7624001,K7623021,K7623019,K5612303,K5612302,K5612206,K5612203,K5612201,K5612102,K5612101,K5611402,K5611303,K5611302,K5611205,K5611203,K5622105,K5622104,K5622103,K5621802,K5621403,K5621308,K5621305,K5621304,K5621108,K5621107,K5621105,K5621104,K5621001,561613402,K5642302,K5642205,K5642202,K5641304,K5641301,K5641206,K5641203,K5611103,K5614205,K5614102,K5614101,K5612401,K5612304,551613310,581616627,581616806,581613313,581546618,581546713,581542219,561619303,551539615,551534403,551533307,551531902AB,551534106,551534406,K7524006,551614322,K6524112,K6524110,K6523903,K6514205,K6514401,K6513401,571616815,571616806,551613402,581616609,K6643104,K6641203,551549601,K5542702,K5541303,K5552106,K5541105,K5552001,K5541702,K5562310,K5542204,K5551107,K5562605,K5544307,K5564603,K5541204,K5551306,K5551404,551511404,K5512207,K5512101,K5511103,K5511102,K5512203,K5511305,K5512103,K5511205,K5522107,K5512104,K5521112,561544220,561544823B,551544405,551544804B,551549225,551544401,551541404,551544604,551544402,551544228,551637906,551637704,551637908,551637907,551637902,581632240,581636732,581636732,551639640,551637903,551637902,551637701,551637702,K8634048,K8624046,K8623024,K8613012,K8563037,K8543016,K8551039,K8553041,K5541108,K5561603,K5552504,K5542202,K5554405,K5551501,K5564311,K5544106,K5552508,K5564604,K5561309,K5552302,K5542301,K5544208,K5541101,K5554608,K5544203,K5554302,K5554607,K5551302,K5544102,K5541202,K5561602,K5554502,K5551504,K5544202,551541209,551549204,551544213,561634402,561614110,K6611204,K6611115,K6611101,K6611202,K6611301,K6612301,K6614101,K6541104,K6561309,K6552601,K6561310,K6553405,K6543304,K6551403,561614110,K6513302,K6513101,K6523113,K6523107,K6514101,K6513208,K6513201,K6524109,K6514203,K6525106,K6515402,K6513103,K6533117,K6534806,551514402,571536707,571536701,K5535119,K5511402,K5512401,K5515204,K5512402,551637906,581516802,K7647003,K7647002,551637703,551637103,551639615,551637604,551637103,571636737,571636610,571633309,K7621057,K7621044,K7621019,K7634043,K7634031,K7634012,K7625021,K7613007,K7566008,K7566009,K6514103,K6524113,K6515105,K6515101,K6515201,K6525112,K6514304,K6524108,K6551507,K6543106,K6553104,K6542102,K6541101,K6561601,K6542206,K6552105,K6543101,K6541103,K6553502,K6543701,K6541202,K6552504,K6551106,K6562602,K6542201,K6552503,K6542302,K6562603,K6553501,K6542202,K6541302,K6563601,K6561605,K6543208,K6563602,K6552301,581616806,581622207,581622207,551624116,561544408,561542401,561544214,561543213,551519605,551511610,551637908,551634826B,551637903,551637701,551637602,551511401,K6551501,K6543202,K6553302,K6543105,K6553503,K6543001,K6541303,K6542401,K6541401,K6552405,K6543402,K6524319,571546724,571544408,K5652508,K5641202,K5641102,K5644201,K6622107,K6622105,K6634905,K6632406,K6632405,K6612103,K6611402,K5634406,K5634310,K5634114,K5632406,K5632115,K5614203,K5614301,K5552307,K5562506,K5542305,K5542210,K5542104,K5544104,K5542105,551639615,551637702,551637703,551634826B,561612310,561539618,561539631,561534701,551637906,551637908,571611103,561543203,581632240,581636801,581632232,581636801,571633309,571631111,571631111,571636610,581613313,571624405,581616811,581616811,581622207,581616609,551637602,561534625,561613401,561639105,561633315,571612230,571622247,571616806,571536802,551543212,551543405,K5515101,K5515302,K5512304,K5515202,561633610,561632403,551549710,551549211,551549224,561514402,581542234,K6653109,K6643316,K6643206,K6643204,K6643106,K6621307,K6621304,K6621303,K6621107,K6621105,581616811,571616806,571626706";
//		String[] productIDarr = productID.split(",");
//
//		for (int i = 0; i < productIDarr.length; i++) {
//			String title = searching(productIDarr[i].trim());
//
//			if (title != "not found") {
//				title = cleanColor(title);
//				writeTxt(productIDarr[i], title);
//			}
//		}
		/* End Crawl Product Name on OKBuy site */
		
		System.out.println("Done!");
	}
	
	// Crawl image on Taobao.com
	public static void getImageFromTaobao(String productID) {
		String url = "https://world.taobao.com/";
		driver.get(url);

		WebElement searbBox = driver.findElement(By.xpath(".//*[@id='q']"));
		searbBox.sendKeys(productID);
		searbBox.sendKeys(Keys.RETURN);
		
		String notFound = "sorry,沒有找到与“" + productID;
		System.out.println("Not found: " + notFound);
		
		if (driver.getPageSource().contains("//img.alicdn.com/tps/i2/TB1C1VFFVXXXXahXVXXDUUqNpXX-819-456.png")) {
			System.out.println("not found " + productID);
		} else {
			String folderName = "G:/node/data/img/" + productID;
			createFolder(folderName);

			System.out.println("Created " + folderName);

			List<WebElement> listProduc = driver.findElements(By.xpath(".//*[@id='list-itemList']//a"));
			System.out.println("URL: " + listProduc.get(0).getAttribute("href"));
			driver.get(listProduc.get(0).getAttribute("href"));

			String xpath = ".//*[@id='J_SKU']/dl[2]/dd/ul/li/a";
			if(productID.startsWith("K")){
				xpath = ".//*[@id='J_SKU']/dl[1]/dd/ul/li/a";
			}
			
			List<WebElement> listColor = driver.findElements(By.xpath(xpath));
			String tempColorName = "unknown";

			for (int i = 0; i < listColor.size(); i++) {
				System.out.println("Going to get color image");
				tempColorName = listColor.get(i).getAttribute("title").toString().trim().replace("/", "");
				System.out.println("Color name: " + tempColorName);
				
				String imgUrl = listColor.get(i).getAttribute("style").trim();
				System.out.println("Color URL: " + imgUrl);
				
				if(!imgUrl.isEmpty()){
					imgUrl = imgUrl.split("\"")[1];
					imgUrl = imgUrl.replace("30x30.jpg", "600x600.jpg");
					System.out.println("Color name: " + imgUrl);

					try {
						saveImage("http:" + imgUrl, folderName + "/" + productID + tempColorName + "-1.jpg");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			List<WebElement> listImage = driver.findElements(By.xpath(".//*[@id='J_ThumbNav']//img"));
			
			System.out.println("size: " + listImage.size());
			
			for (int j = 0; j < listImage.size(); j++) {
				System.out.println("Going to get color image..." + j);
				String imgUrl = listImage.get(j).getAttribute("src");
				System.out.println("imgUrl: " + imgUrl);
				imgUrl = imgUrl.replace("70x70.jpg", "600x600.jpg");

				try {
					saveImage(imgUrl, folderName + "/" + productID + tempColorName + "-" + (j + 2) + ".jpg");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			// Get details
			List<WebElement> detail = driver.findElements(By.xpath(".//*[@id='attributes']//li"));
			StringBuilder sDetail = new StringBuilder();
			
			for(int x =0; x<detail.size(); x++){
				sDetail.append("<div>" + detail.get(x).getText() + "</div>");
				sDetail.append(System.getProperty("line.separator"));
			}
			
			writeTxt(folderName + "/" + productID + "-desc.txt", sDetail.toString());
			
			//Roll page
			for(int r =0; r<5; r++){
				rollPage();
			}
			
			// Get photo description
			List<WebElement> photoDetail = driver.findElements(By.xpath(".//*[@id='J_DivItemDesc']/p/img"));
			int photoIndex = 1;
			String subname = "01";
			for (int k = 0; k < photoDetail.size(); k++) {
				
				if(photoDetail.get(k).getAttribute("src").contains(".jpg")){
					if(photoIndex <10)
						subname = "0" + photoIndex;
					else
						subname = photoIndex + "";
					
					try {
						saveImage(photoDetail.get(k).getAttribute("src"), folderName + "/" + productID + "_" + subname + ".jpg");
						photoIndex++;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	// Crawl image on Tmall.com
	public static void getImageFromTmall(String productID) {
		String url = "https://list.tmall.com/search_product.htm?q=" + productID
				+ "&type=p&spm=a220m.1000858.a2227oh.d100&from=.list.pc_1_searchbutton";
		driver.get(url);

		if (driver.getPageSource().contains("喵~没找到与")) {
			System.out.println("not found " + productID);
		} else {
			WebElement fItem = driver.findElement(By.xpath(".//*[@id='J_ItemList']//a"));
			String sItem = fItem.getAttribute("href");
			driver.get(sItem);

			String folerName = "G:/node/data/img/" + productID;
			createFolder(folerName);

			List<WebElement> colorArr = driver.findElements(By.xpath(".//*[@id='J_DetailMeta']/div[1]/div[1]/div/div[4]/div/div/dl[1]/dd/ul//li"));

			for (int x =0; x <colorArr.size(); x ++){
				if(colorArr.get(x).getAttribute("class").toString().trim() == "tb-selected"){
					// get color name and photos
					String colorName = colorArr.get(x).getAttribute("title").toString().trim();
					getImageColor(folerName, productID, colorName);
				}else{
					String imgUrl = colorArr.get(x).getAttribute("style").toString().trim();
					imgUrl = imgUrl.split(")")[0];
					imgUrl = imgUrl.split("(")[1];
					imgUrl = imgUrl.replace("40x40q90.jpg", "600x600q90.jpg");
					
					String colorName = colorArr.get(x).getAttribute("title").toString().trim();
					
					try {
						saveImage(imgUrl, folerName + "/" + productID + colorName + "-1.jpg");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("Color i: " + colorArr.size());
		}
	}
	
	// Get image for earch color on Tmall
	public static void getImageColor(String folderName, String productID, String colorName) {
		List<WebElement> photoColorArr = driver.findElements(By.xpath(".//*[@id='J_UlThumb']//a/img"));
		System.out.println("Size: " + photoColorArr.size());

		for (int j = 0; j < photoColorArr.size(); j++) {
			System.out.println("j: " + j);

			String imgUrl = photoColorArr.get(j).getAttribute("src").replaceAll("60x60q90.jpg", "600x600q90.jpg");
			String imgName = productID + colorName + "-" + (j + 1) + ".jpg";

			try {
				saveImage(imgUrl, folderName + "/" + imgName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Crawl product description
	public static void getProductDetail(String productID) {
		String url = "http://search.jd.com/Search?keyword=" + productID + "&enc=utf-8&wq=K6552301&pvid=lcc9kvsi.wf6vsn";
		driver.get(url);

		String productDetail;

		if (driver.getPageSource().contains("抱歉，没有找到与")) {
			productDetail = "not found";
		} else {
			WebElement fItem = driver.findElement(By.xpath(".//*[@id='J_goodsList']//a"));
			String sItem = fItem.getAttribute("href");
			driver.get(sItem);

			List<WebElement> titleArr = driver.findElements(By.xpath(".//*[@id='detail']//ul[2]/li"));
			StringBuilder detail = new StringBuilder();

			for (int i = 2; i < titleArr.size(); i++) {

				if (!titleArr.get(i).getText().trim().isEmpty()) {
					String createLine = "<div>" + titleArr.get(i).getText().trim() + "</div>";
					detail.append(createLine).append(System.getProperty("line.separator"));
				}
			}

			// Write txt file
			String fileName = "G:/node/data/product-detail/" + productID + "-desc.txt";
			writeTxt(fileName, detail.toString());
			System.out.println("write file " + productID + " successfully");
		}
	}
	
	// Crawl Product detail on jd.com site
	public static void crawlImageJDSite(String productID) {
		String url = "http://search.jd.com/Search?keyword=" + productID
				+ "&enc=utf-8&wq=jhgasdsaj&pvid=o8y4kzsi.wf6vsn";
		driver.get(url);

		if (driver.getPageSource().contains("抱歉，没有找到与")) {
			System.out.println("not found " + productID);
		} else {

			WebElement fItem = driver.findElement(By.xpath(".//*[@id='J_goodsList']//a"));
			String sItem = fItem.getAttribute("href");
			driver.get(sItem);

			String folerName = "G:/node/data/Des/" + productID;
			createFolder(folerName);

			// Get description
			List<WebElement> titleArr = driver.findElements(By.xpath(".//*[@id='detail']//ul[2]/li"));
			StringBuilder detail = new StringBuilder();

			for (int i = 2; i < titleArr.size(); i++) {

				if (!titleArr.get(i).getText().trim().isEmpty()) {
					String createLine = "<div>" + titleArr.get(i).getText().trim() + "</div>";
					detail.append(createLine).append(System.getProperty("line.separator"));
				}
			}

			// Write txt file
			String fileName = folerName + "/" + productID + "-desc.txt";
			writeTxt(fileName, detail.toString());
			System.out.println("write file " + productID + " successfully");

			// Get photo detail
			List<WebElement> photoDes = driver.findElements(By.xpath(".//*[@id='J-detail-content']//img"));
			int photoIndex = 1;
			int flag = 0;

			for (int i = 0; i < photoDes.size(); i++) {
				String imgUrl = photoDes.get(i).getAttribute("src");
				try {
					if (imgUrl.contains(".jpg")) {
						String imgIndex = photoIndex + "";

						if (photoIndex < 10)
							imgIndex = "0" + photoIndex;

						saveImage(imgUrl, folerName + "/" + productID + "_" + imgIndex + ".jpg");
						photoIndex++;
					} else if (imgUrl.contains(".gif") && flag < 3) {
						rollPage();
						i = i - 1;
						flag++;
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
		
	// Crawl image for each  product on Paixe.net site
	public static void crawlImage(String productID){
		String url = "http://www.paixie.net/forbid/p-_" + productID + "__1.html";
		driver.get(url);
		
		if(driver.getPageSource().contains("没有找到相关的商品哦")){
			System.out.println("not found " + productID);
		}
		else{
			WebElement fItem = driver.findElement(By.xpath(".//*[@class='probox']//a"));
			String sItem = fItem.getAttribute("href");
			driver.get(sItem);
			
			String folerName = "G:/node/data/img/" + productID;
			createFolder(folerName);
			
			List<WebElement> colorArr = driver.findElements(By.xpath(".//*[@id='js-good-color-list']//a"));
			
			System.out.println("Color i: " + colorArr.size());
			
			for (int i = 0; i < colorArr.size(); i++) {
				
				colorArr = driver.findElements(By.xpath(".//*[@id='js-good-color-list']//a"));
				
				System.out.println("i: "+ i);
				
				String colorText = "default";
				colorText = colorArr.get(i).getAttribute("title").replaceAll("/", "");
				
				colorArr.get(i).click();
				
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				List<WebElement> photoColorArr = driver.findElements(By.xpath(".//*[@id='js_imglist']//a"));
				
				System.out.println("Size: " + photoColorArr.size());
				
				for (int j = 0; j < photoColorArr.size(); j++) {
					
					System.out.println("j: " + j);
					
					String imgUrl = photoColorArr.get(j).getAttribute("href");
					String imgName = productID + colorText + "-" + (j + 1) + ".jpg";

					try {
						saveImage(imgUrl, folerName + "/" + imgName);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
			
		}
		
	}
	
	// Searching and crawl product name on OkBuy
	public static String searching(String productId) {
		String url = "http://www.okbuy.com/search?top_key=";
		driver.get(url + productId);
		
		String productName;
		
		if(driver.getPageSource().contains("很抱歉，没有找到与")){
			productName = "not found";
		}
		else{
			WebElement fItem = driver.findElement(By.xpath(".//*[@class='gl-name']//a"));
			String sItem = fItem.getAttribute("href");
			driver.get(sItem);
			
			WebElement title = driver.findElement(By.xpath(".//*[@class='prodAllName']"));
			productName = title.getText();
		}
		return productName;
	}
	
	// Crawl photo description on OKBuy
	public static void crawlDes(String productId){
		String url = "http://www.okbuy.com/search?top_key=";
		driver.get(url + productId);
		
		if(!driver.getPageSource().contains("很抱歉，没有找到与")){
			WebElement fItem = driver.findElement(By.xpath(".//*[@class='gl-name']//a"));
			String sItem = fItem.getAttribute("href");
			driver.get(sItem);
			 
			// Create folder
			File dir = new File("G:/node/data/Des/" + productId);
			dir.mkdir();
			System.out.println("Create success: " + productId);
			
			// Get Description
			List<WebElement> photoDes = driver.findElements(By.xpath(".//*[@class='MulPicH750']//img"));
			int photoIndex = 1;
			
			for (int i = 0; i < photoDes.size(); i++) {
				String imgUrl = photoDes.get(i).getAttribute("src");
				int flag = 0;
				try {
					if(imgUrl.contains(".jpg")){
						String imgIndex = photoIndex + "";
						
						if(photoIndex < 10)
							imgIndex = "0" + photoIndex;
						
						saveImage(imgUrl, dir + "/" + productId + "_" + imgIndex + ".jpg");
						photoIndex++;
					}
					else if (imgUrl.contains(".gif")){
						for(int j=0; j<5; j++){
							rollPage();
						}
						i = i-1;
					}
						
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else
			System.out.println("Could not find out " + productId);
	}
	
	public static void createFolder(String folderName){
		File dir = new File(folderName);
		dir.mkdir();
		System.out.println("Create success: " + folderName);
	}
	
	public static void rollPage() {
		Actions actions = new Actions(driver);
		for (int i = 0; i < 5; i++) {
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();
			try {
				Thread.sleep(TimeUnit.SECONDS.toMillis(2));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

		for (int i = 0; i < 5; i++) {
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.UP).perform();
			try {
				Thread.sleep(TimeUnit.SECONDS.toMillis(2));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		actions.keyUp(Keys.CONTROL).sendKeys(Keys.HOME).perform();
	}
	
	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);

		System.out.println("URL: " + imageUrl);
		System.out.println("Local: " + destinationFile);

		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
		is.close();
		os.close();
	}
	
	public static void writeTxt(String fileName, String content) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(fileName, "UTF-8");
			writer.println(content);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static String cleanColor(String title){
		int index = 0;
		String subTitle = title;
		char[] cTitle = title.toCharArray();
		
		for (int i = title.length(); i > 0; i--) {
			if (Character.isDigit(cTitle[i - 1])) {
				index = i;
				break;
			}
		}
		
		if(index != 0)
			subTitle = title.substring(0, index);
		
		return subTitle;
	}
}
