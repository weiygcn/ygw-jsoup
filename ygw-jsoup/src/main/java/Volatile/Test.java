package Volatile;

/**
 * Created by weiyg on 2017/9/30.
 */
public class Test {
    public static volatile boolean bChanged;

    public static void main(String[] args) {
        int i = 0;
        while (i < 2) {
            TestHaveVolatile t1 = new TestHaveVolatile(bChanged);
            TestNoVolatile t2 = new TestNoVolatile(bChanged);
            t1.start();
            t2.start();
            i++;
        }

    }
}
