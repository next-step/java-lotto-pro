package step3;

import step3.domain.LottoVendingMachine;
import step3.domain.RandomNumberGenerateStrategy;
import step3.service.LottoService;

public class LottoApplication {
    public static void main(String[] args) {
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine(new RandomNumberGenerateStrategy());
        new LottoService(lottoVendingMachine).execute();
    }
}
