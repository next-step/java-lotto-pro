package lotto.view;

import calculator.utils.Splitter;
import lotto.domain.*;
import lotto.message.InputMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println(InputMessage.INPUT_MONEY);
        return scanner.nextInt();
    }

    public static LottoWinningTicket inputWinningNumbers() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS);
        LottoTicket lottoTicket = inputLottoNumbers();
        LottoNumber bonusNumber = inputBonusNumber();

        return new LottoWinningTicket(lottoTicket, bonusNumber);
    }

    private static LottoNumber inputBonusNumber() {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER);
        return new LottoNumber(scanner.nextInt());
    }

    private static LottoTicket inputLottoNumbers() {
        String[] stringNumbers = Splitter.splitString(scanner.next());

        List<LottoNumber> numbers = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            numbers.add(new LottoNumber(stringNumber));
        }
        return new LottoTicket(numbers);
    }

    public static ManualNumber inputManualNumber(Money money) {
        System.out.println(InputMessage.INPUT_MANUAL_NUMBER);
        return new ManualNumber(scanner.nextInt(), money);
    }
}
