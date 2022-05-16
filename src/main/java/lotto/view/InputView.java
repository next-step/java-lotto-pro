package lotto.view;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String readMoney() {
        System.out.println("구입 금액을 입력해 주세요.");

        return scanner.nextLine();
    }

    public static List<LottoNumber> readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String input = scanner.nextLine();
        return Arrays.stream(input.split(","))
                .map(s -> new LottoNumber(Integer.parseInt(s.trim())))
                .collect(Collectors.toList());
    }
}
