package lotto.view;

import java.util.Scanner;
import lotto.component.LottoGeneratorable;
import lotto.domain.BonusBall;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
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

    public BonusBall inputBonusBall(final Lotto winningLotto) {
        final LottoNumber bonusLottoNumber = new LottoNumber(NumberUtils.parseInt(readLine()));

        return new BonusBall(winningLotto, bonusLottoNumber);
    }

    private String readLine() {
        return SCANNER.nextLine();
    }
}
