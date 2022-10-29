package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static int inputPayAmount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public static List<Integer> inputLottoWinnerNumbers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String input = sc.nextLine();
        input = input.replaceAll(" ", "");
        String[] winnerNumbers = input.split(",");
        return Arrays.stream(winnerNumbers).map(Integer::parseInt).collect(Collectors.toList());
    }
}
