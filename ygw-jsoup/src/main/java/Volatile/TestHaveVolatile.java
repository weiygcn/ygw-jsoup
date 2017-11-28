package Volatile;

/**
 * Created by weiyg on 2017/9/30.
 */
public class TestHaveVolatile extends Thread {
    private static boolean bChanged;

    public TestHaveVolatile(boolean bChanged) {
        this.bChanged = bChanged;
    }

    @Override
    public void run() {
        if (bChanged = true) {
            System.out.println(this.getName() + "值存在变化，现为：" + this.bChanged);
        } else if (bChanged = false) {
            System.out.println(this.getName() + "正常-默认值：" + this.bChanged);
        }
    }

}
