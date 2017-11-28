package callback;

/**
 * Created by weiyg on 2017/9/25.
 */
public class HttpClientTest implements OnFInishLIstener{
    public static void main(String args[]){
        System.out.println("开始执行");
//        1.方法1
//        HttpClient.excuse(new OnFInishLIstener() {
//            @Override
//            public void onFinish() {
//                System.out.println("执行结束");
//            }
//        });


//        2
//        HttpClientTest test = new HttpClientTest();
//        HttpClient.excuse(test);

//        3
        HttpClientTest test = new HttpClientTest();
        test.start();

    }
    public void start(){
        HttpClient.excuse(this);
    }


    @Override
    public void onFinish() {
        System.out.println("执行结束");
    }
}
