package lotto.lotto;

import lotto.Purchasable;
import lotto.money.Money;

import java.util.List;

public class ManualLottoes implements Purchasable {

    private final List<Lotto> lottoes;
    private final Money totalMoney;

    private ManualLottoes(List<Lotto> lottoes) {
        this.lottoes = lottoes;
        this.totalMoney = null;
    }

    public static ManualLottoes of(List<Lotto> lottoes) {
        return null;
    }

    public static ManualLottoes empty() {
        return null;
    }

    @Override
    public Money price() {
        return totalMoney;
    }

    public int size() {
        return lottoes.size();
    }
}
