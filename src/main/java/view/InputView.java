package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.domain.Ball;
import lotto.domain.Money;
import lotto.domain.Ticket;
import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String COMMA = ",";
    private static final String ALL_SPACES_PATTERN = "\\s";
    private static final String EMPTY = "";

    private InputView() {
    }

    public static Money readMoney() {
        return new Money(scanner.nextLine());
    }

    public static Ticket readTicket() {
        List<Integer> numbers = Arrays.stream(removeAllSpaces(scanner.nextLine()).split(COMMA))
            .map(InputView::parseInt)
            .collect(Collectors.toList());

        return new Ticket(numbers);
    }

    public static Ball readBall() {
        return new Ball(parseInt(removeAllSpaces(scanner.nextLine())));
    }

    private static String removeAllSpaces(String numbers) {
        return numbers.replaceAll(ALL_SPACES_PATTERN, EMPTY);
    }

    private static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoErrorCode.INVALID_NUMBER);
        }
    }
}
