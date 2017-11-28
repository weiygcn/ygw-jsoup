package Command;

/**
 * Created by weiyg on 2017/9/26.
 */
public class PrintCommand implements Command{
    @Override
    public void process(int[] target){
        for(int tmp:target){
            System.out.println("迭代输出目标数组的元素:"+tmp);
        }
    }
}
