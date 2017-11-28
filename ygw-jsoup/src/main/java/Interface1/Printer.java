package Interface1;

/**
 * Created by weiyg on 2017/9/26.
 */
public class Printer implements Output,Product {
    @Override
    public void getDate(String msg) {
        System.out.println("printer类，getData函数" + msg);
    }

    @Override
    public void out() {
        System.out.println("printer类，out函数");
    }
    @Override
    public int getProductTime(){
        return 45;
    }


}
