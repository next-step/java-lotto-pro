package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lotto.generator.RandomLottoNumberGenerator;

public class Lottos {
    private static final int EXTRA_NUM = 1;
    private static final int ZERO_NUM = 0;
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos purchase(Money money) {
        List<Lotto> lottos = randomLottos(money);
        return new Lottos(lottos);
    }

    public static Lottos purchase(Money totalMoney, List<Lotto> manualLottos) {
        validateManualLottosNotNUll(manualLottos);
        Money leftMoney = leftMoney(totalMoney, manualLottos);
        List<Lotto> lottos = randomLottos(leftMoney);
        lottos.addAll(manualLottos);
        return new Lottos(lottos);
    }

    private static List<Lotto> randomLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int count = money.maxLottoCount();
        for (int i = ZERO_NUM; i < count; i++) {
            lottos.add(Lotto.draw(new RandomLottoNumberGenerator()));
        }
        return lottos;
    }

    private static Money leftMoney(Money totalMoney, List<Lotto> manualLottos) {
        Money leftMoney;
        try {
            leftMoney = totalMoney.subtract(Money.valueOf(Lotto.PRICE).multiply(manualLottos.size()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("수동 로또 구매에 필요한 돈이 부족합니다.");
        }
        return leftMoney;
    }

    private static void validateManualLottosNotNUll(List<Lotto> manualLottos) {
        if (Objects.isNull(manualLottos)) {
            throw new IllegalArgumentException("로또 번호 갯수가 올바르지 않습니다.");
        }
    }

    public LottoStatistics lottoStatistics(WinningLotto winningLotto) {
        Map<LottoRanking, Integer> lottoStatistics = new EnumMap<>(LottoRanking.class);
        for (Lotto lotto : this.lottos) {
            LottoRanking lottoRanking = lotto.lottoRanking(winningLotto);
            lottoStatistics.put(lottoRanking, lottoStatistics.getOrDefault(lottoRanking, ZERO_NUM) + EXTRA_NUM);
        }
        return new LottoStatistics(lottoStatistics);
    }

    public Money totalPrice() {
        return Money.valueOf(Math.multiplyExact(lottos.size(), Lotto.PRICE));
    }

    public List<Lotto> readOnlyLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public int size() {
        return lottos.size();
    }
}
