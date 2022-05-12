package camp.nextstep.edu.view;

import camp.nextstep.edu.level1.lotto.lotto.Lotto;
import camp.nextstep.edu.level1.lotto.lotto.LottoResult;
import camp.nextstep.edu.level1.stringCaluator.calculator.StringCalculator;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static StringCalculator enterCalculateValue() {
        System.out.println("양수를 구분자와 함께 입력해 주세요.");
        System.out.println("기본 구분자는 :, 입니다.");
        System.out.println("//로 시작된 문자를 입력하 후 계산할 값을 입력하면, // 뒤의 문자로 구분하여 계산합니다.");

        StringBuilder sb = new StringBuilder();
        sb.append(scanner.nextLine());

        if (sb.toString().startsWith("//")) {
            sb.append("\n");
            sb.append(scanner.nextLine());
        }

        return new StringCalculator(sb.toString());
    }

    public static Lotto enterLottoValue() {
        System.out.println("구입금액을 입력해 주세요.");

        return new Lotto(scanner.nextLine());
    }

    public static LottoResult enterLottoWinningNumbers(Lotto lotto) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return lotto.compareWinningNumber(scanner.nextLine());
    }
}
