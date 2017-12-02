package DemoInterfaceCallback;

/**
 * Created by weiyg on 30/11/2017.
 */
public class TestCall {
    public static void main(String[] args) {
        Student student = new StudentYGW();
        Teacher t = new Teacher(student);
        t.askQuestion();
    }
}
