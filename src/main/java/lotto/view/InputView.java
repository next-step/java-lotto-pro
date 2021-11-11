package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.Message;
import lotto.domain.WinningLotto;

public class InputView {
    public static final int MANUAL_LOTTO_MIN = 1;
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

    public static List<Lotto> createManualLottos() {
        int manualLottoCount = InputView.inputManualLottoCount();
        return InputView.inputManualLottosNumbers(manualLottoCount);
    }

    private static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String number = scanner.nextLine();
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            System.out.println(Message.NON_POSITIVE_NUMBER_INPUT_MESSAGE.getMessage());
            return inputManualLottoCount();
        }
    }

    private static List<Lotto> inputManualLottosNumbers(int manualLottoCount) {
        if (manualLottoCount < MANUAL_LOTTO_MIN) {
            return new ArrayList<>();
        }
        List<Lotto> manualLottos = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualLottoCount; i++) {
            createManualLotto(manualLottos);
        }
        return manualLottos;
    }

    private static void createManualLotto(List<Lotto> manualLottos) {
        try {
            String numbers = scanner.nextLine();
            manualLottos.add(LottoFactory.createManualLotto(numbers));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            createManualLotto(manualLottos);
        }
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }
}
