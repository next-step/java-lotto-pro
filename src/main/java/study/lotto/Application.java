package study.lotto;

import study.lotto.controller.LottoController;
import study.lotto.view.ConsoleUserInterface;
import study.lotto.view.LottoView;
import study.lotto.view.printer.ConsolePrinter;

public class Application {
    public static void main(String[] args) {
        try {
            ConsoleUserInterface userInterface = new ConsoleUserInterface(new ConsolePrinter());
            LottoController controller = new LottoController(new LottoView(userInterface));
            controller.start();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
