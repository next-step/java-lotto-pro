package lotto.state;

import java.io.PrintStream;

public class FinishState implements State {
    @Override
    public void printQuestion(PrintStream out) {

    }

    @Override
    public void printResult(String text, PrintStream out) {

    }

    @Override
    public State next() {
        return null;
    }

    @Override
    public boolean isFinish() {
        return true;
    }
}
