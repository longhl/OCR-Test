package tess4j;
import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

/**
 * tesseract for java�� ocr��Optical Character Recognition����ѧ�ַ�ʶ��
 * ������
 * @author wind
 */
public class Tess4jUtils {
    /**
     * ��ͼƬ����ȡ����,Ĭ������Ӣ���ֿ�,ʹ��classpathĿ¼�µ�ѵ����
     * @param path
     * @return
     */
    public static String readChar(String path){
        // JNA Interface Mapping
        ITesseract instance = new Tesseract();
        // JNA Direct Mapping
        // ITesseract instance = new Tesseract1();
        File imageFile = new File(path);
        //In case you don't have your own tessdata, let it also be extracted for you
        //��������ʹ��classpathĿ¼�µ�ѵ������
        File tessDataFolder = LoadLibs.extractTessResources("tessdata");
        //Set the tessdata path
        instance.setDatapath(tessDataFolder.getAbsolutePath());
        //Ӣ�Ŀ�ʶ�����ֱȽ�׼ȷ
        instance.setLanguage("chi_sim");
        return getOCRText(instance, imageFile);
    }

    /**
     * ��ͼƬ����ȡ����
     * @param path ͼƬ·��
     * @param dataPath ѵ����·��
     * @param language �����ֿ�
     * @return
     */
    public static String readChar(String path, String dataPath, String language){
        File imageFile = new File(path);
        ITesseract instance = new Tesseract();
        instance.setDatapath(dataPath);
        //Ӣ�Ŀ�ʶ�����ֱȽ�׼ȷ
        instance.setLanguage(language);
        return getOCRText(instance, imageFile);
    }

    /**
     * ʶ��ͼƬ�ļ��е�����
     * @param instance
     * @param imageFile
     * @return
     */
    private static String getOCRText(ITesseract instance, File imageFile){
        String result = null;
        try {
            result = instance.doOCR(imageFile);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return result;
    }

   /* public static void main(String[] args) {
        String path = "src/main/resources/image/text.png";
        System.out.println(readChar(path));

        String ch = "src/main/resources/image/ch.png";
        //System.out.println(readChar(ch, "src/main/resources", Const.CHI_SIM));
        System.out.println(readChar(ch, "src/main/resources", "chi_sim"));
    }*/
    
    
    public static void main(String[] args) {
        //File imageFile = new File("eurotext.tif");
        File imageFile = new File("a00001.pdf");
        ITesseract instance = new Tesseract();  // JNA Interface Mapping
        // ITesseract instance = new Tesseract1(); // JNA Direct Mapping

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
    

}
//ע��:���Ľ������׼ȷ����Ҫ�Լ�ѵ���ֿ�
//����ѵ���ֿ⣬�Լ������������Ʋ�https://github.com/followwwind/javautils
