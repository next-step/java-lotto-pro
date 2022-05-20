package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Lottos;

import java.util.List;

public class LottoCount {

    private static final int ZERO = 0;

    private final int count;

    public LottoCount(String count) {
        try {
            this.count = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        validatePositive();
    }

    public LottoCount(int count) {
        this.count = count;
        validatePositive();
    }

    private void validatePositive() {
        if (count < ZERO) {
            throw new IllegalArgumentException("카운트는 0보다 큰 수여야 합니다.");
        }
    }

    public int count() {
        return count;
    }

    public Lottos generateLottos(LottoNumberGenerator generator) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = generator.generate();
            lottos.add(Lotto.create(numbers));
        }
        return lottos;
    }

    public LottoCount minus(LottoCount minus) {
        return new LottoCount(this.count - minus.count);
    }

    public boolean isZero() {
        return count == ZERO;
    }
}
