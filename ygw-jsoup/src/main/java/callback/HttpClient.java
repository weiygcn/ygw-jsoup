package callback;

/**
 * Created by weiyg on 2017/9/25.
 */
public class HttpClient {


    public static void excuse(final OnFInishLIstener listener){

        new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(listener != null ){
                    listener.onFinish();
                }
            }
        }.start();



    }


}
