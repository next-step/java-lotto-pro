package lotto.state;

import lotto.auto.AutoLottoApplication;

import java.io.PrintStream;
import java.util.Scanner;

public interface State {
    void printQuestion(PrintStream out);

    default void printResult(String text, PrintStream out) {
        // do nothing
    }

    State next();

    default boolean isFinish() {
        return false;
    }

    default void process(AutoLottoApplication autoLottoApplication, Scanner scanner) {
        printQuestion(System.out);
        try {
            String input = scanner.nextLine();
            printResult(input, System.out);
            autoLottoApplication.setState(next());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
