package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView{
    @Override
    public int takeBudget() {
        System.out.println("구매금액을 입력해주세요.");
        String budget = Console.readLine();
        try{
           return Integer.parseInt(budget);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("구매금액은 숫자만 입력가능합니다.");
        }
    }
}
