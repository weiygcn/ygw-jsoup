package runoob.study;

/**
 * Created by weiyg on 2017/9/7.
 */
public class extendsThread extends Thread {
    private Thread t;
    private String ThreadName;

    public extendsThread(String name) {
        ThreadName = name;
        System.out.println("构造方法初始化线程名-" + ThreadName);
    }

    @Override
    public void start() {
        if (t == null) {
            t = new Thread(this, ThreadName);
            System.out.println(ThreadName + "线程开始");
            t.start();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println(ThreadName + "线程运行");
            System.out.println("sleep-5000millis");
            Thread.sleep(5000);
            System.out.println("ThreadExit");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
