package bankOperatorThread;
//

//import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantLock;

//import java.util.concurrent.TimeUnit;

public class Bank {
    private double count = 0;
    private final ReentrantLock lock = new ReentrantLock();


    public double addMoney(int num) {
        try {
            System.out.println("存钱---时间戳" + System.currentTimeMillis());
            return yunsuan(true, num, false, false);
        } catch (Exception i) {
            i.printStackTrace();
            return count;
        }
    }

    public double searchCount() {
        try {
            System.out.println("查询---时间戳" + System.currentTimeMillis());
            return yunsuan(false, 0, true, false);
        } catch (Exception i) {
            i.printStackTrace();
            return count;
        }
    }

    public double draw(int num) throws NoMoneyException {
        try {
            System.out.println("取钱---时间戳" + System.currentTimeMillis());
            return yunsuan(false, num, false, true);
        } catch (Exception i) {
            i.printStackTrace();
            return count;
        }
    }

    public double yunsuan(boolean join, int num, boolean search, boolean draw) {
        lock.lock();
//        synchronized (this) {
        try {
            System.out.println("111账户原余额：" + count + "线程---" + Thread.currentThread().getName());
            if (search) {
            } else if (join) {
                count = count + num;
            } else if (draw) {
                if (num > count) {
                    new NoMoneyException(count, num);
//                System.out.println("取钱---时间戳" + System.currentTimeMillis());
                } else {
                    count = count - num;
                }
            }
//            Thread.sleep(1000);
            System.out.println("222-return前-unlock之前：" + count + "线程：" + Thread.currentThread().getName());
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return count;
        } finally {
            lock.unlock();
        }
//        }
    }
}

