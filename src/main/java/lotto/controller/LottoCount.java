package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;

import java.util.List;

public class LottoCount {

    private final int count;

    public LottoCount(String count) {
        try {
            this.count = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public LottoCount(int count) {
        this.count = count;
    }

    public int count() {
        return count;
    }

    public Lottos generateLottos(LottoGenerator generator) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = generator.generate();
            lottos.add(Lotto.create(numbers));
        }
        return lottos;
    }
}
