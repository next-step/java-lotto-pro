package lotto.ui;

import java.util.Scanner;

public class InputView {
    static final String PRINT_INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    static Scanner scanner = new Scanner(System.in);

    public static int getMoneyInput(){
        System.out.println(PRINT_INPUT_MONEY_MESSAGE);
        String inputMoney = scanner.nextLine();

        return validateMoneyInput(inputMoney);
    }

    public static int validateMoneyInput(String inputMoney) {
        int money;
        try{
            money = Integer.parseInt(inputMoney);
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException("금액은 숫자입니다.");
        }
        if(money < 0){
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
        return money;
    }
}
