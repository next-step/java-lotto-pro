package step3.view;

import java.util.Scanner;
import step3.domain.Lotto;
import step3.domain.Money;
import util.LottoNumbers;
import util.Numbers;

public class ConsoleInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public Money inputMoney() {
        final int money = Numbers.parseInt(readLine());

        return new Money(money);
    }

    public Lotto inputWinningLotto() {
        return new Lotto(LottoNumbers.split(readLine()));
    }

    private String readLine() {
        return SCANNER.nextLine();
    }
}
