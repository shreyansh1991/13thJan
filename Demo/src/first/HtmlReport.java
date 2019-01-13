package first;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class HtmlReport {
	public static void writeData() throws IOException {
		File file = new File("report1.html");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));

		String html = "<html><body><button name=\"button\" value=\"OK\" type=\"button\" onclick=\"hello()\">\"Click Here\"></button>"; 

		bw.write(html);
		bw.write("/body></html>");
		
		/*<!DOCTYPE>
		<html>  
		<body>  
		<button name="button" value="OK" type="button" onclick="hello()">Click Here</button>  
		<script>  
		function hello(){  
		alert("hello javatpoint user");  
		}  
		</script> */ 
		/*</body>
		</html> */ 

		

		
		
		/*bw.write("</table></h1>");*/
		bw.flush();
		bw.close();
	}
	public static void main(String[] args) throws IOException {
		writeData();
	}

}
