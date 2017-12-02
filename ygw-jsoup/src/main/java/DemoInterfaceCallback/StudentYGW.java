package DemoInterfaceCallback;

/**
 * Created by weiyg on 30/11/2017.
 */
public class StudentYGW implements Student {

    @Override
    public void ResolveAnswer(Callback callback) {
        try {
            new Thread().sleep(3000);
            callback.tellAnswer("答案就是不知道，哈哈哈");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
