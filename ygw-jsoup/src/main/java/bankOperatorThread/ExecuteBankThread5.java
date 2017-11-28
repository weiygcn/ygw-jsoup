package bankOperatorThread;

public class ExecuteBankThread5 extends Thread {
    private Thread t;
    private String ThreadName;
    Bank b;

    public ExecuteBankThread5(String name, Bank b) {
        ThreadName = name;
        this.b = b;
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
        try {
            System.out.println("》》》》存入100后---余额=" + b.addMoney(100)+"--运行run线程名："+ Thread.currentThread().getName());
        } catch (Exception i) {
            i.printStackTrace();
        }
    }
}
