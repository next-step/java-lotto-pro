package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Ball;
import lotto.domain.Money;
import lotto.domain.Ticket;
import lotto.domain.TicketCount;
import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;

public class Parser {
    private static final String COMMA = ",";
    private static final String ALL_SPACES_PATTERN = "\\s";
    private static final String EMPTY = "";

    private Parser() {
    }

    private static long parseLong(String number) {
        try {
            return Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoErrorCode.INVALID_NUMBER);
        }
    }

    private static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoErrorCode.INVALID_NUMBER);
        }
    }

    public static Money parseMoney(String money) {
        return new Money(Parser.parseLong(money));
    }

    public static TicketCount parseCount(String count) {
        return new TicketCount(parseLong(count));
    }

    public static Ticket parseTicket(String ticket) {
        String[] numbers = removeAllSpaces(ticket).split(COMMA);

        List<Integer> validNumbers = Arrays.stream(numbers)
            .map(Parser::parseInt)
            .collect(Collectors.toList());

        return new Ticket(validNumbers);
    }

    public static Ball parseBall(String ball) {
        String number = removeAllSpaces(ball);
        int validNumber = parseInt(number);
        return Ball.of(validNumber);
    }

    private static String removeAllSpaces(String numbers) {
        return numbers.replaceAll(ALL_SPACES_PATTERN, EMPTY);
    }
}
