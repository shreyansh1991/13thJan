package first;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class FirstClass {
	public static void generateReport() throws IOException
	{
	
		LinkedHashMap<String, Integer> passedCount = new LinkedHashMap<String, Integer>();
		LinkedHashMap<String, Integer> failedCount = new LinkedHashMap<String, Integer>();

		int count = 0;
		int passCount = 0;
		int failCount = 0;
		int total = 0;
		int percentage = 0;
		int failPercentage = 0;
		int totalPassedCount = 0;
		int totalFailedCount = 0;
		int scope = 0;
		int totalScope = 0;
		int totalRecords = 0;
		int totalPassedPercentage = 0;
		int totalFailPercentage = 0;

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "browser_exe" + File.separator + "chromedriver.exe");
	// These 3 Lines for headless mode.
		ChromeOptions options=new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options);
		
		

		driver.get(
				"http://preflightmanager.us.oracle.com/apex/f?p=121:14:1452664310989:5294701724953:NO::P14_DTE_ID,P14_RERUN_ID:42680056,1");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
System.out.println("application ready..");
		driver.findElement(By.id("sso_username")).sendKeys("shreyansh.jain@oracle.com");

		driver.findElement(By.id("ssopassword")).sendKeys(Encrypt.decryptPass("cGluQ29kZUAyNjEwMDE="));
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();

		WebElement table = driver.findElement(By.xpath("//table[@id='R53754391918480961']/following::table[1]"));

		/*
		 * WebElement tableHeader = driver.findElement(By.xpath(
		 * "//table[@id='R53754391918480961']/following::table[1]"));
		 * 
		 * List<WebElement> allHeaders = tableHeader.findElements(By.tagName("th"));
		 */
		/*
		 * for (int i = 1; i <= 3; i++) { System.out.print(allHeaders.get(i).getText() +
		 * "      "); }
		 */

		List<WebElement> allRows = table.findElements(By.tagName("tr"));

		for (int i = 0; i < allRows.size(); i++) {
			List<WebElement> allColumns = allRows.get(i).findElements(By.tagName("td"));

			if (allColumns.size() > 0) {

				for (int j = 0; j < 1; j++) {

					if (allColumns.get(0).getText().contains("FIN")) {
						++count;

						if (count == 1) {

							String temp = allColumns.get(1).getText();
							String tempArray[] = temp.split("_");

							if (!passedCount.containsKey(tempArray[2])) {
								passCount = Integer.parseInt(allColumns.get(2).getText());

								passedCount.put(tempArray[2], passCount);

								failCount = Integer.parseInt(allColumns.get(3).getText());
								failedCount.put(tempArray[2], failCount);

							} else {

								passCount = Integer.parseInt(allColumns.get(2).getText());
								passedCount.put(tempArray[2], passedCount.get(tempArray[2]) + passCount);

								failCount = Integer.parseInt(allColumns.get(3).getText());
								failedCount.put(tempArray[2], failedCount.get(tempArray[2]) + failCount);
							}
						} else if (count > 1) {

							String temp = allColumns.get(0).getText();

							String tempArray[] = temp.split("_");

							if (!passedCount.containsKey(tempArray[2])) {

								passCount = Integer.parseInt(allColumns.get(1).getText());
								passedCount.put(tempArray[2], passCount);
								failCount = Integer.parseInt(allColumns.get(2).getText());
								failedCount.put(tempArray[2], failCount);

							} else {

								passCount = Integer.parseInt(allColumns.get(1).getText());
								passedCount.put(tempArray[2], passedCount.get(tempArray[2]) + passCount);
								failCount = Integer.parseInt(allColumns.get(2).getText());
								failedCount.put(tempArray[2], failedCount.get(tempArray[2]) + failCount);

							}
						}

					}

				}

				System.out.println();
			}

		}

		File file = new File("report.html");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));

		String html = "<h1><table border=1   style=\"width:100%\">" + "" + "<th>" + "Automation Report" + "</th>";

		bw.write(html);

		String headers = "<tr>" + "<th>" + "Products" + "</th>" + "<th>" + "Scope" + "</th>" + "<th>" + "Passed"
				+ "</th>" + "<th>" + "Failed" + "</th>" + "<th>" + "Passed Percenatge" + "</th>" + "<th>"
				+ "Failed Percentage" + "</th></tr>";
		bw.write(headers);

		System.out.println("Passed Count - " + passedCount);
		Iterator<Map.Entry<String, Integer>> passedEntries = passedCount.entrySet().iterator();
		Iterator<Map.Entry<String, Integer>> failedEntries = failedCount.entrySet().iterator();
		while (passedEntries.hasNext()) {

			Map.Entry<String, Integer> mapEntries = passedEntries.next();
			Map.Entry<String, Integer> mapFailedEntries = failedEntries.next();

			totalPassedCount = totalPassedCount + mapEntries.getValue();
			totalFailedCount = totalFailedCount + mapFailedEntries.getValue();
			scope = mapEntries.getValue() + mapFailedEntries.getValue();
			totalScope = totalScope + scope;
			if (scope > 0) {
				++totalRecords;
				bw.write("<tr>" + "<td>" + mapEntries.getKey() + "</td>");
				bw.write("<td>" + scope + "</td>");
				bw.write("<td>" + mapEntries.getValue() + "</td>");
				bw.write("<td>" + mapFailedEntries.getValue() + "</td>");
			}

			total = mapEntries.getValue() + mapFailedEntries.getValue();
			if (total > 0) {
				percentage = (mapEntries.getValue() * 100 / total);
				failPercentage = (mapFailedEntries.getValue() * 100 / total);
				totalPassedPercentage = totalPassedPercentage + percentage;
				totalFailPercentage = totalFailPercentage + failPercentage;

				bw.write("<td>" + percentage + "</td>");
				bw.write("<td>" + failPercentage + "</td>");

				bw.write("</tr>");
			}

		}

		bw.write("<tr>" + "<td><b>" + "Total" + "</b></td>");
		bw.write("<td><b>" + totalScope + "</b></td>");
		bw.write("<td><b>" + totalPassedCount + "</b></td>");
		bw.write("<td><b>" + totalFailedCount + "</b></td>");

		bw.write("<td><b>" + totalPassedPercentage / totalRecords + "%" + "</b></td>");
		bw.write("<td><b>" + totalFailPercentage / totalRecords + "%" + "</b></td>");

		bw.write("</tr></table></h1>");
		bw.flush();
		bw.close();
		System.out.println("Report generated..");

	}
	public static void main(String[] args) throws IOException {
		generateReport();
		
	
	}
	/* function f1() {
         var cmpname=Packages.com.tdiinc.Employee.getcompanyName();
         var empObj = new Packages.com.tdiinc.Employee("George")
         var ename = empObj.getempName();
     }*/
}
