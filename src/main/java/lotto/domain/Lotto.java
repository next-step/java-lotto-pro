package lotto.domain;

import java.util.List;

public class Lotto {
    private LottoNumbers numbers;
    private Rank rank;

    public Lotto(List<Integer> numbers) {
        this.numbers = new LottoNumbers(numbers);
    }

    public Lotto(int matchCount) {
        this.rank = Rank.valueOf(matchCount);
    }

    public int getPrize() {
        return this.rank.getPrize();
    }

    @Override
    public String toString() {
        return "[" + numbers.toString() + "]";
    }
}
