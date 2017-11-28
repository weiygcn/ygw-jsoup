package Download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by weiyg on 2017/9/30.
 */
public class SingleDownload {


    public static void main(String args[]){
        final long startTime =System.currentTimeMillis();
        try{
            URL url = new URL("http://sw.bos.baidu.com/sw-search-sp/software/d4e97ccd4bd9f/jdk-8u144-windows-i586_8.0.1440.1.exe");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5 * 1000);
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "image/git,image/jpeg,image/pjpeg,image/pjpeg,"
                    + "application/x-shockwave-flash,application/xaml+xml,"
                    + "application/vnd.ms-xpsdocument,application/x-ms-xbap,"
                    + "application/x-ms-application,application/vnd.ms-excel,"
                    + "application/vnd.ms-powerpoint,application/msword,*/*");
            con.setRequestProperty("Accept-Language", "zh-CN");
            con.setRequestProperty("Charset", "UTF-8");
            InputStream inStream = con.getInputStream();
            File file = new File("123.png");
            FileOutputStream fos = new FileOutputStream(file);

            int len = 0;
            byte[] buffer = new byte[1024];
            while((len = inStream.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }


        long costTime = System.currentTimeMillis() - startTime;
        System.out.println("cost time :" +costTime);

        //29307
    }

}
