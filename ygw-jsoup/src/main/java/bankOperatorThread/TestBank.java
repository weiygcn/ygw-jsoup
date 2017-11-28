package bankOperatorThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;

public class TestBank {


    public static void main(String[] args) throws InterruptedException {
//        TimeUnit.SECONDS.sleep(10);
        Bank bank = new Bank();
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(8);
        ExecuteBankThread1 one = new ExecuteBankThread1("Thread-11", bank);
//        one.start();
//        System.out.println("======================================");
        ExecuteBankThread2 two = new ExecuteBankThread2("Thread-22", bank);
//        two.start();
//        System.out.println("======================================");
        ExecuteBankThread3 three = new ExecuteBankThread3("Thread-33", bank);
//        three.start();

//        System.out.println("======================================");

        ExecuteBankThread4 four = new ExecuteBankThread4("Thread-44", bank);
//        four.start();
//        System.out.println("======================================");

        ExecuteBankThread5 five = new ExecuteBankThread5("Thread-55", bank);
//        five.start();
//        System.out.println("======================================");

        ExecuteBankThread6 six = new ExecuteBankThread6("Thread-66", bank);
//        six.start();
//        System.out.println("======================================");

        ExecuteBankThread7 seven = new ExecuteBankThread7("Thread-77", bank);
//        seven.start();
//        System.out.println("======================================");

        ExecuteBankThread8 eight = new ExecuteBankThread8("Thread-88", bank);
//        eight.start();
        cachedThreadPool.execute(one);
        cachedThreadPool.execute(two);
        cachedThreadPool.execute(three);
        cachedThreadPool.execute(four);
        cachedThreadPool.execute(five);
        cachedThreadPool.execute(six);
        cachedThreadPool.execute(seven);
        cachedThreadPool.execute(eight);
        cachedThreadPool.shutdown();

    }
}

