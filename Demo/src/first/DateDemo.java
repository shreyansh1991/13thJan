package first;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
public static void main(String[] args) {
	System.out.println("message sent successfully...."+"Time : " + new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date()));
}
}
