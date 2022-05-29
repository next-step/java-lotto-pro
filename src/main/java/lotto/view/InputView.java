package lotto.view;

import calculator.utils.Splitter;
import lotto.domain.*;
import lotto.message.InputMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Money inputMoney() {
        try {
            System.out.println(InputMessage.INPUT_MONEY);
            return new Money(scanner.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputMoney();
        }

        return null;
    }

    public static LottoWinningTicket inputWinningTicket() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS);
        LottoTicket lottoTicket = inputLottoNumbers();
        LottoNumber bonusNumber = inputBonusNumber();

        return new LottoWinningTicket(lottoTicket, bonusNumber);
    }

    private static LottoNumber inputBonusNumber() {
        try {
            System.out.println(InputMessage.INPUT_BONUS_NUMBER);
            return new LottoNumber(scanner.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBonusNumber();
        }

        return null;
    }

    private static LottoTicket inputLottoNumbers() {
        try {
            String[] stringNumbers = Splitter.splitString(scanner.next());

            List<LottoNumber> numbers = new ArrayList<>();
            for (String stringNumber : stringNumbers) {
                numbers.add(new LottoNumber(stringNumber));
            }
            return new LottoTicket(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static ManualLottoTicketCount inputManualNumber(Money money) {
        try {
            System.out.println(InputMessage.INPUT_MANUAL_NUMBER);
            return new ManualLottoTicketCount(scanner.nextInt(), money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static LottoTickets inputManualTickets(ManualLottoTicketCount manualNumber) {
        System.out.println(InputMessage.INPUT_MANUAL_TICKETS);
        List<LottoTicket> manualTickets = new ArrayList<>();
        for (int i = 0; i < manualNumber.getTicketCount(); i++) {
            manualTickets.add(inputLottoNumbers());
        }
        return new LottoTickets(manualTickets);
    }
}
