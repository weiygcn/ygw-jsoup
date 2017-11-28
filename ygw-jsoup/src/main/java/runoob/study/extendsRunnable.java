package runoob.study;

/**
 * Created by weiyg on 2017/9/4.
 */
public class extendsRunnable implements Runnable {
    private Thread t;
    private String threadName;

    public extendsRunnable(String name) {
        this.threadName = name;
        System.out.println( "构造方法初始化Thread：" + threadName );
    }

    public void start() {
        System.out.println( "开始运行" + threadName );
        if (t == null) {
            t = new Thread( this, threadName );
            t.start();
        }

    }

    @Override
    public void run() {
        System.out.println( "override，这是继承接口创建的线程" );
        try {
            for (int n = 0; n < 5; n++) {
                System.out.println( "线程名：" + threadName + n );
                Thread.sleep( 50 );
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( threadName + "线程退出" );
    }
}
