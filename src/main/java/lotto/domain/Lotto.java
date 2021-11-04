package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final int MAX_SIZE = 6;
    private static final String DELIMITER = ",";

    private final Set<LottoNumber> lotto = new HashSet();

    public Lotto(final List<Integer> lotto) {
        for (Integer number : lotto) {
            this.lotto.add(new LottoNumber(number));
        }
        check();
    }

    public Lotto(final String numbers) {
        this(Arrays.stream(numbers.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    private void check() {
        if (lotto.size() != MAX_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다");
        }
    }

    public int match(final Lotto lotto) {
        return (int) this.lotto.stream()
                .filter(lotto::contain)
                .count();
    }

    private boolean contain(LottoNumber number) {
        return this.lotto.contains(number);
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
}
