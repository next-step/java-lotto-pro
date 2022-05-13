package study.lotto;

import study.lotto.controller.LottoController;
import study.lotto.view.ConsoleUserInterface;
import study.lotto.view.LottoView;
import study.lotto.view.printer.ConsolePrinter;

public class Application {
    public static void main(String[] args) {
        ConsolePrinter printer = new ConsolePrinter();
        try {
            runLotto(printer);
        } catch (IllegalArgumentException e) {
            printer.error(e.getMessage());
        }
    }

    private static void runLotto(ConsolePrinter printer) {
        ConsoleUserInterface userInterface = new ConsoleUserInterface(printer);
        LottoController controller = new LottoController(new LottoView(userInterface));
        controller.start();
    }
}
