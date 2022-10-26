package step3;

import java.util.Scanner;

public class InputView {
    private static final String REQUEST_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private final Scanner sc;
    
    public InputView() {
        this.sc = new Scanner(System.in);
    }
    
    public int inputPayment() {
        System.out.println(REQUEST_PAYMENT);
        return sc.nextInt();
    }
    
    public String inputWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
        return sc.nextLine();
    }
}
