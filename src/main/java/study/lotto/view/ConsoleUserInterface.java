package study.lotto.view;

import study.lotto.view.printer.Printer;
import study.lotto.view.scanner.ConsoleScanner;

public class ConsoleUserInterface {
    private final Printer printer;

    public ConsoleUserInterface(Printer printer) {
        this.printer = printer;
    }

    public void show(String message) {
        printer.info(message);
    }

    public String getUserInput(String message) {
        show(message);
        return ConsoleScanner.readLine();
    }
}
