package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        return scanner.nextInt();
    }

    public static List<Integer> inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return Arrays.stream(scanner.next().trim().split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static LottoNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return new LottoNumber(scanner.nextInt());
    }
}
