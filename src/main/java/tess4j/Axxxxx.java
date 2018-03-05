package tess4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Axxxxx {
	public static String sss(String myString) {
		String newString = null;
		Pattern CRLF = Pattern.compile("(\r\n|\r|\n|\n\r)");
		Matcher m = CRLF.matcher(myString);
		if (m.find()) {
			newString = m.replaceAll("<br>");
		}
		return newString;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String aaa = "sdfsfdsfsdf\r\n,dsfsdfsdf\r\n";
		// aaa.replace("s", "x");
		String newStr = sss(aaa);
		
		System.out.println(aaa);
		System.out.println(newStr);
	}
}
