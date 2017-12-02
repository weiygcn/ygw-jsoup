package DemoInterfaceCallback;

/**
 * Created by weiyg on 30/11/2017.
 */
public class Teacher implements Callback{
    private Student student;

    public Teacher(Student student){
        this.student=student;
    }
    public void askQuestion(){
        student.ResolveAnswer(this);
    }
    @Override
    public void tellAnswer(String str){
        System.out.println("知道了，你的答案是：“"+str+"”");
    }
}
