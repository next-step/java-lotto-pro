package lotto.model;

import lotto.generator.InputLottoNumberGenerator;
import lotto.generator.RandomLottoNumberGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private static final int EXTRA_NUM = 1;
    private static final int ZERO_NUM = 0;
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos buy(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int count = money.maxLottoCount();
        for (int i = ZERO_NUM; i < count; i++) {
            lottos.add(Lotto.draw(new RandomLottoNumberGenerator()));
        }
        return new Lottos(lottos);
    }

    public static Lottos buy(String[] input) {
        List<Lotto> lottos = new ArrayList<>();
        for (String s : input) {
            lottos.add(Lotto.draw(new InputLottoNumberGenerator(s)));
        }
        return new Lottos(lottos);
    }

    public LottoStatistics lottoStatistics(Lotto winningLotto) {
        Map<LottoRanking, Integer> lottoStatistics = new EnumMap<>(LottoRanking.class);
        for (Lotto lotto : this.lottos) {
            LottoRanking lottoRanking = lotto.lottoRanking(winningLotto);
            lottoStatistics.put(lottoRanking, lottoStatistics.getOrDefault(lottoRanking, ZERO_NUM) + EXTRA_NUM);
        }
        return new LottoStatistics(lottoStatistics);
    }

    public Money totalPrice() {
        return Money.valueOf(Math.multiplyExact(lottos.size(), Money.LOTTO_PRICE));
    }

    public List<Lotto> readOnlyLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public int size() {
        return lottos.size();
    }
}
