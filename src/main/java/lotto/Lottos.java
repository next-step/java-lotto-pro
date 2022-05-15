package lotto;

import static java.util.stream.IntStream.range;
import static lotto.Lotto.LottoType.AUTO;

import generic.Money;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import lotto.Lotto.LottoType;

public class Lottos {

    private final List<Lotto> lottoList;

    private Lottos(final List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos of(Lotto... lotto) {
        return new Lottos(Arrays.asList(lotto));
    }

    public static Lottos purchaseAuto(final Money purchaseMoney) {
        return purchase(purchaseMoney, AUTO);
    }

    private static Lottos purchase(final Money purchaseMoney, final LottoType lottoType) {
        return new Lottos(buyLottoList(purchaseMoney, lottoType));
    }

    private static List<Lotto> buyLottoList(final Money purchaseMoney, final LottoType lottoType) {
        if (lottoType.isAuto()) {
            return range(0, purchaseMoney.divide(Lotto.PURCHASE_PRICE).getIntValue())
                    .mapToObj(value -> Lotto.generate())
                    .collect(Collectors.toList());
        }

        throw new IllegalArgumentException("잘못된 타입입니다.");
    }

    public int size() {
        return lottoList.size();
    }

    public Money purchasePrice() {
        return Lotto.PURCHASE_PRICE.times(this.lottoList.size());
    }

    public LottoWinResultGroup end(final LottoNumbers winningNumbers) {
        return new LottoWinResultGroup(this.lottoList.stream()
                .map(lotto -> lotto.confirm(winningNumbers))
                .collect(Collectors.toList())
        );
    }

    public void each(final Consumer<Lotto> consumer) {
        this.lottoList.forEach(consumer);
    }
}
