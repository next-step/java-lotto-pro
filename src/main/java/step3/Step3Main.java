package step3;

import java.util.Scanner;
import step3.controller.LottoController;
import step3.domain.LottoManager;
import step3.model.LottoMachine;
import step3.view.InputView;
import step3.view.OutputView;

public class Step3Main {

    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        LottoController lottoController = new LottoController(new LottoMachine(new LottoManager()), new InputView(s), new OutputView());
        lottoController.startLotto();

    }

}
