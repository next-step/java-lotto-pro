package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    /**
     * 자동/수동 포함한 로또 생성기
     * @param maxLottoCount lottoNumberGenerator에 의해 생성할 로또 개수
     * @param lottoNumberGenerator
     * @param manualLottos 수동으로 기생성된 로또
     */
    public static Lottos mergeLottos(int maxLottoCount, LottoNumberGenerator lottoNumberGenerator, Lottos manualLottos) {
        List<Lotto> lottos = new ArrayList<>(manualLottos.lottos);
        for(int i = 0; i < maxLottoCount; i++) {
            lottos.add(Lotto.generateLotto(lottoNumberGenerator));
        }
        return new Lottos(lottos);
    }

    public Money findTotalPrice() {
        return Money.createMoney((long) lottos.size() * LOTTO_PRICE);
    }

    public List<Lotto> unmodifiedLottos() {
        return Collections.unmodifiableList(this.lottos);
    }
}
