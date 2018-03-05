package tess4j;

import java.awt.Rectangle;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.Word;
import net.sourceforge.tess4j.util.LoadLibs;

public class Example {
	public static void main(String[] args) {

		long time_start = System.currentTimeMillis();

		File imageFile = new File("D://000003.pdf");

		ITesseract instance = new Tesseract();

		File tessDataFolder = LoadLibs.extractTessResources("tessdata");

		instance.setDatapath(tessDataFolder.getParent());
		instance.setLanguage("chi_sim");

		try {
			String result = instance.doOCR(imageFile);
			
			
			System.out.println(result);
			// Pattern CRLF = Pattern.compile("(\r\n|\r|\n|\n\r)");
			// Matcher m = CRLF.matcher(result);
			// if (m.find()) {
			// result = m.replaceAll("<br>");
			// }
			// String[] split = result.split("<br>");
			// for (String string : split) {
			// if (string != null && !"".equals(string))
			// System.out.println(string);
			// }
			//
			// System.out.println(result);

			long time_end = System.currentTimeMillis();
			long time = time_end - time_start;
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("识别用时：" + time / 1000.0f + "s");

		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}
	}
}
