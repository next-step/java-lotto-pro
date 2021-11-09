package step3.view;

import java.util.Scanner;
import step3.domain.Lotto;
import step3.domain.Money;
import util.LottoNumbers;
import util.Numbers;

public class ConsoleInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static String readLine() {
        return SCANNER.nextLine();
    }

    public static Money inputMoney() {
        ConsoleOutputView.print("구입금액을 입력해 주세요.");

        final int money = Numbers.parseInt(readLine());

        return new Money(money);
    }

    public static Lotto inputWinningLotto() {
        ConsoleOutputView.print("지난 주 당첨 번호를 입력해 주세요.");

        return new Lotto(LottoNumbers.split(readLine()));
    }
}
