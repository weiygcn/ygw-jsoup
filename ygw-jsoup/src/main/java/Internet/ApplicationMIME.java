package Internet;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


/**
 * Created by weiyg on 2017/9/28.
 */
public class ApplicationMIME {
    public static void main(String[] args)throws UnsupportedEncodingException{
        String keyWord = URLEncoder.encode("杨广伟","GBK");
        System.out.println("杨广伟中文转换MIME格式后为："+keyWord);
        String str = URLDecoder.decode("%D1%EE%B9%E3%CE%B0","GBK");
        System.out.println("%D1%EE%B9%E3%CE%B0 反转后字符库为："+str);

    }
}
