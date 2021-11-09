package lotto.state;

import lotto.LottoApplication;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface State {

    int DEFAULT_READ_LINE = 1;

    default void printQuestion(PrintStream out) {
        // do nothing
    }

    default void printResult(List<String> texts, PrintStream out) {
        // do nothing
    }

    default int readLineCount() {
        return DEFAULT_READ_LINE;
    }

    State next();

    default boolean isFinish() {
        return false;
    }

    default void process(LottoApplication lottoApplication, Scanner scanner) {
        printQuestion(System.out);
        try {
            List<String> inputs = getInputs(scanner);
            printResult(inputs, System.out);
            lottoApplication.setState(next());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    default List<String> getInputs(Scanner scanner) {
        List<String> inputs = new ArrayList<>();
        for (int i = 0, n = readLineCount(); i < n; i++) {
            inputs.add(scanner.nextLine());
        }
        return inputs;
    }
}
