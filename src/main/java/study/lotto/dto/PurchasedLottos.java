package study.lotto.dto;

import java.util.List;
import java.util.stream.Collectors;
import study.lotto.domain.Lottos;

public class PurchasedLottos {

    private final List<PurchasedLotto> lottoList;

    public PurchasedLottos(List<PurchasedLotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static PurchasedLottos from(Lottos lottos) {
        return new PurchasedLottos(
                lottos.lottoNumbers().stream().map(PurchasedLotto::new).collect(Collectors.toList()));
    }

    public List<PurchasedLotto> getLottoList() {
        return lottoList;
    }
}
