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

    public Money totalPrice() {
        Money result = Money.from(0);
        for (Lotto lotto : lottoList) {
            result = result.add(lotto.price());
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Lotto lotto : lottoList) {
            builder.append(lotto.toString() + "\n");
        }
        return builder.toString();
    }
}
