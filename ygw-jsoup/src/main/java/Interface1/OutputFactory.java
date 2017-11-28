package Interface1;

/**
 * Created by weiyg on 2017/9/26.
 */
public class OutputFactory {
    public Output getPrinter(int num) {
        if (num == 0) {
            return new Printer();
        } else if (num == 1) {
            return new BetterPrinter();
        }
        return null;
    }

    public static void main(String[] args) {
        try {

            OutputFactory outputFactory = new OutputFactory();
            Product product=new BetterPrinter();

            Computer computer = new Computer(outputFactory.getPrinter(1));
            computer.keyIn("轻量级JAVA EE企业应用实战");
            computer.keyIn("疯狂JAVA讲义");
            computer.print();
            System.out.println(computer.getProductTime(product));
            computer.keyIn("疯狂Android讲义");
            computer.keyIn("疯狂Ajax讲义");
            computer.print();
            computer.print("孙悟空", "猪八戒", "白骨精");
           // computer.test();
            System.out.println("====================");

            Computer computerA = new Computer(outputFactory.getPrinter(0));
            System.out.println(computerA.getProductTime(product));
            computerA.print();
        } catch (NullPointerException n) {
            System.out.println("出现异常");
            n.printStackTrace();
        }
    }
}
