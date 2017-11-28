package Interface1;

/**
 * Created by weiyg on 2017/9/26.
 */
public class Computer {
    private Output out;
    private Product pro;
    public Computer(Output out) {
        this.out = out;
    }
//    public Computer(Product pro) {
//        this.pro = pro;
//    }

    public void keyIn(String msg) {
        out.getDate(msg);
    }

    public void print(String... msgs) {
        //out.print(msgs);
    }
//   // public void test(){
//        out.test();
//    }
    public int getProductTime(Product pro){
        return pro.getProductTime();
    }
}
