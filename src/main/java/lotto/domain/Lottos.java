package lotto.domain;

import static java.util.stream.IntStream.range;

import generic.Money;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import util.ListUtils;

public class Lottos {

    private final List<Lotto> lottoList;

    private Lottos(final List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos of(Lotto... lotto) {
        return new Lottos(Arrays.asList(lotto));
    }

    public static Lottos purchaseAuto(final Money purchaseMoney) {
        return purchase(purchaseMoney);
    }

    private static Lottos purchase(final Money purchaseMoney) {
        return new Lottos(buyLottoList(purchaseMoney));
    }

    private static List<Lotto> buyLottoList(final Money purchaseMoney) {
        return range(0, purchaseMoney.divide(Lotto.PURCHASE_PRICE).getIntValue())
                .mapToObj(value -> Lotto.generate())
                .collect(Collectors.toList());
    }

    public int size() {
        return lottoList.size();
    }

    public Money purchasePrice() {
        return Lotto.PURCHASE_PRICE.times(this.lottoList.size());
    }

    public LottoWinResultGroup draw(final WinningNumbers winningNumbers) {
        return new LottoWinResultGroup(this.lottoList.stream()
                .map(lotto -> lotto.confirm(winningNumbers))
                .collect(Collectors.toList())
        );
    }

    public void each(final Consumer<Lotto> consumer) {
        this.lottoList.forEach(consumer);
    }

    public Lottos addAll(final Lottos lottos) {
        return Lottos.of(ListUtils.addAll(this.lottoList, lottos.lottoList)
                .toArray(new Lotto[0]));
    }

    public int manualSize() {
        return (int) lottoList.stream()
                .filter(Lotto::isManual)
                .count();
    }

    public int autoSize() {
        return (int) lottoList.stream()
                .filter(Lotto::isAuto)
                .count();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lottos)) {
            return false;
        }
        final Lottos lottos = (Lottos) o;
        return Objects.equals(lottoList, lottos.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoList);
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "lottoList=" + lottoList +
                '}';
    }
}
