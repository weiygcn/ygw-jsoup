package Command;

/**
 * Created by weiyg on 2017/9/26.
 */
public class AddCommand implements Command{
    @Override
    public void process(int[] target){
        int sum=0;
        for(int tmp:target){
            sum+=tmp;
        }
        System.out.println("输出数组元素的总和:"+sum);
    }
}
