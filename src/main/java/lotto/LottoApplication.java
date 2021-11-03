package lotto;

import lotto.service.LottoMachineService;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMachineService machine = new LottoMachineService();
        machine.run();
    }
}
