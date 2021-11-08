package lotto.view;

import java.util.Scanner;

import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketFactory;
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

    public static LottoTicket inputWinningNumbersOfLastWeek() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.nextLine();
        try {
            return LottoTicketFactory.createManualLottoTicket(numbers);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputWinningNumbersOfLastWeek();
        }
    }

    public static LottoNumber inputBonusNumber(LottoTicket winningLottoTicket) {
        System.out.println("보너스 볼을 입력해 주세요.");
        String number = scanner.nextLine();
        try {
            LottoNumber lottoNumber = new LottoNumber(number);
            validateDuplicateLottoNumber(winningLottoTicket, lottoNumber);
            return lottoNumber;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return inputBonusNumber(winningLottoTicket);
        }
    }

    private static void validateDuplicateLottoNumber(LottoTicket winningLottoTicket, LottoNumber lottoNumber) {
        if (winningLottoTicket.existLottoNumber(lottoNumber)) {
            throw new IllegalArgumentException(Message.EXIST_DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }
}
