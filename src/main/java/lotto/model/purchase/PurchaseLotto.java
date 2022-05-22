package lotto.model.purchase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.model.lotto.Lotto;
import lotto.model.money.Money;
import lotto.model.result.LottoResult;
import lotto.model.winning.WinningLotto;
import lotto.type.LottoRank;

public class PurchaseLotto {

    private final List<Lotto> autoLottoList;
    private final List<Lotto> manualLottoList;

    public PurchaseLotto(List<Lotto> autoLottoList, List<Lotto> manualLottoList) {
        this.autoLottoList = autoLottoList;
        this.manualLottoList = manualLottoList;
    }

    public LottoResult rankMatch(WinningLotto winningLotto, Money purchasedMoney) {
        Map<LottoRank, Integer> rankMap = new HashMap<>();
        Arrays.stream(LottoRank.values())
            .forEach(lottoRank -> rankMap.put(lottoRank, 0));

        concatLottoList().forEach(lotto -> {
            LottoRank lottoRank =  winningLotto.match(lotto);
            rankMap.put(lottoRank, rankMap.get(lottoRank) + 1);
        });

        return new LottoResult(rankMap, purchasedMoney);
    }

    public List<Lotto> concatLottoList() {
        return Stream.concat(autoLottoList.stream(), manualLottoList.stream())
            .collect(Collectors.toList());
    }

    public int manualLottoCount() {
        return manualLottoList.size();
    }

    public int autoLottoCount() {
        return autoLottoList.size();
    }

}
