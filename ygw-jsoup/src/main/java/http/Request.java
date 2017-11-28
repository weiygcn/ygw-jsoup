package http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fcibook.quick.http.QuickHttp;
import org.apache.http.entity.ContentType;
import java.util.HashMap;

/**
 * Created by weiyg on 21/11/2017.
 */
public class Request {
    public HashMap<String,Object> apiTest(String url, String body, String token, String uid) {
        Long startTime=System.currentTimeMillis();
        HashMap<String,Object> map =new HashMap<String, Object>();
        String res = new QuickHttp()
                .post()
                .url(url)
                .setBodyContent(body)
                .setContentType(ContentType.APPLICATION_JSON)
                .addHeader("x-cert-token", token)
                .addHeader("x-cert-uid", uid)
                .text();

//        System.out.println(res);
        //判断接口返回code是否为1 1表示请求接口成功
        try {
            JSONObject josn = JSON.parseObject(res);
            Object codeObj = josn.get("code");
            if (codeObj == null) {
                map.put("report","json返回code无值");
            } else {
                int code = (Integer) codeObj;
                if (code == 1) {
                    map.put("report","测试通过");
                } else {
                    map.put("report","测试失败");
                }
            }
        } catch (Exception e) {
            map.put("interfaceResp",res);
        } finally {
            Long sTime = System.currentTimeMillis() - startTime;
            map.put("interfaceResp",res);
            map.put("sTime",sTime);
            return map;
        }
    }
}
