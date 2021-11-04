package lotto;

import lotto.controller.LottoMachineController;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMachineController machine = new LottoMachineController();
        machine.run();
    }
}
