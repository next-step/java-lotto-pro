package study.lotto.view.printer;

public class ConsolePrinter implements Printer {
    @Override
    public void info(String message) {
        System.out.print(message);
    }

    @Override
    public void error(String errorMessage) {
        System.out.print("[ERROR] " + errorMessage);
    }
}
