package lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotteries {
    public static final Lotteries EMPTY = new Lotteries(Collections.emptyList());

    private final List<Lotto> lotteries;

    public Lotteries(final List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries of(final Lotteries... lotteries) {
        return new Lotteries(Stream.of(lotteries)
            .map(Lotteries::get)
            .flatMap(Collection::stream)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList)));
    }

    public void add(final Lotto lotto) {
        this.lotteries.add(lotto);
    }

    public List<Lotto> get() {
        return Collections.unmodifiableList(this.lotteries);
    }

    public int size() {
        return this.lotteries.size();
    }

    @Override
    public String toString() {
        final StringJoiner joiner = new StringJoiner(System.lineSeparator());

        for (final Lotto lotto : this.lotteries) {
            joiner.add(lotto.toString());
        }

        return joiner.toString();
    }
}
