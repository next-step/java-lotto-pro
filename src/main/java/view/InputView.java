package view;

import java.util.Scanner;

import lotto.domain.Ball;
import lotto.domain.Money;
import lotto.domain.Ticket;
import lotto.domain.TicketCount;
import lotto.utils.Parser;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static Money readMoney() {
        return Parser.parseMoney(scanner.nextLine());
    }

    public static TicketCount readCount() {
        return Parser.parseCount(scanner.nextLine());
    }

    public static Ticket readTicket() {
        return Parser.parseTicket(scanner.nextLine());
    }

    public static Ball readBall() {
        return Parser.parseBall(scanner.nextLine());
    }
}
