package Internet;
import sun.net.util.IPAddressUtil;

import java.io.IOException;
import java.net.*;
/**
 * Created by weiyg on 2017/9/28.
 */
public class InternNetTest {
    public static void main(String[] args) throws IOException{
        InetAddress ip = InetAddress.getByName("www.baidu.com");
        System.out.println("crazyit是否可达："+ip.isReachable(2000));
        System.out.println(ip.getHostAddress());
        InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
        System.out.println("本机是否可达:"+local.isReachable(5000));
        System.out.println(local.getCanonicalHostName());
    }
}
