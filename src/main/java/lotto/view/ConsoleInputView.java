package lotto.view;

import lotto.lotto.Lotto;
import lotto.lotto.LottoGenerator;
import lotto.money.Money;
import java.util.Scanner;

class ConsoleInputView implements InputView {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Money readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Money.of(scanner.nextLine());
    }

    @Override
    public Lotto readPreviousWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return LottoGenerator.commaSplitting(scanner.nextLine())
                             .generate();
    }
}
