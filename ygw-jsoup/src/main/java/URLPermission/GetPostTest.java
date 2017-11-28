package URLPermission;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by weiyg on 10/10/2017.
 */
public class GetPostTest {
    public static String sendGet(String url, String parm) {
        String result = "";
        String urlName = url + "?" + parm;
        try {
            URL realUrl = new URL(urlName);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozila/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
            conn.connect();
            Map<String, List<String>> map = conn.getHeaderFields();
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        return result;
    }

    public static String sendPost(String url, String parm) {
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozila/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");

            conn.setDoOutput(true);
            conn.setDoInput(true);

            PrintWriter out = new PrintWriter(conn.getOutputStream());
            out.print(parm);
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (Exception e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args){
        String s= GetPostTest.sendGet("http://www.baidu.com",null);
        System.out.println(s);
        String s1=GetPostTest.sendPost("http://www.baidu.com",null);
        System.out.println(s1);
    }
}
