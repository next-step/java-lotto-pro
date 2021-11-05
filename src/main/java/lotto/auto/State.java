package lotto.auto;

import java.io.PrintStream;

public interface State {
    void printQuestion(PrintStream out);
    void printResult(String text, PrintStream out);
    State next();
    boolean isFinish();
}
