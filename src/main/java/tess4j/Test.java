package tess4j;

import java.io.File;

public class Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OCR ocr = new OCR();
		try {
			//String maybe = new OCR().recognizeText(new File("E://temp//222.jpg"), "jpg");
			String maybe = new OCR().recognizeText(new File("D://pic1.jpg"), "jpg");
			System.out.println(maybe);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}