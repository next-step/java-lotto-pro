package camp.nextstep.edu.step3;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoPaper {
    private final List<Lotto> purchase;

    public LottoPaper(List<Lotto> purchase) {
        if (purchase.isEmpty()) {
            throw new IllegalArgumentException("invalid construct input");
        }
        this.purchase = purchase;
    }

    public LottoResult checkAll(final Lotto answerLotto, final LottoNumber bonus) {
        if (Objects.isNull(answerLotto) || Objects.isNull(bonus)) {
            throw new IllegalArgumentException("invalid check all input");
        }

        return new LottoResult(purchase.stream()
                .map((lotto) -> lotto.checkTo(answerLotto, bonus))
                .collect(Collectors.toList()));
    }

    public int numberOfPurchases() {
        return this.purchase.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPaper that = (LottoPaper) o;
        return Objects.equals(purchase, that.purchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchase);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : purchase) {
            stringBuilder.append(String.format("%s\n", lotto));
        }
        return stringBuilder.toString();
    }
}
