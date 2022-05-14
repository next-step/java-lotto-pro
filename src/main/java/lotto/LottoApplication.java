package lotto;

import lotto.service.LottoMachine;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.pay();
    }
}
