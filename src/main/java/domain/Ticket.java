package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static domain.Lotto.PRICE;

public final class Ticket {

    private final List<Lotto> elements;

    public Ticket(List<Lotto> elements) {
        this.elements = elements;
    }

    public static Ticket buy(Money money, LottoFactory factory) {
        List<Lotto> lottos = new ArrayList<>();
        while (money.isGreaterThanEqual(PRICE)) {
            lottos.add(factory.make());
            money = money.subtract(PRICE);
        }
        return new Ticket(lottos);
    }

    public Rewards check(Lotto wining) {
        return elements.stream()
                .map(it -> it.compareTo(wining))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Rewards::new));
    }

    public List<Lotto> getElements() {
        return elements.stream()
                .collect(Collectors.toUnmodifiableList());
    }
}
