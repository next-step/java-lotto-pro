package step3;

import step3.domain.LottoVendingMachine;
import step3.domain.Money;
import step3.domain.NumberGenerateStrategy;
import step3.domain.RandomNumberGenerateStrategy;
import step3.service.LottoService;

public class LottoApplication {
    public static void main(String[] args) {
        Money lottoPrice = new Money(1000L);
        NumberGenerateStrategy numberGenerateStrategy = new RandomNumberGenerateStrategy();
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine(numberGenerateStrategy, lottoPrice);
        new LottoService(lottoVendingMachine).execute();
    }
}
