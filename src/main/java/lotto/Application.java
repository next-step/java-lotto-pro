package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.Machine;

public class Application {

    public static void main(String[] args) {
        Machine machine = new LottoMachine();
        machine.start();
    }
}
