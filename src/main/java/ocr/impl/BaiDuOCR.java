package ocr.impl;

import com.baidu.aip.ocr.AipOcr;
import ocr.OCR;
import org.json.JSONObject;

import java.io.File;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by 618 on 2018/1/12.
 * @author lingfengsan
 */
public class BaiDuOCR implements OCR{
    //设置APPID/AK/SK
    private static final String APP_ID = "10695538";
    private static final String API_KEY = "W5Rw1xh7xsfmYARLHWFX2Gkz";
    private static final String SECRET_KEY = "6Tvl6i5clMGS5PP1bSWQ0tO85qLpx8I6";
    private static final AipOcr CLIENT=new AipOcr(APP_ID, API_KEY, SECRET_KEY);
    BaiDuOCR(){
        // 可选：设置网络连接参数
        CLIENT.setConnectionTimeoutInMillis(2000);
        CLIENT.setSocketTimeoutInMillis(60000);
        System.out.println("欢迎您使用百度OCR进行文字识别");
    }
    @Override
    public String getOCR(File file) {
        Long start=System.currentTimeMillis();
        String path=file.getAbsolutePath();
        // 调用接口
        JSONObject res = CLIENT.basicGeneral(path, new HashMap<String, String>());
        String result=res.toString(2);
        System.out.println((System.currentTimeMillis())-start);
        return result;
    }

    public static void main(String[] args) {
        OCR ocr=new BaiDuOCR();
        String path = "/Users/bkc/IdeaProjects/MillionHero/WechatIMG260.jpeg";
        long beforeTime = new Date().getTime();
        String result=ocr.getOCR(new File(path));
        long after = new Date().getTime();
        System.out.println(result + " " + (after - beforeTime));
    }
}
