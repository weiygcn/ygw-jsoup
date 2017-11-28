package enumA;

/**
 * Created by weiyg on 2017/9/27.
 */
public enum Operation {
    PLUS {
        public double eval(double a, double b) {
            return a + b;
        }
    }, MINUS {
        public double eval(double a, double b) {
            return a - b;
        }
    }, TIMES {
        public double eval(double a, double b) {
            return a * b;
        }
    }, DIVIDE {
        public double eval(double a, double b) {
            return a / b;
        }
    };


    public abstract double eval(double a, double b);

    public static void main(String[] args) {
        double a=Operation.PLUS.eval(4,2);
        double b=Operation.MINUS.eval(4,2);
        double c=Operation.TIMES.eval(4,2);
        double d=Operation.DIVIDE.eval(4,2);
        System.out.println(a+"\t"+b+"\t"+c+"\t"+d);
    }
}
