package com.ygw.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * Created by weiyg on 2017/8/28.
 */
public class AddWechaId_Soup {

    /**
     * 信息采集微信群id添加
     * @param args
     */
    public static void main(String[] args) {
        try {
            //请求数据源网站
            String urlS = "http://weixinqun.com/group?c=310100&t=54&p=1";
            Element dom = Jsoup.connect( urlS ).get();
            Elements elements = dom.select( "div.border5" );

            //遍历取出list数据
            for (Element e : elements) {
                String content = e.select( "a" ).attr( "href" );
                String[] text = content.split( "=" );
                String id = text[1];
                System.out.println( text[1] );

                //连接数据入口
                String url = "http://manage.zsmy.cn/crawlWxGroup/save";
                String data = Jsoup.connect( url )
                        .data( "parameters", "{\"common\":{},\"data\":{\"group_id\":\"" + id + "\"}}" )
                        .post().text();
                System.out.println( data );
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
