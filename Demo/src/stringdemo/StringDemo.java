package stringdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDemo {
public static void main(String[] args) {
	boolean b=StringDemo.checkForSpecialCharacters("!");
	if(b)
		System.out.println("There is a special character in my string");
	
}
/**
 * This method checks for SpecialCharacters and returns true if special characters found.
 * @param value
 * @return
 */
public static boolean checkForSpecialCharacters(String value)
{
	try {
	Pattern p=Pattern.compile("[^a-zA-Z0-9]");
	Matcher m=p.matcher(value);
	return m.find();
	}catch (NullPointerException e) {
	return false;
	}
}
}
