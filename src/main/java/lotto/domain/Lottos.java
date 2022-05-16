package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList) {
        this.lottoList = new ArrayList<>(lottoList);
    }

    public static Lottos from(List<Lotto> lottoList) {
        return new Lottos(lottoList);
    }

    public List<Lotto> matchedLottoList(List<LottoNumber> prizeNumbers, MatchResult matchResult) {
        List<Lotto> result = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            if (lotto.match(prizeNumbers).equals(matchResult)) {
                result.add(lotto);
            }
        }
        return Collections.unmodifiableList(result);
    }


}
