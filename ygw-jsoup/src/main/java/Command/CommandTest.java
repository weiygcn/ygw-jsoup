package Command;

/**
 * Created by weiyg on 2017/9/26.
 */
public class CommandTest {
    static int[] MyArray={1,2,3,4,5,6,7};
    public static void main(String[] args) {
        ProcessArray processArray=new ProcessArray();
        processArray.process(MyArray,new AddCommand());
        processArray.process(MyArray,new PrintCommand());
    }

}
