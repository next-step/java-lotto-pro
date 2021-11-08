package lotto.view;

import java.util.Scanner;

import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Message;

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

    public static Lotto inputWinningNumbersOfLastWeek() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.nextLine();
        try {
            return LottoFactory.createManualLotto(numbers);
        } catch (NumberFormatException exception) {
            System.out.println(Message.NON_POSITIVE_LOTTO_NUMBER_MESSAGE.getMessage());
            return inputWinningNumbersOfLastWeek();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputWinningNumbersOfLastWeek();
        }
    }

    public static LottoNumber inputBonusNumber(Lotto winningLotto) {
        System.out.println("보너스 볼을 입력해 주세요.");
        String number = scanner.nextLine();
        try {
            LottoNumber lottoNumber = LottoNumber.valueOf(number);
            validateDuplicateLottoNumber(winningLotto, lottoNumber);
            return lottoNumber;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputBonusNumber(winningLotto);
        }
    }

    private static void validateDuplicateLottoNumber(Lotto winningLotto, LottoNumber lottoNumber) {
        if (winningLotto.existLottoNumber(lottoNumber)) {
            throw new IllegalArgumentException(Message.EXIST_DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }
}
