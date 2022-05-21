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
        List<Lotto> lottos = generateRandomLottos(money.maxLottoCount());
        return new Lottos(lottos);
    }

    public static Lottos purchase(Money totalMoney, List<Lotto> manualLottos) {
        validateManualLottosNotNull(manualLottos);
        int randomLottoCount = totalMoney.maxLottoCount() - manualLottos.size();
        validateRandomLottoCountNotNegativeNumber(randomLottoCount);
        List<Lotto> lottos = generateRandomLottos(randomLottoCount);
        lottos.addAll(manualLottos);
        return new Lottos(lottos);
    }

    private static void validateRandomLottoCountNotNegativeNumber(int randomLottoCount) {
        if(randomLottoCount < ZERO_NUM) {
            throw new IllegalArgumentException("수동 로또 구매에 필요한 돈이 부족합니다.");
        }
    }

    private static List<Lotto> generateRandomLottos(int randomLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = ZERO_NUM; i < randomLottoCount; i++) {
            lottos.add(Lotto.draw(new RandomLottoNumberGenerator()));
        }
        return lottos;
    }

    private static void validateManualLottosNotNull(List<Lotto> manualLottos) {
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
