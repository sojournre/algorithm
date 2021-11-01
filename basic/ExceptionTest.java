package basic;

public class ExceptionTest {
    public void sayNick(String nick) throws FoolException {
//        try {
            if ("fool".equals(nick)) {
                throw new FoolException();
            }
            System.out.println("당신의 별명은 " + nick + " 입니다.");
//        } catch (FoolException e) {
//        }
    }

    public static void main(String[] args) {
        ExceptionTest test = new ExceptionTest();
        try {
            test.sayNick("fool");
            test.sayNick("genious");
        } catch (FoolException e) {
            System.err.println("FoolException이 발생했습니다.");

        }
    }
}
