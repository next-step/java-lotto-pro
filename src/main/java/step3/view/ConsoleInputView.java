package step3.view;

import java.util.Scanner;
import step3.component.LottoGeneratorable;
import step3.domain.Lotto;
import step3.domain.Money;
import util.NumberUtils;

public class ConsoleInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public Money inputMoney() {
        final int money = NumberUtils.parseInt(readLine());

        return new Money(money);
    }

    public Lotto inputWinningLotto(final LottoGeneratorable lottoGeneratorable) {
        return lottoGeneratorable.generate(readLine());
    }

    private String readLine() {
        return SCANNER.nextLine();
    }
}
