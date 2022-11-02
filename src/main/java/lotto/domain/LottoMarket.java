package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMarket {
    private static final Money TICKET_PRICE = new Money(1_000L);

    private static final LottoGenerator randomGenerator = new RandomLottoGenerator();;

    private LottoMarket() {}

    public static List<LottoTicket> sell(Money money, List<String> manualInputs) {
        Money autoLottoMoney = money.subtract(TICKET_PRICE.multiply(manualInputs.size()));
        return make(getAutoAmount(autoLottoMoney), manualInputs);
    }

    private static Quantity getAutoAmount(Money money) {
        return new Quantity((int) money.divide(TICKET_PRICE));
    }

    private static List<LottoTicket> make(Quantity quantity, List<String> manualInputs) {
        return Stream.concat(makeManual(manualInputs).stream(), makeAuto(quantity).stream())
                .collect(Collectors.toList());

    }

    private static List<LottoTicket> makeAuto(Quantity quantity) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (long i = 0; i < quantity.value(); i++) {
            tickets.add(randomGenerator.create());
        }

        return tickets;
    }

    private static List<LottoTicket> makeManual(List<String> inputs) {
        return ManualLottoGenerator.createMany(inputs);
    }
}
