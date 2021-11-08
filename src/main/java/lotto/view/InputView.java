package lotto.view;

import java.util.Scanner;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;

public class InputView {
    private static final Scanner scanner = getScanner();

    private InputView() {
    }

    public static LottoMoney inputLottoAmount() {
        System.out.println("구매 금액을 입력해 주세요.");
        String amount = scanner.nextLine();
        try {
            return new LottoMoney(amount);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputLottoAmount();
        }
    }

    public static WinningLotto createWinningLotto() {
        return inputBonusNumber(inputWinningNumbersOfLastWeek());
    }

    public static Lotto inputWinningNumbersOfLastWeek() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.nextLine();
        try {
            return LottoFactory.createManualLotto(numbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputWinningNumbersOfLastWeek();
        }
    }

    public static WinningLotto inputBonusNumber(Lotto winningLotto) {
        System.out.println("보너스 볼을 입력해 주세요.");
        String number = scanner.nextLine();
        try {
            LottoNumber lottoNumber = LottoNumber.valueOf(number);
            return new WinningLotto(winningLotto, lottoNumber);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputBonusNumber(winningLotto);
        }
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }
}
