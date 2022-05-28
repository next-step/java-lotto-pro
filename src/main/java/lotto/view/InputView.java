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
        Money money = null;

        while (money == null) {
            try {
                System.out.println(InputMessage.INPUT_MONEY);
                money = new Money(scanner.nextInt());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    public static LottoWinningTicket inputWinningTicket() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS);
        LottoTicket lottoTicket = inputLottoNumbers();
        LottoNumber bonusNumber = inputBonusNumber();

        return new LottoWinningTicket(lottoTicket, bonusNumber);
    }

    private static LottoNumber inputBonusNumber() {
        LottoNumber bonusNumber = null;

        while (bonusNumber == null) {
            try {
                System.out.println(InputMessage.INPUT_BONUS_NUMBER);
                bonusNumber = new LottoNumber(scanner.nextInt());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return bonusNumber;
    }

    private static LottoTicket inputLottoNumbers() {
        LottoTicket lottoTicket = null;

        while (lottoTicket == null) {
            try {
                String[] stringNumbers = Splitter.splitString(scanner.next());

                List<LottoNumber> numbers = new ArrayList<>();
                for (String stringNumber : stringNumbers) {
                    numbers.add(new LottoNumber(stringNumber));
                }
                lottoTicket = new LottoTicket(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return lottoTicket;
    }

    public static ManualNumber inputManualNumber(Money money) {
        ManualNumber manualNumber = null;

        while (manualNumber == null) {
            try {
                System.out.println(InputMessage.INPUT_MANUAL_NUMBER);
                manualNumber = new ManualNumber(scanner.nextInt(), money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return manualNumber;
    }

    public static LottoTickets inputManualTickets(ManualNumber manualNumber) {
        System.out.println(InputMessage.INPUT_MANUAL_TICKETS);
        List<LottoTicket> manualTickets = new ArrayList<>();
        for (int i = 0; i < manualNumber.getManual(); i++) {
            manualTickets.add(inputLottoNumbers());
        }
        return new LottoTickets(manualTickets);
    }
}
