package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private static final int ZERO = 0;
    private List<Lotto> lottos = new ArrayList<>();

    private Player() {

    }

    private Player(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Player buyCustomLottos(List<Lotto> customLottos) {
        return new Player(customLottos);
    }

    public static Player buyAutoLotto(int money) {
         return new Player(autoLottos(money));
    }

    public LottoReport matchWinnerLotto(Lotto winnerLotto, LottoNumber bonusNumber) {
        return new LottoReport(lottoResult(winnerLotto, bonusNumber));
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    private static List<Lotto> autoLottos(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int buyLottoQty = money / Lotto.LOTTO_MONEY;
        for (int i = ZERO; i < buyLottoQty; i++) {
            lottos.add(Lotto.createAutoLotto());
        }
        return lottos;
    }

    private List<LottoRank> lottoResult(Lotto winnerLotto, LottoNumber bonusNumber) {
        return this.lottos
                .stream()
                .map((lotto -> lotto.match(winnerLotto, bonusNumber)))
                .collect(Collectors.toList());
    }


}
