package com.ygw.jsoup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * 删除信息采集中微信群无效group_id
 * Created by weiyg on 2017/9/1.
 */
public class DelInvaildWechaId {
    public static void main(String[] args) {
        try {
            long time_start = System.currentTimeMillis();
            String url_1 = "http://manage.zsmy.cn/crawlWxGroup/list";  //查询地址
            String rq_url = "http://manage.zsmy.cn/crawlWxGroup/deleteWxGroup"; //删除地址

            //使用查询接口获取无法获得的group_id
            String as_data = Jsoup.connect( url_1 )
                    .data( "parameters", "{\"common\":{\"page\":1,\"size\":200},\"data\":{\"group_id\":-1,\"group_name\":\"\",\"industry\":\"\",\"weixin_no\":\"\",\"address\":\"\",\"tag\":\"\",\"status\":\"0\"}}" )
                    .post().text();
            //使用删除接口，删除无法获取的无用id
            JSONObject jsonObject = JSON.parseObject( as_data );
            JSONArray jsonArray = jsonObject.getJSONObject( "data" ).getJSONArray( "list" );
            int countNumber = jsonArray.size();
            for (Object j : jsonArray) {
                Object group_id = JSON.parseObject( j.toString() ).get( "group_id" );
                String rq_date = "{\"common\":{},\"data\":{\"group_id\":\"" + group_id + "\"}}";
                String response = Jsoup.connect( rq_url ).data( "parameters", rq_date ).post().text();
                System.out.println( response );
                System.out.println( "=========================================" );
            }
            long time_end = System.currentTimeMillis();
            long h = time_end - time_start;
            System.out.println( "共删除" + countNumber + "条数据，共花费：" + h + "毫秒" );

        } catch (IOException c) {
            c.printStackTrace();
        }
    }
}
