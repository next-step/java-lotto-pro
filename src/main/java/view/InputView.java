package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static int inputReadPurchaseMoney(){
        System.out.println("구매 금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public static String inputWinLottoNumbers(){
        sc.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }
}
