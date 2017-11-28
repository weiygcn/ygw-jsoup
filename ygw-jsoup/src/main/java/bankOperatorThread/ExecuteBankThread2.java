package bankOperatorThread;

//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;

public class ExecuteBankThread2 extends Thread {
    private Thread t;
    private String ThreadName;
    Bank b;
//    private Lock lock = new ReentrantLock();

    public ExecuteBankThread2(String name,Bank b) {
        ThreadName = name;
        this.b=b;
    }

    @Override
    public void start() {
//        System.out.println("运行start");
        if (t == null) {
//            System.out.println("线程为NULL,执行线程名创建");
            t = new Thread(this, ThreadName);
        }
        t.run();
    }

    @Override
    public void run() {
//        lock.lock();
        try {
            try {
                System.out.println("》》》》取出100后---余额=" + b.draw(100)+"--运行run线程名："+ Thread.currentThread().getName());
            } catch (NoMoneyException n) {
                n.printStackTrace();
            }
        } catch (Exception i) {
            i.printStackTrace();
        } finally {
//            lock.unlock();
        }
    }
}
