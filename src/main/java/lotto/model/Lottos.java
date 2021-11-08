package lotto.model;

import lotto.NumberListGenerator;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.LottoNumber.MAX_VALUE;
import static lotto.model.LottoNumber.MIN_VALUE;
import static lotto.model.LottoNumbers.LOTTO_SIZE;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generateAuto(int count) {
        final List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            final List<Integer> list = NumberListGenerator.generateRandomNumbers(LOTTO_SIZE, MIN_VALUE, MAX_VALUE);
            final Lotto lotto = Lotto.generate(list);
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public LottoResult calculateWinning(LottoNumbers winNumbers) {
        final List<Winning> winnings = new ArrayList<>();
        for (Lotto lotto : lottos) {
            winnings.add(lotto.calculateWinning(winNumbers));
        }
        return new LottoResult(winnings);
    }

    public Money getSellingPrice() {
        return lottos.stream()
                .map(Lotto::getSellingPrice)
                .reduce(new Money(0), Money::plus);
    }
}
