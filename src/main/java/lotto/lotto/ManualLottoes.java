package lotto.lotto;

import lotto.Purchasable;
import lotto.money.Money;
import lotto.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class ManualLottoes implements Purchasable {

    private static final ManualLottoes EMPTY = new ManualLottoes(Collections.emptyList());

    private final List<Lotto> lottoes;
    private final Money totalMoney;

    private ManualLottoes(List<Lotto> lottoes) {
        this.lottoes = requireNonNull(lottoes, "lottoes");
        this.totalMoney = calculateMoney(lottoes);
    }

    public static ManualLottoes of(List<Lotto> lottoes) {
        return CollectionUtils.isEmpty(lottoes) ? EMPTY : new ManualLottoes(lottoes);
    }

    public static ManualLottoes empty() {
        return EMPTY;
    }

    @Override
    public Money price() {
        return totalMoney;
    }

    public List<Lotto> lottoes() {
        return Collections.unmodifiableList(lottoes);
    }

    public int size() {
        return lottoes.size();
    }

    private static Money calculateMoney(List<Lotto> lottoes) {
        return lottoes.stream()
                      .map(Lotto::price)
                      .reduce(Money.of(0L), Money::add);
    }
}
