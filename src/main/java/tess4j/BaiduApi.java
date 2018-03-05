package tess4j;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

public class BaiduApi {
	// 设置APPID/AK/SK
	public static final String APP_ID = "10792949";// "你的 App ID";
	public static final String API_KEY = "Icf544WeE61e5MNtoklP8l5t";// "你的 Api Key";
	public static final String SECRET_KEY = "OX8xTtZskvwaPaLS1EP6iMVIqZvtAUTV";// "你的 Secret Key";

	public static void main(String[] args) {
		long time_start = System.currentTimeMillis();
		// 初始化一个AipOcr
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		// 可选：设置网络连接参数
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);

		// 传入可选参数调用接口
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("recognize_granularity", "big");
		options.put("detect_direction", "true");
		options.put("vertexes_location", "true");
		options.put("probability", "true");

		// 参数为本地图片路径
		String image = "D://longhl//邮箱附件//OCR材料//OCR材料 - 副本//表单//招商基金_modified.jpg";
		
		
		JSONObject res = client.accurateGeneral(image, options);
		
		//String templateSign = "e495d8c4178c53e6ad046658ca828126"; //票据模板id
		//JSONObject res = client.custom(image, templateSign, options); //模板识别
		
		JSONArray words_result = res.getJSONArray("words_result");

		int length = words_result.length();

		for (int i = 0; i < length; i++) {
			Map<String, Object> item = words_result.getJSONObject(i).toMap();
			String words = (String) item.get("words");
			System.out.println(i + ":" + words);
		}

		long time_end = System.currentTimeMillis();
		long time = time_end - time_start;
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("识别用时：" + time/1000.0f + "s");
		
		//System.out.println(res.toString(2));

	}


	
}
