package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Integer> takeWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] inputNumbers = input.split(",");
        return Arrays.stream(inputNumbers)
                .mapToInt((number)-> Integer.parseInt(number.trim()))
                .boxed()
                .collect(Collectors.toList());
    }
}
