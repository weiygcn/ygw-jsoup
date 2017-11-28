package Interface1;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by weiyg on 2017/9/26.
 */
public class BetterPrinter implements Output, Product {
    private String[] printDate = new String[MAX_CACHE_LINE * 2];
    private int dataNum = 0;

    @Override
    public void getDate(String msg) {
        if (dataNum >= MAX_CACHE_LINE * 2) {
            System.out.println("输出队列已满，添加失败");
        } else {
            printDate[dataNum++] = msg;
        }
        System.out.println("BetterPrinter类，getDate函数：" + msg);
    }

    @Override
    public void out() {
        while (dataNum > 0) {
            System.out.println("高速打印机正在打印:" + printDate[0]);
            System.arraycopy(printDate, 1, printDate, 0, --dataNum);
        }
        System.out.println("BetterPrinter类，out函数");
    }

    @Override
    public int getProductTime() {
        return 54;
    }
}
