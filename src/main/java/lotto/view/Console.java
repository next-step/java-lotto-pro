package lotto.view;

import lotto.model.Lottery;
import lotto.model.Money;
import lotto.model.Number;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Console {
    private static Scanner scanner;

    private Console() {
    }

    private static String readLine() {
        return getInstance().nextLine();
    }

    private static Scanner getInstance() {
        if (Objects.isNull(scanner) || isClosed()) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    private static boolean isClosed() {
        try {
            final Field sourceClosedField = Scanner.class.getDeclaredField("sourceClosed");
            sourceClosedField.setAccessible(true);
            return sourceClosedField.getBoolean(scanner);
        } catch (final Exception e) {
            System.out.println("unable to determine if the scanner is closed.");
        }
        return true;
    }

    public static Money readMoney() {
        return new Money(readLine());
    }

    public static int readManualGameCount() {
        return Integer.parseInt(readLine());
    }

    public static Lottery readNumbers() {
        List<Number> numbers = new LinkedList<>();
        for (String number : split(readLine())) {
            numbers.add(new Number(number.trim()));
        }
        return new Lottery(numbers);
    }

    public static Number readBonusNumber() {
        return new Number(readLine());
    }

    private static String[] split(String input) {
        return input.split(",");
    }
}
