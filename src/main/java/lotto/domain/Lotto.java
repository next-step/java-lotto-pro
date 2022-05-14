package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int LIMIT_LOTTO = 6;
    private static final Lotto INSTANCE = new Lotto();

    private final List<LottoNumber> lotto;

    private Lotto() {
        lotto = IntStream.range(MIN, MAX)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> autoLotto() {
        shuffle();
        return INSTANCE.lotto
                .stream()
                .limit(LIMIT_LOTTO)
                .collect(Collectors.toList());
    }

    private static void shuffle() {
        Collections.shuffle(INSTANCE.lotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lotto=" + lotto +
                '}';
    }
}
