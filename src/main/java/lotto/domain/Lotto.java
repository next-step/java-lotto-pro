package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    private static final int MAX_SIZE = 6;

    private final Set<LottoNumber> lotto = new HashSet();

    public Lotto(final List<Integer> lotto) {
        for (Integer number : lotto) {
            this.lotto.add(new LottoNumber(number));
        }
        check();
    }

    public Lotto(final String numbers) {
        this(Splitter.split(numbers));
    }

    public Lotto(final Numbers numbers) {
        this(numbers.random());
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (LottoNumber number : lotto) {
            builder.append(", ");
            builder.append(number.toString());
        }
        builder.delete(0, 2);
        return builder.toString();
    }
}
