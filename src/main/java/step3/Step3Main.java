package step3;

import java.util.Scanner;
import step3.controller.GameController;
import step3.model.GameModel;
import step3.view.InputView;
import step3.view.OutputView;

public class Step3Main {

    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        GameController gameController = new GameController(new GameModel(), new InputView(s), new OutputView());
        gameController.startLotto();

    }

}
