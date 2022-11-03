package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMarket {
    private final Money lottoPrice;
    private final LottoGenerator randomGenerator ;

    public LottoMarket(Money lottoPrice, LottoGenerator randomGenerator) {
        this.lottoPrice = lottoPrice;
        this.randomGenerator = randomGenerator;
    }

    public List<LottoTicket> sell(Money money, List<String> manualInputs) {
        Money autoLottoMoney = money.subtract(lottoPrice.multiply(manualInputs.size()));
        return make(getAutoAmount(autoLottoMoney), manualInputs);
    }

    private Quantity getAutoAmount(Money money) {
        return new Quantity((int) money.divide(lottoPrice));
    }

    private List<LottoTicket> make(Quantity quantity, List<String> manualInputs) {
        return Stream.concat(makeManual(manualInputs).stream(), makeAuto(quantity).stream())
                .collect(Collectors.toList());
    }

    private List<LottoTicket> makeAuto(Quantity quantity) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (long i = 0; i < quantity.value(); i++) {
            tickets.add(randomGenerator.create());
        }

        return tickets;
    }

    private List<LottoTicket> makeManual(List<String> inputs) {
        return ManualLottoGenerator.createMany(inputs);
    }
}
