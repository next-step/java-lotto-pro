package lotto.view;

import java.util.List;
import java.util.Scanner;

import lotto.domain.LottoMoney;
import lotto.domain.LottoNumbersFactory;
import lotto.domain.LottoTicket;

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

    public static LottoTicket winningNumbersOfLastWeek() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.nextLine();
        try {
            List<Integer> winningNumbers = LottoNumbersFactory.createManualLottoNumbers(numbers);
            return new LottoTicket(winningNumbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return winningNumbersOfLastWeek();
        }
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }
}
