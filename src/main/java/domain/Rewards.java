package domain;

import java.util.List;

public final class Rewards {

    private final List<Reward> elements;

    public Rewards(List<Reward> elements) {
        this.elements = elements;
    }

    public long count(Reward reward) {
        return elements.stream()
                .filter(it -> it.equals(reward))
                .count();
    }

    public double calculateRateOfReturn() {
        Money total = elements.stream()
                .map(Reward::getPrize)
                .reduce(new Money(0), Money::add);
        return total.calculateRateOfReturn(Lotto.PRICE.multiply(elements.size()));
    }
}
