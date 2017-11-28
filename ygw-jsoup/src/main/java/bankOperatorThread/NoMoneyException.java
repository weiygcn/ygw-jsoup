package bankOperatorThread;
public class NoMoneyException extends Exception {
    public NoMoneyException(double beforcount, int drawNum) {
        if (drawNum > beforcount) System.out.println("ERRO余额不足,差"+(drawNum-beforcount));
    }
}
