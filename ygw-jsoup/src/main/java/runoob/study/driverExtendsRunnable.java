package runoob.study;

/**
 * Created by weiyg on 2017/9/7.
 */
public class driverExtendsRunnable {
    public static void main(String[] args){
        extendsRunnable t=new extendsRunnable( "壹线程" );
        extendsRunnable t1=new extendsRunnable( "1线程" );

        t.start();
        t1.start();

    }
}
